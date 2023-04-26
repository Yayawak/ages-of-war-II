package srcs.Prototypes;

import helpers.ImageData;
import srcs.Enums.TeamType;
import srcs.GameUI.MainUI;
import srcs.StateMachine.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class EntityPrototype {
    protected State state;
    protected TeamType teamType = TeamType.PLAYER;
    // protected int attackSpeed;
    // protected int attackSpeed;
    protected float attackSpeed;
    protected ImageData imgData;
    protected String name;
    protected int gold;
    protected Point position;
    protected float buildTime;
    protected int attackRange;
    protected int attackDamage;
    // protected ArrayList<Image> walkSprites = new ArrayList<>();
    // protected LinkedList<Image> walkSprites = new LinkedList<>();
    // protected LinkedList<Image> attackASprites = new LinkedList<>();
    protected List<Image> walkSprites = new LinkedList<>();
    protected List<Image> attackASprites = new LinkedList<>();
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

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
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

    @Override
    public String toString() {
        return "EntityPrototype [teamType=" + teamType + ", attackSpeed=" + attackSpeed + ", imgData=" + imgData
                + ", name=" + name + ", gold=" + gold + ", position=" + position + ", buildTime=" + buildTime
                + ", attack damage is " + attackDamage
                + "]";
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public long getAttackRateInMillisec() {
        // return (long)(getAttackSpeed() * 25.0f + 100);
        // return (long)(getAttackSpeed() / 25.0f + 300);
        // return (long)(getAttackSpeed() / 25.0f + 300);
        // ? from range atkSpd = [0 -> 10 unit]
        // * range of attack per sec is [0.5sec -> 2sec]
        // ? want average is 1000
        // * use mapping function y = 1000 + (100x - 500)
        // return (long)(100 * getAttackSpeed() + 1000);
        // return (long)(100 * getAttackSpeed() + 300);
        // return (long)(1000 + (100 * getAttackSpeed() - 300));
        // * use mapping function y = -190x + 2000
        return (long)((-190) * getAttackSpeed() + 2000);
        // return (long)(getAttackSpeed() / 25.0f);
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    // public LinkedList<Image> getWalkSprites() {
    public List<Image> getWalkSprites() {
        return walkSprites;
    }

    public void setWalkSprites(LinkedList<Image> walkSprites) {
        this.walkSprites = walkSprites;
    }

    // public LinkedLis<Image> getAttackASprites() {
    public List<Image> getAttackASprites() {
        return attackASprites;
    }

    // public void setAttackASprites(LinkedList<Image> attackASprites) {
    public void setAttackASprites(java.util.List<Image> attackASprites) {
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
