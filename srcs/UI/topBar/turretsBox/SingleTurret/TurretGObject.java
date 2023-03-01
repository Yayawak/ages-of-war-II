package srcs.UI.topBar.turretsBox.SingleTurret;

import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.CharacterGObject;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import java.awt.*;;

public class TurretGObject extends GameObject {

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
                turret.getPosition().x,
                turret.getPosition().y,
                closestCgo.getLocation().x,
                closestCgo.getLocation().y
            );
            g2d.setStroke(new BasicStroke(4));
        }
    }

    @Override
    public String toString() {
        return String.format("turret name : ", turret.getName());
        // return "TurretGObject [turret=" + turret + "turret prototype is \n" + turret.toString() +  "]";
    }



}
