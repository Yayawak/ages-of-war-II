package srcs.GameUI.mainGame.Debugger;

import javax.swing.JLabel;
import javax.swing.JPanel;

import helpers.UniCodeRandomer;
import helpers.CustomComponents.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import srcs.GameUI.MainUI;
import srcs.Interfaces.Loopable;

public class DebugPanel extends JPanel implements Loopable {
    private static DebugPanel instance;
    private JTextArea debugComponent;
    // private String debugText = "Default Debugger";
    private String debugText = "こんにちは、世界！";

    public static DebugPanel getInstance() {
        if (instance == null) instance = new DebugPanel();
        return instance;
    }

    public DebugPanel() {
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
            // new Font("Arial",
            new Font("MS Gothic",
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
    // public static String getDebugText() {
        return debugText;
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
            // + 1
            // + getHeight()
        ;
        // ... existing code ...
        setSize(new Dimension(getWidth(), panelHeight));
        setLocation(new Point(
                MainUI.getInstance().getWidth() - this.getWidth() - 150,
                MainUI.getInstance().getY() + 10
        ));

    }

    // public void setDebugText(String debugText) {
    public void setDebugText(String debugText) {

        this.debugText = debugText;
        // debugComponent.setText(debugText
        //     // + " " +
        //     + "\t\t" +
        //     UniCodeRandomer.getRandomHiragana()
        // );
        debugComponent.setText(
            UniCodeRandomer.getRandomHiragana()
            // + "\t" +
            + " : " +
            debugText
        );
        resizeFont();
    }


    @Override
    public void update() {
        debugComponent.setText(debugText);
    }

    @Override
    public void draw(Graphics g) {
    }

}
