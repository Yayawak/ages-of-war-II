

import audio.Music;
import helpers.SpritesInstallator;
import srcs.GameUI.MainFrame;
import srcs.GameUI.mainGame.MainGame;
import srcs.StartGameUI.StartGameFrame;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import test.TestTooltip;
import test.TileGeneratorApp;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Music riskMusic = new Music();
                riskMusic.setFile("risk.wav");
                riskMusic.play();
                StartGameFrame startGameFrame = new StartGameFrame();
                startGameFrame.setVisible(true);

                // new TestTooltip();
                // new TileGeneratorApp().setVisible(true);

            }
        });

    }
}
