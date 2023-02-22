package srcs.mainGame;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.App;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainGame extends JPanel {
// public class MainGame {
    // public static JPanel mainGame = new JPanel();
    public MainGame() {
        setBackground(Color.blue);
        setOpaque(true);
        // mainGame.setBackground(Color.blue);
        // mainGame.setOpaque(true);
        Dimension dim = new Dimension(
            App.mainFrame.getWidth(),
            (int)(App.mainFrame.getHeight() * 0.80f)
        );
        // mainGame.setSize(dim);
        setPreferredSize(dim);

        // App.mainFrame.add(mainGame, BorderLayout.CENTER);
        App.mainFrame.add(this, BorderLayout.CENTER);
        // App.mainFrame.add(mainGame, 1);
        // App.mainFrame.add(mainGame);

        addBg();
    }

    private void addBg() {
        String imagePath = "/images/aow_bg.png";
        String basePath = new File("").getAbsolutePath();
        String fullImgPath = basePath + imagePath;
        Image img = new ImageIcon(fullImgPath).getImage();

        // img.getScaledInstance(getWidth(), getHeight(),
        //     Image.SCALE_DEFAULT);
        // JLabel imageLabel = new JLabel(
        //     new ImageIcon(fullImgPath)
        // );
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        // Dimension imageSize = new Dimension();
        Dimension imageSize = getSize();
        imageLabel.setSize(imageSize);
        // add(imageLabel);


    }

    private void addBackground(Graphics2D g2d) {
        // String imagePath = "./../../images/bg.jpeg";
        String imagePath = "/images/bg.jpeg";
        BufferedImage image = null;
        try {
            String basePath = new File("").getAbsolutePath();
            System.out.println(basePath);
            image = ImageIO.read(new File(basePath + imagePath));

        } catch (Exception e) {
            System.out.println(e);
        }
        // mainGame.paint
        // mainGame.add(image);
        g2d.drawImage(image, 0, 0, this);
    }

    @Override
    public void paintComponent(Graphics g) {
        // g.drawImage()
        Graphics2D g2d = (Graphics2D)g;
        // addBackground(g2d);
    }
}
