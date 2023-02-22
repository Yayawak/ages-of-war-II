package srcs.UI.topBar.unitsBox;
import javax.management.openmbean.OpenMBeanConstructorInfo;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import srcs.App;
import srcs.UI.mainGame.MainGame;
import srcs.UI.topBar.TopBar;

import java.awt.*;
import java.util.ArrayList;;

public class UnitsBox extends JPanel {
    // public static final JPanel unitsBox = new JPanel();
    private int numberOfUnits = 4;
    private ArrayList<JPanel> unitBoxes = new ArrayList<>();

    public UnitsBox() {
        setBackground(Color.PINK);
        // setPreferredSize(getPreferredSize());
        // setSize(getPreferredSize());
        // setSize(getSize());
        TopBar.topBar.add(this);
        init();
    }

    private void init() {
        // setLayout(new FlowLayout(FlowLayout.LEFT));
        // setLayout(new CardLayout());
        // setLayout(null);
        // setLayout(new BoxLayout(this, 1));
        // setLayout(new BoxLayout(this, 0));
        // System.out.println(getWidth());
        System.out.println(getWidth());
        System.out.println(getHeight());

        Dimension subUnitPanelDimension = new Dimension(
            // (int)((getWidth() * 0.8f) / numberOfUnits),
            // (int)(getHeight() * 0.8f)
            100, 50
        );
        // System.out.println(subUnitPanelDimension.toString());

        for (int i = 0; i < numberOfUnits; i++) {
            JPanel unitPanel = new JPanel();
            // unitPanel.setPreferredSize(subUnitPanelDimension);
            unitPanel.setSize(subUnitPanelDimension);
            unitPanel.setBackground(Color.orange);
            unitBoxes.add(unitPanel);
            // add(unitPanel);
        }
        unitBoxes.stream().forEach(panel -> {
            add(panel);
        });
    }

}
