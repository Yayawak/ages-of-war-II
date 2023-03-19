package srcs.GameUI.mainGame.SubScene.GameObject.Turret;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Interfaces.Loopable;
import srcs.Interfaces.RangeUnit;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;

import java.awt.*;
import java.awt.image.*;

import helpers.ImageData;;

public class TurretGObject extends GameObject implements RangeUnit {

    private TurretPrototype turretPrototype;
    private CharacterGObject closestCgo;

    public TurretGObject(TurretPrototype turretPrototype) {
        super(turretPrototype.getImgData().getSprite(), turretPrototype.getPosition(),
                new Dimension(turretPrototype.getImgData().getImgWidth(), turretPrototype.getImgData().getImgHeight()));
        this.turretPrototype = turretPrototype;
    }

    @Override
    public void update() {
        // super.update();
        // System.out.println("update from Turret game object");
        closestCgo = findClosestOpponent(turretPrototype);
        // System.out.println("POSITIOn of turet = " + getLocation());

        setLocation(turretPrototype.getPosition());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        if (closestCgo != null) {
            // todo : draw line to that gameobject
            float d = getDistanceBetweenGameObject(this, closestCgo);
            if (d < turretPrototype.getAttackRange()) {
                // System.out.format("Turret (%s) : found enemy (%s)\n",
                    // turretPrototype.getName(),
                    // closestCgo.getCharacter().getName()
                // );
                g2d.setStroke(new BasicStroke(10));
                g2d.setColor(new Color(0, 255, 10));
                g2d.drawLine(
                    turretPrototype.getPosition().x, turretPrototype.getPosition().y,
                    closestCgo.getLocation().x, closestCgo.getLocation().y);

                // g2d.setColor(new Color(
                //     (float)Math.random(),
                //     (float)Math.random(),
                //     (float)Math.random()
                // ));

                // int x = turretPrototype.getPosition().x;
                // int y = turretPrototype.getPosition().y;

                // g2d.drawOval(x, y, (int)d, (int)d);
                // todo 2 : fire bullet to enemy -> decrease hp ->
                // attackOpponent(this.getTurretPrototype(), closestCgo.getCharacter());
                // * --> descresase hp bar graphically
                // * --> increase gold when die --> destory gObj
                // fireBulletToOpponent(this, closestCgo);
                // fireBulletToOpponent(closestCgo, this);
            }
        }
    }

    @Override
    public void fireBulletToOpponent(GameObject sender, GameObject reciever) {
        if (sender instanceof TurretGObject) {
            TurretGObject tgo = (TurretGObject) sender;
            // TurretPrototype tpt = tgo.getEn
            // tgo.
            // todo : draw bullet to scene
            ImageData bulletImgData = tgo.getTurretPrototype().getBulletImgData();
            // if (bulletImgData == null) {
            // System.out.println("bullet image data is null");
            // }
            BufferedImage bi = new BufferedImage(
                    50, 50, BufferedImage.TYPE_INT_ARGB);
            GameObject bulletGo = new GameObject(
                    bulletImgData.getSprite(),
                    // turretPrototype.get
                    // bi,
                    tgo.getLocation(),
                    tgo.getSize());

            // ! : find bug of this
            // MainGame.getObjectsInScene().add(bulletGo);
            // MainGame.getInstance().add(bulletGo);
            // Mi
        }

    }

    public TurretPrototype getTurretPrototype() {
        return turretPrototype;
    }

    public void setTurret(TurretPrototype turretPrototype) {
        this.turretPrototype = turretPrototype;
    }

    public CharacterGObject getClosestCgo() {
        return closestCgo;
    }

    public void setClosestCgo(CharacterGObject closestCgo) {
        this.closestCgo = closestCgo;
    }

}
