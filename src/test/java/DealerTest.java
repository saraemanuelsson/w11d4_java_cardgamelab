import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;

    @Before
    public void before() {
        dealer = new Dealer();
    }

    @Test
    public void canPopulateGameCards() {
        Deck deck1 = new Deck();
        deck1.populateDeck();
        Deck deck2 = new Deck();
        deck2.populateDeck();
        ArrayList<Deck> decks = new ArrayList<Deck>();
        decks.add(deck1);
        decks.add(deck2);
        dealer.populateGameCards(decks);
        assertEquals(104, dealer.getSizeOfGameCards());
    }

}
