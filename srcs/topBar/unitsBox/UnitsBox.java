package srcs.topBar.unitsBox;
import javax.swing.JPanel;

import srcs.topBar.TopBar;

import java.awt.*;;

public class UnitsBox {
    public static final JPanel unitsBox = new JPanel();

    public UnitsBox() {
        unitsBox.setBackground(Color.gray);
        TopBar.topBar.add(unitsBox);
    }

}
