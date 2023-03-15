package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.Interfaces.ComponentSizeItf;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Prototypes.Characters.CharactersData.CharLists.Age_I.NatureProphet;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretsData;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.UI.mainGame.SubScene.GameObject.CharacterGObject;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import srcs.UI.mainGame.SubScene.GameObject.TowerGameObject;
import srcs.UI.topBar.turretsBox.SingleTurret.TurretGObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.function.ObjIntConsumer;

import javax.imageio.stream.FileImageInputStream;
import javax.swing.GroupLayout;
import helpers.ImageData;
import java.awt.image.*;
import java.awt.event.*;;

public class MainGame extends JPanel implements ComponentSizeItf,
        Loopable {
    private static MainGame instance = null;
    private static ArrayList<GameObject> objectsInScene = new ArrayList<>();

    public static MainGame getInstance() {
        if (instance == null)
            instance = new MainGame();
        return instance;
    }

    private MainGame() {
        init();
    }

    private void init() {
        setBackground(new Color(242, 42, 242));
        setForeground(new Color(100, 0, 0));
        setPreferredSize(new Dimension(625, 400));

        // GroupLayout mainGameLayout = new GroupLayout(this);
        // setLayout(mainGameLayout);
        // mainGameLayout.setHorizontalGroup(
        // mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        // .addGap(0, 625, Short.MAX_VALUE));
        // mainGameLayout.setVerticalGroup(
        // mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        // .addGap(0, 297, Short.MAX_VALUE));

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // CharacterPrototype np = new NatureProphet(TeamType.PLAYER);
                // np.setPosition(getMousePosition());
                // GameObject go = new CharacterGObject(np);
                // objectsInScene.add(go);
                // System.out.println("Enter main game mouse clicked.");
                FireGunTurret fgt = new FireGunTurret(TeamType.PLAYER);
                fgt.setPosition(getMousePosition());
                TurretGObject turret = new TurretGObject(fgt);
                turret.setLocation(getMousePosition());
                objectsInScene.add(turret);
            }
        });
        ImageData towerImgData = new ImageData("tower/tower1.png", 116, 228);
        TowerPrototype playerTowerPrototype = new TowerPrototype(1000, TeamType.PLAYER,
                null, null, towerImgData, new Point(50, 210));
        TowerGameObject playerTowerGameObject = new TowerGameObject(playerTowerPrototype);
        objectsInScene.add(playerTowerGameObject);
    }

    private void drawBg(Graphics g) {
        String imagePath = "backgrounds/dirtbackground.png";
        // String imagePath = "backgrounds/war_bg.jpeg";
        ImageData imgData = new ImageData(imagePath, getWidth(), getHeight());
        Image sprite = imgData.getSprite();
        g.drawImage(sprite, 0, 0, this);
    }

    private void drawGameObjects(Graphics g) {
        objectsInScene.stream().forEach(obj -> {
            if (obj != null) {
                g.drawImage(obj.getImg(),
                        obj.getX(), obj.getY(),
                        this);
            } else {
                System.out.println("SceneObject is null");
            }
        });
    }

    @Override // ! loop but why
    public void paintComponent(Graphics g) {
        // public void draw(Graphics g) {
        super.paintComponent(g);
        // System.out.println("Paint component from MainGame");
        drawBg(g);
        drawGameObjects(g);
        // ! identical 1.
        objectsInScene.forEach(obj -> {
            if (obj != null)
                obj.draw(g);
        });
        // draw(g);
    }

    // todo : recieve data from event mouse click
    public void addGameObjectToScene(GameObject go) {
        objectsInScene.add(go);
    }

    @Override
    public void update() {
        // System.out.println("update from MainGame");
        try {
            objectsInScene.forEach(obj -> {
                if (obj != null)
                    obj.update();
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void draw(Graphics g) {
        // ! identical 2.
        // objectsInScene.forEach(obj -> {
        // if (obj != null)
        // obj.draw(g);
        // });
    }

    public static ArrayList<GameObject> getObjectsInScene() {
        return objectsInScene;
    }

    public static void setObjectsInScene(ArrayList<GameObject> objectsInScene) {
        MainGame.objectsInScene = objectsInScene;
    }
}
