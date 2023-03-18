

package srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class SkeletonWarrior extends CharacterPrototype {
    public SkeletonWarrior(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
            "characters/skeletonAge/skeletonWarrior/walk/skeletonWalk_0000.png"
        );
        setName("Skeleton warrior");
        setExperiance(3);
        setGold(5);
        setMaxHp(50);
        setMovementSpeed(1);
        setAttackSpeed(1);
        // setTeam(TeamType.PLAYER);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(200);
        setAttackDamage(4);

        for (int i = 0; i < 7; i++) {
            String formatter =
                String.format(
            "characters/skeletonAge/skeletonWarrior/walk/skeletonWalk_000%d.png",i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        // System.out.println(getWalkSprites());
    }
}
