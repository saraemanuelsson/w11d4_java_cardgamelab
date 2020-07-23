import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlayerTest {

    private Player player1;
    private Player player2;
    private Deck deck;

    @Before
    public void before(){
        player1 = new Player("Alice");
        player2 = new Player("Bob");
        deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();

    }

    @Test
    public void hasName(){
        assertEquals("Alice", player1.getName());
        assertEquals("Bob", player2.getName());
    }

    @Test
    public void hasWon(){
        assertFalse(player1.isWinner());
        assertFalse(player2.isWinner());
    }

    @Test
    public void testIfStartsWithEmptyHand(){
        assertEquals(0, player1.hasCard());
        assertEquals(0, player2.hasCard());
    }

     @Test
     public void hasReceivedCard() {
       player1.receiveCard(deck);
       assertEquals(1, player1.hasCard());
     }
}
