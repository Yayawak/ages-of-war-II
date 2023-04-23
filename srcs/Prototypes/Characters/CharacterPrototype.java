package srcs.Prototypes.Characters;

import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.Prototypes.EntityPrototype;
import helpers.ImageData;
import java.awt.Point;
import java.nio.charset.spi.CharsetProvider;

public class CharacterPrototype extends EntityPrototype {
    private int experiance;
    private int movementSpeed;

    public CharacterPrototype(EntityPrototype entProt) {
        super(entProt);
        // this.attacker
        // hp = maxHp;
        // maxHp = hp;
    }

    public CharacterPrototype(TeamType teamType) {
        super(teamType);
        // System.out.println("Max hp init = " + maxHp);
        // hp = maxHp;
        // maxHp = hp;
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }


    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getMaxHp() {
        return maxHp;
    }

}
