package srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge;

import java.awt.Image;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class BlackHoodWizard extends CharacterPrototype {

    public BlackHoodWizard(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
                // "characters/wizrdAge/fireWizard/fireFire/fireball_00.png"
                // /Users/rio/Desktop/ages-of-war-II/images/characters/wizardAge/fireWizard/walk/Walk_00.png
                "characters/wizardAge/blackHoodWizard/walk/tile000.png"
        // /characters/wizardAge/fireWizard/walk/Walk_00.png
        );
        setName("Black hood man");
        setExperiance(100);
        setGold(100);
        setMaxHp(200);
        // setMovementSpeed(4);
        setMovementSpeed(1);
        // setMovementSpeed(2);
        // setAttackSpeed(1);
        setAttackSpeed(8);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(600);
        // setAttackDamage(50);
        // setAttackDamage(1);
        setAttackDamage(10);

        for (int i = 0; i < 7; i++) {
            String formatter = String.format(
                "characters/wizardAge/blackHoodWizard/walk/tile00%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 16; i++) {
            // String prefix = i < 10 ? "" : "0";
            String prefix = i < 10 ? "00" : "0";
            // String formatter =
            //         "characters/wizardAge/blackHoodWizard/attack/tile"
            //         + ((i < 10) ? "00" : "0") + String.valueOf(i);

            // String formatter = "characters/wizardAge/blackHoodWizard/attack/tile002.png";
            String formatter = "characters/wizardAge/blackHoodWizard/attack/tile"
                + prefix + String.valueOf(i) + ".png";

                    // , i);
            Image atkImg = new ImageData(formatter).getSprite();
            getAttackASprites().add(atkImg);
        }
    }

}
