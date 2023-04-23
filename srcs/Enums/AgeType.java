package srcs.Enums;

public enum AgeType {
    SKELETON("skeleton age"),
    STONE("stone age"),
    EGYPT("egypt age"),
    KNIGHT("knight age"),
    WIZARD("wizard age"),
    SAMURAI("samurai age"),
    FF7("final fantasy age"),
    SOLDER("soldier age"),
    ALIEN("alien age"),
    NONE("none age");

    // public abstract String getAgeName();
    private String ageName;
    private AgeType(String ageName) {
        this.ageName = ageName;
    }

    public String getAgeName() {
        return ageName;
    }
}
