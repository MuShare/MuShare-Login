package org.mushare.login.enums;

public enum OS {

    unkonwn(0, "unknown"),
    Web(0, "web"),
    iOS(1, "ios"),
    Android(2, "android");

    private int code;
    private String identifier;

    private OS(int code, String identifier) {
        this.code = code;
        this.identifier = identifier;
    }

    public int getCode() {
        return code;
    }

    public String getIdentifier() {
        return identifier;
    }

    public static OS fromIdentifer(String identifier) {
        switch (identifier) {
            case "web":
                return Web;
            case "ios":
                return iOS;
            case "android":
                return Android;
            default:
                return unkonwn;
        }
    }

}
