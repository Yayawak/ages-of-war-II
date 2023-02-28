package srcs.Prototypes.Turrets;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.EntityPrototype;

import java.awt.*;;

public class TurretPrototype extends EntityPrototype {
    private int projectileSpeed;
    private ImageData bulletImgData;

    public TurretPrototype(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            float buildTime, EntityPrototype copyInstance, int projectileSpeed, ImageData bulletImgData) {
        super(teamType, attackSpeed, imgData, name, gold, position, buildTime, copyInstance);
        this.projectileSpeed = projectileSpeed;
        this.bulletImgData = bulletImgData;
    }

}
