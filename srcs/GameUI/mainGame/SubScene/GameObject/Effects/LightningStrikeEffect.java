package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import audio.Music;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Prototypes.EntityPrototype;

public class LightningStrikeEffect extends AbstractEffect {
    int lightningTotalDamage = 150;
    int lightningDamage = lightningTotalDamage / 10;;
    // public LightningStrikeEffect() {
    public LightningStrikeEffect(TeamType team) {
        super();
        Image effectImage = new ImageData("effects/lightning strikes/lightning-strike_03.png")
            .getSprite();
        Dimension size = new Dimension(30, 30);
        setImg(effectImage);
        setImgSize(size);
        effectFrames = SpritesInstallator.getSpritesInFolder("effects/lightning strikes",
            200, 200
        );
        // initAnimation(10);
        setTeamType(team);
        this.initAnimation();
        // Music ms = new Music();
        // ms.setFile("lightning-strike.wav");
        // ms.play();
        // initUpdate();
    }

    // private void initUpdate() {

    // }

    @Override
    protected void initAnimation() {
        new Thread(() -> {
            Music ms = new Music();
            ms.setFile("lightning-strike.wav");
            // long animationSpeed = 10;
            long animationSpeed = 5;
            // long animationSpeed = 40;
            // long animationSpeed = 100;
            int i = 0;
            // int totalDamageToDeal = 1000;
            while (!isEffectDied) {
                // CharacterGObject foe = findClosestOpponent();
                CharacterGObject foe = MainGame.getInstance().getRandomCharacterGameObjectFromTeam(getTeamType());
                damager = foe.getCharacter();

                setPos(new Point(
                    foe.getX(),
                    foe.getY() - this.getHeight()
                ));
                foe.getCharacter().decreaseHp(lightningDamage);
                lightningTotalDamage -= lightningDamage;
                if (lightningTotalDamage <= 0 || damager == null || foe == null) {
                    try { ms.stop(); } catch(Exception e) { System.out.println(e); }
                    destroyGameObject();
                    isEffectDied = true;
                    return;
                }
                while (i < effectFrames.size()) {
                    ms.play();
                    try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                    setImg(effectFrames.get(i));
                    i++;
                }
                i = 0;
            }
        }).start();
    }

}
