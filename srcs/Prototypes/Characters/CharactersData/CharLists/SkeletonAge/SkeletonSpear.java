
package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonSpear extends CharacterPrototype {
    public SkeletonSpear(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/skeletonAge/skeletonSpear/walk/Walk_00.png"
        // " II/images/characters/skeletonAge/skeletonSpear/walk/Walk_00.png"
        );
        setName("Skeleton Spearman");
        setExperiance(15);
        setGold(30);
        setMaxHp(30);
        setMovementSpeed(1);
        setAttackSpeed(5);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(400);
        setAttackDamage(5);

        for (int i = 0; i < 7; i++) {
            String formatter = String.format(
                    // "characters/skeletonArcher/walk/Skeleton_Archer_Sprite_0%d.png"
                    "characters/skeletonAge/skeletonSpear/walk/Walk_0%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 4; i++) {
            String formatter = String.format(
                    // "characters/skeletonArcher/walk/Skeleton_Archer_Sprite_0%d.png"
                    "characters/skeletonAge/skeletonSpear/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getWalkSprites().add(atkImg);
        }
    }
}
