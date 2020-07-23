import java.util.ArrayList;

public class Player {

private ArrayList<Card> dealtCards;
private String name;
private Boolean winner;

  public Player(String name) {
    this.name = name;
    this.winner = false;
    this.dealtCards = new ArrayList<Card>();
  }

  public String getName() {
    return this.name;
  }

  public Boolean isWinner() {
    return this.winner;
  }

  public ArrayList<Card> getDealtCards() {
    return this.dealtCards;
  }

  public int hasCard() {
    return this.dealtCards.size();
  }

  public void receiveCard(Deck deck) {
    Card dealtCard = deck.dealCard();
    this.dealtCards.add(dealtCard);
  }

  public void setWinner(){
    this.winner = true;
  }

//  public int getValueOfCard(){
//
//  }
  

}
