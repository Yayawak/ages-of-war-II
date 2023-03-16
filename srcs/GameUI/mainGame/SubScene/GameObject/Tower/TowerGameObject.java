package srcs.GameUI.mainGame.SubScene.GameObject.Tower;

import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.Prototypes.Tower.TowerPrototype;

import java.awt.Dimension;

public class TowerGameObject extends GameObject {
    private TowerPrototype towerPrototype;
    public TowerGameObject(TowerPrototype towerPrototype) {
        super(towerPrototype.getImageData().getSprite(),
                towerPrototype.getPosition(), new Dimension(towerPrototype.getImageData().getImgWidth(),
                        towerPrototype.getImageData().getImgHeight()));
        this.towerPrototype = towerPrototype;
    }

    public TowerPrototype getTowerPrototype() {
        return towerPrototype;
    }
    public void setTowerPrototype(TowerPrototype towerPrototype) {
        this.towerPrototype = towerPrototype;
    }
}
