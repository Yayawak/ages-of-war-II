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
    }

    public void destroyGameObject() {
        revalidate();
        repaint();
        MainGame.getObjectsInScene().remove(this);
    }

    public GameObject copy() {
        return new GameObject(img, pos, imgSize);
    }
}
