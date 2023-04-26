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
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.Santana;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.Teera;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class TeacherAge extends AgeData {
    private static AgeData instance;

    public static AgeData getInstance() {
        if (instance == null)
            instance = new TeacherAge();
        return instance;
    }

    public TeacherAge() {
        setNextAgeData(null);
        setAgeType(AgeType.TEACHER);

        Image bgImg = new ImageData("backgrounds/juggernautWood.jpeg",
                MainUI.getInstance().getWidth(),
                (int) MainGame.getInstance().getPreferredSize().getHeight() + 50).getSprite();
        setBackgroundImage(bgImg);

        CharacterPrototype[] cps = {
            new Santana(TeamType.PLAYER),
            new Teera(TeamType.PLAYER),
            new Teera(TeamType.PLAYER),
        };
        setCharacterPrototypes(
        new ArrayList<CharacterPrototype>(
                Arrays.asList(cps)));

        TurretPrototype[] turretPrototypes = {
                new RedLaserTurret(),
                new RedLaserTurret(),
        };
        setTurretPrototypes(
                new ArrayList<TurretPrototype>(
                        Arrays.asList(turretPrototypes)));

        ImageData towerImgData = new ImageData(
                "tower/shinra.png", 116, 228);
        TowerPrototype towerPrototype = new TowerPrototype(1000,
                TeamType.PLAYER,
                null,
                null,
                towerImgData,
                new Point(50, 210));
        setTowerPrototype(towerPrototype);

        setExpRequiredToUpgrade(1000);

        setUpgradeImage(
                new ImageData(
                        "upgradeIcons/stoneAgeUp.png").getSprite());
    }

    @Override
    public void useUltimate(TeamType team) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useUltimate'");
    }

}
