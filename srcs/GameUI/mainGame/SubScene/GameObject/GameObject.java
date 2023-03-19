package srcs.GameUI.mainGame.SubScene.GameObject;

import java.awt.Graphics;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.StateMachine.State;

import java.awt.*;

public class GameObject extends JPanel implements Loopable {
    protected TeamType teamType;
    protected Image img;
    protected Point pos;
    protected Dimension imgSize;
    protected boolean isCollide = false;
    protected long spawnTime;
    protected boolean hasAttacked;

    public GameObject(Image img, Point pos, Dimension imgSize) {
        spawnTime = System.nanoTime();
        setLocation(pos);
        setImg(img);
        setSize(imgSize); // ? Important for collsion detection
        setPreferredSize(imgSize); // ? Important for collsion detection
        this.imgSize = imgSize;
        this.pos = pos;
        init();
    }

    private void init() {
        setLayout(null);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        if (teamType == TeamType.ENEMY) {
            // System.out.println("This is  enemy");
            // AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            // ! getImg() return null now
            // tx.translate(getImg().getWidth(null), 0);
            // AffineTransformOp op = new AffineTransformOp(tx,
            //     AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            // setImg(
            // ! buf Image -> BufferedImage
            //     op.filter((BufferedImage)getImg(), null)
            // );
        } else {
            // System.out.println("this go " + "is player");
        }
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void update() {
        // System.out.println("update from gameobjct ");
        setCollide(false);
        for (GameObject go : MainGame.getInstance().
            getObjectsInScene())
        {
            checkCollision(this, go);
        }
        // closeest

    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        MainGame.getInstance().removeGameObjectFromScene(this);
    }

    public GameObject copy() {
        return new GameObject(img, pos, imgSize);
    }


    protected float getDistanceBetweenGameObject(
        GameObject thisGo,
        GameObject thatGo
    ) {
        float dx = thisGo.getX() - thatGo.getX();
        float dy =  thisGo.getY() - thatGo.getY();
        // System.out.println("turret position " + turret.getPosition());
        // System.out.println("cgo postion " + cgo.getPosition());
        // System.out.println("dx = " + dx);
        // System.out.println("dy = " + dy);
        double d = Math.sqrt(dx * dx + dy * dy);
        return (float)d;
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
                // ent.setState(State.ATTACK);
                // attackOpponent(ent, closetCharacter.getCharacter());
                // Check if tha attack has no been made yet
                if (!hasAttacked) {
                    //  Find the closet enemy and attack it
                    // if (closetCharacter != null) {
                    if (closetCharacter != null) {
                        hasAttacked = true;
                        attackOpponent(ent,
                            closetCharacter.getCharacter()
                        );
                    }
                    // if (closi)
                }
                // ent.getState().nex
                // attackOpponent(closestCgo.getCharacter(), character);
                // System.out.println("combat occured");
                // System.out.println("Min = " + min);
                // System.out.format("Name of closest character is : %s\n",
                    // closetCharacter.getCharacter().getName());
            }
        }
        // if (closetCharacter == null) { System.out.println("Closest character = NULL");}
        return closetCharacter;

    }

    // protected void attackOpponent(CharacterPrototype attacker,
    private void attackOpponent(EntityPrototype attacker,
        CharacterPrototype damager) {

        // is
        // if (attacker.getState().equals(State.ATTACK)) {
        // if (attacker.getState().equals(State.ATTACK)) {
        // attacker.setState(State.ATTACK);

        // if (attacker.getState() == State.ATTACK) {
        //     // donothing
        // } else {

        // damager.decreaseHp(attacker.getAttackDamage());
        // }
        // if (isAttacking)
        System.out.format("Attacker(%s) : id(%s) -> Damager(%s) : id(%s)\n",
            attacker.getName(),
            String.valueOf(attacker.hashCode()).substring(5),
            damager.getName(),
            String.valueOf(damager.hashCode()).substring(5)
        );
        // try {
        //     // int atkInterval = 1 / attacker.getAttackSpeed();
        //     // int atkInterval = 1 / attacker.getAttackSpeed();
        //     Thread.sleep(1000);
        //     damager.decreaseHp(attacker.getAttackDamage());
        // } catch (Exception e) { System.out.println(e); }
        // if (attacker.getState() == State.ATTACK) {

        // }

        // if (attacker.getState() == State.MOVE) {
        //     attacker.setState(State.ATTACK);
        // }
        // else {

        // }
        System.out.println("Create new Thread" + "-->".repeat(9));
        // return;
        // try {
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        // }
        // System.out.println("Start Thread");
        new Thread(
            () -> {
                int atkRate = attacker.getAttackSpeed();
                // while (damager != null
                while ( damager.getHp() > 0
                ) {
                    System.out.format("%s -> %s\n",
                        attacker.getName(),
                        damager.getName()
                    );
                    // long ms = (atkRate * 1000);
                    // long ms = (1000);
                    long ms = (100);
                    damager.decreaseHp(attacker.getAttackDamage());
                    try {
                        Thread.sleep(ms);
                    } catch (Exception e) { }
                }
                hasAttacked = false; // reset attacker to be attack again if enemy is die
                attacker.setState(State.MOVE);
            }, "attacking Thread"
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
        if (thisGo.getBounds().intersects(thatGo.getBounds())
            &&
            thisGo != thatGo
        ) {
            // ! bug
            // System.out.println("this spawn time = " + thisGo.spawnTime);
            // System.out.println("that spawn time = " + thatGo.spawnTime);
            // System.out.println("==================");
            if (thisGo.spawnTime < thatGo.spawnTime) {
                if (thisGo instanceof CharacterGObject
                    &&
                    thatGo instanceof CharacterGObject
                ) {
                    CharacterGObject c1 = (CharacterGObject)thisGo;
                    CharacterGObject c2 = (CharacterGObject)thatGo;

                    // System.out.println("c1 name : " + c1.getCharacter().getName());
                    // System.out.println("c2 name : " + c2.getCharacter().getName());
                    // System.out.println("->".repeat(9));

                }
                thisGo.setCollide(false);
                // thatGo.setCollide(true);
            } else {
                // thisGo.setCollide(true);
                // thatGo.setCollide(false);
            }

            // if (thisGo.teamType != thatGo.teamType) {
            //     thatGo.setCollide(true); //* for other stop
            // }
        }
        else {
            // thisGo.setCollide(false);
            // thatGo.setCollide(false);
        }
    }

    public TeamType getTeamType() {
        return teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;

    }

    public boolean isCollide() {
        return isCollide;
    }
}
