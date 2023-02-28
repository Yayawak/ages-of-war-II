package srcs.UI.topBar.goldExpProgPanel.expPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExpPanel extends JPanel {
    private static ExpPanel instance = null;
    private JLabel goldLabel;

    public static ExpPanel getInstance() {
        if (instance == null)
            instance = new ExpPanel();
        return instance;
    }
    public ExpPanel() {
        init();
    }

    private void init() {
        // setPreferredSize(getPreferredSize());
        // setSize(getPreferredSize());
        setBackground(Color.blue);
        goldLabel = new JLabel("EXP : ");
        add(goldLabel);
        System.out.println("Exp label inited");
    }
}
