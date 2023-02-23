package srcs.UI.lowerBar.hpPanel;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.*;

public class HpBar extends JProgressBar {
    public HpBar() {
        init();
    }
    private void init() {
        // setBackground(new java.awt.Color(255, 109, 109));
        // setBackground(Color.red);
        setPreferredSize(getPreferredSize());
        // setPreferredSize(new Dimension(200, 35));
        // setPreferredSize(new Dimension(10, 100));
        // setPreferredSize(new Dimension(100,10));
    }
}
