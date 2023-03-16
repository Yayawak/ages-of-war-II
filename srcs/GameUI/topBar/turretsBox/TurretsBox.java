package srcs.GameUI.topBar.turretsBox;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.turretsBox.SubTurret.SubTurret;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretsData;

import java.awt.*;
import java.util.ArrayList;;

public class TurretsBox extends JPanel {
    private static TurretsBox instance = null;
    private int numberOfTurrets = 2;
    private ArrayList<SubTurret> subTurretBoxes = new ArrayList<>();

    private TurretsBox() {
        initLayout();
        initTurrets();
        // TopBar.getInstance().add(this);
    }

    public static TurretsBox getInstance() {
        if (instance == null) {
            instance = new TurretsBox();
        }
        return instance;
    }

    private void initLayout() {
        setBackground(new Color(22, 100, 242));
        setLayout(new GridLayout(1, 0, 20, 10));
    }

    private void initTurrets() {
        for (int i = 0; i < numberOfTurrets; i++) {
            // String relPath = "turrets/chinese_canon.png";
            TurretPrototype turretPrototype = TurretsData.getInstance()
                    .getAvailableTurrents().get(i);

            // System.out.println(turretPrototype.getImgData().getFullPath());
            // System.out.println(turretPrototype.getName());
            SubTurret subTurret = new SubTurret(turretPrototype);
            subTurretBoxes.add(subTurret);
        }
        subTurretBoxes.stream().forEach(st -> {
            add(st);
        });
    }
}
