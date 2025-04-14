package org.example;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        if(stamina > 50){
            System.out.println("La stamina no puede superar 50, recibirá 25");
            this.stamina = 25;
        } else if (stamina <= 0) {
            System.out.println("La stamina no puede ser menor que 1, recibirá 25");
            this.stamina = 25;
        } else {
            this.stamina = stamina;
        };
        setStrength(strength);
    }

    public Warrior(String name) {
        super(name, ThreadLocalRandom.current().nextInt(100, 201));
        this.stamina = ThreadLocalRandom.current().nextInt(10, 51);
        this.strength = ThreadLocalRandom.current().nextInt(1, 11);
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStamina(int stamina){
        this.stamina=stamina;
    }

    public void setStrength(int strength) {
        if(strength > 10){
            System.out.println("La fuerza no puede superar 10, recibirá 5");
            this.strength = 5;
        }else if (strength <= 0) {
            System.out.println("La fuerza no puede ser menor que 1, recibirá 5");
            this.strength = 5;
        } else {
        this.strength = strength;
        }
    }

    @Override
    public void attack(Character target) {
        Random random = new Random();
        boolean heavyAttack = random.nextBoolean(); // devuelve true o false random
        int damage = 0;

        if (heavyAttack && stamina >= 5) {
            // sale heavy Attack
            damage = strength;
            stamina -= 5;
            System.out.println(getName() + "hace un HEAVY ATTACK!!!");
        } else if (stamina >= 1) {
            // sale weak Attack
            damage = strength / 2;
            stamina += 1;
            System.out.println(getName() + " hace un weak attack!");
        } else {
            // No queda stamina
            stamina += 2;
            System.out.println(getName() + " necesita descansar y recuperar stamina...");
        }

        // Quitar la vida
        int newHp = target.getHp() - damage;
        target.setHp(newHp);
        if(target.getHp() <= 0){
            target.setAlive(false);
        }
        System.out.println(getName() + " hace " + damage + " puntos de daño a " + target.getName() +
                ". A " + target.getName() + " le quedan " + target.getHp() + " puntos de HP.");
    }

}
