package srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge;

import java.awt.Image;
import java.awt.Point;

import helpers.ImageData;
import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.HealingDrone;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.IcebergEffect;
import srcs.Prototypes.EntityPrototype;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.StateMachine.State;

public class Kula extends CharacterPrototype {
    IcebergEffect icebergEffect;
    public Kula(TeamType tt) {
        super(tt);
        ImageData img = new ImageData(
"characters/cyberAge/kula/ice/kula-ice_03.png"
        );
        setName("Kula");
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
        setAttackRange(700);
        // setAttackDamage(50);
        // setAttackDamage(20);
        // setAttackDamage(1);
        // setAttackDamage(2);
        setAttackDamage(4);

        setWalkSprites(SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/kula/walk"
        ));
        setAttackASprites(SpritesInstallator.getSpritesInFolder(
    "characters/cyberAge/kula/summoning-ice",
        // 200, 250
        // 100, 50
        150, 150
        ));
        icebergEffect = new IcebergEffect();
        icebergEffect.setVisible(false);
        // initThreadChecker();
        MainGame.getInstance().addGameObjectToScene(icebergEffect);
    }
    // private void initThreadChecker() {
    //     new Thread(() -> {
    //         while (true) {
    //             initChecker();
    //         }
    //     }).start();
    // }

    // private void initChecker() {
    private void initChecker() {
        // if (getState() == State.ATTACK) {
        // if (getState() == State.ATTACK && icebergEffect != null) {
        //     Point foePos = MainGame.getInstance().getRandomCharacterGameObjectFromTeam(TeamType.ENEMY)
        //         .getPos();
        //     icebergEffect.setPos(foePos);
        // }
        // skill1();
    }

    @Override
    protected void attack1St() {
        super.attack1St();
        // icebergEffect.setPos();
    }

    // iceberg attack
    // public void normalAttack(GameObject enemy) {
    public void normalAttack(EntityPrototype enemy) {
        // this.skillName = skillName
        // System.out.println("kula normal attack");
        icebergEffect.setVisible(true);
        icebergEffect.setPos(enemy.getPosition());
    }
    // private void skill1() {
    //     // long cooldown = 5000l;
    //     float cooldownSec = 9f;
    //     // if (cooldownSec )
    //     while (cooldownSec > 0) {
    //         try { Thread.sleep(1000); } catch (Exception e) { }
    //         cooldownSec -= 1.f;
    //     }
    //     // callHealingDrone();

    // }

}
