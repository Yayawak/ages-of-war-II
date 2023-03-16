package srcs.Systems.TowerSystem;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Tower.TowerPrototype;

import java.awt.*;

public class TowerSystem implements Loopable {

    private TowerPrototype towerPrototype;

    public TowerSystem(String initTowerRelPath) {
        ImageData towerImgData = new ImageData(
            // "tower/tower1.png", 116, 228);
            initTowerRelPath, 116, 228);
        towerPrototype = new TowerPrototype(1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            new Point(50, 210)
        );
        TowerGameObject playerTowerGameObject =
            new TowerGameObject(towerPrototype);
        MainGame.getInstance().addGameObjectToScene(playerTowerGameObject);

    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {

    }
}
