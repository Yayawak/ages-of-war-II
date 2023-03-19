

package srcs.Prototypes.Characters.CharactersData.CharLists.FinalFantasyAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Sephiroth extends CharacterPrototype {
    public Sephiroth(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
            "characters/ff7Age/sephiroth/atk/stab/sephiroth_atk_00.png"
// /Users/rio/Desktop/ages-of-war-II/images/characters/ff7Age/sephiroth/atk/stab/sephiroth_atk_00.png
// /Users/rio/Desktop/ages-of-war-II/images/characters/ff7Age/sephiroth/atk/light_fire/fire_03.png
        );
        setName("Sephiroth");
        setExperiance(15);
        setGold(25);
        setMaxHp(200);
        setMovementSpeed(2);
        setAttackSpeed(5);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(100);
        setAttackDamage(15);

        for (int i = 0; i < 10; i++) {
            String formatter =
            String.format(
            "characters/ff7Age/sephiroth/atk/stab/sephiroth_atk_0%d.png"
                , i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 6; i++) {
            String formatter =
            String.format(
            "characters/ff7Age/sephiroth/atk/heavy_fire/fire_0%d.png"
// of-war-II/images/characters/ff7Age/sephiroth/atk/heavy_fire/fire_05.png
                , i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getAttackASprites().add(imgWalk);
        }
        // System.out.println(getWalkSprites());
    }
}
