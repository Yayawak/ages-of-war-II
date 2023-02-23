package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Malee.MaleeUnit;
import srcs.Enums.TeamType;

public class NatureProphet extends MaleeUnit {

    public NatureProphet() {
        ImageData grimImageData = new ImageData(
            "/images/characters/np.png",
            50, 50
        );
        setCharacterName("Nature prophet");
        setExperiance(2);
        setGold(20);
        setHp(35);
        setMovementSpeed(3);
        setAttackSpeed(4);
        setTeam(TeamType.PLAYER);
        setImageData(grimImageData);
    }

    public NatureProphet(String characterName, int experiance, int gold, int hp, int movementSpeed, int attackSpeed,
            TeamType team, ImageData imageData) {
        super(characterName, experiance, gold, hp, movementSpeed, attackSpeed, team, imageData);
    }

}

