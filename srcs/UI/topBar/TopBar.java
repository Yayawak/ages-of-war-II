package srcs.UI.topBar;

import javax.swing.JPanel;
import srcs.App;
import srcs.interfaces.ComponentSizeItf;
import srcs.UI.topBar.specialsBox.SpecialsBox;
import srcs.UI.topBar.turretsBox.TurretsBox;
import srcs.UI.topBar.unitsBox.UnitsBox;
// import srcs.UI.topBar.upgradesBox.UpgradesBox;
import java.awt.*;

// public class TopBar extends JPanel {
public class TopBar implements ComponentSizeItf {
    public static final JPanel topBar = new JPanel();
    // public static JPanel topBar;

    public TopBar() {
        // topBar = new JPanel();
        topBar.setBackground(Color.red);
        Dimension dim = new Dimension(
                App.mainFrame.getWidth(),
                (int)(App.mainFrame.getHeight() * 0.15f)
        );
        topBar.setLayout(new GridLayout(0, 3));
        // * Must use setPreferredSize because We use LayoutManager
        topBar.setPreferredSize(dim); // if use setSize it will error becuase of it will set this panel relative to it's parent ??
        // topBar.setSize(dim);
        showComponentSize("TopBar", topBar);

        new UnitsBox();
        new TurretsBox();
        new SpecialsBox();
        // new UpgradesBox();

        App.mainFrame.add(topBar, BorderLayout.NORTH);
    }
}
