import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    private Player player;
    private Game game;

    @Before
    public void before() {
       player = new Player("Alice");
       game = new Game(3);
       game.addPlayer(player);
    }

    @Test
    public void startsWithNoPlayers() {
        Game newGame = new Game(3);
        assertEquals(0, newGame.getNumberOfPlayers());
    }

    @Test
    public void canAddPlayer() {
        game.addPlayer(player);
        assertEquals(2, game.getNumberOfPlayers());
    }

    @Test
    public void canGiveDecksToDealer() {
        game.giveDecksToDealer();
        assertEquals(156, game.getDealer().getSizeOfGameCards());
    }

    @Test
    public void canStartGame() {
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
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(ace);
        assertEquals(true, game.blackJack(game.getDealer()));
    }

    @Test
    public void wontBlackJackIfNoAce() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card queen = new Card(SuitType.CLUBS, RankType.QUEEN);
        ArrayList<Card> hand = new ArrayList<Card>();
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(queen);
        assertEquals(false, game.blackJack(game.getDealer()));
    }

    @Test
    public void canGetResult() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        game.getPlayers().get(0).receiveCard(jack);
        game.getPlayers().get(0).receiveCard(nine);
        game.getDealer().receiveCard(nine);
        game.getDealer().receiveCard(seven);
        game.getResult();
        assertEquals(game.getPlayers(), game.getWinners());
    }

    @Test
    public void canGetResultDealerWins() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        game.getPlayers().get(0).receiveCard(seven);
        game.getPlayers().get(0).receiveCard(nine);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(jack);
        game.getResult();
        assertEquals(game.getDealer(), game.getWinners().get(0));
    }

    @Test
    public void canHandleBlackJack() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        game.getPlayers().get(0).receiveCard(jack);
        game.getPlayers().get(0).receiveCard(nine);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(ace);
        game.handleBlackJack();
        assertEquals(game.getDealer(), game.getWinners().get(0));
        assertEquals(1, game.getWinners().size());
    }

    @Test
    public void canHandleBlackJackPlayerWins() {
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        game.getPlayers().get(0).receiveCard(jack);
        game.getPlayers().get(0).receiveCard(ace);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(seven);
        game.handleBlackJack();
        assertEquals(game.getPlayers(), game.getWinners());
        assertEquals(1, game.getWinners().size());
    }

    @Test
    public void canDealMoreCardsToPlayerNotOnStand() {
        Player player2 = new Player("Bob");
        game.addPlayer(player2);
        game.startGame();
        game.getPlayers().get(0).changeStand();
        game.dealMoreCardsToPlayer();
        assertEquals(2, game.getPlayers().get(0).getNumberOfCards());
        assertNotEquals(2, game.getPlayers().get(1).getNumberOfCards());
    }

    @Test
    public void canHandleDealersTurnUnder16() {
        game.startGame();
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        game.getDealer().receiveCard(seven);
        game.getDealer().receiveCard(seven);
        game.handleDealersTurn();
        assertNotEquals(2, game.getDealer().getNumberOfCards());
    }

    @Test
    public void canHandleDealersTurnOver16() {
        Card jack = new Card(SuitType.CLUBS, RankType.JACK);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(jack);
        game.handleDealersTurn();
        assertEquals(2, game.getDealer().getNumberOfCards());
    }

    @Test
    public void canHandleDealerBust(){
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(jack);
        game.handleDealerBust();
        assertEquals(game.getPlayers(), game.getWinners());
        assertEquals(1, game.getWinners().size());
    }

    @Test
    public void canPlayGame(){
        game.giveDecksToDealer();
        Card jack = new Card(SuitType.SPADES, RankType.JACK);
        Card nine = new Card(SuitType.HEARTS, RankType.NINE);
        Card seven = new Card(SuitType.CLUBS, RankType.SEVEN);
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        game.getPlayers().get(0).receiveCard(nine);
        game.getPlayers().get(0).receiveCard(jack);
        game.getPlayers().get(0).changeStand();
        game.getDealer().receiveCard(jack);
        game.getDealer().receiveCard(seven);
        game.playGame();
        assertEquals(game.getPlayers(), game.getWinners());
        assertEquals(1, game.getWinners().size());
    }

}
