package srcs.Prototypes;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.UI.MainUI;

import java.awt.*;;

public class EntityPrototype {
    protected TeamType teamType = TeamType.PLAYER;
    protected int attackSpeed;
    protected ImageData imgData;
    protected String name;
    protected int gold;
    protected Point position;
    protected float buildTime;
    protected EntityPrototype copyInstance;

    public EntityPrototype(EntityPrototype entProt) {
        init();
    }

    public EntityPrototype(TeamType teamType) {
        this.teamType = teamType;
        init();
    }

    public EntityPrototype(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            float buildTime) {
        this.teamType = teamType;
        this.attackSpeed = attackSpeed;
        this.imgData = imgData;
        this.name = name;
        this.gold = gold;
        this.position = position;
        this.buildTime = buildTime;
        init();
    }

    public EntityPrototype getCopyInstance() {
        if (copyInstance == null)
            copyInstance = new EntityPrototype(this);
        return copyInstance;
    }

    private void init() {
        int spawnX = (teamType == TeamType.PLAYER) ? 0 : (int) MainUI.getInstance().getScreenSize().getWidth();
        if (position == null) {
            position = new Point();
        }
        this.position = new Point(spawnX, position.y);

    }

    public TeamType getTeamType() {
        return teamType;
    }

    public void setTeamType(TeamType teamType) {
        this.teamType = teamType;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public ImageData getImgData() {
        return imgData;
    }

    public void setImgData(ImageData imgData) {
        this.imgData = imgData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public float getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(float buildTime) {
        this.buildTime = buildTime;
    }

    public void setCopyInstance(EntityPrototype copyInstance) {
        this.copyInstance = copyInstance;
    }

}
