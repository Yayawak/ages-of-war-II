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
import srcs.Prototypes.Characters.CharactersData.CharLists.NinjaAge.Kunoichi;
import srcs.Prototypes.Characters.CharactersData.CharLists.NinjaAge.NinjaMonk;
import srcs.Prototypes.Characters.CharactersData.CharLists.NinjaAge.NinjaPeasant;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class NinjaAge extends AgeData {
    private static NinjaAge instance;

    public static NinjaAge getInstance() {
        if (instance == null)
            instance = new NinjaAge();
        return instance;
    }

    public NinjaAge() {
        setNextAgeData(SamuraiAge.getInstance());
        setAgeType(AgeType.NINJA);

        Image bgImg = new ImageData("backgrounds/ninja_bg.png",
                MainUI.getInstance().getWidth(),
                (int) MainGame.getInstance().getPreferredSize().getHeight() + 50).getSprite();
        setBackgroundImage(bgImg);

        CharacterPrototype[] cps = {
                new NinjaPeasant(TeamType.PLAYER),
                new NinjaMonk(TeamType.PLAYER),
                new Kunoichi(TeamType.PLAYER)
        };
        setCharacterPrototypes(
                new ArrayList<CharacterPrototype>(
                        Arrays.asList(cps)));

        TurretPrototype[] turretPrototypes = {
                new RedLaserTurret(),
                new FireGunTurret()
        };
        setTurretPrototypes(
                new ArrayList<TurretPrototype>(
                        Arrays.asList(turretPrototypes)));

        // /Users/rio/Desktop/games dev/ages-of-war-II/images/tower/skeleton based 0.png
        ImageData towerImgData = new ImageData(
                // "tower/tower1.png",
                "tower/skeleton based  0.png",
                // 116, 228
                // 150, 200
                200, 275);
        TowerPrototype towerPrototype = new TowerPrototype(
                1000,
                TeamType.PLAYER,
                null,
                null,
                towerImgData,
                // new Point(50, 210)
                new Point(50, 150));
        setTowerPrototype(towerPrototype);
        setExpRequiredToUpgrade(1000);
        setUpgradeImage(
                new ImageData(
                        "upgradeIcons/stoneAgeUp.png").getSprite());
    }

    @Override
    public void useUltimate(TeamType team) {
        throw new UnsupportedOperationException("Unimplemented method 'useUltimate'");
    }
}