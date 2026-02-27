
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface Attacker {
    void attack(Character opponent);
}

abstract class Character {
    private final String id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name, int hp) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = (name == null || name.trim().isEmpty()) ? "Fighter" : name.trim();
        this.hp = Math.max(1, hp);
        this.isAlive = true;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHp() { return hp; }
    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
        this.isAlive = this.hp > 0;
    }
    public boolean isAlive() { return isAlive; }

    protected abstract void attack(Character target);
}

class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        this.stamina = Math.max(0, stamina);
        this.strength = Math.max(1, strength);
    }

    @Override
    protected void attack(Character opponent) {
        int damage = 0;
        if (stamina >= 5 && Math.random() < 0.5) {
            System.out.println(getName() + " → HEAVY ATTACK!  💥");
            damage = strength;
            stamina -= 5;
        } else if (stamina >= 1) {
            System.out.println(getName() + " → WEAK ATTACK!  ⚔️");
            damage = strength / 2;
            stamina -= 1;
        } else {
            System.out.println(getName() + " is exhausted... recovering stamina 😴");
            stamina += 2;
        }
        opponent.setHp(opponent.getHp() - damage);
        System.out.println("→ " + damage + " damage → " + opponent.getName() + " HP: " + opponent.getHp());
    }

    public int getStamina() { return stamina; }
    public int getStrength() { return strength; }
}

class Wizard extends Character {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = Math.max(0, mana);
        this.intelligence = Math.max(1, intelligence);
    }

    @Override
    protected void attack(Character opponent) {
        int damage = 0;
        if (mana >= 5 && Math.random() < 0.5) {
            System.out.println(getName() + " → FIREBALL!  🔥");
            damage = intelligence;
            mana -= 5;
        } else if (mana >= 1) {
            System.out.println(getName() + " → STAFF STRIKE!  🪄");
            damage = 2;
            mana -= 1;
        } else {
            System.out.println(getName() + " is out of mana... meditating 🧘");
            mana += 2;
        }
        opponent.setHp(opponent.getHp() - damage);
        System.out.println("→ " + damage + " damage → " + opponent.getName() + " HP: " + opponent.getHp());
    }

    public int getMana() { return mana; }
    public int getIntelligence() { return intelligence; }
}

public class IronBattle {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final String LOG_FILE = "battle_logs.csv";
    private static int matchCounter = 1;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        loadLastMatchCounter();
        System.out.println("=====================================");
        System.out.println("   IRONBATTLE SIMULATOR  ⚔️🔥🪄");
        System.out.println("=====================================");
        System.out.println("Log file: " + Paths.get(LOG_FILE).toAbsolutePath());
        initializeLogFile();

        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("→ Choice: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> startManualBattle();
                case "2" -> startRandomBattle();
                case "3" -> startCsvBattle();
                case "4" -> viewPastBattles();
                case "5" -> {
                    System.out.println("\nGoodbye! See you in the next battle ⚔️");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please enter 1-5.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n1. Manual Battle (create your fighters)");
        System.out.println("2. Random Battle (quick auto fight)");
        System.out.println("3. Battle from CSV (fighters.csv)");
        System.out.println("4. View Past Battles");
        System.out.println("5. Exit");
    }

    private static void initializeLogFile() {
        Path path = Paths.get(LOG_FILE);
        if (!Files.exists(path)) {
            try {
                String header = "matchId,round,timestamp,attacker,damage,target,hp_left,description,pair\n";
                Files.writeString(path, header, StandardOpenOption.CREATE);
                System.out.println("Log file created.");
            } catch (IOException e) {
                System.err.println("Failed to create log file: " + e.getMessage());
            }
        }
    }

    private static void loadLastMatchCounter() {
        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            br.readLine(); // header
            String maxId = "M0000";
            while ((line = br.readLine()) != null) {
                if (line.startsWith("M")) {
                    String id = line.split(",", 2)[0].trim();
                    if (id.compareTo(maxId) > 0) {
                        maxId = id;
                    }
                }
            }
            matchCounter = Integer.parseInt(maxId.substring(1)) + 1;
            System.out.println("Next match ID: " + String.format("M%04d", matchCounter));
        } catch (Exception e) {
            matchCounter = 1;
        }
    }

    private static void startManualBattle() {
        System.out.println("\n=== MANUAL BATTLE ===");
        Character p1 = createCharacterManually(1);
        if (p1 == null) return;
        Character p2 = createCharacterManually(2);
        if (p2 == null) return;

        String title = p1.getName() + " vs " + p2.getName();
        System.out.println("\n" + title);
        runBattle(p1, p2, title);
    }

    private static Character createCharacterManually(int num) {
        System.out.println("\nFighter #" + num);
        System.out.print("Type (warrior / wizard): ");
        String type = sc.nextLine().trim().toLowerCase();

        System.out.print("Name: ");
        String name = sc.nextLine().trim();

        if (type.equals("warrior")) {
            int stamina   = readInt("Stamina   (10–50): ", 10, 50);
            if (stamina == -1) return null;
            int strength  = readInt("Strength  (1–10):  ", 1, 10);
            if (strength == -1) return null;
            int hp = 100 + rand.nextInt(101);
            return new Warrior(name, hp, stamina, strength);
        } else if (type.equals("wizard")) {
            int mana         = readInt("Mana         (10–50): ", 10, 50);
            if (mana == -1) return null;
            int intelligence = readInt("Intelligence (1–50):  ", 1, 50);
            if (intelligence == -1) return null;
            int hp = 50 + rand.nextInt(51);
            return new Wizard(name, hp, mana, intelligence);
        } else {
            System.out.println("Invalid type! (warrior or wizard only)");
            return createCharacterManually(num);
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) return val;
                System.out.println("Value must be between " + min + " and " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private static void startRandomBattle() {
        Character p1 = createRandomCharacter("Hero");
        Character p2 = createRandomCharacter("Enemy");

        String title = p1.getName() + " vs " + p2.getName();
        System.out.println("\nRandom Fight → " + title);
        runBattle(p1, p2, title);
    }

    private static Character createRandomCharacter(String prefix) {
        boolean isWarrior = rand.nextBoolean();
        String name = prefix + (isWarrior ? " Warrior" : " Mage");

        if (isWarrior) {
            int hp = 100 + rand.nextInt(101);
            int stamina = 10 + rand.nextInt(41);
            int strength = 1 + rand.nextInt(10);
            return new Warrior(name, hp, stamina, strength);
        } else {
            int hp = 50 + rand.nextInt(51);
            int mana = 10 + rand.nextInt(41);
            int intelligence = 1 + rand.nextInt(50);
            return new Wizard(name, hp, mana, intelligence);
        }
    }

    private static void runBattle(Character c1, Character c2, String title) {
        String matchId = String.format("M%04d", matchCounter++);
        System.out.println("\n" + title.toUpperCase());
        System.out.println("MATCH ID: " + matchId + "\n");

        int origHp1 = c1.getHp();
        int origHp2 = c2.getHp();

        boolean tie;
        do {
            tie = false;

            c1.setHp(origHp1);
            c2.setHp(origHp2);

            int round = 1;
            while (c1.isAlive() && c2.isAlive()) {
                System.out.println("ROUND " + round + " ──────────────────────────────");
                System.out.printf("%-22s HP %3d   |   %-22s HP %3d%n",
                        c1.getName(), c1.getHp(), c2.getName(), c2.getHp());

                attackAndLog(matchId, round, c1, c2, title);
                if (!c2.isAlive()) break;

                attackAndLog(matchId, round, c2, c1, title);

                round++;
            }

            System.out.println("\n" + "═".repeat(45));
            if (!c1.isAlive() && !c2.isAlive()) {
                System.out.println("TIE! Both warriors fell. Restarting battle...");
                tie = true;
            } else if (!c1.isAlive()) {
                System.out.println("★ WINNER → " + c2.getName().toUpperCase() + " ★");
            } else {
                System.out.println("★ WINNER → " + c1.getName().toUpperCase() + " ★");
            }
            System.out.println("═".repeat(45));
        } while (tie);
    }

    private static void attackAndLog(String matchId, int round, Character attacker, Character target, String pair) {
        int oldHp = target.getHp();
        attacker.attack(target);
        int damage = oldHp - target.getHp();

        String timestamp = LocalDateTime.now().format(dtf);
        String desc = damage > 0 ? "damage dealt" : "no damage / recover";

        String logLine = String.join(",",
                matchId,
                String.valueOf(round),
                timestamp,
                escapeCsv(attacker.getName()),
                String.valueOf(damage),
                escapeCsv(target.getName()),
                String.valueOf(target.getHp()),
                escapeCsv(desc),
                escapeCsv(pair)
        );

        appendToLog(logLine);
        // System.out.println("[LOGGED → " + logLine + "]");  // debug — uncomment if needed
    }

    private static String escapeCsv(String value) {
        if (value == null) return "\"\"";
        String escaped = value.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }

    private static void appendToLog(String line) {
        try {
            Files.writeString(
                    Paths.get(LOG_FILE),
                    line + "\n",
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println("Error writing to log: " + e.getMessage());
        }
    }

    private static void startCsvBattle() {
        List<Character> fighters = loadFightersFromCsv("fighters.csv");
        if (fighters.size() < 2) {
            System.out.println("fighters.csv must contain at least 2 characters!");
            return;
        }

        System.out.println("\nAvailable fighters:");
        for (int i = 0; i < fighters.size(); i++) {
            Character c = fighters.get(i);
            String type = (c instanceof Warrior) ? "Warrior" : "Wizard";
            System.out.printf("%2d) %s (%s)%n", i + 1, c.getName(), type);
        }

        int idx1 = readChoice("First fighter", fighters.size());
        if (idx1 == -1) return;
        int idx2 = readChoice("Second fighter", fighters.size());
        if (idx2 == -1 || idx1 == idx2) {
            System.out.println("Same fighter cannot fight himself!");
            return;
        }

        Character p1 = fighters.get(idx1);
        Character p2 = fighters.get(idx2);

        String title = p1.getName() + " vs " + p2.getName();
        System.out.println("\n" + title);
        runBattle(p1, p2, title);
    }

    private static int readChoice(String prompt, int max) {
        while (true) {
            System.out.print(prompt + " (1-" + max + "): ");
            try {
                int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
                if (idx >= 0 && idx < max) return idx;
                System.out.println("Please enter a number between 1 and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number!");
            }
        }
    }

    private static List<Character> loadFightersFromCsv(String filename) {
        List<Character> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] tokens = line.split(",");
                if (tokens.length < 5) continue;

                String type = tokens[0].trim().toLowerCase();
                String name = tokens[1].trim();
                int hp   = Integer.parseInt(tokens[2].trim());
                int val1 = Integer.parseInt(tokens[3].trim());
                int val2 = Integer.parseInt(tokens[4].trim());

                if (type.equals("warrior")) {
                    list.add(new Warrior(name, hp, val1, val2));
                } else if (type.equals("wizard")) {
                    list.add(new Wizard(name, hp, val1, val2));
                }
            }
        } catch (Exception e) {
            System.out.println("Could not read fighters.csv: " + e.getMessage());
        }
        return list;
    }

    private static void viewPastBattles() {
        Map<String, List<String>> battles = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE))) {
            br.readLine(); // header
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                int commaIndex = line.indexOf(',');
                if (commaIndex == -1) continue;
                String matchId = line.substring(0, commaIndex);
                battles.computeIfAbsent(matchId, k -> new ArrayList<>()).add(line);
            }
        } catch (IOException e) {
            System.out.println("Log file could not be read: " + e.getMessage());
            return;
        }

        if (battles.isEmpty()) {
            System.out.println("No battles logged yet.");
            return;
        }

        System.out.println("\nPast Battles:");
        int i = 1;
        Map<Integer, String> numToId = new HashMap<>();
        for (String matchId : battles.keySet()) {
            String sampleLine = battles.get(matchId).get(0);
            String pair = "Unknown pair";

            int lastComma = sampleLine.lastIndexOf(',');
            if (lastComma != -1) {
                pair = sampleLine.substring(lastComma + 1).trim();
                if (pair.startsWith("\"") && pair.endsWith("\"")) {
                    pair = pair.substring(1, pair.length() - 1).replace("\"\"", "\"");
                }
            }

            System.out.printf("%2d) %s   (ID: %s)%n", i, pair, matchId);
            numToId.put(i++, matchId);
        }

        System.out.print("\nWhich battle would you like to view? (number): ");
        try {
            int sel = Integer.parseInt(sc.nextLine().trim());
            String matchId = numToId.get(sel);
            if (matchId == null) {
                System.out.println("Invalid selection.");
                return;
            }

            System.out.println("\n" + matchId + " ─ logs:");
            System.out.println("─".repeat(70));
            for (String log : battles.get(matchId)) {
                System.out.println(log);
            }
            System.out.println("─".repeat(70));
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
}