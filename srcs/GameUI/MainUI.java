package srcs.GameUI;

import javax.swing.*;

import srcs.GameUI.lowerBar.LowerBar;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.Debugger.DebugPanelDepreicated;
import srcs.GameUI.topBar.TopBar;
import srcs.GameUI.topBar.goldExpProgPanel.GoldExpProgPanel;
import srcs.GameUI.topBar.goldExpProgPanel.expPanel.ExpPanel;
import srcs.GameUI.topBar.goldExpProgPanel.goldPanel.GoldPanel;
import srcs.GameUI.topBar.goldExpProgPanel.qProgress.QueueProgress;
import srcs.GameUI.topBar.turretsBox.TurretsBox;
import srcs.GameUI.topBar.ultimateUpgradePanel.UltimateUpgradePanel;
import srcs.GameUI.topBar.unitsBox.UnitsBox;
import srcs.Systems.EnemySystem.EnemyIntegratedSystem;

import java.awt.*;


public class MainUI extends JPanel implements Runnable {
    Thread gameThread;
    private JPanel lowerBar;
    private JPanel mainGame;
    private JPanel topBar;
    private static MainUI instance = null;
    private Dimension screenSize = Toolkit.getDefaultToolkit()
        .getScreenSize();
    private final int FPS = 60;


    public static MainUI getInstance() {
        if (instance == null)
            instance = new MainUI();
        return instance;
    }

    private MainUI() {
        startGameThread();
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        init();
        // System.out.println("after init");
        initMainGameThread();
        gameStart();
    }

    private void gameStart() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;


        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
            if (timer >= 1000000000) {
                timer = 0;
            }
        }
    }

    private void initMainGameThread() {
        new Thread(() -> {
            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            while (true) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;
                if (delta >= 1) {
                    // todo : ? add updater here
                    try { MainGame.getInstance().update(); } catch (Exception e) { }
                    delta--;
                }
                if (timer >= 1000000000) {
                    timer = 0;
                }
            }
        }).start();

    }


    private void init() {

        // setPreferredSize(new Dimension(1400, 850));
        setBackground(new Color(100, 22, 242));
        System.out.println("Init in MainUI panel");
        topBar = TopBar.getInstance();
        topBar.add(UnitsBox.getInstance());
        topBar.add(TurretsBox.getInstance());
        topBar.add(UltimateUpgradePanel.getInstance());
        topBar.add(GoldExpProgPanel.getInstance());


        mainGame = MainGame.getInstance();
        // mainGame.draw
        lowerBar = LowerBar.getInstance();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(topBar);
        add(mainGame);
        add(lowerBar);

    }

    private void update() {
        // System.out.println("kkkk");
        EnemyIntegratedSystem.getInstance().update();
        // * Must have thread for fast
        // new Thread(() -> {
        //     MainGame.getInstance().update();
        // }).start();
        // MainGame.getInstance().update();

        // new Thread(() -> {
        GoldPanel.getInstance().update();
        // }).start();

        // new Thread(() -> {
        ExpPanel.getInstance().update();
        // }).start();

        // new Thread(() -> {
        // }).start();

        // new Thread(() -> {
        QueueProgress.getInstance().update();
        // }).start();
        DebugPanelDepreicated.getInstance().update();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // new Thread(() -> {
        //     MainGame.getInstance().draw(g);
        // }).start();
        MainGame.getInstance().draw(g);
        GoldPanel.getInstance().draw(g);
        ExpPanel.getInstance().draw(g);
        QueueProgress.getInstance().draw(g);
        EnemyIntegratedSystem.getInstance().draw(g);
    }

    public Dimension getScreenSize() {
        return screenSize;
    }

    public int getFPS() {
        return FPS;
    }
}
