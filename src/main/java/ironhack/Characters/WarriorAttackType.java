package ironhack.Characters;

public enum WarriorAttackType {
    WEAK(0),
    HEAVY(5);

    private final int staminaCost;
    WarriorAttackType(int staminaCost) {
        this.staminaCost = staminaCost;
    }

    public int getStaminaCost() {
        return staminaCost;
    }
}
