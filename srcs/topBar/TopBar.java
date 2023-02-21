package srcs.topBar;

import javax.swing.JPanel;

import srcs.App;

import java.awt.*;

// public class TopBar extends JPanel {
public class TopBar {
    public static final JPanel topBar = new JPanel();
    public TopBar() {
        topBar.setBackground(Color.red);
        // App.mainFrame.add(topBar, BorderLayout.NORTH);
        // App.mainFrame.add(topBar, 1);
        App.mainFrame.add(topBar);
    }
}
