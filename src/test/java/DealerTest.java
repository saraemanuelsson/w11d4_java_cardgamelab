import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;
    private ArrayList<Deck> decks;

    @Before
    public void before() {
        dealer = new Dealer();
        deck = new Deck();
        deck.populateDeck();
        decks = new ArrayList<Deck>();
        decks.add(deck);
    }

    @Test
    public void canPopulateGameCards() {
        Deck deck2 = new Deck();
        deck2.populateDeck();
        decks.add(deck2);
        dealer.populateGameCards(decks);
        assertEquals(104, dealer.getSizeOfGameCards());
    }

    @Test
    public void canShuffle(){
        Card card = new Card(SuitType.HEARTS, RankType.ACE);
        ArrayList<Deck> gameDeck = new ArrayList<Deck>();
        gameDeck.add(deck);
        dealer.populateGameCards(gameDeck);
        dealer.shuffleGameCards();
        assertNotSame(card, dealer.dealCard());
    }

    @Test
    public void canDealCard(){
        dealer.populateGameCards(decks);
        dealer.dealCard();
        assertEquals(51, dealer.getSizeOfGameCards());
    }

}
