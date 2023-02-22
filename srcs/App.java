package srcs;

import javax.swing.JFrame;

import srcs.interfaces.ComponentSizeItf;
import srcs.UI.lowerBar.LowerBar;
import srcs.UI.mainGame.MainGame;
import srcs.UI.topBar.TopBar;

import java.awt.*;

// public class App extends JFrame {
public class App implements ComponentSizeItf {
    public static JFrame mainFrame;

    public App(){
        mainFrame = new JFrame();
        // mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setSize(new Dimension(1440, 1300));
        // mainFrame.setSize(new Dimension(1240, 900));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showComponentSize("App", mainFrame);
        // System.out.format("W & H of App is : %.0f, %.0f\n",
        //     mainFrame.getSize().getWidth(),
        //     mainFrame.getSize().getHeight()
        // );

        mainFrame.setLayout(new BorderLayout());

        // todo 1: topbar : 15%
        new TopBar();

        // todo 2: middle game 80%
        new MainGame();

        // todo 3: lower game 5%
        new LowerBar();

        mainFrame.pack();

    }
}
