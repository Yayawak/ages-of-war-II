package srcs.GameUI.mainGame.SubScene.characterHpBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Interfaces.Loopable;

import java.awt.Dimension;

public class CharacterHpBar extends JProgressBar
    implements Loopable {
    private CharacterGObject cgo = null;
    private boolean isHpBarDestroyed = false;

    public CharacterHpBar(CharacterGObject cgo) {
        if (cgo == null) System.out.println("this hpbar have no proper character to attach with.");
        this.cgo = cgo;
        init();
    }

    private void init() {
        // setSize(getPreferredSize());
        // setSize(50, 10);
        // setSize(cgo.getWidth(), 20);
        setMaximum(cgo.getCharacter().getMaxHp());
        setSize(cgo.getWidth() - 50, 20);
        // setBounds(0, 0, cgo.getWidth(), 20);
        // setSize(50, 10);
        // setPreferredSize(new Dimension(50, 10));
        // setForeground(Color.red);
        // setBackground(Color.black);
        // setStringPainted(true);
        // setValue(10);
        // setVisible(true);
        // repaint();

        // increaseHpEveryMs(50);
    }

    public void increaseHpEveryMs(long ms) {
        // long ms = second * 1000l;
        new Thread(
            () -> {
                // int maxHp = cgo.getCharacter().getMaxHp() | 100;
                int maxHp = cgo.getCharacter().getMaxHp();
                while (!isHpBarDestroyed) {
                    setValue(cgo.getCharacter().getHp());
                    if (getValue() >= maxHp) {
                        cgo.getCharacter().setHp(0);
                    }
                    try {
                        // Thread.sleep(1000);
                        Thread.sleep(ms);
                        cgo.getCharacter().increaseHp(1);
                    } catch (Exception e) { System.out.println(e);
                        System.out.println("from CHaraterHPBAr");
                     }
                    // } catch (Exception e) {}
                }
            }
        ).start();
    }


    @Override
    public void update() {
        // System.out.println("update from character hp bar ");
        // System.out.println("current hp is " +
        //     cgo.getCharacter().getHp());
        // System.out.format("location of hp bar is : %s\n",
        //     this.getLocation());
        // System.out.println("===".repeat(20));

        setValue(cgo.getCharacter().getHp());
    }

    // @Override // ? not word
    // protected void paintComponent(Graphics g) {
    //     // g.setColor(Color.red);
    // }

    @Override
    public void draw(Graphics g) {
        setLocation(new Point(
            cgo.getX() + (int)(cgo.getWidth() / 2),
            cgo.getY()
        ));
        setSize(40, 20);
    }

    public boolean isHpBarDestroyed() {
        return isHpBarDestroyed;
    }

    public void setHpBarDestroyed(boolean isHpBarDestroyed) {
        this.isHpBarDestroyed = isHpBarDestroyed;
    }

}
