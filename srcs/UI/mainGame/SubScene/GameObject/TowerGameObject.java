package srcs.UI.mainGame.SubScene.GameObject;

import srcs.Prototypes.Tower.TowerPrototype;
import java.awt.Dimension;

public class TowerGameObject extends GameObject {
    public TowerGameObject(TowerPrototype towerPrototype) {
        super(towerPrototype.getImageData().getSprite(),
                towerPrototype.getPosition(), new Dimension(towerPrototype.getImageData().getImgWidth(),
                        towerPrototype.getImageData().getImgHeight()));
    }
}
