public enum Colors {
    red("\u001B[31m"),
    green("\u001B[32m"),
    white("\u001B[0m");

    private final String code;

    Colors(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
