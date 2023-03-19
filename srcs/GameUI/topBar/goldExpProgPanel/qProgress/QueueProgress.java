package srcs.GameUI.topBar.goldExpProgPanel.qProgress;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JProgressBar;

import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Systems.integratedSystem.IntegratedSystem;

public class QueueProgress extends JProgressBar implements
    Loopable {
    private static QueueProgress instance = null;
    // private float timeToUseInSec = 5;
    private float timeToUseInSec;
    private boolean isEnableCounting = false;
    // ! very crucial attribute
    private boolean isProgressBarAvailable = true;

    private GameObject currentGameObjectToBuild;
    private CharacterPrototype currentCharacterPrototypeToBuild;


    private QueueProgress() {
        init();
        // setBackground(Color.red);
    }

    private void init() {
        // setSize(200, getHeight());
        setStringPainted(true);
        setLayout(null);
        setValue(0);
    }

    public static QueueProgress getInstance() {
        if (instance == null)
            instance = new QueueProgress();
        return instance;
    }

    public void startQueue(float timeToUseInSec) {
        if (isProgressBarAvailable) {
            isProgressBarAvailable = false;
            this.timeToUseInSec = timeToUseInSec;
            isEnableCounting = true;
        }
    }
    @Override
    public void update() {
        if (isEnableCounting) {
            isEnableCounting = false; // * important line : prevent thread to overly generate new thread
            isProgressBarAvailable = false;
            new Thread(
                () -> {
                    while (true) {
                        if (getValue() >= 100) {
                            setValue(0);
                            isEnableCounting = false;
                            generateUnit();
                            break;
                        }
                        long ms = ((long)timeToUseInSec * 10);
                        setValue(getValue() + 1);
                        try {
                            Thread.sleep(ms);
                        } catch (Exception e) { System.out.println(e); }
                    }
                    isProgressBarAvailable = true;
                }
            ).start();
        }
    }

    // public void generateUnit(GameObject go, CharacterPrototype character) {
    private void generateUnit() {
        MainGame.getInstance().addGameObjectToScene(
            currentGameObjectToBuild
        );
        IntegratedSystem.getInstance().getPlayerGoldSystem()
            .decreasedGold(
                currentCharacterPrototypeToBuild.getGold()
            );

    }
    @Override
    public void draw(Graphics g) {
        // startQueue(2);
        // if (System.nanoTime() > expectedEndTime) {
            // setValue(0);
        // }
        // setValue(getValue() + 1);
    }

    public boolean isProgressBarAvailable() {
        return isProgressBarAvailable;
    }

    public void setProgressBarAvailable(boolean isProgressBarAvailable) {
        this.isProgressBarAvailable = isProgressBarAvailable;
    }

    public float getTimeToUseInSec() {
        return timeToUseInSec;
    }

    public void setTimeToUseInSec(float timeToUseInSec) {
        this.timeToUseInSec = timeToUseInSec;
    }

    public GameObject getCurrentGameObjectToBuild() {
        return currentGameObjectToBuild;
    }

    public void setCurrentGameObjectToBuild(GameObject currentGameObjectToBuild) {
        this.currentGameObjectToBuild = currentGameObjectToBuild;
    }

    public CharacterPrototype getCurrentCharacterPrototypeToBuild() {
        return currentCharacterPrototypeToBuild;
    }

    public void setCurrentCharacterPrototypeToBuild(CharacterPrototype currentCharacterPrototypeToBuild) {
        this.currentCharacterPrototypeToBuild = currentCharacterPrototypeToBuild;
    }

}
