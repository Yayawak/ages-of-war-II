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

    private TurretPrototype turret;
    private CharacterGObject closestCgo;

    public TurretGObject(TurretPrototype turret) {
        super(turret.getImgData().getSprite(), turret.getPosition(),
                new Dimension(turret.getImgData().getImgWidth(), turret.getImgData().getImgHeight()));
        this.turret = turret;
    }

    @Override
    public void update() {
        // super.update();
        // System.out.println("update from Turret game object");
        closestCgo = findClosestOpponent(turret);
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D)g;
        if (closestCgo != null) {
            // todo : draw line to that gameobject
            System.out.println("Closest Object exists");
            g2d.setColor(Color.red);
            g2d.drawLine(
                turret.getPosition().x, turret.getPosition().y,
                closestCgo.getLocation().x, closestCgo.getLocation().y
            );
            g2d.setStroke(new BasicStroke(4));

            // todo 2 : fire bullet to enemy -> decrease hp ->
            //* --> descresase hp bar graphically
            //* --> increase gold when die --> destory gObj
            fireBulletToOpponent(this, closestCgo);
            // fireBulletToOpponent(closestCgo, this);
        }
    }

    @Override
    public String toString() {
        return String.format("turret name : ", turret.getName());
        // return "TurretGObject [turret=" + turret + "turret prototype is \n" + turret.toString() +  "]";
    }

	@Override
	public void fireBulletToOpponent(GameObject sender, GameObject reciever) {
        if (sender instanceof TurretGObject) {
            TurretGObject tgo = (TurretGObject)sender;
            // TurretPrototype tpt = tgo.getEn
            // tgo.
            //todo : draw bullet to scene
            ImageData bulletImgData = tgo.getTurret().getBulletImgData();
            // if (bulletImgData == null) {
            //     System.out.println("bullet image data is null");
            // }
            BufferedImage bi = new BufferedImage(
                50, 50, BufferedImage.TYPE_INT_ARGB
            );
            GameObject bulletGo = new GameObject(
                bulletImgData.getSprite(),
                // turret.get
                // bi,
                tgo.getLocation(),
                tgo.getSize()
            );

            // ! : find bug of this
            // MainGame.getObjectsInScene().add(bulletGo);
            // MainGame.getInstance().add(bulletGo);
            // Mi
        }

	}

    public TurretPrototype getTurret() {
        return turret;
    }

    public void setTurret(TurretPrototype turret) {
        this.turret = turret;
    }

    public CharacterGObject getClosestCgo() {
        return closestCgo;
    }

    public void setClosestCgo(CharacterGObject closestCgo) {
        this.closestCgo = closestCgo;
    }



}
