package srcs.Systems.TowerSystem;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Tower.TowerPrototype;

import java.awt.*;

public class TowerSystem implements Loopable {

    private TowerPrototype towerPrototype;

    public TowerSystem(TowerPrototype initTp) {
        setTowerPrototype(initTp);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {

    }

    public TowerPrototype getTowerPrototype() {
        return towerPrototype;
    }

    public void setTowerPrototype(TowerPrototype tp) {
        // newTowerSetup
        if (towerPrototype != tp) {
            towerPrototype = tp;
            //todo : remove old tower game object
            for (GameObject go : MainGame.getInstance().getObjectsInScene()) {
                if (go instanceof TowerGameObject) {
                    TowerGameObject towerToBeReplaced = (TowerGameObject)go;
                    if (towerPrototype.getTeamType() == towerToBeReplaced.getTeamType()) {
                        // if (towerPrototype[])
                        if (tp.getTeamType() == TeamType.ENEMY) {
                            System.out.println("Tower is Enemy !!!!!!!!!!!");
                        }
                        MainGame.getInstance().removeGameObjectFromScene(towerToBeReplaced);
                        break;
                    }
                }
            }
            //todo : add new tower
            // this.towerPrototype = tp;
            TowerGameObject newTgo = new TowerGameObject(towerPrototype);
            MainGame.getInstance().addGameObjectToScene(newTgo);
        }
    }
}
