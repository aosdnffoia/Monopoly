/**
 * Class for Tax Tiles
 */
public class TaxTile extends Tile{
    private int tax;
    public TaxTile(int index, String name, int tax) {
        this.index = index;
        this.name = name;
        this.tax = tax;
    }

    @Override
    public void doAction(Player player, Board board) {
        if(player.getIndex() == 4){
            player.payMoney(200);
        } else if (player.getIndex() == 38) {
            player.payMoney(100);
        }
    }
}
