package org.example.entity;

public class BattleSimulator {
    public void startBattle(Character player1, Character player2){
        System.out.println("BATTLE START!");
        System.out.println(player1.getName() + " VS " + player2.getName());
        Character c1 = initCharacter(player1);
        Character c2 = initCharacter(player2);




        boolean battleOver = false;

        int round = 1;
        while (!battleOver) {

            if(player1.isAlive() && player2.isAlive()){
                System.out.println("\n--- Round " + round + " ---");

                player1.attack(player2);
                player2.attack(player1);

                System.out.println("=> " + player1.getName() + " HP: " + player1.getHp());
                System.out.println("=> " + player2.getName() + " HP: " + player2.getHp());

                round++;
            } else if (!player1.isAlive() && !player2.isAlive()) {
                System.out.println("\nIT'S A TIE!");
                System.out.println("Restarting the battle...\n");
                player1=initCharacter(c1);
                player2=initCharacter(c2);
            } else if (!player2.isAlive()) {
                System.out.println(player1.getName() + " won the battle!");
                battleOver = true;
            }
            else {
                System.out.println(player2.getName() + " won the battle!");
                battleOver = true;

            }
        }
    }


    public Character initCharacter(Character c){
        if(c instanceof Wizard w){
            return new Wizard(w.getName(),w.getHp(),w.getMana(),w.getIntelligence());
        }else if(c instanceof Warrior w){
            return new Warrior(w.getName(),w.getHp(),w.getStamina(),w.getStrength());
        }
        return null;
    }
}
