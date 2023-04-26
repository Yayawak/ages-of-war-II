package srcs.Prototypes.Effects;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.Prototypes.EntityPrototype;

public class HandGrapperPrototype extends EntityPrototype {
    public HandGrapperPrototype(TeamType team) {
        // setAttackDamage(200);
        // setAttackDamage(1);
        setAttackDamage(4);
        // setAttackDamage(10);
        setAttackSpeed(10);
        // setAttackSpeed(1);
        // setAttackSpeed(5);
        // setAttackSpeed(20);
        // setAttackSpeed(0.5f);
        // setAttackSpeed(2);
        setImgData(
            new ImageData("effects/green hands/hand-from-ground.png")
        );
        // LinkedList<Image> handGrapperImages = new LinkedList<>();
        List<Image> handGrapperImages = new LinkedList<>();
        handGrapperImages = SpritesInstallator.getSpritesInFolder("effects/green hands");
        setAttackASprites(handGrapperImages);
    }
}
