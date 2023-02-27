package srcs.Systems.Experiance;

public class Experience {
    public int currentexperience;

    public void increasedExperience(String t) { // kill enemies
        switch (t) {
            case "t1":
                currentexperience += 20;
            case "t2":
                currentexperience += 40;
            case "t3":
                currentexperience += 60;
        }
    }

    public void setStartExperience() {// restart game
        currentexperience = 0;
    }
}
