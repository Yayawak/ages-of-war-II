package srcs.GameUI.mainGame.Debugger;

import javax.swing.JLabel;
import javax.swing.JPanel;

import helpers.CustomComponents.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import srcs.GameUI.MainUI;
import srcs.Interfaces.Loopable;

public class DPV2 extends JPanel implements Loopable {
    private static DPV2 instance;
    private JTextArea debugComponent;
    private String debugText = "Default Debugger";

    private int targetHeight;
    private int currentHeight;
    private int targetFontSize;
    private int currentFontSize;
    private Timer resizeTimer;

    public static DPV2 getInstance() {
        if (instance == null) instance = new DPV2();
        return instance;
    }

    public DPV2() {
        initResizeTimer();
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
            // + 50
            + 1
            // + getHeight()
        ;
        // ... existing code ...
        setSize(new Dimension(getWidth(), panelHeight));
        setLocation(new Point(
                MainUI.getInstance().getWidth() - this.getWidth() - 200,
                MainUI.getInstance().getY() + 10
        ));

        resizeDebugger(panelHeight, fontSize);
    }

    private void initResizeTimer() {
        resizeTimer = new Timer(10, e -> {
            if (currentHeight != targetHeight) {
                // Calculate new height with ease-in-out animation
                int diff = targetHeight - currentHeight;
                double progress = (double) Math.abs(diff) / targetHeight;
                double step = 1 - Math.pow(1 - progress, 2);
                int delta = (int) (diff * step);
                currentHeight += delta;
                setPreferredSize(new Dimension(getWidth(), currentHeight));
                revalidate();
            }
            if (currentFontSize != targetFontSize) {
                // Calculate new font size with ease-in-out animation
                int diff = targetFontSize - currentFontSize;
                double progress = (double) Math.abs(diff) / targetFontSize;
                double step = 1 - Math.pow(1 - progress, 2);
                int delta = (int) (diff * step);
                currentFontSize += delta;
                debugComponent.setFont(new Font("Arial", Font.PLAIN, currentFontSize));
                revalidate();
            }
            if (currentHeight == targetHeight && currentFontSize == targetFontSize) {
                // Stop the timer when the target height and font size are reached
                resizeTimer.stop();
            }
        });
        resizeTimer.setRepeats(true);
    }

    private void resizeDebugger(int targetHeight, int targetFontSize) {
        this.targetHeight = targetHeight;
        this.targetFontSize = targetFontSize;
        if (!resizeTimer.isRunning()) {
            currentHeight = getHeight();
            currentFontSize = debugComponent.getFont().getSize();
            resizeTimer.start();
        }
    }

    public void setDebugText(String debugText) {
        this.debugText = debugText;
        debugComponent.setText(debugText);
        resizeFont();
    }

    @Override
    public void update() {
        debugComponent.setText(debugText);
        // System.out.println("set text pls");
    }

    @Override
    public void draw(Graphics g) {
    }

}
