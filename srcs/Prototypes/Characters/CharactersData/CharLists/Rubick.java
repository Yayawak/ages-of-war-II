package srcs.Prototypes.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Rubick extends CharacterPrototype {
    public Rubick(TeamType teamType) {
        super(teamType);
        ImageData imgData = new ImageData(
            "characters/rubick.png"
        );
        setName("rubick");
        setExperiance(3);
        setGold(40);
        setHp(30);
        setMovementSpeed(2);
        setAttackSpeed(1);
        // setTeam(TeamType.PLAYER);
        setImgData(imgData);
        setBuildTime(2);
    }

}
