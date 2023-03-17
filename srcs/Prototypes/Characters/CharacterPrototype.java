package srcs.Prototypes.Characters;

import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.Prototypes.EntityPrototype;
import helpers.ImageData;
import java.awt.Point;
import java.nio.charset.spi.CharsetProvider;

public class CharacterPrototype extends EntityPrototype {
    private int experiance;
    private int hp;
    private int movementSpeed;
    private int maxHp;

    public CharacterPrototype(EntityPrototype entProt) {
        super(entProt);
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > this.maxHp) {
            hp = this.maxHp;
        }
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
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

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        setHp(maxHp);
    }


    public void decreaseHp(int amount) {
        // int currentHp = cgo.getCharacter().getHp();
        // cgo.getCharacter().setHp(
            // currentHp - amount
        // );
        setHp(getHp() - amount);
    }

    public void increaseHp(int amount) {
        // int currentHp = cgo.getCharacter().getHp();
        // cgo.getCharacter().setHp( currentHp + amount);
        setHp(getHp() + amount);
    }

}
