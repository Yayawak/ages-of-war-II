package srcs.UI.mainGame.SubScene.GameObject.Character;

import java.awt.*;

import javax.swing.JLabel;

import srcs.Enums.Direction;
import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.UI.MainUI;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import srcs.UI.mainGame.SubScene.characterHpBar.CharacterHpBar;

public class CharacterGObject extends GameObject {

    private CharacterPrototype character;
    private Point position;
    private CharacterHpBar hpBar;
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
            // this.add(hpBar);
            // this.revalidate();
            // this.repaint();
            // add(hpBar);
            // revalidate();
            // repaint();
            // updateUI();
            // this.setVisible(false);
        }
        // setVisible(true);
    }

    // ? not called
    // @Override
    // public void paintComponent(Graphics g) {
    //     System.out.println("paint component from cgo");
    //     super.paintComponent(g);
    //     if (hpBar != null) {
    //         this.add(hpBar);
    //         this.revalidate();
    //         this.repaint();
    //     }
    // }

    @Override
    public void update() {
        super.update();
        // System.out.println("Enter update function");
        // System.out.println(Math.random());
        // ? reset collsion : make character movable again
        if (hpBar != null) {
            hpBar.update();
        }

        findClosestOpponent(character);

        if (character.getHp() <= 0) {
            destroyGameObject();
        }

        if (!getCollide()) {
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

        checkIfCharacterOutOfScreen();


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

            default:
                break;
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
        // return new CharacterGObject(character);
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
            default:
                break;
        }
        MainGame.getInstance().remove(hpBar);
        super.destroyGameObject();

    }
}
