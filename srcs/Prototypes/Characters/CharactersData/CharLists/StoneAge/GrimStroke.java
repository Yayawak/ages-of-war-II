package srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class GrimStroke extends CharacterPrototype {

    public GrimStroke() {
        super();
        ImageData grimImageData = new ImageData(
            "characters/grimStroke.png"
        );
        setName("grim");
        setExperiance(1);
        setGold(10);
        setMaxHp(20);
        setMovementSpeed(3);
        setAttackSpeed(2);
        // setTeam(teamType);
        setImgData(grimImageData);
        setBuildTime(1);
        setAttackRange(300);
        setAttackDamage(10);
    }

}
