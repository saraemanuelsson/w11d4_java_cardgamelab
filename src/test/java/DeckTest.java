import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty() {
      assertEquals(0, deck.getNumberOfCards());
    }

    @Test
    public void canPopulateDeck() {
      deck.populateDeck();
      assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void canGetPlayingCards(){
        Card card = new Card(SuitType.HEARTS, RankType.ACE);
        deck.populateDeck();
        Card sampleCard = deck.getPlayingCards().get(0);
        assertEquals(card.getSuit(), sampleCard.getSuit());
        assertEquals(card.getRank(), sampleCard.getRank());
    }

}
