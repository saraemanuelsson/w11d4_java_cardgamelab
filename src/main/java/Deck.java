import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> playingCards;


    public Deck() {
        this.playingCards = new ArrayList<Card>();
    }

    public void addCard (Card card){
        this.playingCards.add(card);
    }

    public int getNumberOfCards () {
        return this.playingCards.size();
    }

// public void populateDeck() {

// }

// public void shuffleDeck() {

// }

// public void dealFromDeck() {

// }

}
