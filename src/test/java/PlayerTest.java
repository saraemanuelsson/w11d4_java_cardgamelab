import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player1;
    private Card card;

    @Before
    public void before(){
        player1 = new Player("Alice");
        card = new Card(SuitType.SPADES, RankType.JACK);
    }

    @Test
    public void hasName(){
        assertEquals("Alice", player1.getName());
    }

    @Test
    public void testStartsWithEmptyHand(){
        assertEquals(0, player1.getNumberOfCards());
    }

    @Test
    public void canReceiveCard() {
        player1.receiveCard(card);
        assertEquals(1, player1.getNumberOfCards());
    }

    @Test
    public void canGetHandOfCards(){
        player1.receiveCard(card);
        assertEquals(card, player1.getHandOfCards().get(0));
    }

    @Test
    public void canGetTotalValueOfHand(){
        player1.receiveCard(card);
        player1.receiveCard(card);
        assertEquals(20, player1.getTotalValueOfHand());
    }
}
