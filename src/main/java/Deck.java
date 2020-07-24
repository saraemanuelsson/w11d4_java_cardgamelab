import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> playingCards;

    public Deck() {
        this.playingCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getPlayingCards() {
        return this.playingCards;
    }

    public void addCard(Card card){
        this.playingCards.add(card);
    }

    public int getNumberOfCards () {
        return this.playingCards.size();
    }

    public void populateDeck() {
        for (SuitType suit : SuitType.values()) {
          for (RankType rank : RankType.values()){
            Card card = new Card(suit, rank);
            this.addCard(card);
          }
        }
    }

}
