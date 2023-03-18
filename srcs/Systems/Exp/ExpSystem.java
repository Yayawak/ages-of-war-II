package srcs.Systems.Exp;

public class ExpSystem {
    private int experiance;

    public ExpSystem(int initExp) {
        this.experiance = initExp;
    }

    public void decreaseExperiance(int exp) {
        // experiance -= exp;
        setExperiance(
            getExperiance() - exp
        );
        // setExperiance(
        //     getExperiance() - exp
        // );
    }

    public void increasedExperience(int exp) { // kill enemies
        experiance += exp;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
        // if (experiance > this.experiance)
            // this.experiance = experiance;
        if (experiance < 0) {
            experiance = 0;
        }

    }
}
