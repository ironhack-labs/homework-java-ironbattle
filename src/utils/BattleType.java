package utils;

public enum BattleType {
    RANDOM_BATTLE("1. Random Battle"),
    CUSTOM_BATTLE("2. Customized Battle (character's name and type)"),
    FULL_CUSTOM_BATTLE("3. Full Customized Battle");

    private final String description;

    BattleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
