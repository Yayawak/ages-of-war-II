

import srcs.GameUI.MainFrame;
import srcs.GameUI.mainGame.MainGame;
import srcs.StartGameUI.StartGameFrame;
import test.TestTooltip;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartGameFrame startGameFrame = new StartGameFrame();
                startGameFrame.setVisible(true);

                // new TestTooltip();
            }
        });

    }
}
