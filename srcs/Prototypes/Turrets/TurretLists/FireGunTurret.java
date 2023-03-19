package srcs.Prototypes.Turrets.TurretLists;

import java.awt.Point;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Turrets.TurretPrototype;
import java.awt.Image;

public class FireGunTurret extends TurretPrototype {

    public FireGunTurret() {
        super();
        ImageData turretImgData = new ImageData("turrets/firegun.png");
        // TurretPrototype turretData = new TurretPrototype(teamType, 2, turretImgData, "Gun",
        //     100,
        //     getPosition()
        //     , 1, 1, null, 400);


        // this = new FireGunTurret()
        setAttackSpeed(5);
        setImgData(turretImgData);
        setName("Fire gun hell");
        setGold(200);
        //! setLocation
        setPosition(position);
        setBuildTime(3);
        setProjectileSpeed(2);
        // todo : add bullet image
        // Image bullet = new Image()
        setBulletImgData(turretImgData);
        setAttackRange(400);
        setAttackDamage(1);
    }
    // public FireGunTurret(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
    //         float buildTime, int projectileSpeed, ImageData bulletImgData, int attackRange,
    //         int atta) {
    //     super(teamType, attackSpeed, imgData, name, gold, position, buildTime, projectileSpeed, bulletImgData, attackRange);
    // }

    public FireGunTurret(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            float buildTime, int projectileSpeed, ImageData bulletImgData, int attackRange, int attackDamage) {
        super(teamType, attackSpeed, imgData, name, gold, position, buildTime, projectileSpeed, bulletImgData,
                attackRange, attackDamage);
    }

}
