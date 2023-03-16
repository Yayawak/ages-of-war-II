package srcs.Prototypes.Turrets;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.EntityPrototype;

import java.awt.*;;

public class TurretPrototype extends EntityPrototype {
    private int projectileSpeed;
    private ImageData bulletImgData;

    public TurretPrototype(TeamType teamType) {
    // public TurretPrototype() {
        super(teamType);
    }
    public TurretPrototype(TeamType teamType,
        int attackSpeed,
        ImageData imgData, String name,
        int gold, Point position,
        float buildTime, int projectileSpeed,
        ImageData bulletImgData,
        int attackRange, int attackDamage)
    {
        super(teamType, attackSpeed, imgData, name, gold, position, buildTime, attackRange
            ,attackDamage);
        this.projectileSpeed = projectileSpeed;
        this.bulletImgData = bulletImgData;
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

    @Override
    public String toString() {
        return
            "Entity protype is = " + super.toString() + "\n" +
        "TurretPrototype [projectileSpeed=" + projectileSpeed + ", bulletImgData=" + bulletImgData
                // + ", attackRange=" + attackRange
                + "]";
    }

}
