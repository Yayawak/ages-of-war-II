package srcs.Prototypes.Characters.CharactersData.CharLists.NinjaAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class NinjaMonk extends CharacterPrototype {
    public NinjaMonk(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/ninja/ninja2/walk/tile003.png");
        setName("NinjaMonk");
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
                    "characters/ninja/ninja2/walk/tile00%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 5; i++) {
            String formatter = String.format(
                    "characters/ninja/ninja2/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getWalkSprites().add(atkImg);
        }
    }
}
