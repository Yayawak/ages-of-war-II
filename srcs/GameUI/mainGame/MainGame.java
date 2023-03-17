package srcs.GameUI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;
import srcs.Interfaces.ComponentSizeItf;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.NatureProphet;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretsData;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;

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


        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // CharacterPrototype np = new NatureProphet(TeamType.PLAYER);
                // np.setPosition(getMousePosition());
                // GameObject go = new CharacterGObject(np);
                // objectsInScene.add(go);
                // System.out.println("Enter main game mouse clicked.");
                FireGunTurret fgt = new FireGunTurret();
                fgt.setPosition(getMousePosition());
                TurretGObject turret = new TurretGObject(fgt);
                turret.setLocation(getMousePosition());
                objectsInScene.add(turret);
            }
        });
    }

    private void drawBg(Graphics g) {
        String imagePath = "backgrounds/dirtbackground.png";
        // String imagePath = "backgrounds/war_bg.jpeg";
        ImageData imgData = new ImageData(imagePath, getWidth(), getHeight());
        Image sprite = imgData.getSprite();
        g.drawImage(sprite, 0, 0, this);
    }

    // ! bug on start game when first clicked happend delay for 5 sec
    private void drawGameObjects(Graphics g) {
        try {
            objectsInScene.stream().forEach(obj -> {
                if (obj != null) {
                    g.drawImage(obj.getImg(),
                            obj.getX(), obj.getY(),
                            this);
                } else {
                    System.out.println("SceneObject is null");
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override // ! loop but why
    public void paintComponent(Graphics g) {
        // public void draw(Graphics g) {
        super.paintComponent(g);
        // System.out.println("Paint component from MainGame");
        drawBg(g);
    // ? bug on start game when first clicked happend delay for 5 sec
        // ! FOR DRAW ()
        drawGameObjects(g);
        // ! identical 1.
        // ! UPDATE ALL MOVING GRAPHICS IN GAME (FOR MOVE)
        try {
            objectsInScene.forEach(obj -> {
                if (obj != null)
                    obj.draw(g);
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        draw(g);
    }

    // todo : recieve data from event mouse click
    public void addGameObjectToScene(GameObject go) {
        objectsInScene.add(go);
    }

    @Override
    public void update() {
        // System.out.println("update from MainGame");
        // System.out.println(Math.random());
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

    public ArrayList<GameObject> getObjectsInScene() {
        return objectsInScene;
    }

    public void setObjectsInScene(ArrayList<GameObject> objectsInScene) {
        MainGame.objectsInScene = objectsInScene;
    }

    public void removeGameObjectFromScene(GameObject go) {
        try {
            objectsInScene.remove(go);
        } catch (Exception e) { System.out.println(e);
        }
    }
}
