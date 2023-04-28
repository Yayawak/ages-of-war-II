package srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.HealingDrone;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Ghost extends CharacterPrototype {
    public Ghost(TeamType tt) {
        super(tt);
        Dimension size = new Dimension(75, 75);
        ImageData img = new ImageData(
"characters/cyberAge/ghost/walk/ghost-walk_03.png" , size
        );
        setName("Ghost");
        setExperiance(300);
        setGold(250);
        setMaxHp(500);
        // setMovementSpeed(4);
        setMovementSpeed(0.5f);
        // setMovementSpeed(2);
        // setAttackSpeed(1);
        // setAttackSpeed(7);
        setAttackSpeed(8);
        // setAttackSpeed(10);
        // setAttackSpeed(9);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(2);
        setAttackRange(1000);
        // setAttackDamage(50);
        // setAttackDamage(20);
        setAttackDamage(4);
        // setAttackDamage(1);

        setWalkSprites(SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/ghost/walk"
        ));
        setAttackASprites(SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/ghost/shoot"
            // , 150, 150
            // , 50, 50
            , size
        ));
        // initThreadChecker();
    }


}
