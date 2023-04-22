package srcs.GameUI.mainGame.SubScene.GameObject.Tower;

import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.Dimension;
import java.awt.Point;

public class TowerGameObject extends GameObject {
    private TowerPrototype towerPrototype;
    public TowerGameObject(TowerPrototype towerPrototype) {
        super(towerPrototype.getImageData().getSprite(),
                towerPrototype.getPosition(), new Dimension(towerPrototype.getImageData().getImgWidth(),
                        towerPrototype.getImageData().getImgHeight()));
        this.towerPrototype = towerPrototype;
        if (towerPrototype.getTeamType() == TeamType.ENEMY) {
            System.out.println("This is tower game object ENEMY !!!!!!!!!!!!!!!!!!");
            // todo : set initial positon of enemy or player tower
            int spawnX = (int) MainUI.getInstance().getScreenSize().getWidth() - 200;
            Point spawnPos = new Point(spawnX, 200);
            this.setPos(spawnPos);
            // this.setLocation(spawnPos);
            // towerPrototype.setPosition(spawnPos);
        }
    }

    public TowerPrototype getTowerPrototype() {
        return towerPrototype;
    }
    public void setTowerPrototype(TowerPrototype towerPrototype) {
        this.towerPrototype = towerPrototype;
    }

    public void upgradeTowerToNewAge() {
        setImg(IntegratedSystem.getInstance()
            .getCurrentPlayerAgeData().getTowerPrototype()
            .getImageData().getSprite()
        );
        System.out.println("upgrade otwer entered");
    }

    @Override
    public void update() {

    }

    @Override
    public void setPos(Point newPos) {
        this.pos = newPos;
        this.towerPrototype.setPosition(newPos);
        this.setLocation(newPos);
    }
}
