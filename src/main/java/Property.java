/**
 * Class for colored properties that can be owned by a player. Extends TitleDeed.
 */
public class Property extends TitleDeed {
    private Color color;
    private int nHouses;
    private int nHotel;
    private int nRailRoads;
    private int nUtilities;

    public Property(int index, String name, Color color, int price){
        this.index = index;
        this.name = name;
        this.color = color;
        this.price = price;
        this.nHouses = 0;
        this.nHotel = 0;
        this.mortgageAmount = price/2;
        this.nRailRoads = 0;
        this.nUtilities = 0;
    }

    /**
     * enum to store information about property colors and their each of their total counts/house price/hotel price
     */
    public enum Color{
        BROWN(2, 50, 50),
        LIGHTBLUE(3, 50, 50),
        PINK(3, 100, 100),
        ORANGE(3, 100, 100),
        RED(3, 150, 150),
        YELLOW(3, 150, 150),
        GREEN(3, 200, 200),
        DARKBLUE(2, 200, 200);

        private int count;
        private int housePrice;
        private int hotelPrice;
        private Color(final int count, final int housePrice, final int hotelPrice){
            this.count=count;
            this.housePrice = housePrice;
            this.hotelPrice = hotelPrice;
        }

    }

}
