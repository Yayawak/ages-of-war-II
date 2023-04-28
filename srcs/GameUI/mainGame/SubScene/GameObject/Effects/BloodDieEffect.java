package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import audio.Music;
import helpers.SpritesInstallator;
import srcs.GameUI.mainGame.MainGame;

public class BloodDieEffect extends AbstractEffect {
    public BloodDieEffect() {
        effectFrames = SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/ghost/kill"
        );
        MainGame.getInstance().addGameObjectToScene(this);
        Music bloodSound = new Music();
        bloodSound.setFile("blood_bleez.wav");
        // bloodSound.play();
        initAnimation(70);
        countDownToDestroy(0.7f);
    }
}
