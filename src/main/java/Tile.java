public class Tile {
    int index;
    String name;

    /**
     * Default constructor
     */
    public Tile(){}

    /**
     * Constructor with name
     * @param name of tile
     */
    public Tile(int index, String name){
        this.index = index;
        this.name = name;
    }

    public String toString(){
        return this.name + ": Index " + this.index;
    }
}
