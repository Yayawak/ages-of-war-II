package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;

public abstract class AbstractEffect extends GameObject {
    protected List<Image> effectFrames = new LinkedList<>();
    protected boolean isEffectDied = false;

    public AbstractEffect() {
        initAnimation();
        new Thread(() -> {
            while (!isEffectDied) {
                effectUpdater();
            }
        }).start();
    }

    // protected abstract void effectUpdater();
    protected void effectUpdater() {}


    protected void initAnimation() {
        new Thread(() -> {
            long animationSpeed = 200;
            int i = 0;
            while (!isEffectDied || !isGameObjectDied()) {
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

    public void countDownToDestroy(float cooldownSec) {
    // public void countDownToDestroy() {
        new Thread(() -> {
            float counter = cooldownSec;
            // float cooldownSec = 3f;
            // while (cooldownSec > 0) {
            // while (!isEffectDied &&  counter > 0) {
            while (counter > 0) {
            // while (!isEffectDied || cooldownSec > 0) {
                // try { Thread.sleep(1000); } catch (Exception e) { }
                // try { Thread.sleep((long)(cooldownSec / 10)); } catch (Exception e) { }
                try { Thread.sleep(100); } catch (Exception e) { }
                // try { Thread.sleep(100); } catch (Exception e) { }
                // counter -= 1.f;
                // counter -= (cooldownSec / 10);
                counter -= 0.1f;
                // counter -= 0.05f;
            }
            destroyGameObject();
        }).start();
    }
}
