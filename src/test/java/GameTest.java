import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Player player;
    private Game game;
    private Dealer dealer;
    private Deck deck;

    @Before
    public void before() {
       player = new Player("Alice");
       dealer = new Dealer();
       deck = new Deck();
       deck.populateDeck();
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
    public void canAddDecks(){
        ArrayList<Deck> decks = game.getDecks(3);
        dealer.populateGameCards(decks);
        assertEquals(156, dealer.getSizeOfGameCards());
    }

//    @Test
//    public void canStartGame(){
//        game.startGame(3);
//        assertEquals(150, dealer.getSizeOfGameCards());
//        assertEquals(2, player.getNumberOfCards());
//        assertEquals(2, dealer.getNumberOfCards());
//    }

}
