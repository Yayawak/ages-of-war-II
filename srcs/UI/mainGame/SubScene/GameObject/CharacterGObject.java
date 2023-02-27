package srcs.UI.mainGame.SubScene.GameObject;

import java.awt.Image;
import java.awt.*;
import srcs.Characters.*;
import srcs.Characters.Character;;

public class CharacterGObject extends GameObject {

    Character character;
    Point position;
    public CharacterGObject(Character character) {
        super(character.getImageData().getSprite(),
            (int)character.getPosition().getX(),
            (int)character.getPosition().getY()
        );
        this.character = character;
        this.position = character.getPosition();
    }
    // public CharacterGObject(Image img, int xPos, int yPos) {
    //     super(img, xPos, yPos);
    // }

    public void draw(Graphics g) {
        moveRight(g);
    }

    private void moveRight(Graphics g) {
        int x = getX();
        int mul = 20;
        setLocation(x + character.getMovementSpeed() * mul,
            400);
            // getY());
    }



}
