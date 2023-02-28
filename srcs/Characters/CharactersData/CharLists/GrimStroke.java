package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Character;
import srcs.Enums.TeamType;

public class GrimStroke extends Character {

    public GrimStroke() {
        ImageData grimImageData = new ImageData(
            "characters/grimStroke.png"
        );
        setCharacterName("grim");
        setExperiance(1);
        setGold(10);
        setHp(15);
        setMovementSpeed(3);
        setAttackSpeed(2);
        setTeam(TeamType.PLAYER);
        setImageData(grimImageData);
        setBuildTime(1);
    }

}
