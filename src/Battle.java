import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Battle {


    private Character winner;
    private Character looser;
    private boolean tieGame;
    private List<String> battleRecord=new ArrayList<>();
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
        this.battleRecord =  battleRecord;
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

        Character p1 = clone(player1);
        Character p2 = clone(player2);

        do{
            performAttack(p1, p2);
            performAttack(p2, p1);
            checkBattleResult(p1, p2);
            round++;

            if(isTieGame()){
                setTieGame(false);
                setRound(1);
                p1 = clone(player1);
                p2 = clone(player2);
            }

        }while(getWinner()==(null));

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

    public void battlePrinter(List<String> battleRecord, int timeSleepMilliSeconds) {
        int roundNumber = 1;

        System.out.println("***************************** ROUND " + roundNumber + " FIGHT *****************************");

        for (String battleIndex : battleRecord) {
            if (battleIndex.startsWith("We have a tie match between the players.")) {
                System.out.println(battleIndex);
                roundNumber = 1;
                System.out.println("***************************** ROUND " + roundNumber + " FIGHT *****************************");
            } else if (battleIndex.startsWith("Round")) {
                int currentRound = roundNumberExtract(battleIndex);
                if (currentRound == roundNumber) {
                    System.out.println(battleIndex);
                } else {
                    roundNumber = currentRound;
                    System.out.println("***************************** ROUND " + roundNumber + " FIGHT *****************************");
                    System.out.println(battleIndex);
                }
            } else {
                System.out.println(battleIndex);
            }

            try {
                Thread.sleep(timeSleepMilliSeconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int roundNumberExtract(String text) {

        String patron = "Round (\\d+)";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String numeroStr = matcher.group(1);
            return Integer.parseInt(numeroStr);
        }
        else
            return -1;

    }

}
