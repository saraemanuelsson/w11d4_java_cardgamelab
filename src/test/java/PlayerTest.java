import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PlayerTest {

    private Player player1;

    @Before
    public void before(){
        player1 = new Player("Alice");
    }

    @Test
    public void hasName(){
        assertEquals("Alice", player1.getName());
    }

    @Test
    public void hasWon(){
        assertFalse(player1.isWinner());
    }

    @Test
    public void testIfStartsWithEmptyHand(){
        assertEquals(0, player1.hasCard());
    }


}
