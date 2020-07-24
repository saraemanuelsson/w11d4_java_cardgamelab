import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Person {

    private ArrayList<Card> gameCards;

    public Dealer() {
        this.gameCards = new ArrayList<Card>();
    }

    public void populateGameCards(ArrayList<Deck> decks) {
        for (Deck deck : decks) {
            for (Card card : deck.getPlayingCards()) {
                this.gameCards.add(card);
            }
        }
    }

    public int getSizeOfGameCards() {
        return this.gameCards.size();
    }

    public void shuffleGameCards() {
        Collections.shuffle(this.gameCards);
    }

    public Card dealCard() {
        return this.gameCards.remove(0);
    }


}
