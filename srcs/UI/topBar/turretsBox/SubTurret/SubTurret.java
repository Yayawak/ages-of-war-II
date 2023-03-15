package srcs.UI.topBar.turretsBox.SubTurret;

import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;;

public class SubTurret extends JPanel {
    // private Image turretImage;
    private TurretPrototype turretPrototype;
    public SubTurret(TurretPrototype tp) {
        // System.out.println("Enter subTurret class");
        this.turretPrototype = tp;
        // this.turretImage = tp.getImgData().getSprite();
        initGraphic();
        initEvent();
    }

    private void initGraphic() {
        // System.out.println("Enter init Graphic");
        GroupLayout panelLayout = new GroupLayout(this);
        setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Dimension imgSize = new Dimension(
            50, 50
        );
        setPreferredSize(imgSize);
        setBackground(Color.red);
        setOpaque(true);

    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TowerPrototype.
                //todo : ADD TURRET OT PLAYER'S TOWER
                System.out.println(e);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Enter paint comp from turetsBox");
        super.paintComponent(g);
        // g.drawImage(turretImage,
        System.out.println("sprint path : " +
            turretPrototype.getImgData().getFullPath());
        if (turretPrototype.getImgData().getSprite() != null) {
            g.drawImage(turretPrototype.getImgData().getSprite(),
                0,
                0,
                getWidth(),
                getHeight(),
                null
            );
        } else {
            System.out.println("no turret image sprint");
        }
    }
}
