/**
 * Class for the Board. Contains tiles, cards, players.
 */
public class Board {
    private Tile[] tiles;
    private ChanceCard[] chanceCards;
    private CommunityChest[] communityChestCards;
    private Player[] players;

    /**
     * Default constructor for Board
     */
    public Board(){
        this.tiles = new Tile[40];
        this.chanceCards = new ChanceCard[16];
        this.communityChestCards = new CommunityChest[16];
        this.generatePlayers();
        this.generateBoard();
    }

    /**
     * Generate players for the board
     */
    private void generatePlayers(){
        int nPlayers = 2; //hard coded as 2 for now, this input will come somewhere from the GUI
        players = new Player[nPlayers];
        for(int i = 0; i < nPlayers; i++){
            players[i] = new Player("Player " + (i+1)); //also hard coded, name will also come from GUI

        }
    }

    /**
     * Method to generate a new board
     */
    private void generateBoard(){
        TileFactory tileFactory = new TileFactory();

        //Factory calls for all 40 tiles
        tiles[0] = tileFactory.getTile("StartTile", 0, "GO", null, null);
        tiles[1] = tileFactory.getTile("Property", 1, "Mediterranean Avenue", Property.Color.BROWN, 60);
        tiles[2] = tileFactory.getTile("CardTile", 2, "Community Chest", null, null);
        tiles[3] = tileFactory.getTile("Property", 3, "Baltic Avenue", Property.Color.BROWN, 60);
        tiles[4] = tileFactory.getTile("TaxTile", 4, "Income Tax", null, 200);
        tiles[5] = tileFactory.getTile("Railroad", 5, "Reading Railroad", null, 200);
        tiles[6] = tileFactory.getTile("Property", 6, "Oriental Avenue", Property.Color.LIGHTBLUE, 100);
        tiles[7] = tileFactory.getTile("CardTile", 7, "Chance", null, null);
        tiles[8] = tileFactory.getTile("Property", 8, "Vermont Avenue", Property.Color.LIGHTBLUE, 100);
        tiles[9] = tileFactory.getTile("Property", 9, "Connecticut Avenue", Property.Color.LIGHTBLUE, 120);
        tiles[10] = tileFactory.getTile("JailTile", 10, "Jail", null, null);

        tiles[11] = tileFactory.getTile("Property", 11, "St. Charles Place", Property.Color.PINK, 140);
        tiles[12] = tileFactory.getTile("Utility", 12, "Electric Company", null, 150);
        tiles[13] = tileFactory.getTile("Property", 13, "States Avenue", Property.Color.PINK, 140);
        tiles[14] = tileFactory.getTile("Property", 14, "Virginia Avenue", Property.Color.PINK, 160);
        tiles[15] = tileFactory.getTile("Railroad", 15, "Pennsylvania Railroad", null, 200);
        tiles[16] = tileFactory.getTile("Property", 16, "St. James Place", Property.Color.ORANGE, 180);
        tiles[17] = tileFactory.getTile("CardTile", 17, "Community Chest", null, null);
        tiles[18] = tileFactory.getTile("Property", 18, "Tennessee Avenue", Property.Color.ORANGE, 180);
        tiles[19] = tileFactory.getTile("Property", 19, "New York Avenue", Property.Color.ORANGE, 200);
        tiles[20] = tileFactory.getTile("FreeParkingTile", 20, "FreeParking", null, null);

        tiles[21] = tileFactory.getTile("Property", 21, "Kentucky Avenue", Property.Color.RED, 220);
        tiles[22] = tileFactory.getTile("CardTile", 22, "Chance", null, null);
        tiles[23] = tileFactory.getTile("Property", 23, "Indiana Avenue", Property.Color.RED, 220);
        tiles[24] = tileFactory.getTile("Property", 24, "Illinois Avenue", Property.Color.RED, 240);
        tiles[25] = tileFactory.getTile("Railroad", 25, "B & O Railroad", null, 200);
        tiles[26] = tileFactory.getTile("Property", 26, "Atlantic Avenue", Property.Color.YELLOW, 260);
        tiles[27] = tileFactory.getTile("Property", 27, "Ventnor Avenue", Property.Color.YELLOW, 260);
        tiles[28] = tileFactory.getTile("Utility", 28, "Water Works", null, 150);
        tiles[29] = tileFactory.getTile("Property", 29, "Marvin Gardens", Property.Color.YELLOW, 280);
        tiles[30] = tileFactory.getTile("ToJailTile", 30, "Go to Jail", null, null);

        tiles[31] = tileFactory.getTile("Property", 31, "Pacific Avenue", Property.Color.GREEN, 300);
        tiles[32] = tileFactory.getTile("Property", 32, "North Carolina Avenue", Property.Color.GREEN, 300);
        tiles[33] = tileFactory.getTile("CardTile", 33, "Community Chest", null, null);
        tiles[34] = tileFactory.getTile("Property", 34, "Pennsylvania Avenue", Property.Color.GREEN, 320);
        tiles[35] = tileFactory.getTile("Railroad", 35, "Short Line", null, 200);
        tiles[36] = tileFactory.getTile("CardTile", 36, "Chance", null, null);
        tiles[37] = tileFactory.getTile("Property", 37, "Park Place", Property.Color.DARKBLUE, 350);
        tiles[38] = tileFactory.getTile("TaxTile", 38, "Luxury Tax", null, 100);
        tiles[39] = tileFactory.getTile("Property", 39, "Boardwalk", Property.Color.DARKBLUE, 400);

    }

    public static void main(String args[]){
        Board board = new Board();
        for(int i = 0; i<40; i++){
            //System.out.println(board.tiles[i]);
            board.players[0].takeTurn();
        }
        board.players[0].takeTurn();
    }
}
