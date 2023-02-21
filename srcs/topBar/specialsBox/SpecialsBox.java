package srcs.topBar.specialsBox;

import javax.swing.JPanel;
import srcs.topBar.TopBar;
import java.awt.*;;

public class SpecialsBox {
    public static final JPanel specialsBox = new JPanel();

    public SpecialsBox() {
        specialsBox.setBackground(Color.CYAN);
        TopBar.topBar.add(specialsBox);
    }
}
