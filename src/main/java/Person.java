import java.util.ArrayList;

public class Person {

    private ArrayList<Card> handOfCards;
    private int totalValueOfHand;
    private Boolean bust;
    private Boolean stand;

    public Person() {
        this.handOfCards = new ArrayList<Card>();
        this.totalValueOfHand = 0;
        this.bust = false;
        this.stand = false;
    }

    public ArrayList<Card> getHandOfCards() {
        return this.handOfCards;
    }

    public int getTotalValueOfHand() {
        return this.totalValueOfHand;
    }

    public Boolean getStand() {
        return this.stand;
    }

    public Boolean getBust() {
        return this.bust;
    }

    public int getNumberOfCards() {
        return this.handOfCards.size();
    }

    public int countAces() {
        int numberOfAces = 0;
        for (Card card : this.handOfCards) {
            if (card.getRank() == RankType.ACE) {
                numberOfAces += 1;
            }
        }
        return numberOfAces;
    }

    public void handleAcesIfBust() {
        for (int i = 0; i < countAces(); ++i ) {
            while (this.totalValueOfHand > 21) {
                this.totalValueOfHand -= 10;
            }
        }
        if (this.totalValueOfHand > 21) {
            this.bust = true;
        }
    }

    public void receiveCard(Card card) {
        this.handOfCards.add(card);
        addToHandTotal(card);
        handleAcesIfBust();
    }

    public void addToHandTotal(Card card) {
        this.totalValueOfHand += card.getValueOfCard();
    }


    public void changeStand(){
        this.stand = !this.stand;
    }

}
