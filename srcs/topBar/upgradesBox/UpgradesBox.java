package srcs.topBar.upgradesBox;
import javax.swing.JPanel;

import srcs.topBar.TopBar;

import java.awt.*;;

public class UpgradesBox {
    public static final JPanel upgradesBox = new JPanel();

    public UpgradesBox() {
        upgradesBox.setBackground(Color.pink);
        TopBar.topBar.add(upgradesBox);
    }

}
