package srcs.GameUI.mainGame.SubScene.GameObject.Projectiles;

import java.awt.Image;
import java.awt.Point;

import helpers.ImageData;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.Prototypes.EntityPrototype;

public class Bullet extends GameObject {
    // GameObject from;
    // GameObject to;
    Point from;
    Point to;
    float velocity; // pixel per sec
    // Point velocity;
    Image bulletImage;
    public Bullet(EntityPrototype from, EntityPrototype to) {
        this(from.getPosition(), to.getPosition());
    }
    public Bullet(Point from, Point to) {
        // this(from, to, 10);
        this(from, to,20);
        // this(from, to,50);
    }
    // public Bullet(GameObject from, GameObject to) {
    //     this(from.getPos(), to.getPos(), 10);
    // }
    // public Bullet(Point from, Point to, float velocity, Image bulletImage) {
    //     this(from, to, velocity, ImageData.getSprite("Heraldy/3 Cadency/Cadency_01.png"));
    // }
    // public Bullet(GameObject from, GameObject to, float velocity) {
    //     this(from, to, velocity, ImageData.getSprite("Heraldy/3 Cadency/Cadency_01.png"));
    // }
    public Bullet(Point from, Point to, float velocity) {
        this(from, to, velocity, ImageData.getSprite("Heraldy/3 Cadency/Cadency_01.png"));
    }
    // public Bullet(Point from, Point to, float velocity, Image bulletImage) {
    //     this(from, to, velocity, bulletImage);
    // }
    // public Bullet(GameObject from, GameObject to, float velocity,
    public Bullet(Point from, Point to, float velocity,
        Image bulletImage) {
        this.from = from;
        this.to = to;
        this.velocity = velocity;
        this.bulletImage = bulletImage;

        setImg(bulletImage);
        MainGame.getInstance().addGameObjectToScene(this);
        setLocation(from.getLocation());
        startShootBullet();
    }

    private void startShootBullet() {
        new Thread(() -> {
            // long breakTimePerTick = (long)(velocity);
            // long breakTimePerTick = (long)(1 / velocity);
            // long breakTimePerTick = 10l;
            long breakTimePerTick = 5l;
            // long breakTimePerTick = 10l;
            // long breakTimePerTick = 20l;
            // long breakTimePerTick = 80l;
            // long breakTimePerTick = 200l;
            // long breakTimePerTick = 200l;
            System.out.println("start bullet");
            while (!isGameObjectDied()) {
                moveToDestination();
                // try { Thread.sleep(1000); } catch (Exception e) { }
                // try { Thread.sleep(breakTimePerTick); } catch (Exception e) { }
                try { Thread.sleep(breakTimePerTick); } catch (Exception e) { }
            }
        }).start();
    }

    private void moveToDestination() {
        System.out.println("moving to destination");
        // getDistanceBetweenGameObject(to, from);
        // Point thisP = getLocation();
        Point currentPosition = getLocation();
        Point destinationPosition = to.getLocation();
        // int deltaX = currentPosition.x - destinationPosition.x;
        int dir = (currentPosition.x - destinationPosition.x) > 0 ? -1 : 1;
        // int deltaY = currentPosition.y - destinationPosition.y;
        // currentPosition.translate(ALLBITS, ABORT);
        // setLocation(currentPosition.);
        currentPosition.translate( (int)(dir * velocity), 0);
        setLocation(currentPosition);
        // setLocation(
        // thisP.
        // float deltaX =
        // change current position no change destination position (but must update)
        // todo : destry game oject
        // if (getLocation().equals(destinationPosition)) {
        // }
        if (getLocation().x > to.x) {
            destroyGameObject();
            setGameObjectDied(true);
        }
    }
}
