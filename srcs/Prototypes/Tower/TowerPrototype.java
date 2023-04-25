package srcs.Prototypes.Tower;

import javax.swing.text.Position;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;
import srcs.Prototypes.EntityPrototype;

import java.awt.*;

// public class TowerPrototype {
public class TowerPrototype extends EntityPrototype {
    // private String towerName;
    private TurretGObject turretAbove = null;
    private TurretGObject turretBelow = null;

    public TowerPrototype(int hp, TeamType teamType, TurretGObject turretAbove, TurretGObject turretBelow,
            ImageData imageData, Point position) {
        this.hp = hp;
        this.teamType = teamType;
        this.turretAbove = turretAbove;
        this.turretBelow = turretBelow;
        // this.imageData = imageData;
        this.imgData = imageData;
        this.position = position;
    }


    public TurretGObject getTurretAbove() {
        return turretAbove;
    }

    public void setTurretAbove(TurretGObject turretAbove) {
        this.turretAbove = turretAbove;
        System.out.println("positions of tower is : " + position);
        turretAbove.getTurretPrototype().setPosition(new Point(
                (int) (position.getX()), (int) (position.getY() - 150)));
        // turretAbove.setLocation(turretAbove.getTurret().getPosition());
        MainGame.getInstance().addGameObjectToScene(turretAbove);
        System.out.println("positions of turret is : " + turretAbove.getTurretPrototype().getPosition());
        // repai
    }

    public TurretGObject getTurretBelow() {
        return turretBelow;
    }

    public void setTurretBelow(TurretGObject turretBelow) {
        this.turretBelow = turretBelow;
        System.out.println("positions of tower is : " + position);
        turretBelow.getTurretPrototype().setPosition(position);
        // turretBelow.setLocation(turretAbove.getTurret().getPosition());
        MainGame.getInstance().addGameObjectToScene(turretBelow);
        System.out.println("positions of turret is : " + turretBelow.getTurretPrototype().getPosition());
    }

    // public ImageData getImageData() {
    //     return imageData;
    // }

    // public void setImageData(ImageData imageData) {
    //     this.imageData = imageData;
    // }

    // public String getTowerName() {
    //     return towerName;
    // }

    // public void setTowerName(String towerName) {
    //     this.towerName = towerName;
    // }
}
