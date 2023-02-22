package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import srcs.App;
import srcs.interfaces.ComponentSizeItf;

import java.awt.*;
import java.io.File;

public class MainGame extends JPanel implements ComponentSizeItf {
    // public static JPanel mainGame = new JPanel();
    public MainGame() {
        setBackground(Color.blue);
        setOpaque(true);
        Dimension dim = new Dimension(
            App.mainFrame.getWidth(),
            (int)(App.mainFrame.getHeight() * 0.80f)
        );
        setSize(dim); // can prevent error of background unstable setting bg size

        App.mainFrame.add(this, BorderLayout.CENTER);

        addBg();
        showComponentSize("MainGame", this);
    }

    private void addBg() {
        String imagePath = "/images/aow_bg.png";
        String basePath = new File("").getAbsolutePath();
        String fullImgPath = basePath + imagePath;
        try {
            Image img = new ImageIcon(fullImgPath).getImage();

            img = img.getScaledInstance(
                getWidth(), getHeight(), Image.SCALE_DEFAULT);
            JLabel imageLabel = new JLabel(new ImageIcon(img));
            add(imageLabel);
        } catch (Exception e) { System.out.println(e); }


    }
}
