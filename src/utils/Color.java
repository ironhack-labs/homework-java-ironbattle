package utils;

public enum Color {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    WHITE("\u001B[0m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
