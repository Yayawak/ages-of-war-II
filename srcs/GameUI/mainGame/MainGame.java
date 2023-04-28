package srcs.GameUI.mainGame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.Debugger.DebugPanel;
import srcs.GameUI.mainGame.Debugger.DebugPanelDepreicated;
import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.HealingDrone;
import srcs.GameUI.mainGame.SubScene.GameObject.Effects.LightningStrikeEffect;
import srcs.GameUI.mainGame.SubScene.GameObject.Tower.TowerGameObject;
import srcs.GameUI.mainGame.SubScene.GameObject.Turret.TurretGObject;
import srcs.Interfaces.ComponentSizeItf;
import srcs.Interfaces.Loopable;
import srcs.Prototypes.Characters.*;
import srcs.Prototypes.Characters.CharactersData.CharactersData;
import srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge.Ghost;
import srcs.Prototypes.Characters.CharactersData.CharLists.CyberAge.GhostGameObject;
import srcs.Prototypes.Characters.CharactersData.CharLists.StoneAge.NatureProphet;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;
import srcs.Prototypes.Turrets.TurretsData;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Systems.Tooltips.DebugTooltip;
import srcs.Systems.integratedSystem.IntegratedSystem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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
                if (SwingUtilities.isLeftMouseButton(e)) {
                    System.out.println("left mouse");
                    DebugTooltip.getInstance().setVisible(false);

                    // GhostGameObject ghost = new GhostGameObject(TeamType.PLAYER);
                    // GhostGameObject ghost = new GhostGameObject(new Ghost(TeamType.PLAYER));
                    // ghost.setPos(getMousePosition());
                    // addGameObjectToScene(ghost);

                    // HealingDrone hd = new HealingDrone(TeamType.PLAYER);
                    // hd.setPos(getMousePosition());
                    // addGameObjectToScene(hd);

                } else {
                    System.out.println("right mouse");
                    DebugTooltip.getInstance().setVisible(true);
                    // DebugTooltip.getInstance().setLocation( getMousePosition());
                    DebugTooltip.getInstance().setLocation(
                        (int)getMousePosition().getX(),
                        (int)(getMousePosition().getY() + DebugTooltip.getInstance().getHeight())
                    );
                }
            }
        });

        setLayout(null);
        add(DebugPanel.getInstance());
    }

    private void drawBg(Graphics g) {
        Image bgSprite = IntegratedSystem.getInstance().getCurrentPlayerAgeData()
            .getBackgroundImage();
        g.drawImage(bgSprite, 0, 0,
            // getWidth(), getHeight(),
        this);
    }

    // ! bug on start game when first clicked happend delay for 5 sec
    private void drawGameObjects(Graphics g) {
        // try {
        try {
            objectsInScene.stream().forEach(obj -> {
                if (obj != null) {
                    g.drawImage(obj.getImg(),
                            obj.getX(), obj.getY(),
                            this);
                } else {
                    // System.out.println("SceneObject is null");
                }
            });
        } catch (Exception e) { }
        // } catch (Exception e) {
            // System.out.println(e);
        // }
    }

    @Override // ! loop but why
    public void paintComponent(Graphics g) {
        // public void draw(Graphics g) {
        super.paintComponent(g);
        // System.out.println("Paint component from MainGame");
        try { drawBg(g); } catch (Exception e) { }
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
        // } catch (Exception e) { System.out.println(e); }
        } catch (Exception e) {}
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
                obj.update();
            });
        } catch (Exception e) { }
        // objectsInScene.forEach(obj -> {
        //     new Thread(() -> {
        //         obj.update();
        //     }).start();
        // });

        // try {
        //     new Thread(
        //         () -> {
        //             objectsInScene.forEach(obj -> {
        //                 new Thread(() -> {
        //                     obj.update();
        //                 }).start();
        //             });
        //         }
        //     ).start();
        // } catch (Exception e) { System.out.println(e); }
        // } catch (Exception e) {}
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
        // } catch (Exception e) { System.out.println(e); }
        } catch (Exception e) {}
    }

    public List<GameObject> getGameObjectsFromTeam(TeamType team) {
        return getObjectsInScene().stream().filter(go -> go.getTeamType() == team).toList();
    }

    public List<CharacterGObject> getCharacterGameObjectsFromTeam(TeamType team) {
        return getObjectsInScene().stream().filter(go ->
            go.getTeamType() == team
            &&  go instanceof CharacterGObject
        ).map(go -> (CharacterGObject)go)
        .toList();
    }

    public CharacterGObject getRandomCharacterGameObjectFromTeam(TeamType team) {
        int size = getCharacterGameObjectsFromTeam(team).size();
        // System.out.println("size " + size);
        return getCharacterGameObjectsFromTeam(team).get((int)(Math.random() * size));
    }
}
