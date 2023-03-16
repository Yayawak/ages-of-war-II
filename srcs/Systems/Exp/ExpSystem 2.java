package srcs.Systems.Exp;

public class ExpSystem {
    private int experiance;

    public ExpSystem(int initExp) {
        this.experiance = initExp;
    }

    public void increasedExperience(int exp) { // kill enemies
        experiance += exp;
    }

    public void setStartExperience() {// restart game
        experiance = 0;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }
}
