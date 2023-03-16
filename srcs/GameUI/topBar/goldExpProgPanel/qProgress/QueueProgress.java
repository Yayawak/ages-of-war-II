package srcs.GameUI.topBar.goldExpProgPanel.qProgress;

import java.awt.Graphics;

import javax.swing.JProgressBar;

import srcs.Interfaces.Loopable;

public class QueueProgress extends JProgressBar implements
    Loopable {
    private static QueueProgress instance = null;
    // private float timeToUseInSec = 5;
    private float timeToUseInSec;
    private boolean isEnableCounting = false;
    // ! very crucial attribute
    private boolean isProgressBarAvailable = true;


    private QueueProgress() {
        init();
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

}
