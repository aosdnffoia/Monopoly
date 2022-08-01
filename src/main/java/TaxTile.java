/**
 * Class for Tax Tiles
 */
public class TaxTile extends Tile{
    private int tax;

    /**
     * Constructor for tax tiles
     * @param index of this tile on the board
     * @param name of this tile
     * @param tax amount of tax associated with this tile
     */
    public TaxTile(int index, String name, int tax) {
        this.index = index;
        this.name = name;
        this.tax = tax;
    }

    /**
     * Method for when a player lands on this tile, different amounts for the two different tax tiles
     * @param player who lands on this tile and pays the tax amount
     * @param board upon which the game is being played
     */
    @Override
    public void doAction(Player player, Board board) {
        if(player.getIndex() == 4){
            player.payMoney(200);
        } else if (player.getIndex() == 38) {
            player.payMoney(100);
        }
    }
}
