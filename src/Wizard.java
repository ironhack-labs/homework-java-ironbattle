import java.util.Random;

class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        this.mana = mana;
        this.intelligence = intelligence;
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
    public void attack(Character opponent) {
        Random random = new Random();
        boolean isFireball = random.nextBoolean(); // Randomly choose Fireball or Staff hit
        if (isFireball) {
            if (this.mana >= 5) {
                opponent.setHp(opponent.getHp() - this.intelligence);
                this.mana -= 5;
            } else {
                opponent.setHp(opponent.getHp() - 2);
                this.mana += 1; // Recover mana by 1 after Staff hit
            }
        } else {
            opponent.setHp(opponent.getHp() - 2);
            this.mana += 1; // Recover mana by 1 after Staff hit
        }

        if (this.mana < 0) {
            this.mana = Math.min(50, this.mana + 2); // Ensure mana does not exceed 50
        }
    }
}

