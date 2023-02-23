package helpers;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.image.*;

public class ImageData {
    private Image sprite;
    private String relativePath;
    private String fullPath;
    private int imgWidth;
    private int imgHeight;
    private BufferedImage bfImg = null;

    public ImageData(String relativePath,
        int imgWidth, int imgHeight) {
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

    public String getRelativePath() {
        return relativePath;
    }
    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
    public String getFullPath() {
        return fullPath;
    }
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
    public int getImgWidth() {
        return imgWidth;
    }
    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }
    public int getImgHeight() {
        return imgHeight;
    }
    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }
}
