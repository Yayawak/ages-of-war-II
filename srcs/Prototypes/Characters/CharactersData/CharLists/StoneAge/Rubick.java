package srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Rubick extends CharacterPrototype {
    public Rubick(TeamType tt) {
        super(tt);
        ImageData imgData = new ImageData(
            "characters/stoneAge/rubick.png"
        );
        setName("rubick");
        setExperiance(3);
        setGold(40);
        setMaxHp(30);
        setMovementSpeed(2);
        setAttackSpeed(1);
        // setTeam(TeamType.PLAYER);
        setImgData(imgData);
        setBuildTime(2);
        setAttackRange(200);
        setAttackDamage(2);
    }

}
