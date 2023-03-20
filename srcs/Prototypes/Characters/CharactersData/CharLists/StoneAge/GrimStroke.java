package srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class GrimStroke extends CharacterPrototype {

    public GrimStroke(TeamType tt) {
        super(tt);
        ImageData grimImageData = new ImageData(
            "characters/stoneAge/grimStroke.png"
            // "characters/stoneAge/santa.png"
            // "characters/stoneAge/meme_1.jpeg"
            // "characters/stoneAge/santaKid.JPG"
            // , 200, 200
            // ,400,400
        );
        setName("grim");
        setExperiance(1);
        setGold(10);
        setMaxHp(30);
        setMovementSpeed(3);
        setAttackSpeed(3);
        // setTeam(teamType);
        setImgData(grimImageData);
        setBuildTime(1);
        setAttackRange(300);
        setAttackDamage(10);
        // setAttackDamage(1);
    }

}
