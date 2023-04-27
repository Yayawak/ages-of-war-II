package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

import audio.Music;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Effects.HandGrapperPrototype;

// public class HandGrapperGObject extends GameObject {
public class HandGrapperGObject extends GameObject {
// public class HandGrapperGObject extends AbstractEffect {
// class HandGrapper extends GameObject implements Animatable {
    HandGrapperPrototype handGrapperPtt;
    CharacterGObject prevCharacterDamager = null;
    public HandGrapperGObject(HandGrapperPrototype handPrototype) {
        super(handPrototype.getImgData().getSprite(),
                new Point(
                        (int) handPrototype.getPosition().getX(),
                        (int) handPrototype.getPosition().getY()),
                new Dimension(
                        handPrototype.getImgData().getImgWidth(),
                        handPrototype.getImgData().getImgHeight()));
        this.handGrapperPtt = handPrototype;
        this.teamType = handGrapperPtt.getTeamType();
        this.attacker = this.handGrapperPtt;
        setImg(handGrapperPtt.getImgData().getSprite());
        initAnimation();
    }

    private void initAnimation() {
        BloodSplashEffect bloodSplash = new BloodSplashEffect();
        MainGame.getInstance().addGameObjectToScene(bloodSplash);
        Music bloodSound = new Music();
        bloodSound.setFile("blood_bleez.wav");
        new Thread(() -> {
            // long animationSpeed = 150;
            // bloodSound.play();
            long animationSpeed = handGrapperPtt.getAttackRateInMillisec();
            int i = 0;
            // boolean stopAttacking = false;
            // while (!stopAttacking) {
            int totalDamageToDeal = 100;
            bloodSound.play();
            while (true) {
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < handGrapperPtt.getAttackASprites().size()) {
                    setImg(handGrapperPtt.getAttackASprites().get(i));
                } else {
                    i = 0;
                    continue;
                }
                // todo : random spawn x OR kill random enemy OR gradullay damage closest gobj
                CharacterGObject foe = findClosestOpponent();
                setPos(foe.getPos());
                bloodSplash.setPos(foe.getPos());
                damager = foe.getCharacter();
                if (totalDamageToDeal <= 0 || damager == null || foe == null) {
                    try { bloodSound.stop(); } catch (Exception e) { }
                    bloodSplash.destroyGameObject();
                    destroyGameObject();
                    return;
                }
                System.out.println(totalDamageToDeal);
                totalDamageToDeal -= handGrapperPtt.getAttackDamage();
                // prevCharacterDamager = foe;
                i++;
            }
        }).start();
    }
}
