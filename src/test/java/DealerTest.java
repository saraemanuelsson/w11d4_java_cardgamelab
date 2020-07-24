import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DealerTest {

    private Dealer dealer;
    private Deck deck;

    @Before
    public void before() {
        dealer = new Dealer();
        deck = new Deck();
        deck.populateDeck();
    }

    @Test
    public void canPopulateGameCards() {
        Deck deck2 = new Deck();
        deck2.populateDeck();
        ArrayList<Deck> decks = new ArrayList<Deck>();
        decks.add(deck);
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

}
