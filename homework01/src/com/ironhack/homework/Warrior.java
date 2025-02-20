package com.ironhack.homework;

import java.util.Random;

import static com.ironhack.homework.Main.*;

public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    // Auxiliar variables
    private String detailsAttack;
    private String infoAttack;

    // COLOR PRINT STYLES
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina < 10){
            this.stamina = 10;
        } else if (stamina > 50) {
            this.stamina = 50;
        } else {
            this.stamina = stamina;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 1){
            this.strength = 1;
        } else if (strength > 10){
            this.strength = 10;
        } else {
            this.strength = strength;
        }
    }

    public String getDetailsAttack() {
        return detailsAttack;
    }

    public void setDetailsAttack(String detailsAttack) {
        this.detailsAttack = detailsAttack;
    }

    public String getInfoAttack() {
        return infoAttack;
    }

    public void setInfoAttack(String infoAttack) {
        this.infoAttack = infoAttack;
    }

    // Method that returns the detailed information of the character
    public String warriorInfo() {
        return "\nWarrior Information: \n" +
                "- Name     : " + getName() + "\n" +
                "- Hp       : " + getHp() + "\n" +
                "- Stamina  : " + getStamina() + "\n" +
                "- Strength : " + getStrength();
    }

    @Override
    public void setHp(int hp) {
        if (isFirstSet()) {  // Only First Time
            if (hp < 100) {
                super.setHp(100);
            } else if (hp > 200) {
                super.setHp(200);
            } else {
                super.setHp(hp);
            }
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void attack(Character character) {
        boolean type = new Random().nextBoolean(); // creating a random boolean.

        // damage and typeAttack variables.
        int damage;
        String typeAttack = "";
        String infoAttack = "";

        // Determine the chosen random attack, in case you want to print on the output.
        if (type){
            typeAttack = "Heavy Attack";
        }else{
            typeAttack = "Weak Attack";
        }

        // Attack damage and stamina depending on the type of attack and strength.
        if(typeAttack.equals("Heavy Attack") && getStamina() >= 5){
            setDetailsAttack("\nWarrior → Heavy Attack (Stamina -5 | Damage = Strength)");
            damage = getStrength();
            infoAttack = "Details [ Stamina: " + getStamina() + " - 5 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.stamina = stamina - 5;
            //player.setFile(stronghit_s);
        } else if(typeAttack.equals("Weak Attack") || getStamina() > 0) {
            setDetailsAttack("\nWarrior → Weak Attack (Stamina +1 | Damage = Strength / 2)");
            damage = (int) Math.round(getStrength() / 2.0);
            infoAttack = "Details [ Stamina: " + getStamina() + " + 1 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.stamina = stamina + 1;
           //player.setFile(weakhit_s);
        } else {
            setDetailsAttack("Warrior → No Attack!!!! (Stamina +2 | Damage 0)");
            damage = 0;
            infoAttack = "Details [ Stamina: " + getStamina() + " + 2 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.stamina = stamina + 2;
        }

        // The character's health based on the damage taken.
        character.setHp(character.getHp() - damage);

        // PRINT THE ATTACK DETAILS
//        System.out.println("+-----------------+---------+---------+-----------+");
//        System.out.printf("| %-47s |\n", infoAttack);
//        System.out.println("+-----------------+---------+---------+-----------+");
//        System.out.println("| "+BOLD+"Name"+RESET+"            | "+BOLD+"Hp"+RESET+"      | "+BOLD+"Stamina"+RESET+" | "+BOLD+"Strength"+RESET+"  |");
//        System.out.println("+-----------------+---------+---------+-----------+");
//
//        System.out.printf("| %-15s | %-7d | %-7d | %-9d |\n", getName(), getHp(), getStamina(), getStrength());
//
//        System.out.println("+-----------------+---------+---------+-----------+");
//        battleInfo(infoAttack);

    }

    // Method that returns the detailed information of the battle
    public String battleInfo() {
        return getDetailsAttack() +
                "\n+-----------------+---------+---------+-----------+\n" +
                String.format("| %-47s |\n", getInfoAttack()) +
                "+-----------------+---------+---------+-----------+\n" +
                "| " + BOLD + "Name" + RESET + "            | " + BOLD + "Hp" + RESET + "      | " + BOLD + "Stamina" + RESET + " | " + BOLD + "Strength" + RESET + "  |\n" +
                "+-----------------+---------+---------+-----------+\n" +
                String.format("| %-15s | %-7d | %-7d | %-9d |\n", getName(), getHp(), getStamina(), getStrength()) +
                "+-----------------+---------+---------+-----------+\n";
    }
}
