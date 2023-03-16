package test;
import javax.swing.*;
import java.awt.*;

public class BoxFrame extends JFrame {
    public BoxFrame() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JLabel lb = new JLabel("This is dummy label");
        // add(lb);
        // new Ractangl
        // ! TYpe A
        // JPanel mainPanel = new JPanel();
        // mainPanel.setBackground(Color.blue);
        // mainPanel.setPreferredSize(new Dimension(200, 400));
        // // mainPanel.setBounds(new Rectangle(0,0, 400, 200));
        // // mainPanel
        // add(mainPanel);
        // add(new BPanel());
        add(new APanel());

        pack();
    }
}

class BPanel extends JPanel {
    int row = 6;
    int col = 6;
    // Point point = new Point(0, 0);
    // Dimension size = new Dimension(50, 50);
    int[] pos = {300, 200};
    int[] size = {100, 100};
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                // Rectangle rect = new Rectangle(point, size);
                // g.drawRect(c, c, r, c);
                // g.draw
                Color color;
                if ((r == 0 || r == row)
                    || (c == 0 || c == col)) {
                    color = Color.green;
                } else {
                    color = Color.blue;
                }

                // Color color = ((r + c) % 2 == 0) ? Color.red : Color.black;
                g.setColor(color);
                g.fillRect(pos[0], pos[1], size[0], size[1]);

                pos[1] = size[1] * c;
            }
            pos[0] = size[0] * r;
        }
    }
}

//! Type B
class APanel extends JPanel {

    public APanel() {
        add(new SubA());
    }

    class SubA extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.green);
            g.fillRect(xPos, 0,50, 100);
            repaint();
        }
    }
    private int xPos = 55;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.red);

        if (xPos < getWidth()) {
            xPos += 1;
        } else {
            xPos = 0;
        }
        g.fillRect(xPos, 0, 100, 200);
        repaint();
    }
}
