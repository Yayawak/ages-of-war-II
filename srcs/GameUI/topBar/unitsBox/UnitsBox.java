package srcs.GameUI.topBar.unitsBox;
import javax.swing.JPanel;

import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.unitsBox.SubUnit.SubUnit;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Systems.AgeSystem.AgeData;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.util.ArrayList;;

public class UnitsBox extends JPanel {
    private static UnitsBox instance = null;
    private int numberOfUnits = 4;
    private static ArrayList<SubUnit> unitBoxes = new ArrayList<>();
    // private static ArrayList<JPanel> unitBoxes = new ArrayList<>();

    private UnitsBox() {
        init();
        // TopBar.getInstance().add(this);
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
                // CharacterPrototype character = SkeletonAge.getInstance().
                    // getCharacterPrototypes().get(i);
                CharacterPrototype character = IntegratedSystem.getInstance()
                    .getCurrentAgeData().getCharacterPrototypes().get(i);
                SubUnit unit = new SubUnit(character);
                unitBoxes.add(unit);

            } catch (Exception e) { System.out.println(e); }
        }
        unitBoxes.stream().forEach(panel -> {
            add(panel);
        });

    }

    private void updateUnitsPanel() {
        for (int i = 0; i < unitBoxes.size(); i++) {
            // unitBoxes.set
        }
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public static ArrayList<SubUnit> getUnitBoxes() {
        return unitBoxes;
    }

    public static void setUnitBoxes(ArrayList<SubUnit> unitBoxes) {
        UnitsBox.unitBoxes = unitBoxes;
    }


}
