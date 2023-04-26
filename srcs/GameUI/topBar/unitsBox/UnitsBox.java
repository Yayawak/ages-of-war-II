package srcs.GameUI.topBar.unitsBox;
import javax.swing.JPanel;

import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.unitsBox.SubUnit.SubUnit;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Systems.AgeSystem.AgeData;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import srcs.Systems.Tooltips.CharacterTooltip;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.util.ArrayList;;

public class UnitsBox extends JPanel {
    private static UnitsBox instance = null;
    private int numberOfUnits = IntegratedSystem.getInstance().getCurrentPlayerAgeData()
        .getCharacterPrototypes().size();
    // private static ArrayList<SubUnit> unitBoxes = new ArrayList<>();
    private ArrayList<SubUnit> unitBoxes = new ArrayList<>();

    private UnitsBox() {
        init();
    }

    public static UnitsBox getInstance() {
        if (instance == null)
            instance = new UnitsBox();
        return instance;
    }

    private void init() {
        // setBackground(new Color(124, 50, 42));
        // setBackground(Color.cyan);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new GridLayout(1, 0, 20, 10));

        // System.out.println(subUnitPanelDimension.toString());

        for (int i = 0; i < numberOfUnits; i++) {
            try {
                // CharacterPrototype character = SkeletonAge.getInstance().
                    // getCharacterPrototypes().get(i);
                CharacterPrototype character = IntegratedSystem.getInstance()
                    .getCurrentPlayerAgeData().getCharacterPrototypes().get(i);
                SubUnit unit = new SubUnit(character);
                System.out.println("i = " + i);
                unitBoxes.add(unit);

            } catch (Exception e) {
                System.out.println("problem fetching character i = " + i);
                // System.out.println(e);
            }
        }
        unitBoxes.stream().forEach(panel -> {
            add(panel);
        });
        System.out.println("# panels : " + unitBoxes.size());

    }

    public void updateUnitsPanel() {
        // for (int i = 0; i < unitBoxes.size(); i++) {
        setNumberOfUnits(IntegratedSystem.getInstance().getCurrentPlayerAgeData().getCharacterPrototypes().size());
        for (int i = 0; i < numberOfUnits; i++) {
            unitBoxes.get(i).setCharacter(
                IntegratedSystem.getInstance().getCurrentPlayerAgeData()
                .getCharacterPrototypes().get(i)
            );
            unitBoxes.get(i).setCharacterTooltip(
                new CharacterTooltip(unitBoxes.get(i).getCharacter())
            );
        }
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    // public static ArrayList<SubUnit> getUnitBoxes() {
    //     return unitBoxes;
    // }

    // public static void setUnitBoxes(ArrayList<SubUnit> unitBoxes) {
    //     UnitsBox.unitBoxes = unitBoxes;
    // }


}
