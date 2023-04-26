package srcs.Systems.AgeSystem.AgeList;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.sound.midi.Track;
import helpers.ImageData;
import srcs.Enums.AgeType;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.GameUI.mainGame.MainGame;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.Interfaces.Animatable;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonArcher;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonSpear;
import srcs.Prototypes.Characters.CharactersData.CharLists.SkeletonAge.SkeletonWarrior;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.*;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;
import srcs.Systems.AgeSystem.AgeData;

class HandGrapperGobj extends GameObject {
// class HandGrapper extends GameObject implements Animatable {
    List<Image> handFrames;
    // LinkedList<Image> handFrames;
    // frames
    // public HandGrapper(Image img, Point pos, Dimension imgSize, List<Image> frames) {
    public HandGrapperGobj(Image img, Point pos, Dimension imgSize, List<Image> frames,
        TeamType team
    ) {
        super(img, pos, imgSize);
        this.handFrames = frames;
        this.teamType = team;
        initAnimation();
    }

    private void initAnimation() {
        new Thread(() -> {
            long animationSpeed = 150;
            int i = 0;
            while (true) {
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < handFrames.size()) {
                    setImg(handFrames.get(i));
                    // todo : random spawn x OR kill random enemy OR gradullay damage closest gobj
                    // * 1. create hand entitiy class for using in findClosestCharacter()
                    // * 2. get closest enemy
                    // * 3. spawn hands at enemy below position

                    CharacterGObject foe = findClosestOpponent();
                    setPos(foe.getPos());
                    // damager = foe;
                    // setPos(

                        // new Point(
                        //     (int)Math.random() * 200,
                        //     (int)Math.random() * 40
                        // )
                    // );
                } else {
                    i = 0;
                    continue;
                }
                // if (findClosestOpponent(attacker))
                i++;
            }
        }).start();
    }
}
public class SkeletonAge extends AgeData {
    private static SkeletonAge instance;
    private List<Image> handGrapperImages;
    public static SkeletonAge getInstance() {
        if (instance == null) instance = new SkeletonAge();
        return instance;
    }
    public SkeletonAge() {
        setNextAgeData(StoneAge.getInstance());
        setAgeType(AgeType.SKELETON);
        Image bgImg = new ImageData("backgrounds/dirtAge.png",
            MainUI.getInstance().getWidth(),
            (int)MainGame.getInstance().getPreferredSize().getHeight() + 50
        ).getSprite();
        setBackgroundImage(bgImg);

        CharacterPrototype[] cps = {
            // new GrimStroke(TeamType.PLAYER),
            new SkeletonWarrior(TeamType.PLAYER),
            new SkeletonArcher(TeamType.PLAYER),
            new SkeletonSpear(TeamType.PLAYER),
            new Morphling(TeamType.PLAYER)
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

        // /Users/rio/Desktop/games dev/ages-of-war-II/images/tower/skeleton based  0.png
        ImageData towerImgData = new ImageData(
                // "tower/tower1.png",
                "tower/skeleton based  0.png",
                // 116, 228
                // 150, 200
                200, 275
        );
        TowerPrototype towerPrototype = new TowerPrototype(
            1000,
            TeamType.PLAYER,
            null,
            null,
            towerImgData,
            // new Point(50, 210)
            new Point(50, 150)
        );
        setTowerPrototype(towerPrototype);
        setExpRequiredToUpgrade(1000);
        setUpgradeImage(
            new ImageData(
                "upgradeIcons/stoneAgeUp.png"
            ).getSprite()
        );

        handGrapperImages = new LinkedList<>();
        for (int i = 3; i < 13; i++) {
            // String path = "effects/green hands/green-hand-hell_03.png";
            String prefix = (i < 10) ? "0" : "";
            String path = "effects/green hands/green-hand-hell_" +
                prefix +
                String.valueOf(i) +
                ".png";
            // String path =;
            handGrapperImages.add(
                new ImageData(path).getSprite()
            );
        }
        //todo : create game hand object and can damger opponent !!!!!
    }

    @Override
    public void useUltimate(TeamType team) {
        System.out.println("ultimate in skeleton age is called.");
        MainGame.getInstance().addGameObjectToScene(getNewHandGrapperGobj());
    }

    public HandGrapperGobj getNewHandGrapperGobj() {
        return new HandGrapperGobj(
            new ImageData("effects/green hands/hand-from-ground.png").getSprite(),
            new Point(400, 200),
            new Dimension(30, 40),
            handGrapperImages,
            TeamType.PLAYER
        );
    }
}
