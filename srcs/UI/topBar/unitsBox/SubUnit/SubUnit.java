package srcs.UI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.Characters.Character;
import srcs.UI.MainUI;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.CharacterGObject;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;

import java.awt.*;
import java.awt.event.*;
import java.time.chrono.MinguoDate;

public class SubUnit extends JPanel{
    private Image img; // pointer is points to the same object as character's image
    private Character character;
    public SubUnit(Character c) {
        initGraphic();
        initEvent();
        this.character = c;
        this.img = character.getImageData().getSprite();
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
                // todo : send character data by mouse clikc
                GameObject go = new CharacterGObject(character);
                MainGame.getInstance().addGameObjectToScene(go);
            }
        });
    }

    private void initGraphic() {
        GroupLayout unitPanelLayout = new GroupLayout(this);
        setLayout(unitPanelLayout);
        unitPanelLayout.setHorizontalGroup(
            unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        unitPanelLayout.setVerticalGroup(
            unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Dimension subUnitPanelDimension = new Dimension(
            50, 50
        );
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
                // 100, 100, null);

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

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }


}
