package srcs.UI.topBar.turretsBox;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import srcs.UI.topBar.TopBar;
import java.awt.*;;

public class TurretsBox extends JPanel {
    private static TurretsBox instance = null;

    private TurretsBox() {
        init();
        // TopBar.getInstance().add(this);
    }

    public static TurretsBox getInstance() {
        if (instance == null) {
            instance = new TurretsBox();
        }
        return instance;
    }

    private void init() {
        setBackground(new Color(22, 100, 242));

        GroupLayout turretsBoxLayout = new GroupLayout(this);
        setLayout(turretsBoxLayout);
        turretsBoxLayout.setHorizontalGroup(
            turretsBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        turretsBoxLayout.setVerticalGroup(
            turretsBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );


    }
}
