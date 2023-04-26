package srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge;

import java.awt.Image;
import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.HealingDrone;
import srcs.Prototypes.Characters.CharacterPrototype;

public class Howell extends CharacterPrototype {
    private int healAmountPerTick = 40;
    private HealingDrone healingDrone = null;
    public Howell(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
"characters/cyberAge/howell/walk/walk_03.png"
        );
        setName("Howell");
        setExperiance(200);
        setGold(150);
        setMaxHp(1000);
        // setMovementSpeed(4);
        setMovementSpeed(1);
        // setMovementSpeed(2);
        // setAttackSpeed(1);
        setAttackSpeed(10);
        // setTeam(teamType);
        setImgData(img);
        setBuildTime(2);
        setAttackRange(300);
        // setAttackDamage(50);
        // setAttackDamage(20);
        // setAttackDamage(1);
        setAttackDamage(2);

        setWalkSprites(SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/howell/walk"
        ));
        setAttackASprites(SpritesInstallator.getSpritesInFolder(
"characters/cyberAge/howell/whiping atk",
        // 200, 250
        // 100, 50
        150, 150
        ));
        initThreadChecker();
    }
    private void initThreadChecker() {
        new Thread(() -> {
            while (true) {
                initChecker();
            }
        }).start();
    }

    private void initChecker() {
        // long cooldown = 5000l;
        float cooldownSec = 9f;
        // if (cooldownSec )
        while (cooldownSec > 0) {
            try { Thread.sleep(1000); } catch (Exception e) { }
            cooldownSec -= 1.f;
        }
        callHealingDrone();
        // if (getHp() < getMaxHp() * 0.7f) {

        // }
    }

    // public void healTeam(CharacterGObject teammateToHeal) {
    // public void healTeam(CharacterPrototype teammateToHeal) {
    // public void healTeam(CharacterPrototype teammateToHeal) {
    // public void callHealingDrone(CharacterPrototype teammateToHeal) {
    public void callHealingDrone() {
        healingDrone = new HealingDrone(teamType, healAmountPerTick);
        MainGame.getInstance().addGameObjectToScene(healingDrone);
        // teammateToHeal.getCharacter().increaseHp(healAmount);
        // if (teammateToHeal.getHp() <= teammateToHeal.getMaxHp()) {
        //     teammateToHeal.increaseHp(healAmount);
        // }
    }

    public int getHealAmountPerTick() {
        return healAmountPerTick;
    }

    public void setHealAmountPerTick(int healAmountPerTick) {
        this.healAmountPerTick = healAmountPerTick;
    }
    public HealingDrone getHealingDrone() {
        return healingDrone;
    }

}
