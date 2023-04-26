package srcs.Prototypes.Characters.CharactersData.CharLists;

import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Charlies extends CharacterPrototype {

    public Charlies(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
                // "characters/wizrdAge/fireWizard/fireFire/fireball_00.png"
                // /Users/rio/Desktop/ages-of-war-II/images/characters/wizardAge/fireWizard/walk/Walk_00.png
                "characters/chalies/chalies ninja walks/Charlie-Ninja_walkes_03.png"
                // "characters/chalies/chalies ninja walks/Charlie-Ninja_walkes_03.png"
        // /characters/wizardAge/fireWizard/walk/Walk_00.png
        );
        setName("Charlies");
        setExperiance(50);
        setGold(200);
        setMaxHp(2000);
        // setMovementSpeed(4);
        setMovementSpeed(3);
        // setMovementSpeed(2);
        // setAttackSpeed(1);
        setAttackSpeed(10);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(150);
        // setAttackDamage(50);
        // setAttackDamage(20);
        setAttackDamage(2);

        setWalkSprites(SpritesInstallator.getSpritesInFolder("characters/chalies/chalies ninja walks/"));
        setAttackASprites(SpritesInstallator.getSpritesInFolder("characters/chalies/chalies ninja spin atks"));
    }

}
