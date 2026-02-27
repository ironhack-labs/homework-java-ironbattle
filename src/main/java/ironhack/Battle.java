package ironhack;

import ironhack.Characters.Character;

public class Battle {

    private final Character c1;
    private final Character c2;

    public Battle(Character c1, Character c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public void start() {
        System.out.println("\n=== BATTLE START ===");
        System.out.println(c1.getName() + " VS " + c2.getName());

        int round = 1;

        while (c1.isAlive() && c2.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");

            c1.attack(c2);
            logStatus();

            if (!c2.isAlive()) break;

            c2.attack(c1);
            logStatus();

            round++;
        }

        System.out.println("\n=== BATTLE END ===");
        if (c1.isAlive()) {
            System.out.println("Winner: " + c1.getName());
        } else {
            System.out.println("Winner: " + c2.getName());
        }
    }

    private void logStatus() {
        System.out.println(
                c1.getName() + " HP: " + c1.getHp() +
                        " | " +
                        c2.getName() + " HP: " + c2.getHp()
        );
    }
}