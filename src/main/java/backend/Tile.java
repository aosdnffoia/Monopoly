package backend;

public class Tile {
    protected int index;
    protected String name;

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

    /**
     * Action associated with this tile: purchase/pay tax/draw card/go to jail
     * @param player
     */
    public void doAction(Player player, Board board){
        if (this.name.equals("GO")) { //according to official rules, nothing special happens when you land here
            //do nothing
        }  else if (this.name.equals("Jail")) {
            //do nothing, just visiting
        } else if (this.name.equals("Free Parking")) { //according to official rules, nothing special happens when you land here
            //do nothing
        } else if (this.name.equals("Go to Jail")) {
            player.setInJail(true);
            player.setTurnsInJail(0);
            player.setIndex(10);
        }
    }

    public String toString(){
        return this.name + ": Index " + this.index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
