package srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.util.List;

import helpers.SpritesInstallator;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.BloodConcussiveEffect;
import srcs.GameUI.mainGame.SubScene.GameObject.Projectiles.Bullet;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;

public class GhostGameObject extends CharacterGObject {
    // private Ghost ghost = new Ghost(TeamType.PLAYER);
    // private static Ghost ghost = new Ghost(TeamType.PLAYER);
    // private static Ghost ghost = new Ghost(TeamType.PLAYER);
    // BloodConcussiveEffect blood =  new BloodConcussiveEffect(damager);
    // BloodConcussiveEffect blood =  new BloodConcussiveEffect();
    // private
    // private Ghost ghost;
    // public GhostGameObject(TeamType team) {
    private Thread checkerThread;
    // private GameObject currentGameObject;
    private EntityPrototype currentEnemy;
    public GhostGameObject(Ghost ghost) {
        super(ghost);
        // super(); // called super init for hpbar
        // super(ghost);
        // super(ghost);



        // character = new Ghost(team);
        setCharacter(ghost);
        setImg(character.getImgData().getSprite());
        // setImg(ghost.getImgData().getSprite());
        // setPos(pos);
        setTeamType(character.getTeamType());
        // ghost = new Ghost(team);
        // super(team);

        // super(ghost);
        initThreadChecker();
        // blood.setVisible(false);
        // MainGame.getInstance().addGameObjectToScene(blood);
    }

    private void initThreadChecker() {
        checkerThread =  new Thread(() -> {
            while (!isGameObjectDied()) {
                System.out.println("damager of ghost is " + damager);
                initChecker();
            }
        });
        checkerThread.start();
    }

    private void initChecker() {
        // float cooldownSec = 9f;
        float cooldownSec = 3f;
        // float cooldownSec = 6f;
        // float cooldownSec = 1f;
        // while (cooldownSec > 0) {
        //     try { Thread.sleep(1000); } catch (Exception e) { }
        //     cooldownSec -= 1.f;
        // }
        // CharacterGObject closestFoe = findClosestOpponent();
        // if (closestFoe != null)
        //     damager = closestFoe.getCharacter();
        try { Thread.sleep((long)(cooldownSec * 1000)); } catch (Exception e) { }
        // todo : call special skill
        if (damager != null) {
            snipe(damager);
        } else {
            System.out.println("No enemy for ghost to use SNIPE");
        }
    }



    private void snipe(EntityPrototype enemy) {
        System.out.println("SNIPE !! " + enemy.getName());
        currentEnemy = enemy;
        Bullet bullet = new Bullet(
            getLocation(), enemy.getPosition()
        );
        // System.out.println("enemy name is " + enemy.getName());
    // private void snipe(GameObject enemy) {
        // int tripleDamage = character.getAttackDamage() * 3;
        BloodConcussiveEffect blood = new BloodConcussiveEffect();
        MainGame.getInstance().addGameObjectToScene(blood);
        //todo : create bullet gameobject
        // blood.setVisible(true);
        blood.setPos(enemy.getPosition());
        // blood.setWhoIsBleeding(enemy);
        // blood.setPos(enemy.getPosition());
        // blood.setPos(enemy.getPos());
        enemy.decreaseHp(999);

        // enemy.
    }

    @Override
    public void destroyGameObject() {
        // checkerThread.currentThread(
        // setCurretn
        //todo : called death sprites
        super.destroyGameObject();
    }

    @Override
    public void draw(Graphics g) {
        // super.draw(g);
        // Graphics2D g2d = (Graphics2D)g;
        // // Line2D line;
        // int x0 = getX();
        // int x1 = currentEnemy.getPosition().x;
        // int y0 = getY();
        // int y1 = currentEnemy.getPosition().y;
        // if (currentEnemy != null) {
        //     //  line = new Line2D.Float(
        //     //     (float)getX(),
        //     //     (float)getY(),
        //     //     (float)currentEnemy.getPosition().x,
        //     //     (float)currentEnemy.getPosition().y
        //     // );
        //     // g2d.draw(line);
        //     // new Thread(() -> {})
        //     g2d.setColor(Color.red);
        //     g2d.setStroke(new BasicStroke(1));
        //     // g2d.drawString();
        //     g2d.drawLine( x0, y0, x1, y1);
        // } else {
        //     // g2d = null;
        //     // remove(line);
        //     // x0 = -1
        //     // g2d.drawLine(x0, y0, x0, y0);
        //     // x0 = -1;
        //     // x1 = -1;
        //     // y0 = -1;
        //     // y1 = -1;
        //     // g2d.setColor(getBackground());
        //     // g2d.drawLine( x0, y1, x1, y1);
        //     // repaint();

        // }
    }
}
