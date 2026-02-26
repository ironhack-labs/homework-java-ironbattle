public class BattleEngine {

    public void startBattle(Character player1, Character player2) {
        if (player1 == null || player2 == null) {
            System.out.println("\n[!] You must create both characters first!");
            return;
        }

        boolean finished = false;

        while (!finished) {
            System.out.println("\n===== BATTLE STARTS =====");
            int round = 1;

            while (player1.isAlive() && player2.isAlive()) {
                System.out.println("\n----- Round " + round + " -----");

                player1.attack(player2);
                player2.attack(player1);

                System.out.println("-> " + player1.getName() + " HP: " + player1.getHp());
                System.out.println("-> " + player2.getName() + " HP: " + player2.getHp());

                round++;
            }

            if (!player1.isAlive() && !player2.isAlive()) {
                System.out.println("\n[!] It's a tie! Both combatants died. Restarting battle...");
                player1.reset();
                player2.reset();
            }
            else if (player1.isAlive()) {
                System.out.println("\n*** Winner is: " + player1.getName() + " ***");
                finished = true;
            }
            else {
                System.out.println("\n*** Winner is: " + player2.getName() + " ***");
                finished = true;
            }
        }
    }
}