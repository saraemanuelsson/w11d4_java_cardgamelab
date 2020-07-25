import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void canGetBlackJack() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(jack);
        hand.add(ace);
        assertEquals(true, game.blackJack(hand));
    }

    @Test
    public void wontBlackJackIfNoAce() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card ace = new Card(SuitType.CLUBS, RankType.QUEEN);
        ArrayList<Card> hand = new ArrayList<Card>();
        hand.add(jack);
        hand.add(ace);
        assertEquals(false, game.blackJack(hand));
    }

//    @Test
//    public void canGetResult(){
//        Card jack = new Card(SuitType.SPADES, RankType.JACK);
//        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
//        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
//        game.getPlayers().get(0).receiveCard(jack);
//        game.getPlayers().get(0).receiveCard(nine);
//        game.getDealer().receiveCard(nine);
//        game.getDealer().receiveCard(seven);
//        assertEquals(game.getPlayers(), game.getResult());
//    }
//
//    @Test
//    public void canPlayGame(){
//        assertEquals();
//    }

}
