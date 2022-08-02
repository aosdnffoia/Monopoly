public class Card {
    private String type;
    private int id;
    private String text;

    /**
     * Card constructor
     * @param type 'Chance' or 'Community Chest'
     * @param id Card ID, between 1 and 16 inclusive
     * @param text associated with that card, e.g. 'Go Straight to Jail'
     */
    public Card(String type, int id, String text){
        this.type = type;
        this.id = id;
        this.text = text;
    }

    /**
     * Method with cases for each unique card type/card id pairs
     * @param player Player who drew this card
     * @param board Board upon which this game is being played
     */
    public void doAction(Player player, Board board){
        if(type == "Chance"){
            switch(id){
                case 1:
                    player.move(39 - player.getIndex(), board);
                    break;
                case 2:
                    player.move(40-player.getIndex(), board);
                    break;
                case 3:
                    if(player.getIndex() <= 24){
                        player.move(24-player.getIndex(), board);
                    } else {
                        player.move(64-player.getIndex(), board);
                    }
                    break;
                case 4:
                    if(player.getIndex() <= 11){
                        player.move(11-player.getIndex(), board);
                    } else {
                        player.move(51-player.getIndex(), board);
                    }
                    break;
                case 5: //also pay double rent
                case 6:
                    if(player.getIndex() <= 5){
                        player.move(5-player.getIndex(), board);
                    } else if (player.getIndex() <= 15) {
                        player.move(15-player.getIndex(), board);
                    } else if (player.getIndex() <= 25) {
                        player.move(25-player.getIndex(), board);
                    } else if (player.getIndex() <= 35) {
                        player.move(35-player.getIndex(), board);
                    } else {
                        player.move(45-player.getIndex(), board);
                    }

                    TitleDeed titleDeed6 = (TitleDeed) board.getTile(player.getIndex());
                    if(titleDeed6.getOwner() == null){
                        titleDeed6.doAction(player, board);
                    }else{
                        player.payMoney(titleDeed6.getRent() * 2);
                    }
                    break;
                case 7: //also throw dice pay 10x number rolled
                    if(player.getIndex() <= 12){
                        player.move(12-player.getIndex(), board);
                    } else if (player.getIndex() <= 28) {
                        player.move(28-player.getIndex(), board);
                    } else {
                        player.move(52-player.getIndex(), board);
                    }

                    TitleDeed titleDeed7 = (TitleDeed) board.getTile(player.getIndex());
                    if(titleDeed7.getOwner() == null){
                        titleDeed7.doAction(player, board);
                    }else{
                        int payAmount7 = (int) ((Math.random()*6) + (Math.random()*6)) * 10;
                        player.payMoney(payAmount7);
                        titleDeed7.getOwner().gainMoney(payAmount7);
                    }
                    break;
                case 8:
                    player.gainMoney(50);
                    break;
                case 9:
                    player.setGetOutOfJailFreeCard(true);
                    break;
                case 10:
                    player.move(-3, board);
                    break;
                case 11:
                    player.setInJail(true);
                    player.setTurnsInJail(0);
                    player.setIndex(10);
                    break;
                case 12:
                    int nHouses = 0;
                    int nHotels = 0;
                    for(TitleDeed titleDeed12: player.getTitleDeeds()){
                        if (titleDeed12 instanceof Property){
                            nHouses += ((Property)titleDeed12).getnHouses();
                            nHotels += ((Property)titleDeed12).getnHotel();
                        }
                    }
                    player.payMoney((nHouses * 25) + (nHotels * 100));
                    break;
                case 13:
                    player.payMoney(15);
                    break;
                case 14:
                    if(player.getIndex() <= 5){
                        player.move(5-player.getIndex(), board);
                    } else  {
                        player.move(45-player.getIndex(), board);
                    }
                    break;
                case 15:
                    player.payMoney((board.getPlayers().length-1) * 50);
                    for(Player player1: board.getPlayers()){
                        if(!player.equals(player1)){
                            player1.gainMoney(50);
                        }
                    }
                    break;
                case 16:
                    player.gainMoney(150);
                    break;
            }
        } else if (type == "Community Chest") {
            switch(id){
                case 1:
                    player.move(40-player.getIndex(), board);
                    break;
                case 2:
                    player.gainMoney(200);
                    break;
                case 3:
                case 12:
                    player.payMoney(50);
                    break;
                case 4:
                    player.gainMoney(50);
                    break;
                case 5:
                    player.setGetOutOfJailFreeCard(true);
                    break;
                case 6:
                    player.setInJail(true);
                    player.setTurnsInJail(0);
                    player.setIndex(10);
                    break;
                case 7:
                case 10:
                case 16:
                    player.gainMoney(100);
                    break;
                case 8:
                    player.gainMoney(20);
                    break;
                case 9:
                    for(Player player1: board.getPlayers()){
                        if(!player.equals(player1)){
                            player1.payMoney(10);
                        }
                    }
                    player.gainMoney((board.getPlayers().length-1) * 50);
                    break;
                case 11:
                    player.payMoney(100);
                    break;
                case 13:
                    player.gainMoney(25);
                    break;
                case 14:
                    int nHouses = 0;
                    int nHotels = 0;
                    for(TitleDeed titleDeed: player.getTitleDeeds()){
                        if (titleDeed instanceof Property){
                            nHouses += ((Property)titleDeed).getnHouses();
                            nHotels += ((Property)titleDeed).getnHotel();
                        }
                    }
                    player.payMoney((nHouses * 40) + (nHotels * 115));
                    break;
                case 15:
                    player.gainMoney(10);
                    break;
            }
        }
    }

    public String toString(){
        return this.text;
    }
}
