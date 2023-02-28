package srcs.UI.topBar.specialsBox;

import java.awt.Color;
import javax.swing.GrayFilter;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.UI.topBar.TopBar;;

public class SpecialsBox extends JPanel {
    private static SpecialsBox instance = null;

    public static SpecialsBox getInstance() {
        if (instance == null)
            instance = new SpecialsBox();
        return instance;
    }
    public SpecialsBox() {
        init();
    }

    private void init() {
        // setBackground(new java.awt.Color(2, 150, 22));
        setBackground(Color.orange);

        GroupLayout upgradesBoxLayout = new GroupLayout(this);
        setLayout(upgradesBoxLayout);
        upgradesBoxLayout.setHorizontalGroup(
            upgradesBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        upgradesBoxLayout.setVerticalGroup(
            upgradesBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

    }
}
