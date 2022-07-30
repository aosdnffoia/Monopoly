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
        int cardID = (int) (Math.random()*16) + 1;
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
