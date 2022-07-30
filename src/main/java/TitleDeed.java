/**
 * Class for TitleDeeds that can be owned by a Player, extends Tile.
 */
public class TitleDeed extends Tile {
    protected int price;
    private int rent;
    protected int mortgageAmount;
    private Player owner = null;
    private boolean mortgaged = false;

    @Override
    public void doAction(Player player, Board board) {
        //offer to player for sale
        player.payMoney(this.price);
        player.addProperty(this);
        this.setOwner(player);
    }

    /**
     * Set a new owner for this TitleDeed
     * @param player the new owner
     */
    public void setOwner(Player player){ this.owner = player; }

    /**
     * Mortgage this TitleDeed.
     */
    public void mortgage(){
        if(owner != null) {
            mortgaged = true;
            owner.gainMoney(mortgageAmount);
        }else{
            return;
        }
    }

    /**
     * Un-mortgage this TitleDeed.
     */
    public void unmortgage(){
        if(owner != null) {
            mortgaged = false;
            owner.payMoney(mortgageAmount);
        }else{
            return;
        }
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }
}
