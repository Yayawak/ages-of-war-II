package test;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class TestFrame extends JFrame {
    public TestFrame() {
        setVisible(true);
        setSize(new Dimension(1000, 300));
        setBackground(Color.red);
        // setPreferredSize(new Dimension(1000, 300));
        setVisible(true);

        JPanel pan = new JPanel();
        pan.setBackground(Color.green);
        add(pan);
    }
}
