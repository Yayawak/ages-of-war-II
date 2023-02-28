package srcs.Prototypes.Characters;

import srcs.Enums.TeamType;
import srcs.Prototypes.EntityPrototype;
import srcs.UI.MainUI;
import helpers.ImageData;
import java.awt.Point;
import java.nio.charset.spi.CharsetProvider;

public class CharacterPrototype extends EntityPrototype {
    private int experiance;
    private int hp;
    private int movementSpeed;
    // private Point position = new Point(0,0);
    // private Point position = new Point(50, 50);
    // private Point position = new Point(500, 200);
    // private Point position = new Point(999, 200);

    public CharacterPrototype(EntityPrototype entProt) {
        super(entProt);
    }

    public CharacterPrototype(TeamType teamType) {
        super(teamType);
    }

    public int getExperiance() {
        return experiance;
    }

    public void setExperiance(int experiance) {
        this.experiance = experiance;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }


}
