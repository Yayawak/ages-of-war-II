package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Dimension;
import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonWarrior extends CharacterPrototype {
    public SkeletonWarrior(TeamType tt) {
        super(tt);
        // Dimension size = new Dimension(125, 150);
        Dimension size = new Dimension(75, 100);
        ImageData imgData = new ImageData(
            "characters/skeletonAge/skeletonWarrior/walk/skeletonWalk_0000.png", size);
        setName("SkeletonWarrior");
        setExperiance(25);
        setGold(50);
        setMaxHp(25);
        setMovementSpeed(1);
        setAttackSpeed(2);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(100);
        setAttackDamage(6);

        setWalkSprites(SpritesInstallator.getSpritesInFolder(
            "characters/skeletonAge/skeletonWarrior/walk"
            , size
        ));
        setAttackASprites(
            SpritesInstallator.getSpritesInFolder(
                "characters/skeletonAge/skeletonWarrior/attack"
                , size
            )
        );
    }
}
