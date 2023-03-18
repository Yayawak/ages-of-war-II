package srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Morphling extends CharacterPrototype {

    public Morphling(TeamType tt) {
        super(tt);
        ImageData grimImageData = new ImageData(
            "characters/stoneAge/morphling.png"
        );
        setName("morphling");
        setExperiance(1);
        setGold(10);
        setMaxHp(25);
        // setHp(getMaxHp());
        // System.out.println("max hp morph : " + getMaxHp());
        setMovementSpeed(5);
        setAttackSpeed(2);
        // setTeam(TeamType.PLAYER);
        setImgData(grimImageData);
        setBuildTime(3);
        setAttackRange(100);
        setAttackDamage(8);
    }

}
