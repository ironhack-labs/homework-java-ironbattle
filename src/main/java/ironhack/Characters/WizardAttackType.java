package ironhack.Characters;

public enum WizardAttackType {
    FIREBALL(5),
    STAFF_HIT(0);

    private final int manaCost;

    WizardAttackType(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getManaCost() { return manaCost; }
}
