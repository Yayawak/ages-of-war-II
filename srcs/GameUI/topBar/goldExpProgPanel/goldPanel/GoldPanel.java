package srcs.GameUI.topBar.goldExpProgPanel.goldPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Interfaces.Loopable;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;

public class GoldPanel extends JPanel implements Loopable {
    private static GoldPanel instance = null;
    private JLabel goldLabel;
    private int goldAmout = 0;
    private Font goldFont;

    public static GoldPanel getInstance() {
        if (instance == null)
            instance = new GoldPanel();
        return instance;
    }

    private GoldPanel() {
        init();
    }

    private void init() {
        // setPreferredSize(getPreferredSize());
        // setSize(getPreferredSize());
        setBackground(Color.red);
        goldLabel = new JLabel("GOLD : ");
        goldFont = new Font(Font.SANS_SERIF, Font.PLAIN, 50);
        goldLabel.setFont(goldFont);
        add(goldLabel);
        System.out.println("gold label inited");
        goldLabel.setForeground(Color.orange);
    }

    // @Override
    // protected void paintComponent(Graphics g) {
    // super.paintComponent(g);
    // }
    @Override
    public void update() {
        // System.out.println("update from goldPanel");
        // goldAmout = GoldSystem.getInstance().
        // ? on changing stage of gold -> update goldLabel size
        // if (goldAmout != IntegratedSystem.getInstance().
        // getPlayerGoldSystem().getGold()
        // ) {
        // goldLabel.setFont(new Font(
        // Font.SANS_SERIF, Font.BOLD,
        // // (int)(Math.random() * 50)
        // goldFont.getSize() * 2
        // ));
        // }
        // goldLabel.setFont(new Font(
        // Font.SANS_SERIF, Font.BOLD,
        // // (int)(Math.random() * 50)
        // goldFont.getSize() / 2
        // ));

        goldAmout = IntegratedSystem.getInstance().getPlayerGoldSystem().getGold();

        // System.out.println("gold amout = " + goldAmout);
    }

    @Override
    public void draw(Graphics g) {
        // int rand = (int)(Math.random() * 100);
        String goldStr = String.valueOf(goldAmout + "💲");
        goldLabel.setPreferredSize(new Dimension(200, 100));
        goldLabel.setText(goldStr);
    }
}
