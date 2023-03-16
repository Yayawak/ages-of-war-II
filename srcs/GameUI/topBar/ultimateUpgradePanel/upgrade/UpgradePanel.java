package srcs.GameUI.topBar.ultimateUpgradePanel.upgrade;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Interfaces.Loopable;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;

public class UpgradePanel extends JPanel implements Loopable {
    private static UpgradePanel instance = null;

    public static UpgradePanel getInstance() {
        if (instance == null)
            instance = new UpgradePanel();
        return instance;
    }

    private UpgradePanel() {
        init();
    }

    private void init() {
        // setPreferredSize(getPreferredSize());
        // setSize(getPreferredSize());
        setBackground(Color.red);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
    }
}
