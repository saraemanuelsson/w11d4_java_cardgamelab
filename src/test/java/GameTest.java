import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player1;
    private Player player2;
    private Game game;

    @Before
    public void before() {
       player1 = new Player("Alice");
       player2 = new Player("Bob");
       game = new Game();
       game.addPlayer(player1);
       game.addPlayer(player2);
    }

    @Test
    public void startsWithNoPlayers(){
        Game newGame = new Game();
        assertEquals(0, newGame.getNumberOfPlayers());
    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player1);
        assertEquals(3, game.getNumberOfPlayers());
    }

    @Test
    public void canStartGame(){

    }

}
