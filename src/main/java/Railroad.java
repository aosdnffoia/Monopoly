/**
 * Class for RailRoads
 */
public class Railroad extends TitleDeed {
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
