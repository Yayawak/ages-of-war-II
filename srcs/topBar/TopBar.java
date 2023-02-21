package srcs.topBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import srcs.App;
import java.awt.*;

// public class TopBar extends JPanel {
public class TopBar {
    public static final JPanel topBar = new JPanel();

    public TopBar() {
        topBar.setBackground(Color.red);
        // no use for ratio test
        Dimension dim = new Dimension(
            App.mainFrame.getWidth(),
            (int)(App.mainFrame.getHeight() * 0.15f)
            // 500
        );
        topBar.setSize(dim);
        App.mainFrame.add(topBar, BorderLayout.NORTH);
        // App.mainFrame.add(topBar, 1);
<<<<<<< HEAD
        // App.mainFrame.add(topBar);
=======
        App.mainFrame.add(topBar);

        topBar.setLayout(new GridLayout(0, 4));
        JPanel topBar1 = new JPanel();
        JPanel topBar2 = new JPanel();
        JPanel topBar3 = new JPanel();
        JPanel topBar4 = new JPanel();
        topBar1.setBackground(Color.CYAN);
        topBar.add(topBar1);
        topBar2.setBackground(Color.DARK_GRAY);
        topBar.add(topBar2);
        topBar3.setBackground(Color.gray);
        topBar.add(topBar3);
        topBar4.setBackground(Color.pink);
        topBar.add(topBar4);
>>>>>>> cca8f4d8452db69d1ada0564e6d102b4a00696e8
    }
}
