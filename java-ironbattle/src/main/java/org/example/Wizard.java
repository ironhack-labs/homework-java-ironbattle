package org.example;

import java.util.Random;

public class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, (int) (Math.random() * (101 - 50)) + 50);
        setMana((int) (Math.random() * (51 - 10)) + 10);
        setIntelligence((int) (Math.random() * (51 - 1)) + 1);
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        if (hp < 50 || hp > 100) {
            System.out.println("Error la vida está fuera de rango: 50 - 100, recibirá 50");
            setHp(50);
        } else {
            setHp(hp);
        }
        if (mana < 1 || mana > 50) {
            System.out.println("Error mana fuera de rango: 1 - 50, recibirá 25");
            setMana(25);
        } else {
            setMana(mana);
        }
        if (intelligence < 1 || intelligence > 10) {
            System.out.println("Error inteligencia fuera de rango: 1 - 10, recibirá 5");
            setIntelligence(5);
        } else {
            setIntelligence(intelligence);
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public void attack(Character target) {
        String[] attacks = {"Bola de fuego", "Golpe de baston"};
        Random random = new Random();
        int R = random.nextInt(attacks.length);
        String attack = attacks[R];
        System.out.println(getName() + ": va a atacar con " + attack);

        switch (attack) {
            case "Bola de fuego":
                fireballAttack(target);
                break;
            case "Golpe de baston":
                staffHitAttack(target);
                break;
        }

        if (target.getHp() <= 0) {
            target.setAlive(false);
        }
    }

    private void fireballAttack(Character target) {
        System.out.println("Lanzando ataque de bola de fuego");
        if (this.mana < 0) {
            System.out.println(getName() + ": no tiene suficiente mana, usar el ataque de bola de fuego");
            staffHitAttack(target);
        } else {
            target.setHp(target.getHp() - this.intelligence);
            setMana(getMana() - 5);
            System.out.println(getName() + " hace " + this.intelligence + " puntos de daño a " + target.getName() +
                    ". A " + target.getName() + " le quedan " + target.getHp() + " puntos de HP.");
        }
    }

    private void staffHitAttack(Character target) {
        System.out.println("Lanzando ataque de bastón");
        if (this.mana <= 0) {
            setMana(getMana() + 2);
            System.out.println(getName() + " recupera " + 2 + " puntos de mana. " + target.getName() +
                    ". A " + target.getName() + " le quedan " + target.getHp() + " puntos de HP.");
        } else {
            target.setHp(target.getHp() - 2);
            setMana(getMana() + 1);
            System.out.println(getName() + " hace " + 2 + " puntos de daño a " + target.getName() +
                    " y recupera 1 de mana. A " + target.getName() + " le quedan " + target.getHp() + " puntos de HP.");
        }
    }
}
