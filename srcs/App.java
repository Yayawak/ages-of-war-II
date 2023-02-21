package srcs;

import javax.swing.JFrame;
import javax.swing.JPanel;

import srcs.mainGame.MainGame;
import srcs.topBar.TopBar;

import java.awt.*;

// public class App extends JFrame {
public class App {
    public static JFrame mainFrame;
    public App() {
        mainFrame = new JFrame();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // mainFrame.setLayout(new BorderLayout());
        mainFrame.setLayout(new GridLayout(3,0));
        // todo 1: topbar : 15%
        // topbar is here
        new TopBar();

        // todo 2: middle game 80%
        new MainGame();

        // todo 3: lower game 80%
        JPanel lowerBar = new JPanel();
        lowerBar.setBackground(Color.green);
        // mainFrame.add(lowerBar, BorderLayout.SOUTH);
        // mainFrame.add(lowerBar, 1);
        mainFrame.add(lowerBar);

    }
}
