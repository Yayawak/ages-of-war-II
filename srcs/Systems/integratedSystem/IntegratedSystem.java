package srcs.Systems.integratedSystem;

import srcs.Systems.Gold.GoldSystem;

public class IntegratedSystem {
    private static IntegratedSystem instance;
    private GoldSystem playerGoldSystem;
    private GoldSystem enemyGoldSystem;
    // private static GoldSystem playerGoldSystem;
    // private static GoldSystem enemyGoldSystem;

    public static IntegratedSystem getInstance() {
        if (instance == null)
            instance = new IntegratedSystem();
        return instance;
    }

    private IntegratedSystem() {
        startSystem();
    }

    private void startSystem() {
        playerGoldSystem = new GoldSystem(300);
        enemyGoldSystem = new GoldSystem(500);
    }

    public GoldSystem getPlayerGoldSystem() {
        return playerGoldSystem;
    }

    public GoldSystem getEnemyGoldSystem() {
        return enemyGoldSystem;
    }
}
