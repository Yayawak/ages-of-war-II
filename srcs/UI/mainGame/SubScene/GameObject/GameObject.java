package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Characters.Character;

import java.awt.*;

public class GameObject extends JPanel {
    protected Image img;

    public GameObject(Image img, int x, int y) {
        setLocation(x, y);
        setImg(img);
        // System.out.println("Position = " + xPos + " : " + yPos);
        // repaint();
    }

    public void draw(Graphics g) {
        // moveRight(g);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

}
