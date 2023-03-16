package srcs.GameUI.mainGame.SubScene.GameObject;

import java.awt.Graphics;
import java.time.chrono.ThaiBuddhistChronology;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;

import java.awt.*;

public class GameObject extends JPanel implements Loopable {
    protected TeamType teamType;
    protected Image img;
    protected Point position;
    protected Dimension imgSize;
    private boolean isCollide = false;
    protected long spawnTime;
    protected boolean isAttacking = false;
    protected boolean isBusyOnAttacking = false;

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
        // System.out.println("update from gameobjct ");
        for (GameObject go : MainGame.getInstance().
            getObjectsInScene()) {
            checkCollision(this, go);
        }
    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        MainGame.getInstance().removeGameObjectFromScene(this);
    }

    public GameObject copy() {
        return new GameObject(img, position, imgSize);
    }

    public CharacterGObject findClosestOpponent(EntityPrototype ent) {
    // public CharacterGObject findClosestOpponent(GameObject finder) {
        // int min = Integer.MAX_VALUE;
        double min = Double.MAX_VALUE;
        CharacterGObject closetCharacter = null;
        for (GameObject gameObject : MainGame.getInstance().getObjectsInScene()) {
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
                isAttacking = true;
                // if (isAttacking) {
                //     attackOpponent(ent, closetCharacter.getCharacter());
                // }
                attackOpponent(ent, closetCharacter.getCharacter());
                // attackOpponent(closestCgo.getCharacter(), character);
                System.out.println("combat occured");
                // System.out.println("Min = " + min);
                // System.out.format("Name of closest character is : %s\n",
                    // closetCharacter.getCharacter().getName());
            }else {
                isAttacking = false;
            }
        } else {
            closetCharacter = null;
        }
        // else {
        //     isAttacking = false;
        // }
        System.out.println("is attacking = " + isAttacking);
        // if (closetCharacter == null) { System.out.println("Closest character = NULL");}
        return closetCharacter;

    }

    protected void attackOpponent(EntityPrototype attacker,
            CharacterPrototype damager) {
        // ! created new thread every millisecond depended on update function
        // todo : make single thread not 100 threads so it's very decrease opponent health
        if (!isBusyOnAttacking) {
            // isBusyOnAttacking = true;
            new Thread(
                () -> {
                    int atkRate = attacker.getAttackSpeed();
                    while (isAttacking) {
                    // while (true) {
                        System.out.println("thread attacking");
                        // if (damager == null || this == null) {
                        // if (damager == null) {
                        // if (this == null) {
                        //     isBusyOnAttacking = false;
                        //     break;
                        // }
                        // long ms = (atkRate * 10000);
                        long ms = (atkRate * 10000000);
                        // long ms = (atkRate * 1000);
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
                // thisGo.setCollide(false);
                // thatGo.setCollide(true);
            } else {
                // thisGo.setCollide(!false);
                // thatGo.setCollide(!true);
            }

            // if (thisGo.teamType != thatGo.teamType) {
            //     thatGo.setCollide(true); //* for other stop
            // }
        } else {
            // thisGo.setCollide(false);
            // thatGo.setCollide(false);
        }
        thisGo.setCollide(false);
        thatGo.setCollide(false);
    }
}
