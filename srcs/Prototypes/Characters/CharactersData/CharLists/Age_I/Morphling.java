package srcs.Prototypes.Characters.CharactersData.CharLists.Age_I;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Morphling extends CharacterPrototype {

    public Morphling(TeamType teamType) {
        super(teamType);
        ImageData grimImageData = new ImageData(
            "characters/morphling.png"
        );
        setName("morphling");
        setExperiance(1);
        setGold(10);
        setMaxHp(25);
        // setHp(getMaxHp());
        // System.out.println("max hp morph : " + getMaxHp());
        setMovementSpeed(3);
        setAttackSpeed(2);
        // setTeam(TeamType.PLAYER);
        setImgData(grimImageData);
        setBuildTime(3);
        setAttackRange(100);
        setAttackDamage(8);
    }

}
