package srcs.GameUI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.topBar.goldExpProgPanel.qProgress.QueueProgress;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Systems.Tooltips.CharacterTooltip;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import javax.swing.Timer;;

public class SubUnit extends JPanel {
    private Image img; // pointer is points to the same object as character's image
    private CharacterPrototype character;
    private CharacterTooltip characterTooltip;

    public SubUnit(CharacterPrototype c) {
        initGraphic();
        initEvent();
        this.character = c;
        this.img = character.getImgData().getSprite();
        characterTooltip = new CharacterTooltip(c);
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            private Timer timer;

            @Override
            public void mouseClicked(MouseEvent e) {
                // System.out.println(e);
                // todo : send character data by mouse clikc
                GameObject go = new CharacterGObject(character);
                if (QueueProgress.getInstance().isProgressBarAvailable()
                        &&
                        IntegratedSystem.getInstance().getPlayerGoldSystem()
                                .getGold() > character.getGold()) {
                    MainGame.getInstance().addGameObjectToScene(go);
                    QueueProgress.getInstance().startQueue(character.getBuildTime());
                    IntegratedSystem.getInstance().getPlayerGoldSystem()
                            .decreasedGold(character.getGold());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                timer = new Timer(1, new ActionListener() {
                    public void actionPerformed(ActionEvent ev) {

                        // getPos
                        // Point cursorPos = MainGame.getInstance().getMousePosition();
                        Point cursorPos = e.getPoint(); //? relative to subUnit JPanel
                        System.out.println("X of image : " + getX()); // absolute pos
                        System.out.println("Width of image : " + getSize().getWidth()); // absolute pos
                        System.out.println(cursorPos);
                        // characterTooltip.setVisible(false);
                        characterTooltip.setLocation(e.getPoint());
                        // while ()
                        // characterTooltip.setLocation(new Point(
                        //     e.getX() + 20,
                        //     e.getY() + 25
                        // ));
                        // characterTooltip.removeAll();
                        // characterTooltip.repaint();
                        // characterTooltip.
                        // characterTooltip.
                        characterTooltip.setVisible(true);
                    }
                });
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (timer != null) {
                    timer.stop();
                    timer = null;
                }
                characterTooltip.setVisible(false);
            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent ev) {
            }

        });
    }

    private void initGraphic() {
        GroupLayout unitPanelLayout = new GroupLayout(this);
        setLayout(unitPanelLayout);
        unitPanelLayout.setHorizontalGroup(
                unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        unitPanelLayout.setVerticalGroup(
                unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));

        Dimension subUnitPanelDimension = new Dimension(
                50, 50);
        setPreferredSize(subUnitPanelDimension);
        setBackground(Color.yellow);
        setOpaque(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawUnit(g);
    }

    private void drawUnit(Graphics g) {
        if (img != null) {
            g.drawImage(img,
                    0, 0,
                    getWidth(), getHeight(), null);
            // 100, 100, null);
            // 50, 50, null);

        } else {
            System.out.println("Image does not exist");
        }
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        // repaint();
    }

    public CharacterPrototype getCharacter() {
        return character;
    }

    public void setCharacter(CharacterPrototype character) {
        this.character = character;
    }

}
