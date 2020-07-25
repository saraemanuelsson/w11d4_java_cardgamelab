import java.util.ArrayList;

public class Person {

    private ArrayList<Card> handOfCards;
    private int totalValueOfHand;

    public Person() {
        this.handOfCards = new ArrayList<Card>();
        this.totalValueOfHand = 0;
    }

    public ArrayList<Card> getHandOfCards() {
        return this.handOfCards;
    }

    public int getTotalValueOfHand(){
        return this.totalValueOfHand;
    }

    public int getNumberOfCards() {
        return this.handOfCards.size();
    }

    public void receiveCard(Card card) {
        this.handOfCards.add(card);
        addToHandTotal(card);
    }

    public void addToHandTotal(Card card){
        this.totalValueOfHand += card.getValueOfCard();
    }
}
