package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Graphics;
import java.time.chrono.ThaiBuddhistChronology;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.Character.CharacterGObject;

import java.awt.*;

public class GameObject extends JPanel implements Loopable {
    protected TeamType teamType;
    protected Image img;
    protected Point pos;
    protected Dimension imgSize;
    private boolean isCollide = false;
    protected long spawnTime;

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
        for (GameObject go : MainGame.getInstance().
            getObjectsInScene()
        ) {
            if (go instanceof CharacterGObject) {
                CharacterGObject cgo = (CharacterGObject)go;
                checkCollision(this, cgo);
            }
        }
        // System.out.println("update from GameObject");
    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        // MainGame.getInstance().getObjectsInScene().remove(this);
        MainGame.getInstance().removeGameObjectFromScene(this);
    }

    public GameObject copy() {
        return new GameObject(img, pos, imgSize);
    }

    public CharacterGObject findClosestOpponent(EntityPrototype ent) {
        double min = Integer.MAX_VALUE;
        CharacterGObject closetCharacter = null;
        for (GameObject gameObject : MainGame.getInstance().getObjectsInScene()) {
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
                // isAttacking = true;
                attackOpponent(ent, closetCharacter.getCharacter());
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

    // protected void attackOpponent(CharacterPrototype attacker,
    protected void attackOpponent(EntityPrototype attacker,
        CharacterPrototype damager) {
        // if (isAttacking)
        new Thread(
            () -> {
                int atkRate = attacker.getAttackSpeed();
                while (damager != null) {
                    long ms = (atkRate * 10000);
                    damager.decreaseHp(attacker.getAttackDamage());
                    try {
                        Thread.sleep(ms);
                    } catch (Exception e) { }
                }
            }
        ).start();
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

    public boolean getCollide() {
        return isCollide;
    }

    private void setCollide(boolean isCollide) {
        this.isCollide = isCollide;
    }

    public long getSpawnTime() {
        return spawnTime;
    }

    public void setSpawnTime(long spawnTime) {
        this.spawnTime = spawnTime;
    }

    public void checkCollision(
        GameObject thisGo,
        GameObject thatGo
    ) {
        // System.out.println("W = " + this.imgSize.width);
        // System.out.println("H = " + getHeight());
        if (thisGo.getBounds().intersects(thatGo.getBounds()) &&
            thisGo != thatGo &&
            thisGo.getBounds() != null && thatGo.getBounds() != null
        ) {
            // ? if spawn before -> stop younger gameobject
            // ! bug
            if (thisGo.spawnTime < thatGo.spawnTime) {
                thisGo.setCollide(false);
                thatGo.setCollide(true);
            } else {
                thisGo.setCollide(!false);
                thatGo.setCollide(!true);
            }

            if (thisGo.teamType != thatGo.teamType) {
                thatGo.setCollide(true); //* for other stop
            }
        } else {
            thisGo.setCollide(false);
            thatGo.setCollide(false);
        }
    }
}
