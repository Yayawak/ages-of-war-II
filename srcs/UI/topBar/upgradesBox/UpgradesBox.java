package srcs.UI.topBar.upgradesBox;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.UI.topBar.TopBar;

import java.awt.*;;

public class UpgradesBox extends JPanel {
    private static UpgradesBox instance = null;

    public static UpgradesBox getInstance() {
        if (instance == null)
            instance = new UpgradesBox();
        return instance;
    }

    private UpgradesBox() {
        init();
    }

    public void init() {
        setBackground(new Color(2, 150, 22));

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
        TopBar.getInstance().add(this);
    }
}
