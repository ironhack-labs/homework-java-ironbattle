import java.util.Scanner;

public class CharacterAttributesInput extends CharacterAttributes {

    public CharacterAttributesInput(){
        setTypeInput();
        setNameInput();
        setHP();
        setAttribute1();
        setAttribute2();
    }

    //Setters inputs from console
    public void setTypeInput(){
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        System.out.println("Choose the character: Wizard or Warrior.");

        do{
            String charType = scanner.nextLine().toLowerCase();
            if (charType.equals("warrior")){
                this.type = 0;
            } else if (charType.equals("wizard")){
                this.type = 1;
            } else if (attempts < 2){
                System.out.println("Invalid input. Please enter a valid character(wizard or warrior).");
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
        System.out.println("Write the name of character");

        do {
            this.name = scanner.nextLine();
            if (!this.name.isEmpty()){
                System.out.println("Let's define " + this.name + "'s attributes.");
                break ;
            } else if (attempts < 2){
                System.out.println("Invalid input. Please enter a valid name.");
            }
        } while (attempts++ < 2);

        if (attempts == 3){
            System.out.println("Maximum attempts reached. Character will be named: Fighter.");
            this.name = "Fighter";
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
        do {
            if (attempts > 0)
                System.out.println(" Please enter a valid value within the range.");
            String input = scanner.nextLine();
            try{
                value = Integer.parseInt(input);
                if (min <= value && value <= max) {
                    break;
                }
                else{
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e){
                System.out.print("Input out of range.");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input.");
            }
        } while (attempts++ < 2);

        if (attempts == 3){
            value = assignRandomInput(min, max);
        }
        return (value);
    }
    int assignRandomInput(int min, int max){
        System.out.println(" Maximum attempts reached. Assigning random value.");
        return (Utils.generateRandomNumber(min, max));
    }
    int assignRandomInput(){
        System.out.println("Maximum attempts reached. Assigning random character.");
        return (Utils.generateRandomNumber());
    }
}
