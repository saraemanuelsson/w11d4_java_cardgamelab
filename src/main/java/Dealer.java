import java.util.ArrayList;

public class Dealer extends Person {

    private ArrayList<Card> gameCards;

    public Dealer() {
        this.gameCards = new ArrayList<Card>();
    }

    public void populateGameCards(ArrayList<Deck> decks) {
        for (Deck deck : decks) {
            this.gameCards.addAll(deck.getPlayingCards());
        }
    }

    public int getSizeOfGameCards() {
        return this.gameCards.size();
    }

}
