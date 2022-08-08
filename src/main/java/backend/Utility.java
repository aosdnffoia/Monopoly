package backend;

/**
 * Class for Utilities
 */
public class Utility extends TitleDeed {
    /**
     * Construcgtor for utility
     * @param index of the backend.Utility on the board
     * @param name of the utility
     * @param price of the utility
     */
    public Utility(int index, String name, int price) {
        this.index = index;
        this.name = name;
        this.price = price;
    }

    @Override
    public void doAction(Player player, Board board) {
        super.doAction(player, board);
    }
}
