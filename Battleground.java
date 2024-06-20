
public class Battleground {
    private static Character c1;
    private static Character c2;

    Battleground(Character c1, Character c2){
        setCharacter1(c1);
        setCharacter2(c2);
        fight();
// THIS IS A TEST COMMENT
    }

    public static void setCharacter1(Character c1) {
        Battleground.c1 = c1;
    }

    public static void setCharacter2(Character c2) {
        Battleground.c2 = c2;
    }

    public void fight() {
        System.out.println("\n=== Fight! ===");
        System.out.println(c1.getName() + " vs " + c2.getName());

        // FIGHT
        while (c1.isAlive() && c2.isAlive()) {

            c1.attack(c2);
            c2.attack(c1);
//            if (random.nextBoolean()) {
//                char1.attack(char2);
//                if (char2.isAlive()) {
//                    char2.attack(char1);
//                }
//            } else {
//                char2.attack(char1);
//                if (char1.isAlive()) {
//                    char1.attack(char2);
//                }
//            }

            System.out.println(c1.getName() + " HP: " + c1.getHp() + " | " + c2.getName() + " HP: " + c2.getHp());
            System.out.println();
        }

        // Determine winner
        if (c1.isAlive()) {
            System.out.println(c1.getName() + " wins!");
        } else {
            System.out.println(c2.getName() + " wins!");
        }


    }

}
