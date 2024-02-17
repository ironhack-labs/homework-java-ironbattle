package model;

public class Battle {
    private final Character character1;
    private final Character character2;

    public Battle(Character character1, Character character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    public void fight() {
        System.out.println(character1);
        System.out.println(character2);
        int round = 1;
        do {
            System.out.printf("%n%nROUND %d FIGHT! %n", round);
            character1.attack(character2);
            character2.attack(character1);
            printStats();
            round++;
        } while (character1.isAlive() && character2.isAlive());
        System.out.println("\n\nGAME OVER!!!\n\n");
    }

    private void printStats() {
        character1.printStats();
        System.out.print(" << VS >> ");
        character2.printStats();
    }

}
