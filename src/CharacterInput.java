import java.util.Scanner;

public class CharacterInput {

    private String name = "";
    private int hp = -1;
    private int attribute1 = -1;
    private int attribute2 = -1;
    private int type = -1; //0-warrior 1-wizard

    public CharacterInput(){
        setTypeInput();
        setNameInput();
        setHP();
        setAttribute1();
        setAttribute2();
    }

    public CharacterInput(String random){
        setAttributesRandom();
    }

    //Setters attributes Random
    public void setAttributesRandom() {
        this.type = Utils.generateRandomNumber();
        this.name = "Fighter";
        this.attribute1 = Utils.generateRandomNumber(10, 50);
        if (this.type == 0){
            this.hp = Utils.generateRandomNumber(100, 200);
            this.attribute2 = Utils.generateRandomNumber(1, 10);
        } else{
            this.hp = Utils.generateRandomNumber(50, 100);
            this.attribute2 = Utils.generateRandomNumber(1, 50);
        }
    }

    //Setters inputs from console
    public void setTypeInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        System.out.println("Choose the character type: Wizard or Warrior.");

        do{
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                this.type = 0;
            } else if (charType.equals("wizard")){
                this.type = 1;
            } else if (attempts < 2){
                System.out.println("Invalid input. Please enter a valid character type (wizard or warrior).");
            }
        } while (attempts++ < 2 && this.type < 0);

        if (attempts == 3 && this.type < 0){
            this.type = assignRandomInput();
        }
    }

    public void setNameInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        if (this.type == 0)
            System.out.println("Let's create a new Warrior!");
        else
            System.out.println("Let's create a new Wizard!");
        System.out.println("Write the name of character.");

        do {
            this.name = scanner.nextLine();
            if (!this.name.isEmpty() && !this.name.replaceAll(" ","").isEmpty()){
                System.out.println("Let's define " + this.name + "'s attributes.");
                break ;
            } else if (attempts < 2){
                System.out.println("Oops, you must introduce a valid name. Try again!");
            }
        } while (attempts++ < 2);

        if (attempts == 3){
            this.name = "Fighter #" + Utils.generateRandomNumber(1,100);
            System.out.println("Maximum attempts reached. Character will be named: " + this.name);
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

    public int enterAttribute (String attributeName, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        int attempts = 0;

        System.out.println("Define " + attributeName + "(range: " + min + " to " + max + "):");
        do {
            if (attempts > 0)
                System.out.println("Oops, value is out of range. Try again!");
            String input = scanner.nextLine();
            try{
                value = Integer.parseInt(input);
                if (min <= value && value <= max) {
                    System.out.println("Great! Value for " + attributeName + " assigned to " +  value);
                    break;
                }
                else{
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e){
                System.out.print("Input out of range.");
            } catch (NumberFormatException e) {
                System.out.print("Oops, you must introduce an integer number.");
            }
        } while (attempts++ < 2);

        if (attempts == 3){
            value = assignRandomInput(min, max);
        }
        return (value);
    }

    public int assignRandomInput(int min, int max){
        System.out.println(" Sorry, you have exhausted the maximum number of attempts. Assigning random value.");
        return (Utils.generateRandomNumber(min, max));
    }
    public int assignRandomInput(){
        System.out.println("Sorry, you have exhausted the maximum number of attempts. Assigning random character.");
        return (Utils.generateRandomNumber());
    }

    //Character creator method
    public Character characterCreatorInput(){
        Character character;
        if (this.getType() == 0){
            character = new Warrior(this.getName(), this.getHP(),
                    this.getAttribute1(), this.getAttribute2());
        } else {
            character = new Wizard(this.getName(), this.getHP(),
                    this.getAttribute1(), this.getAttribute2());
        }
        return character;
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
