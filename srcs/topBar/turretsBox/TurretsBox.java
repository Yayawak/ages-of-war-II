package srcs.topBar.turretsBox;

import javax.swing.*;
import srcs.topBar.TopBar;
import java.awt.*;;

public class TurretsBox {
    public static final JPanel turretsBox = new JPanel();

    public TurretsBox() {
        turretsBox.setBackground(Color.LIGHT_GRAY);
        TopBar.topBar.add(turretsBox);
    }
}
