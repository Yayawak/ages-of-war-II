

package srcs.Prototypes.Characters.CharactersData.CharLists.FinalFantasyAge;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Sephiroth extends CharacterPrototype {
    public Sephiroth(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
            "characters/skeletonAge/skeletonArcher/walk/Skeleton_Archer_Spritelist_00.png"
        );
        // /Users/rio/Desktop/ages-of-war-II/images/characters/skeletonArcher/walk/Skeleton_Archer_Spritelist_00.png
        setName("Sephiroth");
        setExperiance(15);
        setGold(30);
        setMaxHp(10);
        setMovementSpeed(3);
        setAttackSpeed(1);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(600);
        setAttackDamage(8);

        for (int i = 0; i < 7; i++) {
            String formatter =
            String.format(
            // "characters/skeletonArcher/walk/Skeleton_Archer_Sprite_0%d.png"
            "characters/skeletonAge/skeletonArcher/walk/Skeleton_Archer_Spritelist_0%d.png"
                , i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        System.out.println(getWalkSprites());
    }
}
