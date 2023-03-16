
import srcs.UI.MainFrame;
import test.TestTooltip;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // new MainFrame().setVisible(true);
                new TestTooltip();
            }
        });
    }
}
