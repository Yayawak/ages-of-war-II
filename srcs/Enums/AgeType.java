package srcs.Enums;

public enum AgeType {
    SKELETON("skeleton age"),
    STONE("stone age"),
    EGYPT("egypt age"),
    KNIGHT("knight age"),
    NINJA("ninja age"),
    SAMURAI("samurai age"),
    WIZARD("wizard age"),
    FF7("final fantasy age"),
    CYBER("cyber age"),
    TEACHER("teacher age"),
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
