package srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge;

import srcs.Prototypes.Characters.CharacterPrototype;
import java.awt.Image;
import helpers.ImageData;
import srcs.Enums.TeamType;

public class SamuraiArcher extends CharacterPrototype {
    public SamuraiArcher(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/samurai/samuraiArcher/walk/tile001.png");
        setName("SamuraiArcher");
        setExperiance(30);
        setGold(50);
        setMaxHp(800);
        setMovementSpeed(3);
        setAttackSpeed(1);
        setImgData(imgData);
        setBuildTime(1);
        setAttackRange(150);
        setAttackDamage(14);

        for (int i = 0; i < 8; i++) {
            String formatter = String.format(
                    "characters/samurai/samuraiArcher/walk/tile00%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }
        for (int i = 0; i < 5; i++) {
            String formatter = String.format("characters/samurai/samuraiArcher/attack/tile00%d.png", i);
            Image atkImg = new ImageData(formatter).getSprite();
            getAttackASprites().add(atkImg);
        }
    }
}
