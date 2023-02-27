package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Character;
import srcs.Enums.TeamType;

public class Morphling extends Character {

    public Morphling() {
        ImageData grimImageData = new ImageData(
            "characters/morphling.png"
        );
        setCharacterName("morphling");
        setExperiance(1);
        setGold(10);
        setHp(15);
        setMovementSpeed(3);
        setAttackSpeed(2);
        setTeam(TeamType.PLAYER);
        setImageData(grimImageData);
    }

}
