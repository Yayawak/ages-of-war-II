package srcs.GameUI.topBar.ultimateUpgradePanel.upgrade;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Interfaces.Loopable;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.awt.event.*;

public class UpgradePanel extends JPanel implements Loopable {
    private static UpgradePanel instance = null;
    Image upgradeImg;

    public static UpgradePanel getInstance() {
        if (instance == null)
            instance = new UpgradePanel();
        return instance;
    }

    private UpgradePanel() {
        init();
        initEvent();
    }

    private void init() {
        // setPreferredSize(getPreferredSize());
        // setSize(getPreferredSize());
        setBackground(Color.red);
        upgradeImg = StoneAge.getInstance().getUpgradeImage();
    }

    private void initEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //todo : upgrade new age
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(upgradeImg, 0, 0, null);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
    }
}
