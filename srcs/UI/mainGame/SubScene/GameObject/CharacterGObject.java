package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.*;
import srcs.Characters.*;
import srcs.Characters.Character;
import srcs.Enums.Direction;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.UI.MainUI;
import srcs.UI.mainGame.MainGame;

public class CharacterGObject extends GameObject {

    Character character;
    Point position;
    public CharacterGObject(Character character) {
        super(character.getImageData().getSprite(),
            new Point(
                (int)character.getPosition().getX(),
                (int)character.getPosition().getY()
            ),
            new Dimension(
                character.getImageData().getImgWidth(),
                character.getImageData().getImgHeight()
            )
        );
        this.character = character;
        this.position = character.getPosition();
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Collsion status = " + isCollide);
        if (!isCollide) {
            move(Direction.RIGHT);
        }else {
            // stand still
            // move(Direction.LEFT);
        }
        int screenWidth = MainUI.getInstance().getScreenSize().width;
        if (getX() > screenWidth) {
            IntegratedSystem.getInstance().getPlayerGoldSystem()
                .increasedGold(character.getGold());
            destroyGameObject();
        }
    }

    private void move(Direction dir) {
        int mul = 6;
        switch (dir) {
            case RIGHT:
                setLocation(getX() +
                    character.getMovementSpeed() * mul,
                    400);
                break;

            case LEFT:
                setLocation(getX() -
                    character.getMovementSpeed() * mul,
                    400);
                break;

            default:
                break;
        }
    }




}
