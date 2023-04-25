package srcs.Systems.Tooltips;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import srcs.GameUI.mainGame.Debugger.DebugPanel;
import srcs.Systems.EnemySystem.EnemyIntegratedSystem;
import srcs.Systems.integratedSystem.IntegratedSystem;

public class DebugTooltip extends JPopupMenu {
    JButton addEnemyGoldBtn;
    JButton addEnemyExpBtn;
    // private boolean isRunningTooltip = false;
    private static DebugTooltip instance;
    public static DebugTooltip getInstance() {
        if (instance == null) instance = new DebugTooltip();
        return instance;
    }

    private DebugTooltip() {
        super();
        // setPreferredSize(new Dimension(100, 150));
        // setPreferredSize(new Dimension(150, 200));
        // setPreferredSize(new Dimension(150, 100));
        setPreferredSize(new Dimension(50, 80));
        setLayout(new GridLayout(2, 1));
        setBackground(Color.red);

        // new Thread(() -> {
        //     // while (true) {
        //     while (isRunningTooltip) {
        //         try {
        //             if (getMousePosition() != null && getBounds().contains(getMousePosition(true))) {
        //             // if (getMousePosition() != null && getBounds().contains(getMousePosition())) {
        //                 System.out.println("mouse is in debug tooltip na.");
        //             } else {
        //                 System.out.println("Mouse is not in debug tooltip.");
        //             }
        //         } catch (Exception e) { }
        //     }
        // }).start();
        // countDown();
        initUI();
    }

    private void initUI() {
        // JLabel addEne
        // addEnemyGoldBtn = new JButton("add enemy gold");
        // addEnemyExpBtn = new JButton("add enemy experiance");
        addEnemyGoldBtn = new JButton("💸");
        addEnemyExpBtn = new JButton("✡︎");
        setLayout(new GridLayout(2, 1));

        add(addEnemyGoldBtn);
        add(addEnemyExpBtn);


        addEnemyExpBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EnemyIntegratedSystem.getInstance().increaseEnemyExp(100);
            }
        });
        addEnemyGoldBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EnemyIntegratedSystem.getInstance().increaseEnemyGold(100);
            }
        });
    }

    private void countDown() {
        // todo : if time > 4 sec with no mouse hover on it
        // ? if cursor position is on this compoennt -> restart countDownTime
    }

    // public void toggleDebugTooltip() {
    //     isRunningTooltip = !isRunningTooltip;
    // }
}
