package srcs.UI.topBar.unitsBox;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.unitsBox.SubUnit.SubUnit;

import java.awt.*;
import java.util.ArrayList;;

public class UnitsBox extends JPanel {
    private static UnitsBox unitsBox = null;
    private int numberOfUnits = 4;
    private ArrayList<JPanel> unitBoxes = new ArrayList<>();

    private UnitsBox() {
        init();
        TopBar.getInstance().add(this);
    }

    public static UnitsBox getInstance() {
        if (unitsBox == null)
            unitsBox = new UnitsBox();
        return unitsBox;
    }

    private void init() {
        // setBackground(new Color(124, 50, 42));
        setBackground(Color.cyan);
        setLayout(new GridLayout(1, 0, 20, 10));

        // System.out.println(subUnitPanelDimension.toString());

        for (int i = 0; i < numberOfUnits; i++) {
            SubUnit unit = new SubUnit();
            // unitBoxes.add(unit);
            // add(unit);
        }
        unitBoxes.stream().forEach(panel -> {
            // add(panel);
            // System.out.println(panel.toString());
        });
    }

}
