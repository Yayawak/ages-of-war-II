package srcs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;

public class App extends JFrame {
    public App() {
        // setSize(1000, 500);
        // System.out.println(JFrame.MAXIMIZED_BOTH);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        // todo 1: topbar : 15%
        JPanel topBar = new JPanel();
        topBar.setBackground(Color.red);
        add(topBar, BorderLayout.NORTH);

        // todo 2: middle game 80%
        JPanel mainGame = new JPanel();
        mainGame.setBackground(Color.blue);
        add(mainGame, BorderLayout.CENTER);

        // todo 3: lower game 80%
        JPanel lowerBar = new JPanel();
        lowerBar.setBackground(Color.green);
        add(lowerBar, BorderLayout.SOUTH);

        // try
    }
}
