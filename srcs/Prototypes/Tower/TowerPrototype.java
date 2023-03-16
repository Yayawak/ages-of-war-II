package srcs.Prototypes.Tower;

import javax.swing.text.Position;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;

import java.awt.*;

public class TowerPrototype {
    private int hp;
    private String towerName;
    private TeamType teamType;
    private TurretGObject turretAbove;
    private TurretGObject turretBelow;
    private ImageData imageData;
    private Point position;

    public TowerPrototype(int hp, TeamType teamType, TurretGObject turretAbove, TurretGObject turretBelow,
            ImageData imageData, Point position) {
        this.hp = hp;
        this.teamType = teamType;
        this.turretAbove = turretAbove;
        this.turretBelow = turretBelow;
        this.imageData = imageData;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    public TurretGObject getTurretAbove() {
        return turretAbove;
    }

    public void setTurretAbove(TurretGObject turretAbove) {
        this.turretAbove = turretAbove;
    }

    public TurretGObject getTurretBelow() {
        return turretBelow;
    }

    public void setTurretBelow(TurretGObject turretBelow) {
        this.turretBelow = turretBelow;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public void setImageData(ImageData imageData) {
        this.imageData = imageData;
    }

    public String getTowerName() {
        return towerName;
    }

    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }
}
