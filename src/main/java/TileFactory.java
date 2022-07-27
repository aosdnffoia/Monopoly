/**
 * TileFactory to assist in creating the 40 tiles needed for a board
 */
public class TileFactory {
    public Tile getTile(String type, int index, String name, Property.Color color, Integer price){

        if(type.equals("Property")){
            return new Property(index, name, color, price);
        } else if (type.equals("Railroad")) {
            return new Railroad(index, name, price);
        } else if (type.equals("Utility")) {
            return new Utility(index, name, price);
        } else if (type.equals("CardTile")) {
            return new CardTile(index, name);
        } else if (type.equals("TaxTile")) {
            return new TaxTile(index, name, price);
        } else if (type.equals("StartTile")) { //according to official rules, nothing special happens when you land here
            return new Tile(index, name);
        }  else if (type.equals("JailTile")) {
            return new Tile(index, name);
        } else if (type.equals("FreeParkingTile")) { //according to official rules, nothing special happens when you land here
            return new Tile(index, name);
        } else if (type.equals("ToJailTile")) {
            return new Tile(index, name);
        }

        return null;
    }


}
