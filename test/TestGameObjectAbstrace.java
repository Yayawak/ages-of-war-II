package test;

public abstract class TestGameObjectAbstrace {
    private boolean isGameObjectDied = false;
    public TestGameObjectAbstrace() {
        start();
    }

    protected void start() {
        new Thread(() -> {
            while (!isGameObjectDied) {
                update();
            }
        }).start();
    }
    protected abstract void update();

    protected void destroyGameObject() {
        setGameObjectDied(true);
    }

    public boolean getIsGameObjectDied() {
        return isGameObjectDied;
    }

    public void setGameObjectDied(boolean isGameObjectDied) {
        this.isGameObjectDied = isGameObjectDied;
    }
}

class BirdTestGameObject extends TestGameObjectAbstrace {

    private String name;
    public BirdTestGameObject(String name) {
        super();
        this.name = name;
    }
    @Override
    protected void update() {
        System.out.println("This is bird named : " + name);
    }

}

class Caller {
    public static void main(String[] args) {
        BirdTestGameObject b1 = new BirdTestGameObject("tanjiro");
        BirdTestGameObject b2= new BirdTestGameObject("bananim");

        try { Thread.sleep(3000); } catch (Exception e) { System.out.println(e); }
        b1.destroyGameObject();
    }
}
