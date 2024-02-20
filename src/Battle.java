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

    public Battle() {
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

    private void checkBattleResult(Character player1, Character player2) {

        if (!player1.getIsAlive() && !player2.getIsAlive()) {
            setTieGame(true);
            battleRecorder(battleRecord);
        } else if (!player1.getIsAlive()) {
            setWinner(player2);
            setLooser(player1);
            battleRecorder(battleRecord);
        } else if (!player2.getIsAlive()) {
            setWinner(player1);
            setLooser(player2);
            battleRecorder(battleRecord);
        }

    }

    //2. Record the battle log
    private void battleRecorder(List<String> battleRecord, Character playerOne, Character playerTwo ){
        this.battleRecord=battleRecord;
        String attackType = playerOne.getCurrentAttack();
        String abilityType = playerOne.getCurrentAbility();

        if(playerOne instanceof Warrior warrior){
            if(!abilityType.equals("None")){
                String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                        " Class: " + playerOne.getClass().getSimpleName() +  " - HP: " + playerOne.getHP()+
                        " - Stamina: " + warrior.getStamina() +
                        " uses ability: " + abilityType + " and recovers " + warrior.getRecoveryAmount() + " stamina!";
                battleRecord.add(record);
                playerOne.setCurrentAbility("None");
            }else {
                String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                        " Class: " + playerOne.getClass().getSimpleName() + " - HP: " + playerOne.getHP() +
                        " - Stamina: " + warrior.getStamina() +
                        " attack with: " + attackType + " makes: " + getDamageDone() + " points of damage to "
                        + playerTwo.getName();
                battleRecord.add(record);
            }

        }else if (playerOne instanceof Wizard wizard){
            if (abilityType.equals("Recovery")) {
                String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                        " Class: " + playerOne.getClass().getSimpleName() + " - HP: " + playerOne.getHP() +
                        " - Mana: " + wizard.getMana() +
                        " uses ability: " + abilityType + " and recovers " + wizard.getRecoveryAmount() + " mana!";
                battleRecord.add(record);
                playerOne.setCurrentAbility("None");
            } else {
                String record = "Round " + getRound() + ": Player " + playerOne.getName() +
                        " Class: " + playerOne.getClass().getSimpleName() + " - HP: " + playerOne.getHP() +
                        " - Mana: " + wizard.getMana() +
                        " attack with: " + attackType + " makes: " + getDamageDone() + " points of damage to "
                        + playerTwo.getName();
                battleRecord.add(record);
            }
        }

    }

    private void battleRecorder(List<String> battleRecord ){
        this.battleRecord=battleRecord;

        if(isTieGame())
            battleRecord.add("\nWe have a tie match between the players. A new match start:\n \n***************************** ROUND 1 FIGHT *****************************");
        else{
            if(getWinner()!=null){
                battleRecord.add("\nThe winner is " + getWinner().getName()
                        + "!!!. Better luck next time: " + getLooser().getName());
                if(getWinner() instanceof Wizard){
                    battleRecord.add(AsciiArt.WizardASCII());
                } else {
                    battleRecord.add(AsciiArt.WarriorASCII());
                }
            }
        }
    }

    public void battlePrinter(List<String> battleRecord, int timeSleepMilliSeconds){

        List<String> newBattleRecordList = new ArrayList<>();
        int roundNumber = 1;

        newBattleRecordList.add("*****************************" + " ROUND " + roundNumber + " FIGHT " + " *****************************");

        for (String battleIndex : battleRecord) {
            if(battleIndex.startsWith("Round")){
                String roundSplitChain = battleIndex.substring(battleIndex.indexOf('R'), battleIndex.indexOf(':'));

                if(roundNumberExtract(roundSplitChain)==roundNumber){
                    newBattleRecordList.add(battleIndex);
                }else{

                    newBattleRecordList.add("\n*****************************" + " ROUND " + roundNumberExtract(roundSplitChain) + " FIGHT " + "*****************************");
                    newBattleRecordList.add(battleIndex);
                    roundNumber++;
                }
            }else{
                newBattleRecordList.add(battleIndex);
                roundNumber=1;
                //newBattleRecordList.add("\n*****************************" + " ROUND " + roundNumber + " FIGHT " + "*****************************");
            }

        }

        for (int i = 0; i < newBattleRecordList.size(); i++) {
            if(newBattleRecordList.get(i).startsWith("We have a tie match between the players.")){
                System.out.println(newBattleRecordList.get(i));
            }else{
                System.out.println(newBattleRecordList.get(i));

                if ((i + 1) % 3 == 0 && (i + 1) < newBattleRecordList.size()) {
                    try {
                        Thread.sleep(timeSleepMilliSeconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private int roundNumberExtract(String text) {

        String patron = "Round (\\d+)";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String numberStr = matcher.group(1);
            return Integer.parseInt(numberStr);
        }
        else
            return -1;

    }

}
