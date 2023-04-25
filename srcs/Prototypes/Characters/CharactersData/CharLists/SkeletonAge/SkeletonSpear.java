package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonSpear extends CharacterPrototype {
    public SkeletonSpear(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/skeletonAge/skeletonSpear/walk/Walk_00.png");
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

        for (int i = 0; i < 7; i++) {
            String formatter = String.format(
                    "characters/skeletonAge/skeletonSpear/walk/Walk_0%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 4; i++) {
            String formatter = String.format(
                    "characters/skeletonAge/skeletonSpear/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getWalkSprites().add(atkImg);
        }
    }
}
