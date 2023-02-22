package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import srcs.App;
import srcs.interfaces.ComponentSizeItf;

import java.awt.*;
import java.io.File;

// public class MainGame extends JPanel implements ComponentSizeItf {
public class MainGame implements ComponentSizeItf {
    public static JPanel mainGame = new JPanel();
    public MainGame() {
        mainGame.setBackground(Color.blue);
        mainGame.setOpaque(true);
        // setBackground(Color.blue);
        // setOpaque(true);
        Dimension dim = new Dimension(
            App.mainFrame.getWidth(),
            (int)(App.mainFrame.getHeight() * 0.80f)
        );
        mainGame.setSize(dim); // can prevent error of background unstable setting bg size
        // mainGame.setPreferredSize(dim);
        // setSize(dim); // can prevent error of background unstable setting bg size

        // App.mainFrame.add(this, BorderLayout.CENTER);
        App.mainFrame.add(mainGame, BorderLayout.CENTER);

        // addBg();
        // showComponentSize("MainGame", this);
        showComponentSize("MainGame", mainGame);
    }

    private void addBg() {
        String imagePath = "/images/backgrounds/aow_bg.png";
        // String imagePath = "/images/characterImages/np.png";
        String basePath = new File("").getAbsolutePath();
        String fullImgPath = basePath + imagePath;
        try {
            // Image img = new ImageIcon(fullImgPath).getImage();
            // img = img.getScaledInstance(
            //     // getWidth(), getHeight(), Image.SCALE_DEFAULT);
            //     mainGame.getWidth(), mainGame.getHeight(), Image.SCALE_DEFAULT);
            // JLabel imageLabel = new JLabel(new ImageIcon(img));
            // mainGame.add(imageLabel);
        } catch (Exception e) { System.out.println(e); }


    }
}
