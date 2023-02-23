package srcs.UI.topBar.unitsBox;
import javax.swing.JPanel;
import srcs.Characters.CharactersData.CharactersData;
import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.unitsBox.SubUnit.SubUnit;
import java.awt.*;
import java.util.ArrayList;;

public class UnitsBox extends JPanel {
    private static UnitsBox instance = null;
    private int numberOfUnits = 4;
    private static ArrayList<JPanel> unitBoxes = new ArrayList<>();

    private UnitsBox() {
        init();
        TopBar.getInstance().add(this);
    }

    public static UnitsBox getInstance() {
        if (instance == null)
            instance = new UnitsBox();
        return instance;
    }

    private void init() {
        // setBackground(new Color(124, 50, 42));
        setBackground(Color.cyan);
        setLayout(new GridLayout(1, 0, 20, 10));

        // System.out.println(subUnitPanelDimension.toString());

        for (int i = 0; i < numberOfUnits; i++) {
            try {
                Image img = CharactersData.getInstance()
                    .getCharactersList().get(i % 2).getImageData()
                    .getSprite();
                SubUnit unit = new SubUnit();
                unit.setImg(img);
                unitBoxes.add(unit);

            } catch (Exception e) { System.out.println(e); }
        }
        unitBoxes.stream().forEach(panel -> {
            add(panel);
        });

    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public static ArrayList<JPanel> getUnitBoxes() {
        return unitBoxes;
    }

    public static void setUnitBoxes(ArrayList<JPanel> unitBoxes) {
        UnitsBox.unitBoxes = unitBoxes;
    }


}
