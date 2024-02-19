import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Random;

public class Main {
    // ID
    private static long idCounter = 0;

    public static void main(String[] args) {
        Random random = new Random();

        // Random class selection
        List<String> person = new ArrayList<>();
        person.add("Warrior");
        person.add("Wizard");

        // Random index generator
        int randomIndex1= random.nextInt(person.size());
        int randomIndex2= random.nextInt(person.size());

        // Characters
        String character1 = person.get(randomIndex1);
        String character2 = person.get(randomIndex2);

        // Class declaration
        if (character1.equals("Wizard")){
            Wizard ch1 = new Wizard(createID(), "Character1", generatorWizard(), generatorMana(), generatorIntelligence() );
        } else {
            Warrior ch1 = new Warrior(createID(), "Character2", generatorWarrior(), generatorMana(), generatorStrength());
        }

        if (character2.equals("Wizard")){
            Wizard ch2 = new Wizard(createID(), "Character1", generatorWizard(), generatorMana(), generatorIntelligence() );
        } else {
            Warrior ch2 = new Warrior(createID(), "Character2", generatorWarrior(), generatorMana(), generatorStrength());
        }

        // Tests
        System.out.println(character1);
        System.out.println(character2);

    }


    public static synchronized String createID ()
    {
        return String.valueOf(idCounter++);
    }

    public static int generatorWarrior(){
        Random random = new Random();

        List<Integer> hp_warrior = new ArrayList<>();
        for (int i = 100; i <= 200; i++) {
            hp_warrior.add(i);
        }

        int randomIndexWarrior = random.nextInt(hp_warrior.size());

        int hp = hp_warrior.get(randomIndexWarrior);

        return hp;
    }

    public static int generatorStrength(){
        Random random = new Random();

        List<Integer> strengthWarrior = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            strengthWarrior.add(i);
        }

        int randomIndexWizard = random.nextInt(strengthWarrior.size());

        int hp = strengthWarrior.get(randomIndexWizard);

        return hp;
    }

    public static int generatorWizard(){
        Random random = new Random();

        List<Integer> hp_wizard = new ArrayList<>();
        for (int i = 50; i <= 100; i++) {
            hp_wizard.add(i);
        }

        int randomIndexWizard = random.nextInt(hp_wizard.size());

        int hp = hp_wizard.get(randomIndexWizard);

        return hp;
    }

    public static int generatorMana(){
        Random random = new Random();

        List<Integer> manaWizard = new ArrayList<>();
        for (int i = 10; i <= 50; i++) {
            manaWizard.add(i);
        }

        int randomIndexWizard = random.nextInt(manaWizard.size());

        int hp = manaWizard.get(randomIndexWizard);

        return hp;
    }

    public static int generatorIntelligence(){
        Random random = new Random();

        List<Integer> intelligenceWizard = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            intelligenceWizard.add(i);
        }

        int randomIndexWizard = random.nextInt(intelligenceWizard.size());

        int hp = intelligenceWizard.get(randomIndexWizard);

        return hp;
    }
}
