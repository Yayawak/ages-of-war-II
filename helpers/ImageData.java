package helpers;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class ImageData {
    private Image sprite;
    private String pathToImage;
    private int imgWidth;
    private int imgHeight;

    public ImageData(String pathToImage,
        int imgWidth, int imgHeight
    ) {
        this.pathToImage = pathToImage;
        this.imgWidth = imgWidth;
        this.imgHeight = imgHeight;
        init();
    }
    private void init() {
        String basePath = new File("").getAbsolutePath();
        String fullPath = basePath + pathToImage;
        try {
            Image img = new ImageIcon(fullPath).getImage();
            img = img.getScaledInstance(
                imgWidth, imgHeight, Image.SCALE_DEFAULT
            );
            sprite = img;
        } catch (Exception e) { System.out.println(e); }
    }

    public Image getSprite() {
        return sprite;
    }
    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
    public String getPathToImage() {
        return pathToImage;
    }
    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }
}
