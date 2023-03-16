package srcs.Systems.integratedSystem;

import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.Gold.GoldSystem;
import srcs.Systems.TowerSystem.TowerSystem;

public class IntegratedSystem {
    private static IntegratedSystem instance;
    private GoldSystem playerGoldSystem;
    private GoldSystem enemyGoldSystem;

    private ExpSystem playerExpSystem;
    private ExpSystem enemyExpSystem;
    // private TowerSystem playerTowerSystem;
    // private TowerSystem enemyTowerSystem;
    private TowerSystem towerSystem;

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
        // enemyGoldSystem = new GoldSystem(500);
        // enemyGoldSystem = new GoldSystem(100);
        enemyGoldSystem = new GoldSystem(30);

        playerExpSystem = new ExpSystem(50);
        enemyExpSystem = new ExpSystem(75);

        // playerTowerSystem = new TowerSystem();
        towerSystem.getInstance();


    }

    public GoldSystem getPlayerGoldSystem() {
        return playerGoldSystem;
    }

    public GoldSystem getEnemyGoldSystem() {
        return enemyGoldSystem;
    }

    public ExpSystem getPlayerExpSystem() {
        return playerExpSystem;
    }

    public ExpSystem getEnemyExpSystem() {
        return enemyExpSystem;
    }
}
