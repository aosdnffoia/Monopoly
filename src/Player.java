/**
 * Class for a Player
 */
public class Player {
    private final String name;
    private int index;
    private int money;
    private boolean inJail;

    /**
     * Player pays a certain amount (for buying property/houses/rent/etc.)
     * @param amount paid by Player
     * @return if the Player was able to pay that amount
     */
    public boolean payMoney(int amount){
        if(money >= amount) {
            this.money -= amount;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Player gains a certain amount of money (from rent owed/passing go/etc.)
     * @param amount gained by Player
     */
    public void gainMoney(int amount){ this.money += amount; }

    /**
     * Player moved nTiles down the board
     * @param nTiles the number of tiles the Player moves
     * @param board the board down which the Player moves
     */
    public void move(int nTiles, Board board){
        //implement
    }

    /**
     * Constructor for Player
     * @param name Player's name
     */
    public Player(String name) {
        this.name = name;
        this.index = 0;
        this.money = 1500;
        this.inJail = false;
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
