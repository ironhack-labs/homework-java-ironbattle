package com.ironhack.homework;

import java.util.Random;

import static com.ironhack.homework.Main.*;

public class Wizard extends Character implements Attacker{
    private int mana;
    private int intelligence;

    // Auxiliar variables
    private String detailsAttack;
    private String infoAttack;

    // COLOR PRINT STYLES
    private static final String BOLD = "\033[1m";
    private static final String RESET = "\033[0m";

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 10){
            this.mana = 10;
        } else if (mana > 50) {
            this.mana = 50;
        } else {
            this.mana = mana;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence < 1){
            this.intelligence = 1;
        } else if (intelligence > 50) {
            this.intelligence = 50;
        } else {
            this.intelligence = intelligence;
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
    public String wizardInfo() {
        return "\nWizard Information: \n" +
                "- Name         : " + getName() + "\n" +
                "- Hp           : " + getHp() + "\n" +
                "- Mana         : " + getMana() + "\n" +
                "- Intelligence : " + getIntelligence();
    }

    @Override
    public void setHp(int hp) {
        if (isFirstSet()) {  // Only First Time
            if (hp < 50) {
                super.setHp(50);
            } else if (hp > 100) {
                super.setHp(100);
            } else {
                super.setHp(hp);
            }
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void attack(Character character) {
        boolean type = new Random().nextBoolean(); // creating a random boolean

        // damage and typeAttack variables.
        int damage;
        String typeAttack = "";
        String infoAttack = "";

        // Determine the chosen random attack, in case you want to print on the output.
        if (type){
            typeAttack = "Fireball";
        }else{
            typeAttack = "Staff hit";
        }

        // Attack damage and mana depending on the type of attack and the intelligence of the spell.
        if(typeAttack.equals("Fireball") && getMana() >= 5){
            setDetailsAttack("\nWizard → Fireball (Mana -5 | Damage = Intelligence)");
            damage = getIntelligence();
            infoAttack = "Details [ Mana: " + getMana() + " - 5 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.mana = mana - 5;
            player.setFile(fireball_s);
            player.startPlaying();
        } else if(typeAttack.equals("Staff hit") || getMana() > 0) {
            setDetailsAttack("\nWizard → Staff Hit (Mana +1 | Damage = 2)");
            damage = 2;
            infoAttack = "Details [ Mana: " + getMana() + " + 1 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.mana = mana + 1;
            player.setFile(staffhit_s);
            player.startPlaying();

        } else {
            setDetailsAttack("\nWizard → No Attack!!!! (Mana +2 | Damage = 0)");
            damage = 0;
            infoAttack = "Details [ Mana: " + getMana() + " + 2 | Attack Damage → " + damage + " ]";
            setInfoAttack(infoAttack);
            this.mana = mana + 2;
        }

        // The character's health based on the damage taken.
        character.setHp(character.getHp() - damage);

        // PRINT THE ATTACK DETAILS
//        System.out.println("+-----------------+---------+---------+---------------+");
//        System.out.printf("| %-51s |\n", infoAttack);
//        System.out.println("+-----------------+---------+---------+---------------+");
//        System.out.println("| "+BOLD+"Name"+RESET+"            | "+BOLD+"Hp"+RESET+"      | "+BOLD+"Mana"+RESET+"    | "+BOLD+"Intelligence"+RESET+"  |");
//        System.out.println("+-----------------+---------+---------+---------------+");
//
//        System.out.printf("| %-15s | %-7d | %-7d | %-13d |\n", getName(), getHp(), getMana(), getIntelligence());
//
//        System.out.println("+-----------------+---------+---------+---------------+");

//        battleInfo(infoAttack);
    }

    public String battleInfo() {
        return getDetailsAttack() +
                "\n+-----------------+---------+---------+---------------+\n" +
                String.format("| %-51s |\n", getInfoAttack()) +
                "+-----------------+---------+---------+---------------+\n" +
                "| " + BOLD + "Name" + RESET + "            | " + BOLD + "Hp" + RESET + "      | " + BOLD + "Mana" + RESET + "    | " + BOLD + "Intelligence" + RESET + "  |\n" +
                "+-----------------+---------+---------+---------------+\n" +
                String.format("| %-15s | %-7d | %-7d | %-13d |\n", getName(), getHp(), getMana(), getIntelligence()) +
                "+-----------------+---------+---------+---------------+\n";
    }
}
