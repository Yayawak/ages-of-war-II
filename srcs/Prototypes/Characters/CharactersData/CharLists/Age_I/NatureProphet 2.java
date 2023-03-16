package srcs.Prototypes.Characters.CharactersData.CharLists.Age_I;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class NatureProphet extends CharacterPrototype{

    public NatureProphet(TeamType teamType) {
        super(teamType);
        ImageData grimImageData = new ImageData(
            "characters/np.png"
        );
        setName("Nature prophet");
        setExperiance(2);
        setGold(20);
        setMaxHp(35);
        setMovementSpeed(5);
        setAttackSpeed(4);
        // setTeam(TeamType.PLAYER);
        setImgData(grimImageData);
        setBuildTime(4);
        setAttackRange(150);
        setAttackDamage(5);
    }

    // public NatureProphet(String characterName, int experiance, int gold, int hp, int movementSpeed, int attackSpeed,
    //         TeamType team, ImageData imageData, float buildTime) {
    //     super(characterName, experiance, gold, hp, movementSpeed
    //     , attackSpeed, team, imageData, buildTime);
    // }

}

