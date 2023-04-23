package srcs.StartGameUI;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout.Constraints;

import helpers.ImageData;
import srcs.GameUI.MainFrame;

import java.awt.event.*;
import java.awt.*;
// import MainMain;

public class StartGameFrame extends JFrame {
    MainFrame mainFrame;

    public StartGameFrame() {
        // setTitle("อิอิอิอิ");
        setTitle("Warlorant");
        // setTitle("Hahawar");
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
        // startPane.setBackground(Color.black);
        // startPane.setBackground(Color.white);
        JLabel startLabel = new JLabel("START"
        // Constraints.
        );
        Font font = new Font(
            Font.SANS_SERIF,
            Font.BOLD, 30);
        startLabel.setFont(font);
        // set
        Image startImg = new ImageData("UI/start.png"
        // Image startImg = new ImageData("game covers/japan hometown  1.png"
            // ,1500, 700
            ,1500, 400
            // ,startPane.getWidth(),
            // startPane.getHeight()
        ).getSprite();
        // startLabel.setFont(new );
        Image gameCover = new ImageData(
            "game covers/japan hometown  1.png",
            // getWidth(), getHeight()
            1500, 700
        ).getSprite();
        JLabel coverImageLabel = new JLabel( new ImageIcon(gameCover));
        JLabel startImageUILabel = new JLabel(new ImageIcon(startImg));
        startPane.add(startImageUILabel);
        // startPane.add(startLabel);
        // Graphics gStart = startPane.getGraphics();

        // startPane.addMouseListener(new MouseAdapter() {
        // coverImageLabel.add(startPane);
        // startPane.addMouseListener(new MouseAdapter() {
        // startImageUILabel.addMouseListener(new MouseAdapter() {
        coverImageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);

                setVisible(false);
                dispose();
            }
        });



        // JPanel exitPane = new JPanel();
        // exitPane.setBackground(Color.black);
        // exitPane.setBackground(Color.white);
        JLabel exitLabel = new JLabel("EXIT");
        exitLabel.setFont(font);
        Image exitImg = new ImageData("UI/exit.png"
            // ,1500, 700
            // ,1500, 400
            ,500, 300
            // ,300, 200
            // ,1500, 200
            // ,startPane.getWidth(),
            // startPane.getHeight()
        ).getSprite();
        // startLabel.setFont(new );

        // exitPane.add(new JLabel(new ImageIcon(exitImg)));
        startPane.add(new JLabel(new ImageIcon(exitImg)));
        // exitPane.add(exitLabel);

        // exitPane.add(new JLabel(new ImageIcon(bgImage)));
        // Color c = new Color(0, 0, 0, 0);
        // Color c = new Color(0, 0, 0, 5);
        Color c = Color.black;
        startPane.setBackground(c);
        // exitPane.setBackground(c);

        // exitPane.addMouseListener(new MouseAdapter() {
        exitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                dispose();
            }
        });

        centerPane.setLayout(new GridLayout(0, 1));
        // centerPane.setLayout(null);
        // centerPane.setLayout(new BoxLayout());
        // centerPane.add(startPane);
        // centerPane.add(startLabel);
        // centerPane.setLayout(null);
        // coverImageLabel.add(startImageUILabel);
        // coverImageLabel.setLocation(0, 0);
        centerPane.add(coverImageLabel);
        // centerPane.add(startLabel);
        // centerPane.add(exitPane);

        // add(topPane, BorderLayout.NORTH);
        add(centerPane, BorderLayout.CENTER);
        // add(botPane, BorderLayout.SOUTH);
        pack();
    }

    // ? not called
    // @Override
    // public void paintComponents(Graphics g) {
    //     System.out.println("Enter Start Game Frame : paintComponent");
    //     // super.paintComponents(g);
    //     Image gameCover = new ImageData(
    //         "game covers/japan hometown  1.png",
    //         // getWidth(), getHeight()
    //         1500, 700
    //     ).getSprite();
    //     g.drawImage(gameCover, 0, 0, null);
    // }
}
