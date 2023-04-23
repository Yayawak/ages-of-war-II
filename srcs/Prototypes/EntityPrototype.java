package srcs.Prototypes;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.StateMachine.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class EntityPrototype {
    protected State state;
    protected TeamType teamType = TeamType.PLAYER;
    // protected int attackSpeed;
    protected int attackSpeed;
    protected ImageData imgData;
    protected String name;
    protected int gold;
    protected Point position;
    protected float buildTime;
    protected EntityPrototype copyInstance;
    protected int attackRange;
    protected int attackDamage;
    // protected ArrayList<Image> walkSprites = new ArrayList<>();
    protected LinkedList<Image> walkSprites = new LinkedList<>();
    protected ArrayList<Image> attackASprites = new ArrayList<>();
    protected int hp;
    protected int maxHp;

    public EntityPrototype(EntityPrototype entProt) {
        init();
    }

    public EntityPrototype() {
        init();
    }

    public EntityPrototype(TeamType teamType) {
        this.teamType = teamType;
        init();
    }

    public EntityPrototype(TeamType teamType, int attackSpeed, ImageData imgData, String name, int gold, Point position,
            // float buildTime, EntityPrototype copyInstance, int attackRange, int attackDamage) {
            float buildTime, int attackRange, int attackDamage) {
        this.teamType = teamType;
        this.attackSpeed = attackSpeed;
        this.imgData = imgData;
        this.name = name;
        this.gold = gold;
        this.position = position;
        this.buildTime = buildTime;
        this.attackRange = attackRange;
        this.attackDamage = attackDamage;
    }

    public EntityPrototype getCopyInstance() {
        if (copyInstance == null)
            copyInstance = new EntityPrototype(this);
        return copyInstance;
    }

    private void init() {
        state = State.MOVE;
        int spawnX = (teamType == TeamType.PLAYER) ?
            200 :
            // (int) MainUI.getInstance().getScreenSize().getWidth()
            (int) MainUI.getInstance().getScreenSize().getWidth() - 200;
        if (position == null) {
            position = new Point();
        }
        // this.position = new Point(spawnX, position.y);
        this.position = new Point(spawnX, 300);

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

    @Override
    public String toString() {
        return "EntityPrototype [teamType=" + teamType + ", attackSpeed=" + attackSpeed + ", imgData=" + imgData
                + ", name=" + name + ", gold=" + gold + ", position=" + position + ", buildTime=" + buildTime
                + ", copyInstance=" + copyInstance + "]";
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public long getAttackRateInMillisec() {
        return (long)(getAttackSpeed() * 25.0f + 100);
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public LinkedList<Image> getWalkSprites() {
        return walkSprites;
    }

    public void setWalkSprites(LinkedList<Image> walkSprites) {
        this.walkSprites = walkSprites;
    }

    public ArrayList<Image> getAttackASprites() {
        return attackASprites;
    }

    public void setAttackASprites(ArrayList<Image> attackASprites) {
        this.attackASprites = attackASprites;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > this.maxHp) {
            hp = this.maxHp;
        }
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        setHp(maxHp);
    }


    public void decreaseHp(int amount) {
        // int currentHp = cgo.getCharacter().getHp();
        // cgo.getCharacter().setHp(
            // currentHp - amount
        // );
        setHp(getHp() - amount);
    }

    public void increaseHp(int amount) {
        // int currentHp = cgo.getCharacter().getHp();
        // cgo.getCharacter().setHp( currentHp + amount);
        setHp(getHp() + amount);
    }

}
