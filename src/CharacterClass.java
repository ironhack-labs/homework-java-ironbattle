public enum CharacterClass {
    WARRIOR("Warrior"), WIZARD("Wizard");

    private final String text;

    CharacterClass(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
