package srcs;
import javax.swing.*;

import srcs.UI.lowerBar.LowerBar;
import srcs.UI.lowerBar.hpPanel.HpBar;
import srcs.UI.lowerBar.hpPanel.HpPanel;
import srcs.UI.lowerBar.timeControlBar.TimeControlBar;
import srcs.UI.mainGame.MainGame;
import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.specialsBox.SpecialsBox;
import srcs.UI.topBar.turretsBox.TurretsBox;
import srcs.UI.topBar.unitsBox.UnitsBox;
import srcs.UI.topBar.upgradesBox.UpgradesBox;

import java.awt.*;


public class MainUI extends JFrame {
    private static MainUI instance = null;

    public static MainUI getInstance() {
        if (instance == null)
            instance = new MainUI();
        return instance;
    }

    private MainUI() {
        init();
    }

    @SuppressWarnings("unchecked")
    private void init() {

        topBar = TopBar.getInstance();
        mainGame = MainGame.getInstance();

        unitsBox = UnitsBox.getInstance();
        turretsBox = TurretsBox.getInstance();
        specialsBox = SpecialsBox.getInstance();
        upgradesBox = UpgradesBox.getInstance();

        lowerBar = LowerBar.getInstance();
        // timeControlBar = TimeControlBar.getInstance();
        // hpPanel = HpPanel.getInstance();
        // lowerBar.add(timeControlBar);

        setResizable(false);
        setPreferredSize(new Dimension(1400, 850));
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(100, 242, 242));
        getContentPane().setLayout(
            new BoxLayout(getContentPane(),
            BoxLayout.Y_AXIS
            )
        );


        // topBar.add(turretsBox);


        getContentPane().add(topBar);
        getContentPane().add(mainGame);
        getContentPane().add(lowerBar);

        pack();
    }


    // Variables declaration - do not modify
    private JPanel lowerBar;
    private JPanel mainGame;
    private JPanel specialsBox;
    private JPanel timeControlBar;
    private JPanel topBar;
    private JPanel turretsBox;
    private JPanel unitsBox;
    private JPanel upgradesBox;
    // End of variables declaration
}

