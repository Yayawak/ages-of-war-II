package srcs.Systems;

public class TurretSystem {
    private static TurretSystem instance;
    public static TurretSystem getInstance() {
        if (instance == null) instance = new TurretSystem();
        return instance;
    }

    private TurretSystem() {

    }
}
