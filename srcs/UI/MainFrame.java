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

        // setPreferredSize(new Dimension(1400, 850));
        setPreferredSize(new Dimension(1400, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(new Dimension(1400, 850));
        add(MainUI.getInstance());

        pack();
        // validate();
    }
}
