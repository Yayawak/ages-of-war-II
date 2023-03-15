package srcs.UI.lowerBar;
import javax.swing.*;

import srcs.UI.lowerBar.hpPanel.HpPanel;
import srcs.UI.lowerBar.timeControlBar.TimeControlBar;

import java.awt.*;

public class LowerBar extends JPanel {
    private static LowerBar instance = null;

    public static LowerBar getInstance() {
        if (instance == null)
            instance = new LowerBar();
        return instance;
    }

    public LowerBar() {
        init();
        // add(new JLabel("LLLLLLLLL"));
    }

    private void init() {
        // setBackground(new Color(22, 242, 242));
        setBackground(Color.orange);
        setPreferredSize(new Dimension(0,30));
        // add(TimeControlBar.getInstance());

        GroupLayout lowerBarLayout = new GroupLayout(this);
        setLayout(lowerBarLayout);
        lowerBarLayout.setHorizontalGroup(
            lowerBarLayout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
            .addGroup(
                lowerBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TimeControlBar.getInstance(),
                    GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                    120, Short.MAX_VALUE)
                .addComponent(HpPanel.getInstance(),
                    GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap()
            )
        );
        lowerBarLayout.setVerticalGroup(
            lowerBarLayout.createParallelGroup(
                GroupLayout.Alignment.LEADING)
            .addGroup(lowerBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lowerBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeControlBar.getInstance(),
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addGroup(lowerBarLayout.createSequentialGroup()
                        .addComponent(HpPanel.getInstance(),
                        GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                    )
                )
                .addContainerGap())
        );
    }

}
