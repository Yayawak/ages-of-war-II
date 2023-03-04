package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Graphics;
import java.nio.channels.ClosedSelectorException;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.UI.mainGame.MainGame;

import java.awt.*;

public class GameObject extends JPanel implements Loopable {
    protected Image img;
    protected Point position;
    protected Dimension imgSize;
    protected boolean isCollide = false;
    protected long spawnTime;

    public GameObject(Image img, Point position,
        Dimension imgSize) {
        spawnTime = System.nanoTime();
        setLocation(position);
        setImg(img);
        // System.out.println("Position = " + xPos + " : " + yPos);
        setSize(imgSize); // ? Important for collsion detection
        setPreferredSize(imgSize); // ? Important for collsion detection
        this.imgSize = imgSize;
        // repaint();
        init();
    }

    private void init() {
        setLayout(null);
        // setLayout(getLayout());
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    @Override
    public void draw(Graphics g) {
        // moveRight(g);
    }

    @Override
    public void update() {
        // System.out.println("update from GameObject");
    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        MainGame.getObjectsInScene().remove(this);
    }

    public GameObject copy() {
        return new GameObject(img, position, imgSize);
    }

    public CharacterGObject findClosestOpponent(EntityPrototype ent) {
    // public CharacterGObject findClosestOpponent(GameObject finder) {
        // int min = Integer.MAX_VALUE;
        double min = Double.MAX_VALUE;
        CharacterGObject closetCharacter = null;
        for (GameObject gameObject : MainGame.getObjectsInScene()) {
            if (gameObject instanceof CharacterGObject
                && gameObject != this
                && gameObject != null
            ) {
                CharacterGObject cgo = (CharacterGObject) gameObject;
                TeamType anotherCgoTeam = cgo.getCharacter().getTeamType();
                // if (ent.getTeamType() == anotherCgoTeam) continue;
                if (ent.getTeamType() == anotherCgoTeam) continue;
                double x1 = ent.getPosition().getX();
                double y1 = ent.getPosition().getY();
                double x2 = cgo.getX();
                double y2 = cgo.getY();
                // long dy = (long) (Math.abs(y1 - y2));
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
                long dx = (long) (x1 - x2);
                long dy = (long) (y1 - y2);
                // long dx = (long) (Math.abs(x2 - x1));
                // long dy = (long) (Math.abs(y2 - y1));
                double d = Math.sqrt(dx * dx + dy * dy);
                System.out.println("dx = " + dx);
                System.out.println("dy = " + dy);
                if (d <= min) {
                    min = d;
                    closetCharacter = cgo;
                    // System.out.println(
                    //     "closest char name : "
                    //     + closetCharacter.getCharacter().getName()
                    // );
                }
                // else { min = 0; }
            }
        }
        // System.out.println("==========================".repeat(4));
        System.out.println("min = " + min);
        System.out.println(
            "closest char name : "
            + closetCharacter.getCharacter().getName()
        );
        System.out.println("atk range = " + ent.getAttackRange());
        if (min <= ent.getAttackRange()) {
            if (
                closetCharacter != null
                &&
                closetCharacter.getCharacter().getTeamType()
                    != ent.getTeamType()
            ) {
                // todo : combat
                System.out.println("combat occured");
                // isAttacking = true;
                attackOpponent(ent, closetCharacter.getCharacter());
                // if (ent instanceof CharacterPrototype) {
                //     CharacterPrototype damager = (CharacterPrototype)ent;
                //     attackOpponent(closetCharacter.getCharacter(), damager);
                // }
            }
        } else {
            closetCharacter = null;
        }
        return closetCharacter;

    }

    protected void attackOpponent(EntityPrototype attacker,
        CharacterPrototype damager) {
        System.out.println("Attack opponent");
        new Thread(
            () -> {
                int atkRate = attacker.getAttackSpeed() | 1;
                // while (damager != null) {
                long ms = (atkRate * 10000);
                damager.decreaseHp(attacker.getAttackDamage());
                try {
                    Thread.sleep(ms);
                } catch (Exception e) { }
                // }
            }
        ).start();
    }


    public Point getPostion() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Dimension getImgSize() {
        return imgSize;
    }

    public void setImgSize(Dimension imgSize) {
        this.imgSize = imgSize;
    }

    public boolean isCollide() {
        return isCollide;
    }

    public void setCollide(boolean isCollide) {
        this.isCollide = isCollide;
    }

    public long getSpawnTime() {
        return spawnTime;
    }

    public void setSpawnTime(long spawnTime) {
        this.spawnTime = spawnTime;
    }
}
