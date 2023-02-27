package srcs.Systems.MainSystem;

import srcs.Systems.Money.Money;

public class MainSystem {
    private static MainSystem instance;
    private static Money playerMoney;
    private static Money enemyMoney;

    public static MainSystem getInstance() {
        if (instance == null)
            instance = new MainSystem();
        return instance;
    }
    private MainSystem() {
        startSystem();
    }
    private void startSystem() {
        playerMoney = new Money();
        enemyMoney = new Money();
    }
    public static Money getPlayerMoney() {
        return playerMoney;
    }
    public static Money getEnemyMoney() {
        return enemyMoney;
    }
}
