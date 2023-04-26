package srcs.Prototypes.Characters.CharactersData.CharLists.NinjaAge;

import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Kunoichi extends CharacterPrototype {
    public Kunoichi(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/ninja/ninja3/walk/tile000.png");
        setName("Kunoichi");
        setExperiance(25);
        setGold(50);
        setMaxHp(25);
        setMovementSpeed(1);
        setAttackSpeed(2);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(100);
        setAttackDamage(6);

        for (int i = 0; i < 8; i++) {
            String formatter = String.format(
                    "characters/ninja/ninja3/walk/tile00%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 8; i++) {
            String formatter = String.format(
                    "characters/ninja/ninja3/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getWalkSprites().add(atkImg);
        }
    }
}
