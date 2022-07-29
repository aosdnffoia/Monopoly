/**
 * Class for Card Tiles
 */
public class CardTile extends Tile{
    public CardTile(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void doAction(Player player, Board board) {
        if(this.name == "Chance"){
            Card[] chanceCards = board.getChanceCards();
            chanceCards[(int) Math.random()*16 + 1].doAction(player, board);
        } else {
            Card[] communityChest = board.getCommunityChestCards();
            communityChest[(int) Math.random()*16 + 1].doAction(player, board);
        }
    }
}
