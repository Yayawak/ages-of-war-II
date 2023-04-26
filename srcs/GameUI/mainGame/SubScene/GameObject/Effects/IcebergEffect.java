package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;

public class IcebergEffect extends AbstractEffect {

    // public IcebergEffect(TeamType team) {
    public IcebergEffect() {
        super();
        // blood effect
        Image effectImage = ImageData.getSprite(
            "characters/cyberAge/kula/ice/kula-ice_03.png"
        );
        // Dimension size = new Dimension(effectImage.getWidth(null),
        //     effectImage.getHeight(null)
        // );
        Dimension size = new Dimension(30, 30);
        setImg(effectImage);
        setSize(size);
        setPreferredSize(size);
        setImgSize(size);
        // this.imgSize = size;
        effectFrames = SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/kula/ice");
        initAnimation();
    }

}
