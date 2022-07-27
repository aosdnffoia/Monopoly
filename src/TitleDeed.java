/**
 * Abstract class for TitleDeeds that can be owned by a Player, extends Tile.
 */
public abstract class TitleDeed extends Tile {
    private int price;
    private int rent;
    private int mortgageAmount;
    private Player owner = null;
    private boolean mortgaged = false;

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

}
