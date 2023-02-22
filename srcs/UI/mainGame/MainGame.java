package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import srcs.MainUI;
import srcs.interfaces.ComponentSizeItf;

import java.awt.*;
import java.io.File;
import javax.swing.GroupLayout;
import helpers.ImageData;

public class MainGame implements ComponentSizeItf {
    public static JPanel mainGame = new JPanel();
    public MainGame() {
        init();
    }

    private void init() {
        mainGame.setBackground(new Color(242, 42, 242));
        mainGame.setForeground(new Color(100, 0, 0));
        mainGame.setPreferredSize(new Dimension(625, 400));

        GroupLayout mainGameLayout = new GroupLayout(mainGame);
        mainGame.setLayout(mainGameLayout);
        mainGameLayout.setHorizontalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        mainGameLayout.setVerticalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        addBg();
        showComponentSize("MainGame", mainGame);
    }

    private void addBg() {
        String imagePath = "/images/backgrounds/aow_bg.png";
        // String imagePath = "/images/characterImages/np.png";

        ImageData imgData = new ImageData(imagePath, 500, 500);
        JLabel imageLabel = new JLabel(new ImageIcon(imgData.getSprite()));
        mainGame.add(imageLabel);

    }
}
