package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Graphics;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Characters.Character;
import srcs.UI.mainGame.MainGame;
import srcs.interfaces.Loopable;

import java.awt.*;

public class GameObject extends JPanel implements Loopable {
    protected Image img;
    Point pos;
    Dimension imgSize;
    protected boolean isCollide = false;
    protected long spawnTime;

    public GameObject(Image img, Point pos, Dimension imgSize) {
        spawnTime = System.nanoTime();
        setLocation(pos);
        setImg(img);
        // System.out.println("Position = " + xPos + " : " + yPos);
        setSize(imgSize); // ? Important for collsion detection
        this.imgSize = imgSize;
        this.pos = pos;
        // repaint();
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
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
        //? reset collsion : make character movable again
        isCollide = false;
        for (GameObject go : MainGame.getObjectsInScene()) {
            if (isCollideWith(go)) {
                isCollide = true;
            }
        }
    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        MainGame.getObjectsInScene().remove(this);
    }

    public boolean isCollideWith(GameObject otherGameObject) {
        // System.out.println("W = " + this.imgSize.width);
        // System.out.println("H = " + getHeight());
        if (getBounds().
            intersects(otherGameObject.getBounds())
            &&
            this != otherGameObject // collision itself
        ) {
            // System.out.println("Collsion Occcured");
            // ? if spawn before -> stop younger gameobject
            if (this.spawnTime < otherGameObject.spawnTime) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
