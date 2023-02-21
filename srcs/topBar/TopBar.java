package srcs.topBar;

import javax.swing.JPanel;

import srcs.App;

import java.awt.*;

public class TopBar extends JPanel {
    public TopBar() {
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.red);
        // mainFrame.add(topBar, BorderLayout.NORTH);
        App.mainFrame.add(topBar, BorderLayout.NORTH);
    }
}
