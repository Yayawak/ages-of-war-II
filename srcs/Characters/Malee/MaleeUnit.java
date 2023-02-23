package srcs.Characters.Malee;

import helpers.ImageData;
import srcs.Characters.Character;
import srcs.Enums.TeamType;

public class MaleeUnit extends Character {

    public MaleeUnit() {
    }

    public MaleeUnit(String characterName, int experiance, int gold, int hp, int movementSpeed, int attackSpeed,
            TeamType team, ImageData imageData) {
        super(characterName, experiance, gold, hp, movementSpeed, attackSpeed, team, imageData);
    }


}
