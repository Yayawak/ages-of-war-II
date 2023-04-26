package srcs.GameUI.topBar.ultimateUpgradePanel.ultimate;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.integratedSystem.IntegratedSystem;
import java.awt.*;
import java.awt.event.*;

public class UltimatePanel extends JPanel implements
    Loopable {
    private static UltimatePanel instance = null;
    private Image ultimateImage;

    public static UltimatePanel getInstance() {
        if (instance == null)
            instance = new UltimatePanel();
        return instance;
    }
    public UltimatePanel() {
        System.out.println("enter UltimatePanel");

        init();
        initEvent();
    }

    private void init() {
        // setBackground(Color.blue);
        // ultimateImage = new ImageData("characters/phynix_ck_cw.png").getSprite();
        // todo : this is dummy data
        // ultimateImage = new ImageData("characters/phynix_ck_cw.png").getSprite();
        ultimateImage = SkeletonAge.getInstance().getUltimateImage();
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //todo : metheor depends on each ages
                IntegratedSystem.getInstance().getCurrentPlayerAgeData()
                    .useUltimate(TeamType.PLAYER);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(ultimateImage, 0, 0, null);
    }

    @Override
    public void update() {
    }

    // not connected manually from mainUI.draw
    @Override
    public void draw(Graphics g) {
    }

    public void setUltiImage(Image newUltimateImage) {
        this.ultimateImage = newUltimateImage;
    }
}
