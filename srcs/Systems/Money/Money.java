package srcs.Systems.Money;

public class Money {
    public int currentmoney;

    public void increasedMoney(String t) { // kill enemies
        switch (t) {
            case "t1":
                currentmoney += 20;
            case "t2":
                currentmoney += 40;
            case "t3":
                currentmoney += 60;
        }
    }

    public void decreasedMoney(String t) { // buy or upgrade sth
        switch (t) {
            case "t1":
                currentmoney -= 20;
            case "t2":
                currentmoney -= 40;
            case "t3":
                currentmoney -= 60;
        }
    }

    public void setStartMoney() { // restart game
        currentmoney = 0;
    }
}
