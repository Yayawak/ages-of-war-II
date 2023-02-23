package helpers;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.*;

public class ImageData {
    private Image sprite;
    private String relativePath;
    private String fullPath;
    private int imgWidth;
    private int imgHeight;
    private BufferedImage bfImg = null;

    public ImageData(String relativePath,
        int imgWidth, int imgHeight)
    {
        this.relativePath = relativePath;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        init();
    }
    private void init() {
        readImageFromFile(relativePath);
    }

    private void readImageFromFile(String relativePath) {
        String basePath = new File("").getAbsolutePath();
        fullPath = basePath + relativePath;
        // relativePath = "/Users/rio/Desktop/ages-of-war-II/images/backgrounds/aow_bg.png";
        try {
            bfImg = ImageIO.read(new File(fullPath));
            resizeSprite(imgWidth, imgHeight);
        }
        catch (Exception e) { System.out.println(e); }
    }

    public void resizeSprite(int w, int h) {
        if (bfImg != null) {
            sprite = bfImg.getScaledInstance(
                imgWidth, imgHeight, Image.SCALE_FAST);
        }
        else {
            System.out.println("No have bufferedImage");
        }
    }

    public Image getSprite() {
        return sprite;
    }
    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
    public String getPathToImage() {
        return relativePath;
    }
    public void setPathToImage(String relativePath) {
        this.relativePath = relativePath;
        readImageFromFile(relativePath);
    }
}
