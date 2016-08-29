package com.kata.tennisgame;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/*
Implement a simple tennis game

**Rules:**

* 1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent. The score is then “Win for player1” or “Win for player2”
 
* 2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “Love”, “Fifteen”, “Thirty”, and “Forty” respectively.
 
* 3. If at least three points have been scored by each player, and the scores are equal, the score is “Deuce”.
 
* 4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “Advantage player1” or “Advantage player2”.
*/
public class GameTest {

    Player federer;
    Player djokovic;
    Game usOpen;

    @Before
    public void beforeGameTest() {
        federer = new Player("Roger Federer");
        djokovic = new Player("Novak Djokovic");
        usOpen = new Game(federer, djokovic);
    }

    
    /**
     * Initial state of score board "love all"
     */
    @Test
    public void scoreBoardTest0_0() {
        Game game = new Game(federer, djokovic);
        assertTrue((federer.getName() + " love, " + djokovic.getName() + " love").equals(game.getScore()));
    }

    /**
     * Score board when second player scores first point
     */
    @Test
    public void scoreBoardTest0_15() {
        djokovic.wonPoint();
        assertTrue((federer.getName() + " love, " + djokovic.getName() + " fifteen").equals(usOpen.getScore()));
    }

    /**
     * Score board when first player score two and second player scores 1 point each
     */
    @Test
    public void scoreBoardTest30_15() {
        federer.wonPoint();
        federer.wonPoint();
        djokovic.wonPoint();
        assertTrue((federer.getName() + " thirty, " + djokovic.getName() + " fifteen").equals(usOpen.getScore()));
    }

    /**
     * Score board when first player score three and second player scores none
     */
    @Test
    public void scoreBoardTest40_0() {
        for(int i=1; i<=3; i++) {
        	federer.wonPoint();
        }
        assertTrue((federer.getName() + " forty, " + djokovic.getName() + " love").equals(usOpen.getScore()));
    }

    /**
     * If at least three points have been scored by each side and a player has one more point than his opponent, 
     * the score of the game is “Advantage player1” or “Advantage player2”.
     */
    @Test
    public void gameAdvantageTest() {
    	for(int i=1; i<=3; i++) {
            federer.wonPoint();
            djokovic.wonPoint();
        }
    	//incrementing Novak Djokovic score by one more than Roger Federer score to check advantage case
    	djokovic.wonPoint();
    	
        assertTrue("advantage Novak Djokovic".equals(usOpen.getScore()));
    }

    /**
     * If at least three points have been scored by each player, and the scores are equal, the score is “Deuce”
     */
    @Test
    public void gameDueceTest() {
    	for(int i=1; i<=3; i++) {
            federer.wonPoint();
            djokovic.wonPoint();
        }
        
    	assertTrue("deuce".equals(usOpen.getScore()));
        federer.wonPoint();
        assertTrue(!"deuce".equals(usOpen.getScore()));
        djokovic.wonPoint();
        assertTrue("deuce".equals(usOpen.getScore()));
    }

    /**
     * A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
     *  The score is then “Win for player1” or “Win for player2”
     */
    @Test
    public void gameWinningTest() {
    	for(int i=1; i<=3; i++) {
            federer.wonPoint();
            djokovic.wonPoint();
        }
    	//incrementing Roger Federer score by one point
    	federer.wonPoint();
        
    	assertTrue(!"Roger Federer won".equals(usOpen.getScore()));
        assertTrue(!"Novak Djokovic won".equals(usOpen.getScore()));
       //incrementing Roger Federer score by one more point so that he will have two points more that Novak Djokovic and wins the game
    	federer.wonPoint();
        assertTrue("Roger Federer won".equals(usOpen.getScore()));
    }

}
