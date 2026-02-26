package com.ironhack.factory;

import com.ironhack.model.Warrior;
import com.ironhack.model.Wizard;
import java.util.Random;

public class CharacterFactory {
    private static final Random random = new Random(System.currentTimeMillis());

    public static Warrior createWarrior(String name, int hp, int stamina, int strength) {
        return new Warrior(name, hp, stamina, strength);
    }

    public static Wizard createWizard(String name, int hp, int mana, int intelligence) {
        return new Wizard(name, hp, mana, intelligence);
    }

    public static Warrior createRandomWarrior(String name) {
        int hp = random.nextInt(101) + 100;
        int stamina = random.nextInt(41) + 10;
        int strength = random.nextInt(10) + 1;
        return new Warrior(name, hp, stamina, strength);
    }

    public static Wizard createRandomWizard(String name) {
        int hp = random.nextInt(51) + 50;
        int mana = random.nextInt(41) + 10;
        int intelligence = random.nextInt(50) + 1;
        return new Wizard(name, hp, mana, intelligence);
    }
}