package srcs.topBar;

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
        // App.mainFrame.add(topBar);
    }
}
