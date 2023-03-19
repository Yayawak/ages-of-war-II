package srcs.Prototypes.Turrets.TurretLists;

import java.awt.Point;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Turrets.TurretPrototype;

public class RedLaserTurret extends TurretPrototype {
    public RedLaserTurret() {
        super();
        ImageData turretImgData = new ImageData("turrets/red_laser.png");
        setAttackSpeed(5);
        setImgData(turretImgData);
        setName("Red Laser hell");
        setGold(200);
        // ! setLocation
        setPosition(position);
        setBuildTime(3);
        setProjectileSpeed(2);
        // todo : add bullet image
        setBulletImgData(turretImgData);
        setAttackRange(1000);
        setAttackDamage(1);
    }

    public RedLaserTurret(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            float buildTime, int projectileSpeed, ImageData bulletImgData, int attackRange, int attackDamage) {
        super(teamType, attackSpeed, imgData, name, gold, position, buildTime, projectileSpeed, bulletImgData,
                attackRange, attackDamage);
    }
}
