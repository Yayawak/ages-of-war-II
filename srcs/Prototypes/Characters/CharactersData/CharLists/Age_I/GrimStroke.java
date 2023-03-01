package srcs.Prototypes.Characters.CharactersData.CharLists.Age_I;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class GrimStroke extends CharacterPrototype {

    public GrimStroke(TeamType teamType) {
        super(teamType);
        ImageData grimImageData = new ImageData(
            "characters/grimStroke.png"
        );
        setName("grim");
        setExperiance(1);
        setGold(10);
        setHp(15);
        setMovementSpeed(3);
        setAttackSpeed(2);
        // setTeam(teamType);
        setImgData(grimImageData);
        setBuildTime(1);
    }

}
