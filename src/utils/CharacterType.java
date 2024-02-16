package utils;

public enum CharacterType {
    WIZARD("Wizard"),
    WARRIOR("Warrior");

    private final String description;

    CharacterType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
