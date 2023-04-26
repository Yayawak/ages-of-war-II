package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonArcher extends CharacterPrototype {
    public SkeletonArcher(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/skeletonAge/skeletonArcher/walk/Skeleton_Archer_Spritelist_00.png");
        setName("SkeletonArcher");
        setExperiance(20);
        setGold(60);
        setMaxHp(12);
        setMovementSpeed(1);
        setAttackSpeed(1);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(300);
        setAttackDamage(3);

        for (int i = 0; i < 7; i++) {
            String formatter = String
                    .format("characters/skeletonAge/skeletonArcher/walk/Skeleton_Archer_Spritelist_0%d.png", i);
            // Image imgWalk = new ImageData(formatter, widthOfImage,
            // heightOfImage).getSprite();
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 15; i++) {
            String prefix = (i < 10) ? "00" : "0";
            String formatter = String.format("characters/skeletonAge/skeletonArcher/attack/tile" + prefix + "%d.png",
                    i);
            Image atkImg = new ImageData(formatter).getSprite();
            // Image atkImg = new ImageData(formatter, widthOfImage,
            // heightOfImage).getSprite();
            getAttackASprites().add(atkImg);
        }
    }
}