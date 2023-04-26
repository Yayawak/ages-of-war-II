package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Prototypes.EntityPrototype;

public class LightningStrikeEffect extends AbstractEffect {
    public LightningStrikeEffect() {
        super();
        Image effectImage = new ImageData("effects/lightning strikes/lightning-strike_03.png")
            .getSprite();
        Dimension size = new Dimension(30, 30);
        setImg(effectImage);
        setSize(size);
        setPreferredSize(size);
        setImgSize(size);
                // String dirPath = "characters/Knight/Knight_1";
                // SpritesInstallator.getSpritesInFolder(dirPath);
                // System.out.println(SpritesInstallator.getSpritesInFolder(dirPath));
        for (int i = 3; i < 35; i++) {
            String prefix = (i < 10) ? "0" : "";
            String path = "effects/lightning strikes/lightning-strike_" +
                prefix +
                String.valueOf(i) +
                ".png";
            effectFrames.add(
                new ImageData(path).getSprite()
            );
        }

        effectFrames = SpritesInstallator.getSpritesInFolder("effects/lightning strikes");
        // initAnimation(10);
        this.initAnimation();
        // initUpdate();
    }

    // private void initUpdate() {

    // }

    @Override
    protected void initAnimation() {
        new Thread(() -> {
            // long animationSpeed = 10;
            long animationSpeed = 100;
            int i = 0;
            int totalDamageToDeal = 1000;
            while (true) {
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < effectFrames.size()) {
                    setImg(effectFrames.get(i));
                } else {
                    i = 0;
                    continue;
                }
                // todo : random spawn x OR kill random enemy OR gradullay damage closest gobj
                // ! create lightning prototype that extends from entityPrototype
                // ? set attack range to very close then kill enemy on close
                // * attacker = this ???????????
                CharacterGObject foe = findClosestOpponent();
                setPos(foe.getPos());
                damager = foe.getCharacter();
                if (totalDamageToDeal <= 0 || damager == null || foe == null) {
                    destroyGameObject();
                    return;
                }
                // System.out.println(totalDamageToDeal);
                // prevCharacterDamager = foe;
                i++;

                // CharacterGObject foe =  findClosestOpponent();
                foe = findClosestOpponent();
                // foe.getCharacter().decreaseHp(totalDamageToDeal);
                // if (foe != null) {
                //     foe.getCharacter().decreaseHp(20);
                // }
                setPos(new Point(
                    foe.getX(),
                    foe.getY() + this.getHeight()
                ));
                // totalDamageToDeal -= 69;
                // if
            }
        }).start();
    }

}
