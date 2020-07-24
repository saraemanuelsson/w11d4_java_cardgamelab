import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Person {

    private Deck gameCards;

    public Dealer() {
        this.gameCards = new Deck();
    }

    public void populateGameCards(ArrayList<Deck> decks) {
        for (Deck deck : decks) {
            for (Card card : deck.getPlayingCards()) {
                this.gameCards.addCard(card);
            }
        }
    }

    public int getSizeOfGameCards() {
        return this.gameCards.getNumberOfCards();
    }

    public void shuffleGameCards() {
        Collections.shuffle(this.gameCards.getPlayingCards());
    }

    public Card dealCard() {
        return this.gameCards.removeTopCard();
    }


}
