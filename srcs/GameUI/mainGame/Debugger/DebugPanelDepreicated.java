package srcs.GameUI.mainGame.Debugger;

import javax.swing.JLabel;
import javax.swing.JPanel;

import helpers.CustomComponents.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import srcs.GameUI.MainUI;
import srcs.Interfaces.Loopable;

public class DebugPanelDepreicated extends JPanel implements Loopable {
    private static DebugPanelDepreicated instance;
    private JTextArea debugComponent;
    private String debugText = "Default Debugger";
    public static DebugPanelDepreicated getInstance() {
        if (instance == null) instance = new DebugPanelDepreicated();
        return instance;
    }

    public DebugPanelDepreicated() {
        init();
    }

    private void init() {
        // setLayout(new FlowLayout());
        setLocation(new Point(
            // MainUI.getInstance().getWidth() - this.getWidth() - 50,
            MainUI.getInstance().getWidth() - this.getWidth() - 200,
            MainUI.getInstance().getY() + 10
            // 300
        ));
        setBackground(new Color(0,0,0,0));
        setSize(new Dimension(200, 30));
        // setMinimumSize(new Dimension(200, 30));
        debugComponent = new JTextArea(debugText);
        // debugComponent = new JLabel(debugText,
        //     SwingConstants.CENTER
        // );
        debugComponent.setOpaque(true);
        debugComponent.setBackground(new Color(0,0,0,0));
        debugComponent.setForeground(Color.orange);
        debugComponent.setLineWrap(true);
        debugComponent.setWrapStyleWord(true);
        debugComponent.setFont(
            new Font("Arial",
                Font.PLAIN, 10
            )
        );
        // debugComponent.setText
        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(
                1, 1, 1, 1
                    // 10, 10, 10, 10
                ),
                new RoundedBorder(
                    // Color.black, 20,
                    Color.black, 30,
                    2, 1
                    // 3, 2
                )
            )
        );
        add(debugComponent);
    }


    public String getDebugText() {
        return debugText;
    }

    public void setDebugText(String debugText) {
        this.debugText = debugText;
    }

    private void resizeFont() {
        Font font = debugComponent.getFont();
        FontMetrics fontMetrics = debugComponent.getFontMetrics(font);
        int lineHeight = fontMetrics.getHeight();
        int areaHeight = debugComponent.getHeight();
        int areaWidth = debugComponent.getWidth();

        // Calculate the maximum number of lines that can fit in the text area
        int maxLines = (int) Math.floor((double) areaWidth / (double) fontMetrics.stringWidth("W"));

        // Get the current text and split it into lines
        String text = debugComponent.getText();
        String[] lines = text.split("\n");

        // Calculate the font size that will fit the maximum number of lines in the text area
        int fontSize = font.getSize();
        while (fontSize > 1) {
            Font testFont = font.deriveFont((float) fontSize);
            fontMetrics = debugComponent.getFontMetrics(testFont);
            lineHeight = fontMetrics.getHeight();
            int numLines = (int) Math.ceil((double) areaWidth / (double) fontMetrics.stringWidth("W"));
            if (numLines <= maxLines) {
                debugComponent.setFont(testFont);
                break;
            }
            fontSize--;
        }

        // Adjust the height of the panel based on the height of the text
        int textHeight = fontMetrics.getHeight() * lines.length;
        int panelHeight = textHeight
            + debugComponent.getInsets().top
            + debugComponent.getInsets().bottom
            + 50
            // + getHeight()
        ;
        setSize(new Dimension(getWidth(), panelHeight));
        setLocation(new Point(
                MainUI.getInstance().getWidth() - this.getWidth() - 200,
                MainUI.getInstance().getY() + 10
        ));
    }


    @Override
    public void update() {
        debugComponent.setText(debugText);
        resizeFont();
    }

    @Override
    public void draw(Graphics g) {
    }
}
