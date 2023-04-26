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
import srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge.SamuraiArcher;
import srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge.SamuraiFlag;
import srcs.Prototypes.Characters.CharactersData.CharLists.SamuraiAge.SamuraiSword;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

public class SamuraiAge extends AgeData {
        private static AgeData instance;

        public static AgeData getInstance() {
                if (instance == null)
                        instance = new SamuraiAge();
                return instance;
        }

        public SamuraiAge() {
                // setNextAgeData(WizardAge.getInstance());
                setNextAgeData(FF7Age.getInstance());
                setAgeType(AgeType.SAMURAI);

                // Image bgImg = new ImageData("backgrounds/juggernautWood.jpeg",
                // /Users/rio/Desktop/games dev/ages-of-war-II/images/backgrounds/japan hometown
                // 0-2.png
                Image bgImg = new ImageData("backgrounds/samurai_bg.png",
                                MainUI.getInstance().getWidth(),
                                (int) MainGame.getInstance().getPreferredSize().getHeight() + 50).getSprite();
                setBackgroundImage(bgImg);

                CharacterPrototype[] cps = {
                                new SamuraiFlag(TeamType.PLAYER),
                                new SamuraiSword(TeamType.PLAYER),
                                new SamuraiArcher(TeamType.PLAYER),
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

                // /Users/rio/Desktop/games dev/ages-of-war-II/images/tower/japan tower on 1.png
                ImageData towerImgData = new ImageData(
                                "tower/japan tower on  1.png", 116, 228);
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
