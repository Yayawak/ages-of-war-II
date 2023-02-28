package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Character;
import srcs.Enums.TeamType;

public class NatureProphet extends Character{

    public NatureProphet() {
        ImageData grimImageData = new ImageData(
            "characters/np.png"
        );
        setCharacterName("Nature prophet");
        setExperiance(2);
        setGold(20);
        setHp(35);
        setMovementSpeed(5);
        setAttackSpeed(4);
        setTeam(TeamType.PLAYER);
        setImageData(grimImageData);
    }

    public NatureProphet(String characterName, int experiance, int gold, int hp, int movementSpeed, int attackSpeed,
            TeamType team, ImageData imageData) {
        super(characterName, experiance, gold, hp, movementSpeed, attackSpeed, team, imageData);
    }

}

