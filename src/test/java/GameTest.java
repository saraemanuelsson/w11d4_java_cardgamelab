import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player;
    private Game game;
//    private Dealer dealer;
//    private Deck deck;

    @Before
    public void before() {
       player = new Player("Alice");
//       dealer = new Dealer();
//       deck = new Deck();
//       deck.populateDeck();
       game = new Game();
       game.addPlayer(player);
    }

    @Test
    public void startsWithNoPlayers(){
        Game newGame = new Game();
        assertEquals(0, newGame.getNumberOfPlayers());
    }

    @Test
    public void canAddPlayer(){
        game.addPlayer(player);
        assertEquals(2, game.getNumberOfPlayers());
    }

    @Test
    public void canGiveDecksToDealer(){
        game.giveDecksToDealer(3);
        assertEquals(156, game.getDealer().getSizeOfGameCards());
    }

    @Test
    public void canStartGame(){
        game.giveDecksToDealer(3);
        game.startGame();
        assertEquals(151, game.getDealer().getSizeOfGameCards());
        assertEquals(2, game.getPlayers().get(0).getNumberOfCards());
        assertEquals(2, game.getDealer().getNumberOfCards());
    }

}
