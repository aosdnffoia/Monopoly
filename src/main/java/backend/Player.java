package backend;

import java.util.ArrayList;

/**
 * Class for a backend.Player
 */
public class Player {
    private final String name;
    private int index;
    private int money;
    private boolean inJail;
    private boolean getOutOfJailFreeCard;
    private int turnsInJail;
    private ArrayList<TitleDeed> titleDeeds;

    /**
     * Constructor for backend.Player
     * @param name backend.Player's name
     */
    public Player(String name) {
        this.name = name;
        this.index = 0;
        this.money = 1500;
        this.titleDeeds = new ArrayList<>();
        this.inJail = false;
        this.turnsInJail = 0;
        getOutOfJailFreeCard = false;
    }

    /**
     * Method for the player to take their turn. They are given an option to trade first, then an option to buy houses/hotels on owned properties, then will roll the die
     * @param board
     */
    public void takeTurn(Board board){
        System.out.println(this.name + "'s Turn: $" + this.money + " **********************************************");
        //Option to offer trade, then option to buy houses/hotels

        int dice1;
        int dice2;
        boolean doubles;
        int nDoubles = 0;

        do{
            if(this.inJail){
                //if in jail, give option to pay 50 to get out or use get out of jail free card
            }

            doubles = false;
            //dice1 = (int) (Math.random()*6) + 1; //implement a roll button
            //dice2 = (int) (Math.random()*6) + 1;
            dice1 = 2;
            dice2 = 0;
            System.out.println("Rolling... " + dice1 + " " + dice2);

            if(dice1 == dice2){
                System.out.println("DOUBLES!!!");
                doubles = true;
                nDoubles++;
                this.inJail = !this.inJail;

                if(nDoubles == 3){
                    System.out.println("STRAIGHT TO JAIL");
                    board.tiles[30].doAction(this, board);
                    break;
                }
            }

            if(!this.inJail){
                System.out.println("NOT IN JAIL");
                this.move(dice1 + dice2, board);
                board.tiles[index].doAction(this, board);
            }else{
                System.out.println("IN JAIL!");
                if(turnsInJail == 2){ //if player has already been in jail for 2 turns
                    inJail = false;
                    turnsInJail = 0;
                } else {
                    turnsInJail += 1;
                }
            }

        }while(doubles && nDoubles < 3);

    }

    /**
     * backend.Player pays a certain amount (for buying property/houses/rent/etc.)
     * @param amount paid by backend.Player
     * @return if the backend.Player was able to pay that amount
     */
    public void payMoney(int amount){
        if(money >= amount) {
            this.money -= amount;
        } else {

            //give player options to sell houses/hotels/mortgage
        }
    }

    /**
     * backend.Player gains a certain amount of money (from rent owed/passing go/etc.)
     * @param amount gained by backend.Player
     */
    public void gainMoney(int amount){ this.money += amount; }

    /**
     * backend.Player moved nTiles down the board
     * @param nTiles the number of tiles the backend.Player moves
     * @param board the board down which the backend.Player moves
     */
    public void move(int nTiles, Board board){
        if(index + nTiles >= 40){
            this.money += 200; //earn 200 for passing GO
        }
        index = (index + nTiles + 40) % 40; //add 40 before mod to take care of case where player draws a card to move spaces backwards when at low index
        System.out.println(board.tiles[index]);
    }

    /**
     * Add a property to the player's property list
     */
    public void addProperty(TitleDeed titleDeed){
        this.titleDeeds.add(titleDeed);
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setGetOutOfJailFreeCard(boolean getOutOfJailFreeCard) {
        this.getOutOfJailFreeCard = getOutOfJailFreeCard;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getMoney() {
        return money;
    }

    public boolean isInJail() {
        return inJail;
    }

    public ArrayList<TitleDeed> getTitleDeeds() {
        return titleDeeds;
    }

    public String toString(){
        return this.name;
    }
}
