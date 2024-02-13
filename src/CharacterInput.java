import java.util.Scanner;

public class CharacterInput {

    private String name = "";
    private int hp = -1;
    private int attribute1 = -1;
    private int attribute2 = -1;
    private int type = -1; //0-warrior 1-wizard


    public CharacterInput(){
        msgStartCreation();
        setTypeInput();
        msgStartType();
        setNameInput();
        setHP(); // make random
        setAttribute1(); //random;
        setAttribute2();
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
    public void msgAssignRandomly(){
        System.out.println("Sorry, you have exhausted the maximum number of attempts.");
    }


    //setters inputs
    public void setTypeInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts++ < 4 && this.type < 0){
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                this.type = 0;
            } else if (charType.equals("wizard")){
                this.type = 1;
            } else if (attempts < 4){
                System.out.println("You must choose Wizard or Warrior.");
            } else{
                msgAssignRandomly();
                System.out.println("Your character will be assigned randomly");
                this.type = 1; //pending to random
            }
        }
    }

    public void setNameInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        System.out.println("Write the name of character");

        while (attempts++ < 4 && this.name.isEmpty()){
            this.name = scanner.nextLine();
            if (!this.name.isEmpty()){
                System.out.println("Let's define " + this.name + "'s attributes.");
            } else if (attempts < 4){
                System.out.println("It is not a correct name. Try again!");
            } else{
                msgAssignRandomly();
                System.out.println("Your character will be named Fighter.");
                this.name = "Fighter";
            }
        }
    }

    public void setHP() {
        String attributeName = "Health Points";
        if (this.type == 0)
            this.hp =  enterAttribute(attributeName, 100, 200);
        else
           this.hp = enterAttribute(attributeName, 50, 100);
    }

    public void setAttribute1() {
        if (this.type == 0){
            this.attribute1 = enterAttribute("stamina", 10, 50);
        } else{
            this.attribute1 = enterAttribute("mana", 10, 50);
        }
    }

    public void setAttribute2() {
        if (this.type == 0){
            this.attribute2 = enterAttribute("strength", 1, 10);
        } else{
            this.attribute2 = enterAttribute("intelligence", 1, 50);
        }
    }

    public int enterAttribute(String attributeName, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        int attempts = 0;

        System.out.println("Define " + attributeName + "(range: " + min + " to " + max + "):");
        while (attempts++ < 4 && (value < min || value > max)){
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                System.out.println("Value assigned" +  value);
            }
            if (attempts < 4 && (value < min || value > max)){
                System.out.println("Value is out of range. Try again!");
            }
            else if (attempts == 4 && (value < min || value > max)){
                msgAssignRandomly();
                System.out.println("The attribute will be assigned randomly.");
                value = min; //randomly
            }
        }
        return (value);
    }

    //getters
    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public int getHP() {
        return this.hp;
    }

    public int getAttribute1() {
        return this.attribute1;
    }

    public int getAttribute2() {
        return this.attribute2;
    }
}
