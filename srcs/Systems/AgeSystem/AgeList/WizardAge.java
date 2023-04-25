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
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.*;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.BlackHoodWizard;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.FireWizard;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.LightningWitch;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.Santana;
import srcs.Prototypes.Characters.CharactersData.CharLists.WizardAge.Teera;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class WizardAge extends AgeData {
    private static AgeData instance;

    public static AgeData getInstance() {
        if (instance == null) instance = new WizardAge();
        return instance;
    }

    public WizardAge() {
        // setNextAgeData(FF7Age.getInstance());
        setNextAgeData(SamuraiAge.getInstance());
        setAgeType(AgeType.WIZARD);

        // /Users/rio/Desktop/ages-of-war-II/images/backgrounds/nightPlain.jpeg
        Image bgImg = new ImageData("backgrounds/nightPlain.jpeg",
            MainUI.getInstance().getWidth(),
            (int)MainGame.getInstance().getPreferredSize().getHeight() + 50
        ).getSprite();
        setBackgroundImage(bgImg);

        CharacterPrototype[] cps = {
            new FireWizard(TeamType.PLAYER),
            // new FireWizard(TeamType.PLAYER),
            // new FireWizard(TeamType.PLAYER),
            new LightningWitch(TeamType.PLAYER),
            // new Santana(TeamType.PLAYER),
            // new FireWizard(TeamType.PLAYER),
            new BlackHoodWizard(TeamType.PLAYER)
            // new Teera(TeamType.PLAYER),
            // new GrimStroke(TeamType.PLAYER),
            // new NatureProphet(TeamType.PLAYER),
            // new Morphling(TeamType.PLAYER)
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
                // "tower/archMage.png", 116, 228);
                "tower/timothy.png", 116, 228);
        TowerPrototype towerPrototype = new TowerPrototype(1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            new Point(50, 210)
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useUltimate'");
    }

}

