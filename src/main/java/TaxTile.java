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
}
