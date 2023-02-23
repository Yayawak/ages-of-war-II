package srcs.Characters.CharactersData.CharLists;

import helpers.ImageData;
import srcs.Characters.Malee.MaleeUnit;
import srcs.Enums.TeamType;

public class GrimStroke extends MaleeUnit {

    public GrimStroke() {
        ImageData grimImageData = new ImageData(
            "/images/characters/grimStroke.png",
            50, 50
        );
        setCharacterName("grim");
        setExperiance(1);
        setGold(10);
        setHp(15);
        setMovementSpeed(3);
        setAttackSpeed(2);
        setTeam(TeamType.PLAYER);
        setImageData(grimImageData);
    }

    public GrimStroke(String characterName, int experiance, int gold, int hp, int movementSpeed, int attackSpeed,
            TeamType team, ImageData imageData) {
        super(characterName, experiance, gold, hp, movementSpeed, attackSpeed, team, imageData);


    }

}
