package srcs.GameUI;

import javax.swing.*;

import srcs.GameUI.mainGame.MainGame;

import java.awt.*;


public class MainFrame extends JFrame {
    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("Warapex");
        // setResizable(false);
        // setLocationRelativeTo(null); //center

        // setPreferredSize(new Dimension(1400, 850));
        setPreferredSize(new Dimension(1400, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setSize(new Dimension(1400, 850));
        MainUI.getInstance();
        add(MainUI.getInstance());
        pack();

    }
}
