package srcs.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.App;
import java.awt.*;

// public class MainGame extends JPanel {
public class MainGame {
    public static JPanel mainGame = new JPanel();
    private String imagePath = "../../images/designed_plan_ui.jpeg";
    public MainGame() {
        mainGame.setBackground(Color.blue);
        mainGame.setOpaque(true);

        // App.mainFrame.add(mainGame, BorderLayout.CENTER);
        // App.mainFrame.add(mainGame, 1);
        App.mainFrame.add(mainGame);
    }
}
