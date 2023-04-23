

package srcs.Systems.AgeSystem.AgeList;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import helpers.ImageData;
import srcs.Enums.AgeType;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.MainGame;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonArcher;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonSpear;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonWarrior;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.*;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class SkeletonAge extends AgeData {

    private static SkeletonAge instance;
    public static SkeletonAge getInstance() {
        if (instance == null) instance = new SkeletonAge();
        return instance;
    }
    public SkeletonAge() {
        setNextAgeData(StoneAge.getInstance());
        setAgeType(AgeType.SKELETON);
        Image bgImg = new ImageData("backgrounds/dirtAge.png",
            MainUI.getInstance().getWidth(),
            (int)MainGame.getInstance().getPreferredSize().getHeight() + 50
        ).getSprite();
        setBackgroundImage(bgImg);

        CharacterPrototype[] cps = {
            // new GrimStroke(TeamType.PLAYER),
            new SkeletonWarrior(TeamType.PLAYER),
            new SkeletonArcher(TeamType.PLAYER),
            new SkeletonSpear(TeamType.PLAYER),
            new Morphling(TeamType.PLAYER)
        };
        setCharacterPrototypes(
            new ArrayList<CharacterPrototype>(
                Arrays.asList(cps)
            )
        );


        TurretPrototype[] turretPrototypes = {
            new RedLaserTurret(),
            new FireGunTurret()
        };
        setTurretPrototypes(
            new ArrayList<TurretPrototype>(
                Arrays.asList(turretPrototypes)
            )
        );

        // /Users/rio/Desktop/games dev/ages-of-war-II/images/tower/skeleton based  0.png
        ImageData towerImgData = new ImageData(
                // "tower/tower1.png",
                "tower/skeleton based  0.png",
                // 116, 228
                // 150, 200
                200, 275
        );
        TowerPrototype towerPrototype = new TowerPrototype(
            1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            // new Point(50, 210)
            new Point(50, 150)
        );
        setTowerPrototype(towerPrototype);
        setExpRequiredToUpgrade(1000);
        setUpgradeImage(
            new ImageData(
                "upgradeIcons/stoneAgeUp.png"
            ).getSprite()
        );
    }

    @Override
    public void useUltimate(TeamType team) {
        System.out.println("ultimate in skeleton age is called.");
                // ((i < 10) ? "0" : "") +
                // Image
        LinkedList<Image> greenHandImages = new LinkedList<>();
        for (int i = 3; i < 13; i++) {
            // String path = "effects/green hands/green-hand-hell_03.png";
            String prefix = (i < 10) ? "0" : "";
            // String path = "effects/green hands/green-hand-hell_" +
            //     prefix +
            //     String.valueOf(i) +
            //     ".png";
            String path = "effects/green hands/hand-from-ground.png";
            greenHandImages.add(
                new ImageData(path).getSprite()
            );
        }
    }
}
