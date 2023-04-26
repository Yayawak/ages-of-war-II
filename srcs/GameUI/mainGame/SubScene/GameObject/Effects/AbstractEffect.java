package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;

public abstract class AbstractEffect extends GameObject {
    protected List<Image> effectFrames = new LinkedList<>();
    protected boolean isEffectDied = false;

    protected void initAnimation() {
        new Thread(() -> {
            long animationSpeed = 200;
            int i = 0;
            while (!isEffectDied) {
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < effectFrames.size()) {
                    setImg(effectFrames.get(i));
                } else {
                    i = 0;
                    continue;
                }
                i++;
                // System.out.println("blood splash");
            }
        }).start();
    }
    protected void initAnimation(long animationSpeed) {
        new Thread(() -> {
            int i = 0;
            while (!isEffectDied) {
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < effectFrames.size()) {
                    setImg(effectFrames.get(i));
                } else {
                    i = 0;
                    continue;
                }
                i++;
                // System.out.println("blood splash");
            }
        }).start();
    }

    @Override
    public void destroyGameObject() {
        this.isEffectDied = true;
        super.destroyGameObject();
    }
}
