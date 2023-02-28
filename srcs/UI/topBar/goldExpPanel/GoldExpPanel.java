package srcs.UI.topBar.goldExpPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;

import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.goldExpPanel.expPanel.ExpPanel;
import srcs.UI.topBar.goldExpPanel.goldPanel.GoldPanel;

import java.awt.*;;

public class GoldExpPanel extends JPanel {
    private static GoldExpPanel instance = null;

    public static GoldExpPanel getInstance() {
        if (instance == null)
            instance = new GoldExpPanel();
        return instance;
    }

    private GoldExpPanel() {
        init();
    }

    public void init() {
        // setBackground(new Color(2, 150, 22));
        setBackground(Color.yellow);
        // setPreferredSize(new Dimension(100, getHeight()));
        // setSize(new Dimension(100, getHeight()));

        GroupLayout upgradesBoxLayout = new GroupLayout(this);
        setLayout(upgradesBoxLayout);
        upgradesBoxLayout.setHorizontalGroup(
            upgradesBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        upgradesBoxLayout.setVerticalGroup(
            upgradesBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );


        // setLayout(new FlowLayout());
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(ExpPanel.getInstance());
        add(GoldPanel.getInstance());

        // setLayout(new BorderLayout());
        // add(ExpPanel.getInstance(), BorderLayout.WEST);
        // add(GoldPanel.getInstance(), BorderLayout.EAST);
    }
}
