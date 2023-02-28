package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Character;
import srcs.Enums.TeamType;

public class Rubick extends Character {
    public Rubick() {
        ImageData imgData = new ImageData(
            "characters/rubick.png"
        );
        setCharacterName("rubick");
        setExperiance(3);
        setGold(40);
        setHp(30);
        setMovementSpeed(2);
        setAttackSpeed(1);
        setTeam(TeamType.PLAYER);
        setImageData(imgData);
        setBuildTime(2);
    }

}
