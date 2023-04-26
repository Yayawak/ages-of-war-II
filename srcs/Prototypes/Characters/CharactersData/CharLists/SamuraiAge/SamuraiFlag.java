package srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge;

import srcs.Prototypes.Characters.CharacterPrototype;
import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;

public class SamuraiFlag extends CharacterPrototype {
    public SamuraiFlag(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
                "characters/samurai/samuraiFlag/walk/tile001.png");
        setName("SamuraiFlag");
        setExperiance(30);
        setGold(50);
        setMaxHp(800);
        setMovementSpeed(3);
        // setAttackSpeed(1);
        setAttackSpeed(10);
        // setAttackSpeed(20);
        setImgData(imgData);
        setBuildTime(1);
        setAttackRange(150);
        // setAttackDamage(14);
        setAttackDamage(2);

        setWalkSprites(SpritesInstallator.getSpritesInFolder("characters/samurai/samuraiFlag/walk/"));
        setAttackASprites(SpritesInstallator.getSpritesInFolder("characters/samurai/samuraiFlag/attack"));
    }
}
