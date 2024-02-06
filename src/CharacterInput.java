import java.util.Scanner;

public class CharacterInput {

    private String name;
    private int atributes[];
    private int type;
    private Character character;

    public CharacterInput(){
        msgStartCreation();
        setTypeInput();
        if (this.type < 0)
            return;
        msgStartType();
        setNameInput();
        if (this.name.isEmpty())
            return;
        setAtributesInput(); // protect atributes
        setCharacter();
    }

    //message functions
    public void msgStartCreation(){
        System.out.println("Choose the character: Wizard or Warrior.");
    }

    public void msgStartType(){
        if (this.type == 0)
            System.out.println("Let's create a new Warrior!");
        else
            System.out.println("Let's create a new Wizard!");
    }

    //setters inputs
    public void setTypeInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        this.type = -1;

        while (attempts++ < 4 && this.type < 0){
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                this.type = 0;
            } else if (charType.equals("wizard")){
                this.type = 1;
            } else{
                if (attempts < 4)
                    System.out.println("You must choose Wizard or Warrior.");
                else
                    System.out.println("Sorry, you have exhausted the maximum number of attempts.");
            }
        }
    }

    public void setNameInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write the name of character");
        for (int i=0; i < 3; i++){
            this.name = scanner.nextLine();
            if (this.name.isEmpty()){
                if (i < 2){
                    System.out.println("It is not a correct name. Try again!");
                } else{
                    System.out.println("Sorry, you have exhausted the maximum number of attempts.");
                }
            }
            else{
                break;
            }
        }
    }


    public void setAtributesInput() {
        this.atributes = new int[3];

        for (int i = 0; i < atributes.length; i++){
            enterAtribute(i);
            if (this.atributes[i] < 0){
               System.out.println("byebye"); //manage error
              break;
            }
        }
    }

    public void enterAtribute(int numAtribute) {

        Scanner scanner = new Scanner(System.in);
        String[] atrWarrior = {"hp", "stamina", "strenght"};
        String[] atrWizard= {"hp", "mana", "intelligence"};

        if (this.type == 0)
            System.out.println("Write the value of " + atrWarrior[numAtribute]);
        else
            System.out.println("Write the value of " + atrWizard[numAtribute]);
        int attempts = 0;
        do{
            if (scanner.hasNextInt()) {
                this.atributes[numAtribute] = scanner.nextInt();
            } else if (attempts < 3){
                System.out.println("It is not a correct range for this atribute. Try again!");
                this.atributes[numAtribute] = -1;
            } else
                System.out.println("Sorry, you have exhausted the maximum number of attempts.");
            attempts++;
        } while (attempts < 3 && this.atributes[numAtribute] < 0);

    }

    public void setCharacter(){
        if (this.type == 0){
            this.character = new Warrior(this.name, this.atributes[0], this.atributes[1], this.atributes[2]);
        } else if (this.type == 1) {
            this.character = new Wizard(this.name, this.atributes[0], this.atributes[1], this.atributes[2]);
        } else
            this.character = null;
    }

}
