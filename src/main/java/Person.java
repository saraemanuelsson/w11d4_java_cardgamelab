import java.util.ArrayList;

public class Person {

    private ArrayList<Card> handOfCards;

    public Person() {
        this.handOfCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHandOfCards() {
        return this.handOfCards;
    }

    public int getNumberOfCards() {
        return this.handOfCards.size();
    }

    public void receiveCard(Card card) {
        this.handOfCards.add(card);
    }

    public int getTotalValueOfHand() {
        int total = 0;
        for (Card card : this.handOfCards) {
            total += card.getValueOfCard();
        }
        return total;
    }
}
