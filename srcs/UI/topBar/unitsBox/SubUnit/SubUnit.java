package srcs.UI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.UI.mainGame.MainGame;

import java.awt.*;
import java.awt.event.*;

public class SubUnit extends JPanel{
    private Image img;
    public SubUnit() {
        initGraphic();
        initEvent();
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
                // MainGame.getInstance().drawObject(getImg(),
                //     (int)(Math.random() * 1000),
                //     (int)(Math.random() * 1000)
                // );
                MainGame.getInstance().repaint();
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
        drawUnit(img, g);
    }

    private void drawUnit(Image img, Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        } else {
            System.out.println("Image does not exist");
        }
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        repaint();
    }


}
