package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Image;
import java.awt.geom.CubicCurve2D;
import java.util.List;

import audio.Music;
import helpers.SpritesInstallator;
import srcs.Prototypes.EntityPrototype;

public class BloodConcussiveEffect extends AbstractEffect {
    // List<Image> bloodConcussiveFrames;
    Music bloodSound = new Music();
    private EntityPrototype whoIsBleeding;
    // public BloodConcussiveEffect(EntityPrototype damager) {
    public BloodConcussiveEffect() {
        // super(); // call initAnimation
        // this.damager = damager;
        effectFrames = SpritesInstallator.getSpritesInFolder(
        "characters/cyberAge/ghost/atk hit"
        );
        // initAnimation(40);
        initAnimation(80);
        // initAnimation(10);
        // countDownToDestroy(0.5f);
        bloodSound.setFile("blood_bleez.wav");
        bloodSound.play();
        countDownToDestroy(0.8f);
        // countDownToDestroy();
    }


    // @Override
    // protected void effectUpdater() {
    //     // super.effectUpdater(); //nothing to use
    //     // System.out.println("blood updated work !");
    //     // if (whoIsBleeding != null) {
    //     //     System.out.println("position of blood effect is after " + damager.getName());
    //     //     this.setPos(whoIsBleeding.getPosition());
    //     // }
    //     this.setPos(whoIsBleeding.getPosition());
    // }

    public EntityPrototype getWhoIsBleeding() {
        return whoIsBleeding;
    }

    public void setWhoIsBleeding(EntityPrototype whoIsBleeding) {
        this.whoIsBleeding = whoIsBleeding;
    }


    @Override
    public void destroyGameObject() {
        try { bloodSound.stop(); } catch (Exception e) { }
        super.destroyGameObject();
    }

}
