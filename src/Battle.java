import java.util.ArrayList;
import java.util.List;

public class Battle {

    //other class defines players character
    private Character winner;
    private Character looser;
    private boolean tieGame;
    private List<String> battleRecord = new ArrayList<>();
    private int round;

    private int damageDone;

    public Battle(Character playerOne, Character playerTwo) {
        setTieGame(false);
        setRound(1);
    }

    private boolean isTieGame() {
        return tieGame;
    }

    private void setTieGame(boolean tieGame) {
        this.tieGame = tieGame;
    }

    public Character getWinner() {
        return winner;
    }

    private void setWinner(Character winner) {
        this.winner = winner;
    }

    public Character getLooser() {
        return looser;
    }

    private void setLooser(Character looser) {
        this.looser = looser;
    }

    public List<String> getBattleRecord() {
        return battleRecord;
    }

    public void setBattleRecord(List<String> battleRecord) {
        this.battleRecord = battleRecord;
    }

    public int getRound() {
        return round;
    }

    private void setRound(int round) {
        this.round = round;
    }

    public int getDamageDone() {
        return damageDone;
    }

    private void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }

    //1. Start the battle

    public void startBattle (Character player1, Character player2){

        int initialLife = 0;
        Character p1 = clone(player1);
        Character p2 = clone(player2);

        while(getWinner()==(null)){

            if(isTieGame()){
                setTieGame(false);
                setRound(1);
                startBattle(p1, p2);
            }else{
                performAttack(player1, player2);
                performAttack(player2, player1);
                //player1.setHp(0);
                //player2.setHp(0);
                checkBattleResult(player1, player2);
                round++;
            }
        }

        /*

        while(!checkBattleResult(player1, player2)){

            if(isTieGame()){
                setTieGame(false);
                startBattle(player1, player2);
            }else{
                performAttack(player1, player2);
                performAttack(player2, player1);
                round++;
            }

        }

         */


    }

    private Character clone(Character character){
        if(character instanceof Wizard){
            return new Wizard((Wizard) character);
        } else {
            return new Warrior((Warrior) character);
        }

    }

    private void performAttack(Character attacker, Character target) {
        int initialLife = target.getHP();
        attacker.attack(target);//Review with team
        setDamageDone(initialLife - target.getHP());
        battleRecorder(battleRecord, attacker, target);

        if(target.getHP() <=0)
            target.setIsAlive(false);

    }

    private boolean checkBattleResult(Character player1, Character player2) {

        if (!player1.getIsAlive() && !player2.getIsAlive()) {
            setTieGame(true);
            battleRecorder(battleRecord);
            return true;
        } else if (!player1.getIsAlive()) {
            setWinner(player2);
            setLooser(player1);
            battleRecorder(battleRecord);
            return true;
        } else if (!player2.getIsAlive()) {
            setWinner(player1);
            setLooser(player2);
            battleRecorder(battleRecord);
            return true;
        }

        return false;

    }
    //2. Record the battle log

    private void battleRecorder(List<String> battleRecord, Character playerOne, Character playerTwo ){
        this.battleRecord=battleRecord;

        // Need a character attribute like "attackName", "skillName" or make a new attribute on battle class?

        if(playerOne instanceof Warrior){
            Warrior warrior = (Warrior) playerOne;

            String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                    " Class: " + playerOne.getClass().getSimpleName() +  " - HP: " + playerOne.getHP()+
                    " - Stamina: " + warrior.getStamina() +
                    /*  "attack with: " + player.getAttackName + */ " makes: " + getDamageDone() + " points of damage to "
                    + playerTwo.getName();


            battleRecord.add(record);
        }else if (playerOne instanceof Wizard){

            Wizard wizard = (Wizard) playerOne;

            String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                    " Class: " + playerOne.getClass().getSimpleName() +  " - HP: " + playerOne.getHP()+
                    " - Mana: " + wizard.getMana() +
                    /*  "attack with: " + player.getAttackName + */ " makes: " + getDamageDone() + " points of damage to "
                    + playerTwo.getName();

                    //imprimir cada tres lineas:
                /*
                linea: "Round 1: "
                Warrior:
                Wizard:
                esperar

                -----
                Round 2:


                 */

            battleRecord.add(record);
        }

    }

    private void battleRecorder(List<String> battleRecord ){
        this.battleRecord=battleRecord;

        if(isTieGame())
            battleRecord.add("We have a tie match between the players. A new match start: ");
        else{
            if(getWinner()!=null){
                battleRecord.add("The winner is " + getWinner().getName()
                        + "!!!. Better luck next time: " + getLooser().getName());
            }
        }

    }






}
