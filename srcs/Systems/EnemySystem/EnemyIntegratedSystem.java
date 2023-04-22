package srcs.Systems.EnemySystem;

import java.awt.Graphics;
import java.awt.Point;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonWarrior;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.Morphling;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.NatureProphet;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.Rubick;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Systems.AgeSystem.AgeList.SkeletonAge;
import srcs.Systems.AgeSystem.AgeList.StoneAge;
import srcs.Systems.Exp.ExpSystem;
import srcs.Systems.Gold.GoldSystem;
import srcs.Systems.TowerSystem.TowerSystem;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.Color;

public class EnemyIntegratedSystem implements Loopable {
    private static EnemyIntegratedSystem instance;
    private GoldSystem enemyGoldSystem;
    private ExpSystem enemyExpSystem;
    private TowerSystem enemyTowerSystem;
    private ArrayList<GameObject> currentAvailableCharacters
    // private List<CharacterGObject> currentAvailableCharacters
            = new ArrayList<>();

    public static EnemyIntegratedSystem getInstance() {
        if (instance == null)
            instance = new EnemyIntegratedSystem();
        return instance;
    }

    public EnemyIntegratedSystem() {
        startSystem();
    }

    private void startSystem() {
        enemyGoldSystem = IntegratedSystem.getInstance().getEnemyGoldSystem();
        enemyExpSystem = IntegratedSystem.getInstance().getEnemyExpSystem();
        // currentAvailableCharacters = CharactersData.getInstance().
        // getCharactersList().stream().map(cData -> new CharacterGObject(cData))
        // .collect(Collectors.toList());
        CharactersData.getInstance().getCharactersList()
            .forEach(character -> {
                GameObject go = new CharacterGObject(character);
                currentAvailableCharacters.add(go);
            });
        // currentAvailableCharacters.forEach(cgo -> {
        // GameObject go = new CharacterGObject(character);
        // });
        // new Thread(()).start();
        // new Thread(new Runnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                periodicChecker();
            }
        }).start();

        enemyTowerSystem = IntegratedSystem.getInstance().getEnemyTowerSystem();
        TurretPrototype initialEnemyTurret =  new FireGunTurret();
        initialEnemyTurret.setTeamType(TeamType.ENEMY);
        enemyTowerSystem.getTowerPrototype().setTurretBelow(
            new TurretGObject(initialEnemyTurret)
            // new FireGunTurret()
        );
    }

    private void periodicChecker() {
        // int spawnEnemyIntervalInMs = 2000;
        // int spawnEnemyIntervalInMs = 1000 / 2;
        int spawnEnemyIntervalInMs = 800;
        // int spawnEnemyIntervalInMs = 1000;
        while (true) {
            try {
                Thread.sleep(spawnEnemyIntervalInMs);
                if (enemyGoldSystem.getGold() > 0) {
                    int ranI = (int)(Math.random() * 4);
                    // CharacterPrototype dummy = SkeletonAge.getInstance().getCharacterPrototypes().get(ranI);
                    CharacterPrototype dummy = IntegratedSystem.getInstance()
                        .getCurrentEnemyAgeData()
                        .getCharacterPrototypes().get(ranI).getClass()
                        .getDeclaredConstructor(TeamType.class)
                        .newInstance(TeamType.ENEMY);
                    dummy.setPosition(new Point(1500, 300));
                    CharacterGObject c = new CharacterGObject(dummy);
                    // todo : make this enemy system usable
                    MainGame.getInstance().addGameObjectToScene(c);
                    enemyGoldSystem.decreasedGold(c
                            .getCharacter().getGold());

                } else {
                    // enemyGoldSystem.setGold(1000);
                }
            } catch (Exception e) { }
        }
    }

    @Override
    public void update() {
        if (
            IntegratedSystem.getInstance()
                .getCurrentEnemyAgeData().getNextAgeData() != null
            &&
            enemyExpSystem.getExperiance() >
                IntegratedSystem.getInstance()
                .getCurrentEnemyAgeData().getExpRequiredToUpgrade()
        ) {
            // sout
            // System.out.println("try to upgrade enemy age");
            IntegratedSystem.getInstance().upgradeAge(TeamType.ENEMY);
        }
    }

    @Override
    public void draw(Graphics g) {
    }
}
