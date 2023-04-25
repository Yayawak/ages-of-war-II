package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonWarrior extends CharacterPrototype {
    public SkeletonWarrior(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/skeletonAge/skeletonWarrior/walk/skeletonWalk_0000.png");
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

        for (int i = 0; i < 7; i++) {
            String formatter = String.format(
                    "characters/skeletonAge/skeletonWarrior/walk/skeletonWalk_000%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 4; i++) {
            String formatter = String.format(
                    "characters/skeletonAge/skeletonWarrior/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getWalkSprites().add(atkImg);
        }
    }
}
