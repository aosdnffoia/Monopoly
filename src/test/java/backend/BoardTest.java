package backend;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @org.junit.jupiter.api.Test
    void getTiles() {
        assertEquals(Board.getTiles().length,40);
        assertEquals(Board.getTiles()[0].getName(),"GO");
        assertEquals(Board.getTiles()[20].getIndex(),20);
    }

    @org.junit.jupiter.api.Test
    void getTile() {
        assertEquals(Board.getTile(0).getName(),"GO");
    }

    @org.junit.jupiter.api.Test
    void getChanceCards() {
        assertEquals(Board.getChanceCards()[2].getType(),"Chance");
        assertEquals(Board.getChanceCards()[10].getId(),11);
        assertEquals(Board.getChanceCards()[0].getText(),"Advance to Boardwalk");
        assertEquals(Board.getChanceCards()[6].getText(),"Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.");
    }

    @org.junit.jupiter.api.Test
    void getCommunityChestCards() {
        assertEquals(Board.getCommunityChestCards()[6].getType(),"Community Chest");
        assertEquals(Board.getCommunityChestCards()[7].getId(),8);
        assertEquals(Board.getCommunityChestCards()[12].getText(),"Receive $25 consultancy fee");
    }

    @org.junit.jupiter.api.Test
    void getPlayers() {
    }
}