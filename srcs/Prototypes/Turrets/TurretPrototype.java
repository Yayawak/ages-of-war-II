package srcs.Prototypes.Turrets;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.EntityPrototype;

import java.awt.*;;

public class TurretPrototype extends EntityPrototype {
    private int projectileSpeed;
    private ImageData bulletImgData;
    private int attackRange;

    public TurretPrototype(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            float buildTime, int projectileSpeed, ImageData bulletImgData,
            int attackRange) {
        super(teamType, attackSpeed, imgData, name, gold, position, buildTime);
        this.projectileSpeed = projectileSpeed;
        this.bulletImgData = bulletImgData;
        this.attackRange = attackRange;
    }

    public int getProjectileSpeed() {
        return projectileSpeed;
    }

    public void setProjectileSpeed(int projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }

    public ImageData getBulletImgData() {
        return bulletImgData;
    }

    public void setBulletImgData(ImageData bulletImgData) {
        this.bulletImgData = bulletImgData;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

}
