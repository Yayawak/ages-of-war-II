package srcs.UI.topBar.unitsBox;
import javax.swing.JPanel;

import srcs.UI.topBar.TopBar;

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
        setBackground(new Color(124, 50, 42));
        setLayout(new GridLayout(1, 0, 20, 10));

        Dimension subUnitPanelDimension = new Dimension(
            // (int)((getWidth() * 0.8f) / numberOfUnits),
            // (int)(getHeight() * 0.8f)
            50, 50
        );
        // System.out.println(subUnitPanelDimension.toString());

        for (int i = 0; i < numberOfUnits; i++) {
            JPanel unitPanel = new JPanel();
            // unitPanel.setPreferredSize(subUnitPanelDimension);
            unitPanel.setPreferredSize(subUnitPanelDimension);
            unitPanel.setBackground(Color.orange);
            unitBoxes.add(unitPanel);
            // add(unitPanel);
        }
        unitBoxes.stream().forEach(panel -> {
            // add(panel);
            // System.out.println(panel.toString());
        });
    }

}
