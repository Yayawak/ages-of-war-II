package srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge;

import srcs.Prototypes.Characters.CharacterPrototype;
import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
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
        // setAttackSpeed(5);
        setAttackSpeed(8);
        setImgData(imgData);
        setBuildTime(1);
        setAttackRange(1000);
        setAttackDamage(14);

        setWalkSprites(SpritesInstallator.getSpritesInFolder("characters/samurai/samuraiArcher/walk/"));
        setAttackASprites(SpritesInstallator.getSpritesInFolder("characters/samurai/samuraiArcher/attack/"));
    }
}
