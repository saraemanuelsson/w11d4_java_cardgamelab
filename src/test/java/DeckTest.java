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

    @Test
    public void canRemoveTopCard(){
        deck.populateDeck();
        deck.removeTopCard();
        assertEquals(51, deck.getNumberOfCards());
    }

    @Test
    public void testRemoveCardUnshuffled(){
      Card card = new Card(SuitType.HEARTS, RankType.ACE);
      deck.populateDeck();
      Card dealtCard = deck.removeTopCard();
      assertEquals(card.getSuit(), dealtCard.getSuit());
      assertEquals(card.getRank(), dealtCard.getRank());
    }

    @Test
    public void canShuffle(){
      Card card = new Card(SuitType.HEARTS, RankType.ACE);
      deck.populateDeck();
      deck.shuffleDeck();
      assertNotSame(card, deck.removeTopCard());
    }

}
