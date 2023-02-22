package helpers;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResizeImage {
    public void getResizeImage() {

    }
    public ResizeImage() {
        try{
            // Scale image on disk
            String imgPath = "";
            File imageFile = new File(imgPath);
            BufferedImage originalImage = ImageIO.read(imageFile);
            int type = originalImage.getType() == 0
                ? BufferedImage.TYPE_INT_ARGB
                : originalImage.getType();

            BufferedImage resizedImageJpg = resizeImage(originalImage, type, 200, 200);
            // ImageIO.write(resizedImageJpg, "jpg", imageFile);

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int type,
                    Integer imgWidth, Integer imgHeight)
    {
        var resizedImage = new BufferedImage(imgWidth, imgHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
        g.dispose();

        return resizedImage;
    }

    public static Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {

        int original_width = imgSize.width;
        int original_height = imgSize.height;
        int bound_width = boundary.width;
        int bound_height = boundary.height;
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width
        if (original_width > bound_width) {
            //scale width to fit
            new_width = bound_width;
            //scale height to maintain aspect ratio
            new_height = (new_width * original_height) / original_width;
        }

        // then check if we need to scale even with the new height
        if (new_height > bound_height) {
            //scale height to fit instead
            new_height = bound_height;
            //scale width to maintain aspect ratio
            new_width = (new_height * original_width) / original_height;
        }

        return new Dimension(new_width, new_height);
    }
}
