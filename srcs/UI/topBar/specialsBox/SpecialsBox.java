package srcs.UI.topBar.specialsBox;

import java.awt.Color;

import javax.swing.JPanel;

import srcs.UI.topBar.TopBar;;

public class SpecialsBox {
    public static final JPanel specialsBox = new JPanel();

    public SpecialsBox() {
        specialsBox.setBackground(Color.CYAN);
        TopBar.topBar.add(specialsBox);
    }
}
