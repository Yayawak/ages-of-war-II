package srcs.UI.topBar.goldExpProgPanel.expPanel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.FontUIResource;

import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.interfaces.Loopable;
import java.awt.Dimension;
import java.awt.Font;

public class ExpPanel extends JPanel implements
    Loopable {
    private static ExpPanel instance = null;
    private JLabel expLabel;
    private int expToShow;

    public static ExpPanel getInstance() {
        if (instance == null)
            instance = new ExpPanel();
        return instance;
    }
    public ExpPanel() {
        init();
    }

    private void init() {
        setBackground(Color.blue);
        expLabel = new JLabel("EXP : ");
        Font f = new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 40);
        expLabel.setFont(f);
        expLabel.setForeground(Color.green);
        add(expLabel);

    }
    @Override
    public void update() {
        expToShow = IntegratedSystem.getInstance()
            .getPlayerExpSystem().getExperiance();
    }
    @Override
    public void draw(Graphics g) {
        String expString = String.valueOf(expToShow + "🌟");
        expLabel.setPreferredSize(new Dimension(
            200, 100
        ));
        expLabel.setText(expString);
    }
}
