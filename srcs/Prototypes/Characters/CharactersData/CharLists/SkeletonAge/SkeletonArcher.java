package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Dimension;
import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonArcher extends CharacterPrototype {
    public SkeletonArcher(TeamType tt) {
        super(tt);
        Dimension size = new Dimension(75, 100);
        ImageData imgData = new ImageData(
"characters/skeletonAge/skeletonArcher/walk/Skeleton_Archer_Spritelist_00.png", size);
        setName("SkeletonArcher");
        setExperiance(20);
        setGold(60);
        setMaxHp(12);
        setMovementSpeed(1);
        // setAttackSpeed(1);
        setAttackSpeed(7);
        // setAttackSpeed(8);
        // setAttackSpeed(9);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(550);
        setAttackDamage(3);
        // setAttackDamage(2);
        setWalkSprites(SpritesInstallator.getSpritesInFolder(
"characters/skeletonAge/skeletonArcher/walk", size
        ));
        setAttackASprites(SpritesInstallator.getSpritesInFolder(
            "characters/skeletonAge/skeletonArcher/attack", size));
    }
}
