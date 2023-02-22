package srcs.UI.lowerBar;
import javax.swing.*;

import srcs.App;

import java.awt.*;

public class LowerBar {
    public static final JPanel lowerBar = new JPanel();

    public LowerBar() {
        lowerBar.setBackground(Color.green);
        Dimension dim = new Dimension(
            App.mainFrame.getWidth(),
            (int)(App.mainFrame.getHeight() * 0.05)
        );
        lowerBar.setPreferredSize(dim);

        App.mainFrame.add(lowerBar, BorderLayout.SOUTH);
        // mainFrame.add(lowerBar, 1);
        // mainFrame.add(lowerBar);
    }

}
