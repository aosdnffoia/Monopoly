package backend;

/**
 * Class for the backend.Board. Contains tiles, cards, players.
 */
public class Board {
    protected static Tile[] tiles;
    private static Card[] chanceCards;
    private static Card[] communityChestCards;
    private Player[] players;

    /**
     * Static Initialization Block in Java is a block that runs before the main() method and is only called once
     */
    static{
        tiles = new Tile[40];
        chanceCards = new Card[16];
        communityChestCards = new Card[16];
        generateBoard();
        generateCards();
    }

    /**
     * Default constructor for backend.Board
     * @param playerCount
     */
    public Board(int playerCount){
        generatePlayers(playerCount);
    }

    /**
     * Generate players for the board
     */
    private void generatePlayers(int numPlayers){
        int nPlayers = numPlayers; //hard coded as 2 for now, this input will come somewhere from the GUI
        players = new Player[nPlayers];
        for(int i = 0; i < nPlayers; i++){
            players[i] = new Player("Player " + (i+1)); //also hard coded, name will also come from GUI

        }
    }

    /**
     * Method to generate a new board
     */
    private static void generateBoard(){
        TileFactory tileFactory = new TileFactory();

        //Factory calls for all 40 tiles
        tiles[0] = tileFactory.getTile("StartTile", 0, "GO", null, null, null, null, null);
        tiles[1] = tileFactory.getTile("Property", 1, "Mediterranean Avenue", Property.Color.BROWN, 60, 2, 10, 250);
        tiles[2] = tileFactory.getTile("CardTile", 2, "Community Chest", null, null, null, null, null);
        tiles[3] = tileFactory.getTile("Property", 3, "Baltic Avenue", Property.Color.BROWN, 60, 4, 20, 350);
        tiles[4] = tileFactory.getTile("TaxTile", 4, "Income Tax", null, 200, null, null, null);
        tiles[5] = tileFactory.getTile("Railroad", 5, "Reading Railroad", null, 200,null, null, null);
        tiles[6] = tileFactory.getTile("Property", 6, "Oriental Avenue", Property.Color.LIGHTBLUE, 100, 6, 30, 550);
        tiles[7] = tileFactory.getTile("CardTile", 7, "Chance", null, null, null, null, null);
        tiles[8] = tileFactory.getTile("Property", 8, "Vermont Avenue", Property.Color.LIGHTBLUE, 100, 6, 30, 550);
        tiles[9] = tileFactory.getTile("Property", 9, "Connecticut Avenue", Property.Color.LIGHTBLUE, 120, 8, 40, 600);
        tiles[10] = tileFactory.getTile("JailTile", 10, "Jail", null, null, null, null, null);

        tiles[11] = tileFactory.getTile("Property", 11, "St. Charles Place", Property.Color.PINK, 140, 10, 50, 750);
        tiles[12] = tileFactory.getTile("Utility", 12, "Electric Company", null, 150, null, null, null);
        tiles[13] = tileFactory.getTile("Property", 13, "States Avenue", Property.Color.PINK, 140, 10, 50, 750);
        tiles[14] = tileFactory.getTile("Property", 14, "Virginia Avenue", Property.Color.PINK, 160, 12, 60, 900);
        tiles[15] = tileFactory.getTile("Railroad", 15, "Pennsylvania Railroad", null, 200, null, null, null);
        tiles[16] = tileFactory.getTile("Property", 16, "St. James Place", Property.Color.ORANGE, 180, 14, 70, 950);
        tiles[17] = tileFactory.getTile("CardTile", 17, "Community Chest", null, null, null, null, null);
        tiles[18] = tileFactory.getTile("Property", 18, "Tennessee Avenue", Property.Color.ORANGE, 180, 14, 70, 950);
        tiles[19] = tileFactory.getTile("Property", 19, "New York Avenue", Property.Color.ORANGE, 200, 16, 80, 1000);
        tiles[20] = tileFactory.getTile("FreeParkingTile", 20, "Free Parking", null, null, null, null, null);

        tiles[21] = tileFactory.getTile("Property", 21, "Kentucky Avenue", Property.Color.RED, 220,  18, 90, 1050);
        tiles[22] = tileFactory.getTile("CardTile", 22, "Chance", null, null, null, null, null);
        tiles[23] = tileFactory.getTile("Property", 23, "Indiana Avenue", Property.Color.RED, 220, 18, 90, 1050);
        tiles[24] = tileFactory.getTile("Property", 24, "Illinois Avenue", Property.Color.RED, 240, 20, 100, 1100);
        tiles[25] = tileFactory.getTile("Railroad", 25, "B & O Railroad", null, 200, null, null, null);
        tiles[26] = tileFactory.getTile("Property", 26, "Atlantic Avenue", Property.Color.YELLOW, 260, 22, 110, 1150);
        tiles[27] = tileFactory.getTile("Property", 27, "Ventnor Avenue", Property.Color.YELLOW, 260, 22, 110, 1150);
        tiles[28] = tileFactory.getTile("Utility", 28, "Water Works", null, 150, null, null, null);
        tiles[29] = tileFactory.getTile("Property", 29, "Marvin Gardens", Property.Color.YELLOW, 280, 24, 120, 1200);
        tiles[30] = tileFactory.getTile("ToJailTile", 30, "Go to Jail", null, null, null, null, null);

        tiles[31] = tileFactory.getTile("Property", 31, "Pacific Avenue", Property.Color.GREEN, 300, 26, 130, 1275);
        tiles[32] = tileFactory.getTile("Property", 32, "North Carolina Avenue", Property.Color.GREEN, 300, 26, 130, 1275);
        tiles[33] = tileFactory.getTile("CardTile", 33, "Community Chest", null, null, null, null, null);
        tiles[34] = tileFactory.getTile("Property", 34, "Pennsylvania Avenue", Property.Color.GREEN, 320, 28, 150, 1400);
        tiles[35] = tileFactory.getTile("Railroad", 35, "Short Line", null, 200, null, null, null);
        tiles[36] = tileFactory.getTile("CardTile", 36, "Chance", null, null, null, null, null);
        tiles[37] = tileFactory.getTile("Property", 37, "Park Place", Property.Color.DARKBLUE, 350, 35, 175, 1500);
        tiles[38] = tileFactory.getTile("TaxTile", 38, "Luxury Tax", null, 100, null, null, null);
        tiles[39] = tileFactory.getTile("Property", 39, "Boardwalk", Property.Color.DARKBLUE, 400, 50, 200, 2000);

    }

    /**
     * Method to generate cards
     */
    private static void generateCards(){
        chanceCards[0] = new Card("Chance", 1, "Advance to Boardwalk");
        chanceCards[1] = new Card("Chance", 2, "Advance to Go (Collect $200)");
        chanceCards[2] = new Card("Chance", 3, "Advance to Illinois Avenue. If you pass Go, collect $200");
        chanceCards[3] = new Card("Chance", 4, "Advance to St. Charles Place. If you pass Go, collect $200");
        chanceCards[4] = new Card("Chance", 5, "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled");
        chanceCards[5] = new Card("Chance", 6, "Advance to the nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay wonder twice the rental to which they are otherwise entitled");
        chanceCards[6] = new Card("Chance", 7, "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.");
        chanceCards[7] = new Card("Chance", 8, "Bank pays you dividend of $50");
        chanceCards[8] = new Card("Chance", 9, "Get Out of Jail Free");
        chanceCards[9] = new Card("Chance", 10, "Go Back 3 Spaces");
        chanceCards[10] = new Card("Chance", 11, "Go to Jail. Go directly to Jail, do not pass Go, do not collect $200");
        chanceCards[11] = new Card("Chance", 12, "Make general repairs on all your property. For each house pay $25. For each hotel pay $100");
        chanceCards[12] = new Card("Chance", 13, "Speeding fine $15");
        chanceCards[13] = new Card("Chance", 14, "Take a trip to Reading backend.Railroad. If you pass Go, collect $200");
        chanceCards[14] = new Card("Chance", 15, "You have been elected Chairman of the backend.Board. Pay each player $50");
        chanceCards[15] = new Card("Chance", 16, "Your building loan matures. Collect $150");

        communityChestCards[0] = new Card("Community Chest", 1, "Advance to Go (Collect $200)");
        communityChestCards[1] = new Card("Community Chest", 2, "Bank error in your favor. Collect $200");
        communityChestCards[2] = new Card("Community Chest", 3, "Doctor’s fee. Pay $50");
        communityChestCards[3] = new Card("Community Chest", 4, "From sale of stock you get $50");
        communityChestCards[4] = new Card("Community Chest", 5, "Get Out of Jail Free");
        communityChestCards[5] = new Card("Community Chest", 6, "Go to Jail. Go directly to jail, do not pass Go, do not collect $200");
        communityChestCards[6] = new Card("Community Chest", 7, "Holiday fund matures. Receive $100");
        communityChestCards[7] = new Card("Community Chest", 8, "Income tax refund. Collect $20");
        communityChestCards[8] = new Card("Community Chest", 9, "It is your birthday. Collect $10 from every player");
        communityChestCards[9] = new Card("Community Chest", 10, "Life insurance matures. Collect $100");
        communityChestCards[10] = new Card("Community Chest", 11, "Pay hospital fees of $100");
        communityChestCards[11] = new Card("Community Chest", 12, "Pay school fees of $50");
        communityChestCards[12] = new Card("Community Chest", 13, "Receive $25 consultancy fee");
        communityChestCards[13] = new Card("Community Chest", 14, "You are assessed for street repair. $40 per house. $115 per hotel");
        communityChestCards[14] = new Card("Community Chest", 15, "You have won second prize in a beauty contest. Collect $10");
        communityChestCards[15] = new Card("Community Chest", 16, "You inherit $100");
    }

    public static Tile[] getTiles() {
        return tiles;
    }

    public static Tile getTile(int index){
        return tiles[index];
    }

    public static Card[] getChanceCards() {
        return chanceCards;
    }

    public static Card[] getCommunityChestCards() {
        return communityChestCards;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayer(int i) {
        return players[i];
    }

    public static void main(String args[]){
        Board board = new Board(4);
        for(int i = 0; i<3; i++){
            //board.players[0].takeTurn(board);
        }
        for(int i = 0; i<40; i++){
            System.out.println(tiles[i]);
        }
    }
}
