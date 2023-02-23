package srcs.UI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.*;

public class SubUnit extends JPanel {
    private Image img;
    public SubUnit() {
        init();
    }

    private void init() {
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
