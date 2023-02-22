package srcs.UI.lowerBar;
import javax.swing.*;

import srcs.App;

import java.awt.*;

public class LowerBar {
    public static final JPanel lowerBar = new JPanel();

    public LowerBar() {
        init();
    }

    private static void init() {
        lowerBar.setBackground(new Color(22, 242, 242));
        lowerBar.setPreferredSize(new Dimension(0, 50));

        GroupLayout lowerBarLayout = new GroupLayout(lowerBar);
        lowerBar.setLayout(lowerBarLayout);
        lowerBarLayout.setHorizontalGroup(
            lowerBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lowerBarLayout.createSequentialGroup()
                .addContainerGap()
                // .addComponent(timeControlBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                // .addComponent(hpPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        lowerBarLayout.setVerticalGroup(
            lowerBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(lowerBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lowerBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    // .addComponent(timeControlBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(lowerBarLayout.createSequentialGroup()
                        // .addComponent(hpPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

    }

}
