import java.util.ArrayList;

public class Dealer extends Person {

    private ArrayList<Card> gameCards;

    public Dealer() {
        this.gameCards = new ArrayList<Card>();
    }

    public int getSizeOfGameCards() {
        return this.gameCards.size();
    }

}
