public class Player {
    private final String name;
    private int index=0;
    private int money = 1500;
    private boolean inJail = false;

    public boolean payMoney(int amount){
        if(money >= amount) {
            this.money -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void gainMoney(int amount){ this.money += amount; }

    public void move(int nTiles, Board board){
        //implement
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getMoney() {
        return money;
    }

    public boolean isInJail() {
        return inJail;
    }
}
