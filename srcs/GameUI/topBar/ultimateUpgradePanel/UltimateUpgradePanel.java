package srcs.GameUI.topBar.ultimateUpgradePanel;

import javax.swing.GrayFilter;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.ultimateUpgradePanel.ultimate.UltimatePanel;
import srcs.GameUI.topBar.ultimateUpgradePanel.upgrade.UpgradePanel;

import java.awt.*;


public class UltimateUpgradePanel extends JPanel {
    private static UltimateUpgradePanel instance = null;

    public static UltimateUpgradePanel getInstance() {
        if (instance == null)
            instance = new UltimateUpgradePanel();
        return instance;
    }
    public UltimateUpgradePanel() {
        initGraphic();
    }

    private void initGraphic() {

        // setLayout(new FlowLayout());
        // setLayout(new GridLayout(1, 0));

        // System.out.println("Enter init Graphic");
        GroupLayout panelLayout = new GroupLayout(this);
        setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Dimension imgSize = new Dimension(
            50, 50
        );
        setPreferredSize(imgSize);
        setBackground(Color.red);
        setOpaque(true);

        add(UltimatePanel.getInstance());
        add(UpgradePanel.getInstance());
    }
}
