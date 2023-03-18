

package srcs.Prototypes.Characters.CharactersData.CharLists.FinalFantasyAge;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Cloud extends CharacterPrototype {
    public Cloud(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
            "characters/ff7Age/cloud/walk/walkWithSword_00.png"
// /Users/rio/Desktop/ages-of-war-II/images/characters/ff7Age/sephiroth/atk/stab/sephiroth_atk_00.png
// /Users/rio/Desktop/ages-of-war-II/images/characters/ff7Age/sephiroth/atk/light_fire/fire_03.png
        );
        setName("cloud");
        setExperiance(30);
        setGold(50);
        setMaxHp(150);
        setMovementSpeed(3);
        setAttackSpeed(4);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(150);
        setAttackDamage(25);

        for (int i = 0; i < 3; i++) {
            String formatter =
            String.format(
                "characters/ff7Age/cloud/walk/walkWithSword_0%d.png"
                , i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 6; i++) {
            String formatter =
            String.format(
                "characters/ff7Age/cloud/forwardAtk/hit_0%d.png"
                , i
            );
            Image atkImg = new ImageData(formatter).getSprite();
            getAttackASprites().add(atkImg);
        }
    }
}
