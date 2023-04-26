package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import helpers.ImageData;

public class BloodSplashEffect extends AbstractEffect {

    public BloodSplashEffect() {
        super();
        // blood effect
        Image effectImage = new ImageData("effects/blood splash/blood_splash_01.png")
            .getSprite();
        // Dimension size = new Dimension(effectImage.getWidth(null),
        //     effectImage.getHeight(null)
        // );

        Dimension size = new Dimension(30, 30);
        setImg(effectImage);
        setSize(size);
        setPreferredSize(size);
        setImgSize(size);
        // this.imgSize = size;
        for (int i = 1; i < 10; i++) {
            // String path = "effects/green hands/green-hand-hell_03.png";
            String prefix = (i < 10) ? "0" : "";
            String path = "effects/blood splash/blood_splash_" +
                prefix +
                String.valueOf(i) +
                ".png";
            // String path =;
            effectFrames.add(
                new ImageData(path).getSprite()
            );
        }
        initAnimation();
    }

}
