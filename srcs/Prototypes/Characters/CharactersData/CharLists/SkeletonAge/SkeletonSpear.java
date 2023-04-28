package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Dimension;
import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonSpear extends CharacterPrototype {
    public SkeletonSpear(TeamType tt) {
        super(tt);
        Dimension size = new Dimension(150, 175);
        ImageData imgData = new ImageData(
                "characters/skeletonAge/skeletonSpear/walk/Walk_00.png", size);
        setName("SkeletonSpear");
        setExperiance(25);
        setGold(40);
        setMaxHp(15);
        setMovementSpeed(1);
        setAttackSpeed(3);
        setImgData(imgData);
        setBuildTime(1);
        setAttackRange(150);
        setAttackDamage(5);
        setWalkSprites(
            SpritesInstallator.getSpritesInFolder( "characters/skeletonAge/skeletonSpear/walk", size)
        );
        setAttackASprites(SpritesInstallator.getSpritesInFolder(
            "characters/skeletonAge/skeletonSpear/attack"

        ));
    }
}
