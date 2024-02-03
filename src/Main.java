public class Main {
    public static void main(String[] args){
        //Temporary creation of characters, can be deleted
        Character char1 = new Character("guerrero",12);
        Character char2 = new Character("wizard",12);




        //Call for the method that will do the combat
        combat(char1,char2);
    }



    public static void combat(Character char1, Character char2){
        boolean finished = false;
        int initialHpChar1 = char1.getHp();
        int initialHpChar2 = char2.getHp();

        //Loop until one of the character wins
        while(!finished){

            //Loop for the battle
            while(char1.isAlive()&&char2.isAlive()){
                char1.attack(char2);
                char2.attack(char1);
            }

            //Once the battle is finished, let's check who wins the battle
            if (char2.isAlive()){
                //Character 2 wins the battle
                System.out.println("The player "+char2.getName()+" wins the battle!");
                finished = true;
            }else if(char1.isAlive()){
                //Character 1 wins the battle
                System.out.println("The player "+char1.getName()+" wins the battle!");
                finished = true;
            }else{
                //The battle result is a tie
                System.out.println("The battle results in a tie! The battle will be repeated");
                char1.setHp(initialHpChar1);
                char2.setHp(initialHpChar2);
            }
        }
    }
}
