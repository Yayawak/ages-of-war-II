package srcs.UI.topBar.unitsBox.SubUnit;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import java.awt.*;

public class SubUnit extends JPanel {
    public SubUnit() {
        GroupLayout unitPanelLayout = new GroupLayout(this);
        setLayout(unitPanelLayout);
        unitPanelLayout.setHorizontalGroup(
            unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        unitPanelLayout.setVerticalGroup(
            unitPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Dimension subUnitPanelDimension = new Dimension(
            // (int)((getWidth() * 0.8f) / numberOfUnits),
            // (int)(getHeight() * 0.8f)
            50, 50
        );
        setPreferredSize(subUnitPanelDimension);
        setBackground(Color.yellow);


    }
}
