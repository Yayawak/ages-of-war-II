package test;

import javax.swing.*;
import java.awt.event.*;

public class TestTooltip extends JFrame {
    public TestTooltip() {
        // setPreferredSize(500, 500);
        setSize(500, 500);
        JPopupMenu popup = new JPopupMenu("Customized tooltip");

        JPanel pane = new JPanel();
        getContentPane().add(pane);
        // pop
        pane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) { System.out.println(ee);
                }
                popup.setVisible(false);
                popup.setLocation(e.getPoint());
                popup.removeAll();
                System.out.println(e.getPoint());
                popup.add(new JTextField(
                    // String.valueOf(ALLBITS)
                    e.getPoint().toString()
                ));
                // popup.sho

                popup.setVisible(true);
            }
        });

        setVisible(true);
    }
}
