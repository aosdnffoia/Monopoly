/**
 * Class for the Board. Contains tiles, cards, players.
 */
public class Board {
    private Tile[] tiles = new Tile[40];
    private ChanceCard[] chanceCards = new ChanceCard[16];
    private CommunityChest[] communityChestCards = new CommunityChest[16];
    private Player[] players;

    /**
     * Method to generate a new board
     */
    private void generateBoard(){
        TileFactory tileFactory = new TileFactory();

        //Factory calls for all 40 tiles
        tiles[1] = tileFactory.getTile("Property", 1, "Mediterranean Avenue", Property.Color.BROWN, 60);
        tiles[3] = tileFactory.getTile("Property", 3, "Baltic Avenue", Property.Color.BROWN, 60);

        tiles[6] = tileFactory.getTile("Property", 6, "Oriental Avenue", Property.Color.LIGHTBLUE, 100);
        tiles[8] = tileFactory.getTile("Property", 8, "Vermont Avenue", Property.Color.LIGHTBLUE, 100);
        tiles[9] = tileFactory.getTile("Property", 9, "Connecticut Avenue", Property.Color.LIGHTBLUE, 120);


        tiles[11] = tileFactory.getTile("Property", 11, "St. Charles Place", Property.Color.PINK, 140);
        tiles[13] = tileFactory.getTile("Property", 13, "States Avenue", Property.Color.PINK, 140);
        tiles[14] = tileFactory.getTile("Property", 14, "Virginia Avenue", Property.Color.PINK, 160);

        tiles[16] = tileFactory.getTile("Property", 16, "St. James Place", Property.Color.ORANGE, 180);
        tiles[18] = tileFactory.getTile("Property", 18, "Tennessee Avenue", Property.Color.ORANGE, 180);
        tiles[19] = tileFactory.getTile("Property", 19, "New York Avenue", Property.Color.ORANGE, 200);


        tiles[21] = tileFactory.getTile("Property", 21, "Kentucky Avenue", Property.Color.RED, 220);
        tiles[23] = tileFactory.getTile("Property", 23, "Indiana Avenue", Property.Color.RED, 220);
        tiles[24] = tileFactory.getTile("Property", 24, "Illinois Avenue", Property.Color.RED, 240);

        tiles[26] = tileFactory.getTile("Property", 26, "Atlantic Avenue", Property.Color.YELLOW, 260);
        tiles[27] = tileFactory.getTile("Property", 27, "Ventnor Avenue", Property.Color.YELLOW, 260);
        tiles[29] = tileFactory.getTile("Property", 29, "Marvin Gardens", Property.Color.YELLOW, 280);


        tiles[31] = tileFactory.getTile("Property", 31, "Pacific Avenue", Property.Color.GREEN, 300);
        tiles[32] = tileFactory.getTile("Property", 32, "North Carolina Avenue", Property.Color.GREEN, 300);
        tiles[34] = tileFactory.getTile("Property", 34, "Pennsylvania Avenue", Property.Color.GREEN, 320);

        tiles[37] = tileFactory.getTile("Property", 37, "Park Place", Property.Color.DARKBLUE, 350);
        tiles[39] = tileFactory.getTile("Property", 39, "Boardwalk", Property.Color.DARKBLUE, 400);

    }

    private static void main(String args[]){
        Board board = new Board();
        board.generateBoard();

        for(int i = 0; i<41; i++){
            System.out.println(board.tiles[i]);
        }
    }
}
