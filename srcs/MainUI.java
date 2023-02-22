package srcs;
import javax.swing.*;

import srcs.UI.lowerBar.LowerBar;
import srcs.UI.mainGame.MainGame;
import srcs.UI.topBar.TopBar;
import srcs.UI.topBar.turretsBox.TurretsBox;
import srcs.UI.topBar.unitsBox.UnitsBox;

import java.awt.*;
import java.rmi.server.UID;


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

        // mvoe topbar
        topBar = TopBar.getInstance();

        new MainGame();
        mainGame = MainGame.mainGame;

        // UnitsBox = new UnitsBox();
        // ! double unit box from here
        unitsBox = UnitsBox.getInstance();
        // unitsBox = new JPanel();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();


        //!! use singleton design pattern
        turretsBox = TurretsBox.getInstance();


        specialsBox = new JPanel();
        upgradesBox = new JPanel();

        new LowerBar();
        lowerBar = LowerBar.lowerBar;


        timeControlBar = new JPanel();
        hpPanel = new JPanel();
        hpBar = new JProgressBar();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(100, 242, 242));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));



        // ? SUB PANELS of units bar
        // ==============================================================
        jPanel1.setPreferredSize(new Dimension(44, 44));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        unitsBox.add(jPanel1);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        unitsBox.add(jPanel2);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        unitsBox.add(jPanel3);

        // topBar.add(unitsBox); // !! Brown units box

        //? ======== END UNIS-BAR SUBUNITS ===================

        // topBar.add(turretsBox);



        specialsBox.setBackground(new Color(124, 50, 142));
        specialsBox.setPreferredSize(new Dimension(76, 57));

        GroupLayout specialsBoxLayout = new GroupLayout(specialsBox);
        specialsBox.setLayout(specialsBoxLayout);
        specialsBoxLayout.setHorizontalGroup(
            specialsBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 76, Short.MAX_VALUE)
        );
        specialsBoxLayout.setVerticalGroup(
            specialsBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        topBar.add(specialsBox);








        upgradesBox.setBackground(new Color(2, 150, 22));

        GroupLayout upgradesBoxLayout = new GroupLayout(upgradesBox);
        upgradesBox.setLayout(upgradesBoxLayout);
        upgradesBoxLayout.setHorizontalGroup(
            upgradesBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        upgradesBoxLayout.setVerticalGroup(
            upgradesBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        topBar.add(upgradesBox);





        getContentPane().add(topBar);
        getContentPane().add(mainGame);
        getContentPane().add(lowerBar);





        timeControlBar.setBackground(new Color(142, 92, 92));

        GroupLayout timeControlBarLayout = new GroupLayout(timeControlBar);
        timeControlBar.setLayout(timeControlBarLayout);
        timeControlBarLayout.setHorizontalGroup(
            timeControlBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        timeControlBarLayout.setVerticalGroup(
            timeControlBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        hpPanel.setBackground(new Color(42, 242, 42));

        hpBar.setBackground(new Color(255, 109, 109));

        GroupLayout hpPanelLayout = new GroupLayout(hpPanel);
        hpPanel.setLayout(hpPanelLayout);
        hpPanelLayout.setHorizontalGroup(
            hpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, hpPanelLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(hpBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        hpPanelLayout.setVerticalGroup(
            hpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(hpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hpBar, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );


        pack();
    }


    // Variables declaration - do not modify
    private JProgressBar hpBar;
    private JPanel hpPanel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
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

