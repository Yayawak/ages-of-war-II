package srcs.UI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import srcs.Characters.CharactersData.CharactersData;
import srcs.Characters.CharactersData.CharLists.NatureProphet;
import srcs.UI.mainGame.SubScene.GameObject.CharacterGObject;
import srcs.UI.mainGame.SubScene.GameObject.GameObject;
import srcs.interfaces.ComponentSizeItf;
import srcs.interfaces.Loopable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.function.ObjIntConsumer;

import javax.swing.GroupLayout;
import helpers.ImageData;
import java.awt.image.*;
import java.awt.event.*;
import srcs.Characters.*;
import srcs.Characters.Character;;

public class MainGame extends JPanel implements ComponentSizeItf,
    Loopable
{
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

        GroupLayout mainGameLayout = new GroupLayout(this);
        setLayout(mainGameLayout);
        mainGameLayout.setHorizontalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        mainGameLayout.setVerticalGroup(
            mainGameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Character np = new NatureProphet();
                np.setPosition(getMousePosition());
                GameObject go = new CharacterGObject(np);
                objectsInScene.add(go);
                System.out.println("Enter main game mouse clicked.");
            }
        });
    }



    private void drawBg(Graphics g) {
        String imagePath = "backgrounds/aow_bg.png";
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
                    this
                );
            } else {
                System.out.println("SceneObject is null");
            }
        });
    }

    @Override //! loop but why
    public void paintComponent(Graphics g) {
    // public void draw(Graphics g) {
        super.paintComponent(g);
        drawBg(g);
        drawGameObjects(g);
    }

    // todo : recieve data from event mouse click
    public void addGameObjectToScene(GameObject go) {
        objectsInScene.add(go);
    }

    @Override
    public void update() {
        // System.out.println("update from MainGame");
        objectsInScene.forEach(obj -> {
            if (obj != null)
                obj.update();
        });
    }

    @Override
    public void draw(Graphics g) {
        objectsInScene.forEach(obj -> {
            if (obj != null)
                obj.draw(g);
        });
        // new CharacterGObject()
        // drawOnMainGame(g);
    }

    public static ArrayList<GameObject> getObjectsInScene() {
        return objectsInScene;
    }

    public static void setObjectsInScene(ArrayList<GameObject> objectsInScene) {
        MainGame.objectsInScene = objectsInScene;
    }
}
