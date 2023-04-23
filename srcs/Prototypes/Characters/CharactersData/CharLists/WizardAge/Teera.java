package srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Teera extends CharacterPrototype {

    public Teera(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
            // "characters/stoneAge/grimStroke.png"
            "characters/wizardAge/Teera.JPG"
            // "characters/stoneAge/meme_1.jpeg"
            // "characters/stoneAge/santaKid.JPG"
            , 200, 200
            // ,400,400
        );
        setName("Teera");
        setExperiance(1);
        setGold(150);
        // setMaxHp(300);
        setMaxHp(100);
        setMovementSpeed(3);
        setAttackSpeed(3);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(300);
        // setAttackDamage(10);
        setAttackDamage(10);
    }

}
