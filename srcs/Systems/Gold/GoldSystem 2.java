package srcs.Systems.Gold;

public class GoldSystem {
    private int gold;

    public GoldSystem(int startGold) {
        gold = startGold;
    }

    public void increasedGold(int amount) { // kill enemies
        gold += amount;
    }

    public void decreasedGold(int amount) { // buy or upgrade sth
        gold -= amount;
        if (gold < 0) {
            restartGold();
        }
    }

    public void restartGold() { // restart game
        gold = 0;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
