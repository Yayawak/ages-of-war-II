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

public class MainGame extends JPanel implements ComponentSizeItf {
    private static MainGame instance = null;

    public static MainGame getInstance() {
        if (instance == null)
            instance = new MainGame();
        return instance;
    }

    private MainGame() {
        init();
    }

    private void init() {
        setBackground(new Color(242, 42, 242));
        setForeground(new Color(100, 0, 0));
        setPreferredSize(new Dimension(625, 400));

        GroupLayout mainGameLayout = new GroupLayout(this);
        setLayout(mainGameLayout);
        mainGameLayout.setHorizontalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        mainGameLayout.setVerticalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        addBg();
        showComponentSize("MainGame", this);
    }

    private void addBg() {
        String imagePath = "/images/backgrounds/aow_bg.png";
        // String imagePath = "/images/characterImages/np.png";

        ImageData imgData = new ImageData(imagePath, 500, 500);
        JLabel imageLabel = new JLabel(new ImageIcon(imgData.getSprite()));
        add(imageLabel);

    }
}
