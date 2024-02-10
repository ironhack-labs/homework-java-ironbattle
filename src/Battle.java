import java.util.ArrayList;
import java.util.List;

public class Battle {

    //other class defines players character

    private Character playerOne;
    private Character playerTwo;
    private Character winner;
    private Character looser;
    private boolean tieGame;
    private List<String> battleRecord = new ArrayList<>();
    private int round;

    private int damageDone;

    public Battle(Character playerOne, Character playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        setTieGame(false);
        setRound(1);


    }

    public Character getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Character playerOne) {
        this.playerOne = playerOne;
    }

    public Character getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Character playerTwo) {
        this.playerTwo = playerTwo;
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
        Character p1=player1;
        Character p2=player2;

        while(getWinner()==(null)){

            if(isTieGame()){
                setTieGame(false);
                startBattle(player1, player2);
            }else{
                performAttack(player1, player2);
                performAttack(player2, player1);
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

    private void performAttack(Character attacker, Character target) {
        int initialLife = target.getHP();
        attacker.attack(target);//Review with team
        int damageDone = initialLife - target.getHP();
        battleRecorder(battleRecord, attacker);

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

    private void battleRecorder(List<String> battleRecord, Character player ){
        this.battleRecord=battleRecord;

        // Need a character attribute like "attackName", "skillName" or make a new attribute on battle class?

        String record = "Round " + getRound() + ": Player " + player.getName() + '\'' +
                "Class: " + player.getClass() +  " - HP: " + player.getHP()+ '\'' +
                "attack with: " + /* player.getAttackName + */ "and makes: " + getDamageDone() + " of damage";


        battleRecord.add(record);
    }

    private void battleRecorder(List<String> battleRecord ){
        this.battleRecord=battleRecord;

        if(!isTieGame())
            battleRecord.add("We have a tie match between the players. A new match start: ");
        else{
            if(getWinner()!=null){
                battleRecord.add("The winner is " + getWinner()
                        + "!!!. Better luck next time: " + getLooser());
            }
        }

    }






}
