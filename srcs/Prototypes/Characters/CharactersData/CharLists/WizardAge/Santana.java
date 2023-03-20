package srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Santana extends CharacterPrototype {

    public Santana(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
            // "characters/stoneAge/grimStroke.png"
            "characters/stoneAge/santa.png"
            // "characters/stoneAge/meme_1.jpeg"
            // "characters/stoneAge/santaKid.JPG"
            , 200, 200
            // ,400,400
        );
        setName("Santa");
        setExperiance(1);
        setGold(10);
        // setMaxHp(1000);
        setMaxHp(200);
        setMovementSpeed(3);
        setAttackSpeed(3);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(1);
        setAttackRange(300);
        // setAttackDamage(10);
        setAttackDamage(1);
    }

}
