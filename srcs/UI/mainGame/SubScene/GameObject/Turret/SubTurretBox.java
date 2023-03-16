package srcs.UI.mainGame.SubScene.GameObject.Turret;

import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import srcs.UI.topBar.goldExpProgPanel.qProgress.QueueProgress;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.GroupLayout;
import java.awt.event.*;

public class SubTurretBox extends JPanel {
    private Image img;
    private TurretPrototype TurretPrototype;

    public SubTurretBox(TurretPrototype turretPrototype) {
        initEvent();
        this.TurretPrototype = turretPrototype;
        this.img = turretPrototype.getImgData().getSprite();
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // drawTurret(getGraphics());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTurret(g);
    }

    private void drawTurret(Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0,
                    getWidth(), getHeight(), null);
        } else {
            System.out.println("Image does not exist");
        }
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public TurretPrototype getTurretPrototype() {
        return TurretPrototype;
    }

    public void setTurretPrototype(TurretPrototype turretPrototype) {
        TurretPrototype = turretPrototype;
    }

}
