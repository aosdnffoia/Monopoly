/**
 * Class for RailRoads
 */
public class Railroad extends TitleDeed {
    /**
     * Railroad Constructor
     * @param index of this Railroad property on the board
     * @param name of this property
     * @param price of this property
     */
    public Railroad(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Override
    public void doAction(Player player, Board board) {
        super.doAction(player, board);
    }
}
