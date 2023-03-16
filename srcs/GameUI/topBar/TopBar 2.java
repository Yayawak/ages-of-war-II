package srcs.GameUI.topBar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import srcs.GameUI.topBar.goldExpProgPanel.GoldExpProgPanel;
import srcs.GameUI.topBar.turretsBox.TurretsBox;
import srcs.GameUI.topBar.ultimateUpgradePanel.UltimateUpgradePanel;
import srcs.GameUI.topBar.unitsBox.UnitsBox;
import srcs.Interfaces.ComponentSizeItf;

// import srcs.UI.topBar.upgradesBox.UpgradesBox;
import java.awt.*;

// public class TopBar extends JPanel {
public class TopBar extends JPanel implements ComponentSizeItf {
    private static TopBar instance = null;

    public static TopBar getInstance() {
        if (instance == null)
            instance = new TopBar();
        return instance;
    }

    private TopBar() {
        init();
    }

    private void init() {
        setBackground(new Color(242, 242, 42));
        setPreferredSize(new Dimension(0, 55));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        // add(UnitsBox.getInstance());
        // add(TurretsBox.getInstance());
        // add(UpgradesBox.getInstance());
    }
}
