package Items;

public class Wallet extends Item {
    private int money;

    public Wallet(String name, int money) {
        super(name, 0);
        this.money = money;
    }
    public Wallet(String name, int money, int cost) {
        super(name, cost);
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }
}
