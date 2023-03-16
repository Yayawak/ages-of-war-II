package srcs.GameUI.topBar.goldExpProgPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;

import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.goldExpProgPanel.expPanel.ExpPanel;
import srcs.GameUI.topBar.goldExpProgPanel.goldPanel.GoldPanel;
import srcs.GameUI.topBar.goldExpProgPanel.qProgress.QueueProgress;

import java.awt.*;;

public class GoldExpProgPanel extends JPanel {
    private static GoldExpProgPanel instance = null;

    public static GoldExpProgPanel getInstance() {
        if (instance == null)
            instance = new GoldExpProgPanel();
        return instance;
    }

    private GoldExpProgPanel() {
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


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel topPan = new JPanel();
        topPan.setLayout(new BoxLayout(topPan, BoxLayout.X_AXIS));
        topPan.add(ExpPanel.getInstance());
        topPan.add(GoldPanel.getInstance());
        add(topPan);

        //todo : progress Q bar
        JPanel botPan = new JPanel();
        botPan.add(QueueProgress.getInstance());
        add(botPan);


        // setLayout(new BorderLayout());
        // add(ExpPanel.getInstance(), BorderLayout.WEST);
        // add(GoldPanel.getInstance(), BorderLayout.EAST);
    }
}
