package srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge;

import java.awt.Image;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class LightningWitch extends CharacterPrototype {

    public LightningWitch(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
                // "characters/wizrdAge/fireWizard/fireFire/fireball_00.png"
                // /Users/rio/Desktop/ages-of-war-II/images/characters/wizardAge/fireWizard/walk/Walk_00.png
                "characters/wizardAge/lightningWitch/walk/tile000.png"
        // /characters/wizardAge/fireWizard/walk/Walk_00.png
        );
        setName("lighing old witch");
        setExperiance(200);
        setGold(150);
        setMaxHp(150);
        // setMovementSpeed(4);
        setMovementSpeed(1);
        // setMovementSpeed(2);
        // setAttackSpeed(1);
        setAttackSpeed(8);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(300);
        // setAttackDamage(50);
        // setAttackDamage(1);
        setAttackDamage(100);

        for (int i = 0; i < 7; i++) {
            String formatter = String.format(
                "characters/wizardAge/lightningWitch/walk/tile00%d.png", i);
            Image imgWalk = new ImageData(formatter).getSprite();
            getWalkSprites().add(imgWalk);
        }

        for (int i = 0; i < 12; i++) {
            // String prefix = i < 10 ? "" : "0";
            String prefix = i < 10 ? "00" : "0";
            // String formatter =
            //         "characters/wizardAge/blackHoodWizard/attack/tile"
            //         + ((i < 10) ? "00" : "0") + String.valueOf(i);

            // String formatter = "characters/wizardAge/blackHoodWizard/attack/tile002.png";
            String formatter = "characters/wizardAge/lightningWitch/attack/tile"
                + prefix + String.valueOf(i) + ".png";

                    // , i);
            Image atkImg = new ImageData(formatter).getSprite();
            getAttackASprites().add(atkImg);
        }
    }

}
