package srcs;

import javax.swing.JFrame;

import srcs.lowerBar.LowerBar;
import srcs.mainGame.MainGame;
import srcs.topBar.TopBar;

import java.awt.*;

// public class App extends JFrame {
public class App {
    public static JFrame mainFrame;

    public App() {
        mainFrame = new JFrame();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // mainFrame.setUndecorated(true);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("W & H of App is :");
        System.out.println(mainFrame.getSize().getWidth());
        System.out.println(mainFrame.getSize().getHeight());

        mainFrame.setLayout(new BorderLayout());
        // mainFrame.setLayout(new FlowLayout());
        // mainFrame.setLayout(new GridLayout(3,0));
        // todo 1: topbar : 15%
        // topbar is here
        new TopBar();

        // todo 2: middle game 80%
        new MainGame();

        // todo 3: lower game 80%
        new LowerBar();

        // mainFrame.pack();

    }
}
