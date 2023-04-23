package srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge;

import java.awt.Image;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class FireWizard extends CharacterPrototype {

    public FireWizard(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
            // "characters/wizrdAge/fireWizard/fireFire/fireball_00.png"
// /Users/rio/Desktop/ages-of-war-II/images/characters/wizardAge/fireWizard/walk/Walk_00.png
            "characters/wizardAge/fireWizard/walk/Walk_00.png"
        // /characters/wizardAge/fireWizard/walk/Walk_00.png
        );
        setName("FireFire The Wizer");
        setExperiance(50);
        setGold(100);
        setMaxHp(70);
        // setMovementSpeed(4);
        setMovementSpeed(1);
        // setAttackSpeed(1);
        setAttackSpeed(1);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(500);
        // setAttackDamage(50);
        setAttackDamage(20);

        for (int i = 0; i < 5; i++) {
            String formatter =
            String.format(
                "characters/wizardAge/fireWizard/walk/Walk_0%d.png"
                , i
            );
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 8; i++) {
            String formatter =
            String.format(
//ages-of-war-II/images/characters/wizardAge/fireWizard/fireFire/fireball_00.png
                "characters/wizardAge/fireWizard/fireFire/fireball_0%d.png"
                , i
            );
            Image atkImg = new ImageData(formatter).getSprite();
            getAttackASprites().add(atkImg);
        }
    }

}
