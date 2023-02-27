package srcs.UI;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("Age of War mock");
        // setResizable(false);
        // setLocationRelativeTo(null); //center

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1400, 850));
        // setSize(new Dimension(1400, 850));
        add(MainUI.getInstance());

        pack();
    }
}
