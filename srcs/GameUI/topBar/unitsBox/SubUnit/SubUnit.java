package srcs.GameUI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.topBar.goldExpProgPanel.qProgress.QueueProgress;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Systems.Tooltips.CharacterTooltip;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;;

public class SubUnit extends JPanel {
    // private Image img; // pointer is points to the same object as character's image
    private CharacterPrototype character;
    private CharacterTooltip characterTooltip;
    // private boolean isCursorOnSubUnitBox = false;
    // private boolean isCursorOnSubUnitBox = true;

    public SubUnit(CharacterPrototype c) {
        this.character = c;
        // this.img = character.getImgData().getSprite();
        characterTooltip = new CharacterTooltip(c);
        initGraphic();
        initEvent(); //
        // initTooltipCallback();
    }

    private void initTooltipCallback() {
        new Thread(() -> {
            while (true) {
                // if (isCursorOnSubUnitBox && getMousePosition() != null) {
                // try {
                // if (getMousePosition(true) != null)
                // ! bug no x on p (position mouse)
                // if (getMousePosition() != null)
                    // characterTooltip.setLocation(getMousePosition());
                // } catch (Exception e) { System.out.println(e); }
                // characterTooltip.setVisible(isCursorOnSubUnitBox);

                // System.out.println("is cursor on subunit = " + isCursorOnSubUnitBox);

                // if (getMousePosition() != null) {
                //     if (getBounds().contains(getMousePosition())) {
                //         isCursorOnSubUnitBox = true;
                //     } else {
                //         isCursorOnSubUnitBox = false;
                //     }
                // }
            }
        }).start();
    }

    private void initEvent() {
        characterTooltip.addMouseListener(new MouseAdapter() {
            // @Override
            // public void mouseEntered(MouseEvent e) {
            // // public void mouseMoved(MouseEvent e) {
            //     // isCursorOnSubUnitBox = true;
            //     System.out.println("ENTER Char TOOLTIP");
            // }
            @Override
            public void mouseExited(MouseEvent e) {
                characterTooltip.setVisible(false);
            }
        });
        characterTooltip.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                characterTooltip.setVisible(true);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                character.setTeamType(TeamType.PLAYER);
                try {
                    GameObject go = new CharacterGObject(
                        character.getClass().getDeclaredConstructor(TeamType.class).newInstance(TeamType.PLAYER)
                    );
                    if (QueueProgress.getInstance().isProgressBarAvailable()
                        &&
                        IntegratedSystem.getInstance().getPlayerGoldSystem()
                            .getGold() > character.getGold())
                    {
                        QueueProgress.getInstance().startQueue(character.getBuildTime());
                        // QueueProgress.getInstance().setCurrentCharacterPrototypeToBuild(character);
                        // Class<TeamType> c = TeamType.class;
                        try {
                            QueueProgress.getInstance().setCurrentCharacterPrototypeToBuild(
                                // character.getClass().getDeclaredConstructor(c).newInstance(TeamType.PLAYER)
                                character.getClass().getDeclaredConstructor(TeamType.class).newInstance(TeamType.PLAYER)
                                // Class.forName())
                            );
                        } catch (Exception e2) {
                            System.out.println(e2);
                        }
                        QueueProgress.getInstance().setCurrentGameObjectToBuild(go);
                    }
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // isCursorOnSubUnitBox = true;
                characterTooltip.setVisible(true);
                // System.out.println("enter");
            }
            // @Override
            // public void mouseMoved(MouseEvent e) {
            //     // characterTooltip.setLocation(getMousePosition());
            // }
            @Override
            public void mouseExited(MouseEvent e) {
                // isCursorOnSubUnitBox = false;
                characterTooltip.setVisible(false);
                // System.out.println("exit");
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // System.out.println("Move");
                // characterTooltip.setLocation(e.getPoint());
                characterTooltip.setLocation(
                    getMousePosition(true).x,
                    getMousePosition(true).y
                );
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
        Image img = character.getImgData().getSprite();
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

    // public Image getImg() {
    //     return img;
    // }

    // public void setImg(Image img) {
    //     this.img = img;
    //     // repaint();
    // }

    public CharacterPrototype getCharacter() {
        return character;
    }

    public void setCharacter(CharacterPrototype character) {
        this.character = character;
    }

    public CharacterTooltip getCharacterTooltip() {
        return characterTooltip;
    }

    public void setCharacterTooltip(CharacterTooltip characterTooltip) {
        this.characterTooltip = characterTooltip;
    }

    // public void setCursorOnSubUnitBox(boolean isCursorOnSubUnitBox) {
    //     this.isCursorOnSubUnitBox = isCursorOnSubUnitBox;
    // }

}
