

package srcs.Systems.AgeSystem.AgeList;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
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
        Image bgImg = new ImageData("backgrounds/war_bg.jpeg",
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

        ImageData towerImgData = new ImageData(
                "tower/tower1.png",
                116, 228
        );
        TowerPrototype towerPrototype = new TowerPrototype(
            1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            new Point(50, 210)
        );
        setTowerPrototype(towerPrototype);
    // new Tower

        setExpRequiredToUpgrade(1000);


        setUpgradeImage(
            new ImageData(
                "upgradeIcons/stoneAgeUp.png"
            ).getSprite()
        );
    }

}
