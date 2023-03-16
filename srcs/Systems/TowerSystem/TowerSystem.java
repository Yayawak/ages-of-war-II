package srcs.Systems.TowerSystem;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import java.awt.*;

public class TowerSystem {

    private static TowerSystem instance;
    private TowerPrototype playerTowerPrototype;
    public static TowerSystem getInstance() {
        if (instance == null) instance = new TowerSystem();
        return instance;
    }

    private TowerSystem() {
        ImageData towerImgData = new ImageData(
            "tower/tower1.png", 116, 228);
        playerTowerPrototype = new TowerPrototype(1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            new Point(50, 210)
        );
        TowerGameObject playerTowerGameObject =
            new TowerGameObject(playerTowerPrototype);
        MainGame.getInstance().getObjectsInScene().
            add(playerTowerGameObject);
    }
}
