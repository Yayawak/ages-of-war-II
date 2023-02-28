package srcs.UI.topBar.turretsBox.SingleTurret;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.CharacterGObject;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import java.awt.*;;

public class TurretGObject extends GameObject {

    private TurretPrototype turret;

    public TurretGObject(TurretPrototype turret) {
        super(turret.getImgData().getSprite(), turret.getPosition(),
                new Dimension(turret.getImgData().getImgWidth(), turret.getImgData().getImgHeight()));
        this.turret = turret;
    }

    @Override
    public void update() {
        // super.update();
        double min = Integer.MAX_VALUE;
        CharacterGObject closetCharacter;
        for (GameObject gameObject : MainGame.getObjectsInScene()) {
            if (gameObject instanceof CharacterGObject) {
                CharacterGObject cgo = (CharacterGObject) gameObject;
                long dx = (long) (turret.getPosition().getX() - cgo.getPosition().getX());
                long dy = (long) (turret.getPosition().getY() - cgo.getPosition().getY());
                double d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                if (d < min) {
                    min = d;
                    closetCharacter = cgo;
                }
            }
        }
        if (min <= turret.getAttackRange()) {
            System.out.println("get attack");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}
