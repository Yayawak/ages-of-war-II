package srcs.UI.topBar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import srcs.interfaces.ComponentSizeItf;
import srcs.UI.topBar.specialsBox.SpecialsBox;
import srcs.UI.topBar.turretsBox.TurretsBox;
import srcs.UI.topBar.unitsBox.UnitsBox;
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
        // new UnitsBox();
        // new TurretsBox();
        // new SpecialsBox();
        // new UpgradesBox();

        // App.mainFrame.add(topBar, BorderLayout.NORTH);
    }

    private void init() {
        setBackground(new Color(242, 242, 42));
        setPreferredSize(new Dimension(0, 55));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }
}
