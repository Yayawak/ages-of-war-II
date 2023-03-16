package srcs.GameUI.mainGame.SubScene.GameObject.Character;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.BoldAction;

import srcs.Enums.Direction;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.characterHpBar.CharacterHpBar;
import srcs.Prototypes.Characters.*;
import srcs.Systems.integratedSystem.IntegratedSystem;

public class CharacterGObject extends GameObject {

    private CharacterPrototype character;
    private Point position;
    CharacterHpBar hpBar;
    // private boolean isAttacking = false;
    public CharacterGObject(CharacterPrototype character) {
        super(character.getImgData().getSprite(),
                new Point(
                        (int) character.getPosition().getX(),
                        (int) character.getPosition().getY()),
                new Dimension(
                        character.getImgData().getImgWidth(),
                        character.getImgData().getImgHeight()));
        this.character = character;
        this.position = character.getPosition();
        init();
    }

    private void init() {
        hpBar = new CharacterHpBar(this);
        if (hpBar != null) {
            // System.out.format("hpBar of %s is exists : %s\n\n",
            //     character.getName(),
            //     hpBar.toString()
            //     );
            // setLayout(null);
            //todo  : make hp bar appear on screen
            // MainUI.getInstance().add(hpBar);
            // MainUI.getInstance().revalidate();
            // MainUI.getInstance().repaint();
            MainGame.getInstance().add(hpBar);
            MainGame.getInstance().revalidate();
            MainGame.getInstance().repaint();
        }
    }
    @Override
    public void update() {
        super.update();
        // System.out.println("Enter update function");
        // System.out.println(Math.random());
        // ? reset collsion : make character movable again
        if (hpBar != null) {
            hpBar.update();
        }

        // findClosestOpponent(character);
        checkIfCharacterOutOfScreen();

        if (character.getHp() <= 0) {
            destroyGameObject();
        }

        if (!getCollide()) {
        // if (true) {
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
        } else { // stand still
        }

        // findClosestOpponent(character);
        // checkIfCharacterOutOfScreen();


    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        if (hpBar != null) {
            hpBar.draw(g);
        }
    }

    private void checkIfCharacterOutOfScreen() {
        int screenWidth = MainUI.getInstance().getScreenSize().width;
        if (getCharacter().getTeamType() == TeamType.PLAYER
            && getX() > screenWidth) {
            destroyGameObject();
        }

        if (getCharacter().getTeamType() == TeamType.ENEMY
            && getX() < 0
            ) {
            destroyGameObject();
        }
    }

    private void move(Direction dir) {
        int mul = 20;
        int x = getX();
        int y = getY();
        int speed = character.getMovementSpeed() * mul;
        Point newPos = new Point(x, y);
        switch (dir) {
            case RIGHT:
                newPos.setLocation(x + speed, y);
                break;
            case LEFT:
                newPos.setLocation(x - speed, y);
                break;
            default: break;
        }
        character.setPosition(newPos);
        setLocation(character.getPosition());
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
    }

    @Override
    public void destroyGameObject() {
        switch (getCharacter().getTeamType()) {
            case PLAYER:
                IntegratedSystem.getInstance().getEnemyGoldSystem()
                    .increasedGold(character.getGold());
                IntegratedSystem.getInstance().getPlayerExpSystem()
                        .increasedExperience(character.getExperiance());
                break;
            case ENEMY:
                IntegratedSystem.getInstance().getPlayerGoldSystem()
                        .increasedGold(character.getGold());
                IntegratedSystem.getInstance().getPlayerExpSystem()
                        .increasedExperience(character.getExperiance());
                break;
            default: break;
        }
        MainGame.getInstance().remove(hpBar);
        super.destroyGameObject();
        // this = null;
        // removeAll();

    }
}//
