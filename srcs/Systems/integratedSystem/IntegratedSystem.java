package srcs.Systems.integratedSystem;

import srcs.Enums.AgeType;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;
import srcs.GameUI.topBar.unitsBox.UnitsBox;
import srcs.Systems.AgeSystem.AgeData;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.Gold.GoldSystem;
import srcs.Systems.TowerSystem.TowerSystem;

public class IntegratedSystem {
    private static IntegratedSystem instance;
    private GoldSystem playerGoldSystem;
    private GoldSystem enemyGoldSystem;

    private ExpSystem playerExpSystem;
    private ExpSystem enemyExpSystem;

    private TowerSystem playerTowerSystem;
    private TowerSystem enemyTowerSystem;

    // private AgeType currentGameAge;
    private AgeData currentAgeData;

    public static IntegratedSystem getInstance() {
        if (instance == null)
            instance = new IntegratedSystem();
        return instance;
    }

    private IntegratedSystem() {
        currentAgeData = SkeletonAge.getInstance();
        startSystem();
    }

    private void startSystem() {

        playerGoldSystem = new GoldSystem(850);
        // playerGoldSystem = new GoldSystem(300);
        enemyGoldSystem = new GoldSystem(500);
        // enemyGoldSystem = new GoldSystem(500);
        // enemyGoldSystem = new GoldSystem(200);
        // enemyGoldSystem = new GoldSystem(100);
        // enemyGoldSystem = new GoldSystem(30);
        // enemyGoldSystem = new GoldSystem(50);

        // playerExpSystem = new ExpSystem(50);
        playerExpSystem = new ExpSystem(10000);
        // playerExpSystem = new ExpSystem(1250);
        enemyExpSystem = new ExpSystem(8000);

        playerTowerSystem = new TowerSystem(
            SkeletonAge.getInstance().getTowerPrototype()
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

    public AgeData getCurrentAgeData() {
        return currentAgeData;
    }

    public void setCurrentAgeData(AgeData currentAgeData) {
        this.currentAgeData = currentAgeData;
    }

    public void upgradeAge(TeamType teamToUpgrade) {
        //todo : check if exp enough
        // if ()
        if (teamToUpgrade == TeamType.PLAYER) {
            if (getPlayerExpSystem().getExperiance() >
                currentAgeData.getExpRequiredToUpgrade()
            ) {
                // todo : decrease exp :
                playerExpSystem.decreaseExperiance(
                    currentAgeData.getExpRequiredToUpgrade()
                );

                // todo : change bg age
                currentAgeData = currentAgeData.getNextAgeData();

                // todo : remove old tower(Skeleton) and change pointer to point to tower(Stone)
                for (GameObject go : MainGame.getInstance().getObjectsInScene()) {
                    if (go instanceof TowerGameObject) {
                        TowerGameObject playerTower = (TowerGameObject)go;
                        // System.out.println("Enter tower changer state");
                        playerTower.upgradeTowerToNewAge();
                        break;
                    }
                }

                // todo : replace old unitsBoxes to new one
                UnitsBox.getInstance().updateUnitsPanel();

                // todo : replace old ultimateImages to new
            }
        }


        // get current age
        AgeType currentAge = AgeType.STONE;
        switch (currentAge) {
            case SKELETON:
                currentAge = AgeType.STONE;
                break;
            case STONE:
                currentAge = AgeType.EGYPT;
                break;
            case EGYPT:
                currentAge = AgeType.KNIGHT;
                break;
            case KNIGHT:
                currentAge = AgeType.WIZARD;
                break;
            case WIZARD:
                currentAge = AgeType.SOLDER;
                break;
            case SOLDER:
                currentAge = AgeType.ALIEN;
                break;
            case ALIEN:
                currentAge = AgeType.NONE;
                break;
            default:
                break;
        }

    }

}
