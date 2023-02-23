package srcs.UI.topBar.turretsBox;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import srcs.UI.topBar.TopBar;
import java.awt.*;;

public class TurretsBox extends JPanel {
    private static TurretsBox single_instance = null;

    private TurretsBox() {
        init();
        TopBar.getInstance().add(this);
    }

    public static TurretsBox getInstance() {
        if (single_instance == null) {
            single_instance = new TurretsBox();
        }
        return single_instance;
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
