package backend;

/**
 * Class for TitleDeeds that can be owned by a backend.Player, extends backend.Tile.
 */
public class TitleDeed extends Tile {
    protected int price;
    private int rent;
    protected int mortgageAmount;
    private Player owner = null;
    private boolean mortgaged = false;

    /**
     * Method for the action the player can take when landing on this tile, purchase the title deed, add it to the player's property list and set the
     * player as the owner of this property. Can only be taken if the tile is unowned.
     * @param player
     * @param board
     */
    @Override
    public void doAction(Player player, Board board) {
        //offer to player for sale
        if(this.owner == null) {
            player.payMoney(this.price);
            player.addProperty(this);
            this.setOwner(player);
        }
    }

    /**
     * Set a new owner for this backend.TitleDeed
     * @param player the new owner
     */
    public void setOwner(Player player){ this.owner = player; }

    /**
     * Mortgage this backend.TitleDeed.
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
     * Un-mortgage this backend.TitleDeed.
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
