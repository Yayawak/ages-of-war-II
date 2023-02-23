package srcs.UI.lowerBar.hpPanel;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class HpPanel extends JPanel {
    private static HpPanel instance = null;
    private HpBar playerHpBar = null;

    public static HpPanel getInstance() {
        if (instance == null)
            instance = new HpPanel();
        return instance;
    }

    private HpPanel() {
        init();
        // System.out.println("aaaaaaaaaa");
    }

    private void init() {
        playerHpBar = new HpBar();
        setPreferredSize(new Dimension(400, 100));
        // setBackground(new Color(42, 242, 42));
        setBackground(Color.blue);

        // setBackground(new Color(105, 109, 109));
        // setBackground(Color.red);
        // add(new JLabel("HP Panel"));


        GroupLayout hpPanelLayout = new GroupLayout(this);
        setLayout(hpPanelLayout);
        hpPanelLayout.setHorizontalGroup(
            hpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, hpPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(playerHpBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        hpPanelLayout.setVerticalGroup(
            hpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerHpBar, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
}

