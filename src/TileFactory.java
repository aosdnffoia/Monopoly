/**
 * TileFactory to assist in creating the 40 tiles needed for a board
 */
public class TileFactory {
    public Tile getTile(String type, int index, String name, Property.Color color, int cost){

        if(type.equals("Property")){
            return new Property(index, name, color, cost);
        } else if (type.equals("RailRoad")) {
            
        } else if (type.equals("Utility")) {
            
        } else if (type.equals("StartTile")) {
            
        } else if (type.equals("JailTile")) {
            
        } else if (type.equals("FreeParking")) {
            
        } else if (type.equals("ToJailTile")) {
            
        }

        return null;
    }


}
