package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import srcs.MainUI;
import srcs.interfaces.ComponentSizeItf;
import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import helpers.ImageData;
import java.awt.image.*;

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
        // showComponentSize("MainGame", this);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBg(g);
    }

    public void drawBg(Graphics g) {
        String imagePath = "/images/backgrounds/aow_bg.png";
        // Image img = new ImageData(imagePath,
        ImageData imgData = new ImageData(imagePath,
            getWidth(),
            getHeight()
        );
        // System.out.println(imgData.getPathToImage());
        Image sprite = imgData.getSprite();
        g.drawImage(sprite, 0, 0, this);

    }
}
