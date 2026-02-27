package services;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import characters.Character;

public class BattleSimulator {

    private static List<Character> characters; 

    private static List<Character> newList  = new ArrayList<>();



    public void startTheGame(List<characters.Character> characters){

        this.characters = characters;


        List<characters.Character> selectedCharacters = selectMatchers();
        start( selectedCharacters.get(0), selectedCharacters.get(1) );

    }

    public static void start(characters.Character c1, characters.Character c2 ){
        int round = 1;
        Character ch1 = c1;
        Character ch2 = c2;

        while(ch1.getHp()>0 && ch2.getHp()>0){

            BattleLog.writeRound(round);

            ch1.attack(ch2);
            BattleLog.writeBattleAction(ch1, ch2);
            ch2.attack(ch1);
            BattleLog.writeBattleAction(ch2, ch1);

            if(ch2.getHp()<=0 && ch1.getHp()>0){
                BattleLog.writeBattleResult(ch1, ch2);
                newList.add(ch1);
            }
            else if(ch1.getHp()<=0 && ch2.getHp()>0){
                BattleLog.writeBattleResult(ch2, ch1);
                newList.add(ch2);
            }
            else if(ch1.getHp()<=0 && ch2.getHp()<=0){
                BattleLog.writeBattleResultTie();
                ch1 = c1;
                ch2 = c2;
                start(ch1, ch2);

            }
            round++;
            selectMatchers();

        }

        
    }


    public static List<characters.Character> selectMatchers() {
        List<characters.Character> returnList = new ArrayList<>();

        if (characters.size() == 1) {

            newList.add(characters.get(0));
            characters.clear();

        } 
        else if(characters.size() == 0){
            characters = newList;
            newList = new ArrayList<>();

        }

        else {

            Collections.shuffle(characters);
            returnList.add(characters.get(0));
            returnList.add(characters.get(1));

            characters.remove(1);
            characters.remove(0);
        }
        return returnList;
    }



}
