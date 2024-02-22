import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
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

        int randomIndexWarrior = random.nextInt(strengthWarrior.size());

        int hp = strengthWarrior.get(randomIndexWarrior);

        return hp;
    }

    //Renombrar a generatorRandomWizard
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
