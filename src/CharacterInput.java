import java.util.Scanner;

public class CharacterInput {

    private String name;
    private int hp;
    private int atribute1;
    private int atribute2;
    private int type;


    public CharacterInput(){
        msgStartCreation();
        setTypeInput();
        msgStartType();
        setNameInput();
        setHP(); // make random
        setAtribute1(); //random;
        setAtribute2();
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
                    System.out.println("You must choose Wizard or Warrior.");
            }
        }
        if (this.type < 0){
            System.out.println("Sorry, you have exhausted the maximum number of attempts.");
            System.out.println("Your character will be assigned randomly");
            this.type = 1; //pending to random
        }
    }

    public void setNameInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        this.name = "";
        System.out.println("Write the name of character");

        while (attempts++ < 4 && this.name.isEmpty()){
            this.name = scanner.nextLine();
            if (this.name.isEmpty()){
                System.out.println("It is not a correct name. Try again!");
            } else{
                System.out.println("Let's define " + this.name + "'s attributes.");
            }
        }
        if (this.name.isEmpty()){
            System.out.println("Sorry, you have exhausted the maximum number of attempts.");
            System.out.println("Your character will be named Fighter.");
            this.name = "Fighter";
        }

    }

    public void setHP() {
        this.hp = -1;
        String atributeName = "hp";
        enterAtribute(atributeName, 1, 50);

    }

    public void setAtribute1() {
        this.atribute1 = -1;
        String atributeName;
        if (this.type == 0){
            atributeName = "stamina";
        } else{
            atributeName = "mana";
        }
        this.atribute1 = enterAtribute(atributeName, 1, 50);
    }

    public void setAtribute2() {
        this.atribute2 = -1;
        String atributeName;
        if (this.type == 0){
            atributeName = "strength";
        } else{
            atributeName = "intelligence";
        }
        this.atribute2 = enterAtribute(atributeName, 1, 50);
    }

    public int enterAtribute(String atributeName, int min, int max) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the value of " + atributeName);
        int value = -1;
        int attempts = 0;
        while (attempts++ < 4 && value < 0){
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0){ //out of range
                    value  = -1;
                    System.out.println("It is not a correct range for this atribute. Try again!");
                }
            } else {
                System.out.println("It is not a correct range for this atribute. Try again!");
                value = -1;
            }
        }

        if (value < 0){
            System.out.println("Sorry, you have exhausted the maximum number of attempts.");
            System.out.println("The atribute will be assigned randomly.");
            value = 20; //randomly
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

    public int getAtribute1() {
        return this.atribute1;
    }

    public int getAtribute2() {
        return this.atribute2;
    }
}
