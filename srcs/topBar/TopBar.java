package srcs.topBar;

import javax.swing.JPanel;
import srcs.App;
import srcs.topBar.specialsBox.SpecialsBox;
import srcs.topBar.turretsBox.TurretsBox;
import srcs.topBar.unitsBox.UnitsBox;
import srcs.topBar.upgradesBox.UpgradesBox;

import java.awt.*;

// public class TopBar extends JPanel {
public class TopBar {
    public static final JPanel topBar = new JPanel();

    public TopBar() {
        topBar.setBackground(Color.red);
        // no use for ratio test
        Dimension dim = new Dimension(
                App.mainFrame.getWidth(),
                (int) (App.mainFrame.getHeight() * 0.15f)
        // 500
        );
        topBar.setSize(dim);
        App.mainFrame.add(topBar, BorderLayout.NORTH);
        // App.mainFrame.add(topBar, 1);
        // App.mainFrame.add(topBar);
        // App.mainFrame.add(topBar);

        topBar.setLayout(new GridLayout(0, 4));
        new SpecialsBox();
        new TurretsBox();
        new UnitsBox();
        new UpgradesBox();
        JPanel topBar3 = new JPanel();
        JPanel topBar4 = new JPanel();
        topBar3.setBackground(Color.gray);
        topBar.add(topBar3);
        topBar4.setBackground(Color.pink);
        topBar.add(topBar4);
    }
}
