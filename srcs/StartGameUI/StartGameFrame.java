package srcs.StartGameUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import helpers.ImageData;
import srcs.GameUI.MainFrame;

import java.awt.event.*;
import java.awt.*;
// import MainMain;

public class StartGameFrame extends JFrame {
    MainFrame mainFrame;

    public StartGameFrame() {
        setTitle("AOW");
        setPreferredSize(new Dimension(1000, 600));
        setLayout(new BorderLayout());
        init();
    }

    void init() {
        JPanel centerPane = new JPanel();
        JPanel topPane = new JPanel();
        JPanel botPane = new JPanel();
        topPane.setBackground(Color.green);
        centerPane.setBackground(Color.orange);
        botPane.setBackground(Color.blue);

        JPanel startPane = new JPanel();
        startPane.setBackground(Color.PINK);
        JLabel startLabel = new JLabel("START");
        Font font = new Font(Font.SANS_SERIF,
            Font.BOLD, 30);
        startLabel.setFont(font);
        startPane.add(startLabel);

        startPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);

                setVisible(false);
                dispose();
            }
        });



        JPanel exitPane = new JPanel();
        exitPane.setBackground(Color.cyan);
        JLabel exitLabel = new JLabel("EXIT");
        exitLabel.setFont(font);
        exitPane.add(exitLabel);

        Image bgImage = new ImageData("backgrounds/war_bg.jpeg").getSprite();
        exitPane.add(new JLabel(new ImageIcon(bgImage)));

        exitPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                dispose();
            }
        });

        centerPane.setLayout(new GridLayout(0, 1));
        centerPane.add(startPane);
        centerPane.add(exitPane);

        // add(topPane, BorderLayout.NORTH);
        add(centerPane, BorderLayout.CENTER);
        // add(botPane, BorderLayout.SOUTH);
        // repaint();
        pack();
    }

    @Override
    public void paintComponents(Graphics g) {
        // super.paintComponents(g);
        System.out.println("paintocmponent form gameFrame initor");
        // Image bgImage = new ImageData("backgrounds/war_bg.jpeg").getSprite();
        // g.drawImage(bgImage, 0, 0, null);
    }
}
