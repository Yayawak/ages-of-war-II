package srcs.lowerBar;
import javax.swing.*;

import srcs.App;

import java.awt.*;

public class LowerBar {
    public LowerBar() {
        JPanel lowerBar = new JPanel();
        lowerBar.setBackground(Color.green);
        App.mainFrame.add(lowerBar, BorderLayout.SOUTH);
        // mainFrame.add(lowerBar, 1);
        // mainFrame.add(lowerBar);
    }

}
