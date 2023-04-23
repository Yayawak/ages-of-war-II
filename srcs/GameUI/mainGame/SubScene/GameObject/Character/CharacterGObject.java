package srcs.GameUI.mainGame.SubScene.GameObject.Character;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import helpers.ImageData;
import srcs.Enums.Direction;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.Debugger.DebugPanel;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.characterHpBar.CharacterHpBar;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonWarrior;
import srcs.StateMachine.State;
import srcs.Systems.integratedSystem.IntegratedSystem;

public class CharacterGObject extends GameObject {

    private CharacterPrototype character;
    private Point position;
    private CharacterHpBar hpBar;
    List<Image> currentAnimatingSprites;
    // private boolean isAttacking;
    // private Thread animateThread;

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
        super.teamType = character.getTeamType();
        // System.out.println(this.teamType);
        this.attacker = this.character;
        init();
    }

    private void init() {
        hpBar = new CharacterHpBar(this);
        if (hpBar != null) {
            //todo  : make hp bar appear on screen
            MainGame.getInstance().add(hpBar);
            MainGame.getInstance().revalidate();
            MainGame.getInstance().repaint();
        }
        animate();
    }

    private void animate() {
        // List<Image> currentAnimatingSprites;
        // List<Image> currentAnimatingSprites = character.getWalkSprites();
        currentAnimatingSprites = character.getWalkSprites();
        boolean isAttackASpritesExists = character.getAttackASprites().size() != 0;
        if (isAttackASpritesExists) {
            currentAnimatingSprites = character.getAttackASprites();
        }
        // long freq = 200;
        // long freq =
        // long freq = 20;
        // int size = currentAnimatingSprites.size();
        // animateThread = new Thread(() -> {
        new Thread(() -> {
            long freq = 40;
            int size;
            // List<Image> currentAnimatingSprites = character.getWalkSprites();
            int i = 0;
            while (true) {
                // if (isInAttackRange) {
                if (attacker.getState() == State.ATTACK) {
                    currentAnimatingSprites = character.getAttackASprites();
                    freq = character.getAttackRateInMillisec();
                    // i = 0;
                } else if (attacker.getState() == State.MOVE ) {
                    currentAnimatingSprites = character.getWalkSprites();
                    freq = 40;
                }
                size = currentAnimatingSprites.size();
                // if (i != currentAnimatingSprites.size() - 1) {
                if (i != size - 1) {
                    try {
                        setImg(currentAnimatingSprites.get(i));
                    // } catch (Exception e) {
                    } catch (IndexOutOfBoundsException e) {
                        i = 0;
                        // System.out.println(e);
                    }
                } else {
                    i = 0;
                }
                i++;
                try { Thread.sleep(freq); } catch (Exception e) { System.out.println(e); }
            }
        // }, "animate");
        }).start();
        // animateThread.start();
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

        // findClosestOpponent(character);

        if (character.getHp() <= 0) {
            destroyGameObject();
        }

        // if (!getCollide()) {
        if (!getCollide()) {
        // if (false) {
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

        // todo : animation of attacking
        // ! BUG : sephiroth attacked emptyness lol, because closestOpponent is not null
        // ! but clossetOpponent really false null (it's not really findClosestOpponent)
        GameObject closestOpp = findClosestOpponent(getCharacter());
        if (closestOpp != null) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.cyan);
            g2d.setStroke(new BasicStroke(1));
            g2d.drawString(getCharacter().getName(), getX(), getY()
                - 30
            );
            g2d.drawLine(
                getX(),
                // getY() + (int)(Math.random() * 300 + 100),
                getY(),
                // getY(),
                closestOpp.getX(),
                // closestOpp.getY() + closestOpp.getWidth() / 2
                closestOpp.getY() - closestOpp.getWidth() / 2
            );
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
            // JFrame endFrame = new JFrame();
            // endFrame.add(new JLabel("GAME OVER"));
            // endFrame.setAlwaysOnTop(true);
            // endFrame.setVisible(true);
            // MainUI.getInstance().setVisible(false);
            JOptionPane.showMessageDialog(null, "GAME OVER");
            System.exit(0);
        }
    }

    private void move(Direction dir) {
        // int mul = 20;
        // int mul = 10;
        double mul = 0.5;
        double x = getX();
        double y = getY();
        double speed = character.getMovementSpeed() * mul;
        Point newPos = new Point((int)x, (int)y);
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
        // ! maybe bug if absent for these 2 below lines
        // character.setPosition(newPos);
        // setLocation(character.getPosition());
        setPos(newPos);
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

    // public CharacterGObject copy() {
    //     return new CharacterGObject(new CharacterPrototype(character));
    //     // return new CharacterGObject(character);
    // }

    @Override
    public void destroyGameObject() {
        switch (getCharacter().getTeamType()) {
            case PLAYER:
                IntegratedSystem.getInstance().getEnemyGoldSystem()
                    .increasedGold(character.getGold());
                IntegratedSystem.getInstance().getPlayerExpSystem()
                        .increasedExperience(character.getExperiance());
                DebugPanel.getInstance().setDebugText(
                    String.format("enemy gold = %d💰\n", IntegratedSystem.getInstance()
                        .getPlayerGoldSystem().getGold())
                    // String.format("enemy gold = %d🤑💰💸\n")
                );
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
        // animateThread.stop();
    }

    @Override
    public void setPos(Point newPos) {
        this.pos = newPos;
        setLocation(newPos);
        character.setPosition(newPos);
    }
}
