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
import helpers.SpritesInstallator;
import srcs.Enums.Direction;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.Debugger.DebugPanel;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.BloodDieEffect;
import srcs.GameUI.mainGame.SubScene.characterHpBar.CharacterHpBar;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonWarrior;
import srcs.StateMachine.State;
import srcs.Systems.integratedSystem.IntegratedSystem;

public class CharacterGObject extends GameObject {

    // private CharacterPrototype character;
    protected CharacterPrototype character;
    // private Point position;
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
        // this.position = character.getPosition();
        super.teamType = character.getTeamType();
        // System.out.println(this.teamType);
        this.attacker = this.character;
        init();
    }

    // public abstract CharacterGObject();
    // public CharacterGObject() {
    //     init();
    //  }

    // private void init() {
    private void init() {
        // System.out.println("init cgo : name " + getCharacter().getName());
        this.update();
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
            // long freq = 100;
            // long freq = 100;
            int size;
            // List<Image> currentAnimatingSprites = character.getWalkSprites();
            int i = 0;
            while (!isGameObjectDied()) {
                // if (isInAttackRange) {
                if (attacker.getState() == State.ATTACK) {
                    currentAnimatingSprites = character.getAttackASprites();
                    freq = character.getAttackRateInMillisec();
                    // freq = 10;
                    // i = 0;
                // } else if (attacker.getState() == State.MOVE ) {
                }
                if (attacker.getState() == State.MOVE ) {
                    currentAnimatingSprites = character.getWalkSprites();
                    // freq = 40;
                    // freq = 70;
                    freq = 100;
                }
                size = currentAnimatingSprites.size();
                // if (i != size - 1) {
                //     try {
                //         setImg(currentAnimatingSprites.get(i));
                //     } catch (IndexOutOfBoundsException e) { i = 0; }
                // } else {
                //     i = 0;
                // }
                // i++;
                while (i < size) {
                    setImg(currentAnimatingSprites.get(i));
                    i++;
                    // try { Thread.sleep(freq); } catch (Exception e) { System.out.println(e); }
                    try { Thread.sleep(freq); } catch (Exception e) {}
                }
                i = 0;
                // try { Thread.sleep(freq); } catch (Exception e) { System.out.println(e); }
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
        // System.out.println("character gameobject entered local updater");
        super.update();
        // System.out.println("Enter update function");
        // System.out.println(Math.random());
        // ? reset collsion : make character movable again
        if (hpBar != null) {
            hpBar.update();
        }

        // ! must have this line for ghost
        findClosestOpponent(character);

        if (character.getHp() <= 0) {
            destroyGameObject();
        }

        // if (!getCollide()) {
        // if (!getCollide() && character.getState() == State.MOVE) {
        // System.out.println("enterd ");
        if (character.getState() == State.MOVE) {
        //     System.out.println("tick move");
        // if (true) {
        // if (false) {
            switch (character.getTeamType()) {
                case PLAYER:
                    move(Direction.RIGHT);
                    // move(Direction.LEFT);
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
            g2d.setColor(Color.yellow);
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
            // ! used to exit game
            // JOptionPane.showMessageDialog(null, "GAME OVER");
            // System.exit(0);
        }
    }

    private void move(Direction dir) {
        // System.out.println("ENTERD MOVE FUNCTION !");
        // int mul = 80;
        // int mul = 20;
        // int mul = 200;
        // int mul = 10;
        double mul = 0.4;
        // double mul = 0.3;
        // double mul = 0.2;
        // setTeamType(TeamType.ENEMY);
        // System.out.println("Team of cgo : " + getTeamType());
        double x = character.getPosition().getX();
        double y = character.getPosition().getY();
        // double x = getX();
        // double x = getLocation().x;
        // double y = getY();
        // double x = getLocation().getX();
        // double y = getLocation().getY();
        // System.out.println("1 ) current point is " + getLocation());
        float rawMoveSpeed = (float)character.getMovementSpeed();
        if (rawMoveSpeed <= 1) {
            rawMoveSpeed += 0.25f;
        }
        double speed = rawMoveSpeed * mul;
        // double speed = 30;
        if (speed < 1) { speed = 1; }
        // ! debug newPos is bug
        // System.out.println("-------------------------------");
        // System.out.println("x of this cgo : " + x);
        // System.out.println("y of this cgo : " + y);
        // // x = 170;
        // // x = character.getPosition().x;
        // speed = 100;
        // System.out.println("speed = " + speed);
        // System.out.println("speed = " + 100);
        Point newPos = new Point((int)x, (int)y);
        switch (dir) {
            case RIGHT:
                newPos.setLocation(x + speed, y);
                // setPos(character.getPosition().x + speed, character.getPosition().y);
                // setPos(new Point(
                //     (int)(character.getPosition().x + speed), character.getPosition().y)
                // );
                // newPos.setLocation(x + 100, y);
                break;

            case LEFT:
                // setPos(new Point(
                //     (int)(character.getPosition().x - speed), character.getPosition().y)
                // );
                newPos.setLocation(x - speed, y);
                // newPos.setLocation(x - 100, y);
                break;

            default:
                System.out.println("default case from move cgo bug !");
                break;
        }

        // System.out.println("2) expected next point is " + newPos);
        // System.out.println("2 ) current point is " + getLocation());
        // setPos(new Point(
        //     (int)(Math.random() * 500),
        //     400
        //     // (int)(Math.random() * 500)
        // ));
        // if (getTeamType() == TeamType.PLAYER)
        // System.out.println("new position is " + newPos);
        // System.out.println("current point is " + getLocation());
        // System.out.println("-------------------------------");
        setPos(newPos);
    }

    public CharacterPrototype getCharacter() {
        return character;
    }

    public void setCharacter(CharacterPrototype character) {
        this.character = character;
    }

    // public Point getPosition() {
    //     return position;
    // }

    // public CharacterGObject copy() {
    //     return new CharacterGObject(new CharacterPrototype(character));
    //     // return new CharacterGObject(character);
    // }

    @Override
    public void destroyGameObject() {
        new BloodDieEffect().setPos(character.getPosition());
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
        hpBar.setHpBarDestroyed(true);
        MainGame.getInstance().remove(hpBar);
        super.destroyGameObject();
        // animateThread.stop();
    }

    @Override
    public void setPos(Point newPos) {
        this.pos = newPos;
        character.setPosition(newPos);
        // System.out.println("character postion is : " + character.getPosition());
        // this.position =
        // System.out.println();
        // System.out.println("set position is " + newPos);
        setLocation(character.getPosition());
        // System.out.println("real location og cgo is " + getLocation());
        // super.setPos(newPos);
    }
}
