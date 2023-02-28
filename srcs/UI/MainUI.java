package srcs.UI;

import javax.swing.*;

import srcs.Systems.EnemySystem.EnemyIntegratedSystem;
import srcs.UI.lowerBar.LowerBar;
import srcs.UI.mainGame.MainGame;
import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.goldExpProgPanel.GoldExpProgPanel;
import srcs.UI.topBar.goldExpProgPanel.expPanel.ExpPanel;
import srcs.UI.topBar.goldExpProgPanel.goldPanel.GoldPanel;
import srcs.UI.topBar.goldExpProgPanel.qProgress.QueueProgress;
import srcs.UI.topBar.specialsBox.SpecialsBox;
import srcs.UI.topBar.turretsBox.TurretsBox;
import srcs.UI.topBar.unitsBox.UnitsBox;

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
        System.out.println("after init");
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


    private void init() {

        // setPreferredSize(new Dimension(1400, 850));
        setBackground(new Color(100, 22, 242));
        System.out.println("Init in MainUI panel");
        topBar = TopBar.getInstance();
        topBar.add(UnitsBox.getInstance());
        topBar.add(TurretsBox.getInstance());
        topBar.add(SpecialsBox.getInstance());
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
        MainGame.getInstance().update();
        GoldPanel.getInstance().update();
        ExpPanel.getInstance().update();
        QueueProgress.getInstance().update();
        EnemyIntegratedSystem.getInstance().update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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
