import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
}
