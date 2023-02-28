package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.*;

import srcs.Enums.Direction;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.*;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.UI.MainUI;
import srcs.UI.mainGame.MainGame;

public class CharacterGObject extends GameObject {

    private CharacterPrototype character;
    private Point position;
    public CharacterGObject(CharacterPrototype character) {
        super(character.getImgData().getSprite(),
            new Point(
                (int)character.getPosition().getX(),
                (int)character.getPosition().getY()
            ),
            new Dimension(
                character.getImgData().getImgWidth(),
                character.getImgData().getImgHeight()
            )
        );
        this.character = character;
        this.position = character.getPosition();
    }

    @Override
    // ? check logic
    public void update() {
        //? reset collsion : make character movable again
        System.out.println("Enter update function");
        isCollide = false;
        for (GameObject go : MainGame.getObjectsInScene()) {
            // * Collide = ชน = Collsion
            if (isCollideWith((CharacterGObject)go)) {
                isCollide = true;
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        if (!isCollide) {
            switch (character.getTeamType()) {
                case PLAYER:
                    move(Direction.RIGHT);
                    break;
                case ENEMY:
                    move(Direction.LEFT);
                    break;
                default:
                    break;
            }
        //* stand still
        }else {
            // move(Direction.LEFT);
        }

        int screenWidth = MainUI.getInstance().getScreenSize().width;
        if (getX() > screenWidth) {
            IntegratedSystem.getInstance().getPlayerGoldSystem()
                .increasedGold(character.getGold());
            IntegratedSystem.getInstance().getPlayerExpSystem()
                .increasedExperience(character.getExperiance());

            // todo : add exp to team
            destroyGameObject();
            // isCollide = true;
        }
    }

    private void move(Direction dir) {
        int mul = 6;
        switch (dir) {
            case RIGHT:
                setLocation(getX() +
                    character.getMovementSpeed() * mul,
                    character.getPosition().y);
                break;

            case LEFT:
                setLocation(getX() -
                    character.getMovementSpeed() * mul,
                    character.getPosition().y);
                break;

            default:
                break;
        }
    }

    public CharacterPrototype getCharacter() {
        return character;
    }

    public void setCharacter(CharacterPrototype character) {
        this.character = character;
    }

    public Point getPosition() {
        return position;
    }

    public CharacterGObject copy() {
        return new CharacterGObject(new CharacterPrototype(character));
        // return new CharacterGObject(character);
    }

    public boolean isCollideWith(CharacterGObject cgo) {
        // System.out.println("W = " + this.imgSize.width);
        // System.out.println("H = " + getHeight());
        if (getBounds().
            intersects(cgo.getBounds())
            &&
            this != cgo // collision itself
            &&
            getBounds() != null && cgo.getBounds() != null
            &&
            character.getTeamType() == cgo.getCharacter().getTeamType()
        ) {
            // System.out.println("Collsion Occcured");
            // ? if spawn before -> stop younger gameobject
            if (this.spawnTime < cgo.spawnTime) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
