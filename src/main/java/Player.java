import java.util.ArrayList;

public class Player {

private ArrayList<Card> handOfCards;
private String name;

  public Player(String name) {
    this.name = name;
    this.handOfCards = new ArrayList<Card>();
  }

  public String getName() {
    return this.name;
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

}
