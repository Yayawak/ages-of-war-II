package srcs.Systems.integratedSystem;

import javax.print.attribute.standard.MediaSize.Engineering;

import audio.Music;
import srcs.Enums.AgeType;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.Debugger.DebugPanel;
import srcs.GameUI.mainGame.Debugger.DebugPanelDepreicated;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.GameUI.topBar.ultimateUpgradePanel.ultimate.UltimatePanel;
import srcs.GameUI.topBar.unitsBox.UnitsBox;
import srcs.Systems.AgeSystem.AgeData;
import srcs.Systems.AgeSystem.AgeList.FF7Age;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.EnemySystem.EnemyIntegratedSystem;
import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.Gold.GoldSystem;
import srcs.Systems.TowerSystem.TowerSystem;

public class IntegratedSystem {
    public static int count_threads = 0;
    private static IntegratedSystem instance;
    private GoldSystem playerGoldSystem;
    private GoldSystem enemyGoldSystem;

    private ExpSystem playerExpSystem;
    private ExpSystem enemyExpSystem;

    private TowerSystem playerTowerSystem;
    private TowerSystem enemyTowerSystem;

    // private AgeType currentGameAge;
    private AgeData currentPlayerAgeData;
    private AgeData currentEnemyAgeData;

    public static IntegratedSystem getInstance() {
        if (instance == null)
            instance = new IntegratedSystem();
        return instance;
    }

    private IntegratedSystem() {
        startSystem();
    }

    private void startSystem() {
        currentPlayerAgeData = SkeletonAge.getInstance();
        currentEnemyAgeData = SkeletonAge.getInstance();
        // currentEnemyAgeData = FF7Age.getInstance();

        playerGoldSystem = new GoldSystem(200);
        enemyGoldSystem = new GoldSystem(500);
        // playerGoldSystem = new GoldSystem(850);
        // playerGoldSystem = new GoldSystem(500);
        // playerGoldSystem = new GoldSystem(300);
        // enemyGoldSystem = new GoldSystem(500);
        // enemyGoldSystem = new GoldSystem(5000);
        // enemyGoldSystem = new GoldSystem(200);
        // enemyGoldSystem = new GoldSystem(100);
        // enemyGoldSystem = new GoldSystem(30);
        // enemyGoldSystem = new GoldSystem(50);

        // playerExpSystem = new ExpSystem(50);
        // playerExpSystem = new ExpSystem(10000);
        playerExpSystem = new ExpSystem(200);
        // playerExpSystem = new ExpSystem(1250);
        // enemyExpSystem = new ExpSystem(8000);
        enemyExpSystem = new ExpSystem(99);

        // ! bug can draw firsst unit because cant get tower prototype ?
        playerTowerSystem = new TowerSystem(
            SkeletonAge.getInstance().getNewTowerPrototype(TeamType.PLAYER)
        );
        enemyTowerSystem = new TowerSystem(
            SkeletonAge.getInstance().getNewTowerPrototype(TeamType.ENEMY)
        );
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

    public TowerSystem getPlayerTowerSystem() {
        return playerTowerSystem;
    }

    public TowerSystem getEnemyTowerSystem() {
        return enemyTowerSystem;
    }

    public AgeData getCurrentPlayerAgeData() {
        return currentPlayerAgeData;
    }

    public void setCurrentPlayerAgeData(AgeData currentPlayerAgeData) {
        this.currentPlayerAgeData = currentPlayerAgeData;
    }

    public AgeData getCurrentEnemyAgeData() {
        return currentEnemyAgeData;
    }

    public void setCurrentEnemyAgeData(AgeData currentEnemyAgeData) {
        this.currentEnemyAgeData = currentEnemyAgeData;
    }

    public void upgradeAge(TeamType teamToUpgrade) {
        if (teamToUpgrade == TeamType.PLAYER) {
            //todo : check if exp enough
            if (getPlayerExpSystem().getExperiance() >
                currentPlayerAgeData.getExpRequiredToUpgrade()
            ) {
                // todo : decrease exp :
                playerExpSystem.decreaseExperiance(
                    currentPlayerAgeData.getExpRequiredToUpgrade()
                );

                // todo : change bg age
                currentPlayerAgeData = currentPlayerAgeData.getNextAgeData();

                // todo : remove old tower(Skeleton) and change pointer to point to tower(Stone)
                for (GameObject go : MainGame.getInstance().getObjectsInScene()) {
                    if (go instanceof TowerGameObject
                        // && go.getTeamType() == TeamType.PLAYER
                    ) {
                        TowerGameObject playerTower = (TowerGameObject)go;
                        System.out.println("Enter player tower changer state");
                        playerTower.upgradeTowerToNewAge();
                        break;
                    }
                }

                // todo : replace old unitsBoxes to new one
                // UnitsBox.getInstance().setNumberOfUnits(
                //     getCurrentPlayerAgeData().getCharacterPrototypes().size()
                // );
                UnitsBox.getInstance().updateUnitsPanel();
                UltimatePanel.getInstance().setUltiImage(getCurrentPlayerAgeData().getUltimateImage());

                Music upgradeSfx = new Music();
                upgradeSfx.setFile("retro-arcade.wav");
                upgradeSfx.play();

                // todo : replace old ultimateImages to new
                DebugPanel.getInstance().setDebugText("Player has upgrader ages to be ... "
                    + getCurrentPlayerAgeData().getAgeType().getAgeName()
                );
            }
        }
        if (teamToUpgrade == TeamType.ENEMY) {
            // if (getEnemyExpSystem().getExperiance() >=
            //     currentEnemyAgeData.getExpRequiredToUpgrade()
            // ) {
                System.out.println("Enemy upgraded AGE");
                // todo : decrease exp :
                EnemyIntegratedSystem.getInstance().decreaseEnemyExp(
                    currentEnemyAgeData.getExpRequiredToUpgrade()
                );
                DebugPanel.getInstance().setDebugText(
                    "Enemy Exp system after upgrade is : " +
                    enemyExpSystem.getExperiance()
                );

                // todo : change bg age
                currentEnemyAgeData = currentEnemyAgeData.getNextAgeData();

                // todo : remove old tower(Skeleton) and change pointer to point to tower(Stone)
                for (GameObject go : MainGame.getInstance().getObjectsInScene()) {
                    if (go instanceof TowerGameObject
                        && go.getTeamType() == TeamType.ENEMY
                    ) {
                        TowerGameObject enemyTowerGo = (TowerGameObject)go;
                        System.out.println("Enter enemy tower changer state");
                        enemyTowerGo.upgradeTowerToNewAge();
                        break;
                    }
                }
            // }
        }

    }

}
