package backend;

/**
 * Class for backend.Card Tiles
 */
public class CardTile extends Tile{
    /**
     * Constructor for card tile
     * @param index that tile's index on the board
     * @param name the tile's name
     */
    public CardTile(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Method for the player who landed on this card tile to draw a random card (either chance or community chest)
     * @param player who landed on this tile
     * @param board upon which this game is being played
     */
    @Override
    public void doAction(Player player, Board board) {
        int cardID = (int) (Math.random()*16);
        if(this.name == "Chance"){
            Card[] chanceCards = board.getChanceCards();
            System.out.println(chanceCards[cardID]);
            chanceCards[cardID].doAction(player, board);
        } else {
            Card[] communityChest = board.getCommunityChestCards();
            System.out.println(communityChest[cardID]);
            communityChest[cardID].doAction(player, board);
        }
    }
}
