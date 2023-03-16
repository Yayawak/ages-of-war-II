package srcs.Systems.EnemySystem;

import java.awt.Graphics;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import srcs.Enums.TeamType;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Prototypes.Characters.CharactersData.CharLists.Age_I.Morphling;
import srcs.Prototypes.Characters.CharactersData.CharLists.Age_I.NatureProphet;
import srcs.Prototypes.Characters.CharactersData.CharLists.Age_I.Rubick;
import srcs.Systems.Gold.GoldSystem;
import srcs.Systems.integratedSystem.IntegratedSystem;
import srcs.UI.mainGame.MainGame;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import srcs.UI.mainGame.SubScene.GameObject.Character.CharacterGObject;

import java.awt.Color;

public class EnemyIntegratedSystem implements Loopable {
    private static EnemyIntegratedSystem instance;
    private GoldSystem enemyGoldSystem;
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
    }

    @Override
    public void update() {
        enemyGoldSystem = IntegratedSystem.getInstance().getEnemyGoldSystem();
        // System.out.println("enemy start loop");
        try {
            Thread.sleep(100);
            // Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e);
        }
        // System.out.println("Enemy Gold = " + enemyGoldSystem.getGold());

        if (enemyGoldSystem.getGold() > 0) {
            // int ranI = (int)(Math.random() * 4);
            // CharacterGObject cgo =
            // (CharacterGObject)currentAvailableCharacters.get(ranI).copy();
            // cgo.getCharacter().setTeam(TeamType.ENEMY);
            // MainGame.getObjectsInScene().add(cgo);

            // * it's Work
            CharacterPrototype dummy = new Morphling(TeamType.ENEMY);
            dummy.setTeamType(TeamType.ENEMY);
            CharacterGObject c = new CharacterGObject(dummy);
            // todo : make this enemy system usable
            MainGame.getInstance().addGameObjectToScene(c);
            enemyGoldSystem.decreasedGold(c
                    .getCharacter().getGold());

            // MainGame.getObjectsInScene().add()
        } else {
            // enemyGoldSystem.setGold(1000);
        }
    }

    @Override
    public void draw(Graphics g) {
    }
}
