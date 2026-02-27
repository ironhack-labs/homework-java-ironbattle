package IronBattle;

public class BattleSimulator {

    public void starter(Character player1, Character player2) {
        System.out.println("Battle Simulator started");
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());

        Character c1=introduceCharacter(player1);
        Character c2=introduceCharacter(player2);

        boolean finished = false;
        int round = 1;
        while (!finished) {
            if(player1.isAlive() && player2.isAlive()){
                System.out.println("Round " + round );
                player1.attack(player2);
                player2.attack(player1);

                System.out.println(player1.getName() + " is attacking " + player1.getHp());
                System.out.println(player2.getName() + " is attacking " + player2.getHp());

                round++;

            }
            else if(!player1.isAlive() && !player2.isAlive()){
                System.out.println("It's a tie");
                player1=introduceCharacter(c1);
                player2=introduceCharacter(c2);


            }
            else if(!player2.isAlive()){
                System.out.println(player1.getName() + " won the game");
                finished = true;

            }else {
                System.out.println(player1.getName() + " won the game");
                finished = true;
            }
        }
    }

    public Character introduceCharacter(Character c){
        if(c instanceof Wizard w){
            return new Wizard(w.getName(),w.getHp(),w.getMana(),w.getIntelligence());
        }else if(c instanceof Warrior w){
            return new Warrior(w.getName(),w.getHp(),w.getStamina(),w.getStrength());
        }
        return null;
    }


}
