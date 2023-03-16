package srcs.GameUI.lowerBar.timeControlBar;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class TimeControlBar extends JPanel {
    private static TimeControlBar instance = null;
    public static TimeControlBar getInstance() {
        if (instance == null)
            instance = new TimeControlBar();
        return instance;
    }

    private TimeControlBar() {
        init();
    }

    private void init() {
        setBackground(new Color(142, 92, 92));
        setPreferredSize(new Dimension(700, 100));
        add(new JLabel("Lable me"));

        GroupLayout timeControlBarLayout = new GroupLayout(this);
        setLayout(timeControlBarLayout);
        timeControlBarLayout.setHorizontalGroup(
            timeControlBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        timeControlBarLayout.setVerticalGroup(
            timeControlBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }
}
