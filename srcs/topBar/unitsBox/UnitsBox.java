package srcs.topBar.unitsBox;

import srcs.topBar.TopBar;
import javax.swing.*;

public class UnitsBox {
    public static final JPanel unitsBox = new JPanel();

    public UnitsBox() {
        JLabel bg = new JLabel(new ImageIcon("/Users/ppichyyy/Desktop/ages-of-war-II/images/Main.jpeg"));
        unitsBox.add(bg);
        TopBar.topBar.add(unitsBox);
    }

}
