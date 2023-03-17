package srcs.Systems.AgeSystem.AgeList;

import java.awt.Image;
import java.awt.Point;
import java.nio.charset.spi.CharsetProvider;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.*;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class StoneAge extends AgeData {
    public StoneAge() {
        setBackgroundImage(getBackgroundImage());

        CharacterPrototype[] cps = {
            new GrimStroke(),
            new NatureProphet(),
            new Rubick(),
            new Morphling()
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
                "tower/tower1.png", 116, 228);
        TowerPrototype towerPrototype = new TowerPrototype(1000,
                TeamType.PLAYER,
                null,
                null,
                towerImgData,
                new Point(50, 210));
        setTowerPrototype(towerPrototype);
    // new Tower

        setExpRequiredToUpgrade(1000);
    }

}
