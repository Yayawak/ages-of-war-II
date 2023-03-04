package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Graphics;

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
    protected Point pos;
    protected Dimension imgSize;
    protected boolean isCollide = false;
    protected long spawnTime;
    protected boolean isAttacking = false;
    protected boolean isBusyOnAttacking = false;

    public GameObject(Image img, Point pos, Dimension imgSize) {
        spawnTime = System.nanoTime();
        setLocation(pos);
        setImg(img);
        // System.out.println("Position = " + xPos + " : " + yPos);
        setSize(imgSize); // ? Important for collsion detection
        setPreferredSize(imgSize); // ? Important for collsion detection
        this.imgSize = imgSize;
        this.pos = pos;
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
        return new GameObject(img, pos, imgSize);
    }

    public CharacterGObject findClosestOpponent(EntityPrototype ent) {
        double min = Integer.MAX_VALUE;
        CharacterGObject closetCharacter = null;
        for (GameObject gameObject : MainGame.getObjectsInScene()) {
            if (gameObject instanceof CharacterGObject
                && gameObject != this
                && gameObject != null
            ) {
                CharacterGObject cgo = (CharacterGObject) gameObject;
                TeamType anotherCgoTeam = cgo.getCharacter().getTeamType();
                if (ent.getTeamType() == anotherCgoTeam) continue;
                // System.out.println("turret position " + ent.getPosition());
                // System.out.println("cgo postion " + cgo.getPosition());
                long dx = (long) (ent.getPosition().getX() - cgo.getLocation().getX());
                long dy = (long) (ent.getPosition().getY() - cgo.getLocation().getY());
                // System.out.println("turret position " + turret.getPosition());
                // System.out.println("cgo postion " + cgo.getPosition());
                // System.out.println("dx = " + dx);
                // System.out.println("dy = " + dy);
                double d = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                if (d < min) {
                    min = d;
                    closetCharacter = cgo;
                }
            }
        }
        // System.out.println("==========================".repeat(4));
        if (min <= ent.getAttackRange()) {
            // System.out.println("get attack");
            if (closetCharacter != null
                &&
                closetCharacter.getCharacter().getTeamType()
                    != ent.getTeamType()
            ) {
                // todo : combat
                isAttacking = true;
                if (isAttacking) {
                    attackOpponent(ent, closetCharacter.getCharacter());
                }
                // attackOpponent(closestCgo.getCharacter(), character);
                System.out.println("combat occured");
                // System.out.println("Min = " + min);
                // System.out.format("Name of closest character is : %s\n",
                    // closetCharacter.getCharacter().getName());
            }
        }
        // if (closetCharacter == null) { System.out.println("Closest character = NULL");}
        return closetCharacter;

    }

    protected void attackOpponent(EntityPrototype attacker,
            CharacterPrototype damager) {
        if (!isBusyOnAttacking) {
            // isBusyOnAttacking = true;
            new Thread(
                () -> {
                    int atkRate = attacker.getAttackSpeed();
                    while (true) {
                        System.out.println("thread attacking");
                        // if (damager == null || this == null) {
                        // if (damager == null) {
                        // if (this == null) {
                        //     isBusyOnAttacking = false;
                        //     break;
                        // }
                        long ms = (atkRate * 10000);
                        damager.decreaseHp(attacker.getAttackDamage());
                        System.out.format("damager name : %s, hp : %d\n"
                            , damager.getName(), damager.getHp()
                        );
                        try {
                            Thread.sleep(ms);
                        } catch (Exception e) { }
                    }
                }
            ).start();
        }
    }


    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
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
