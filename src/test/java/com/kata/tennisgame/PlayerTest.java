package com.kata.tennisgame;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void pointsCanBeAddedToEachPlayer() {
        Player federer = new Player("Roger Federer");
        Player djokovic = new Player("Novak Djokovic");
        
        for(int i=1; i<=3; i++) {
        	federer.wonPoint();
        	djokovic.wonPoint();
        }
        //incrementing sarah scrore by one more than victor score
        djokovic.wonPoint();

        assertTrue(federer.getScore() == 3);
        assertTrue(djokovic.getScore() == 4);
        assertTrue("forty".equals(federer.getScoreDescription()));
        
    }
}
