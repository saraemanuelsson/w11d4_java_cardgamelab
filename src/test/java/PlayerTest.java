import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void before(){
        player = new Player("Alice");
    }

    @Test
    public void hasName(){
        assertEquals("Alice", player.getName());
    }

}
