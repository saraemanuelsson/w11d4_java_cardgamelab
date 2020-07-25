import java.util.ArrayList;

public class Game {

  private ArrayList<Player> players;
  private ArrayList<Deck> decks;
  private Dealer dealer;

  public Game() {
  this.players = new ArrayList<Player>();
  this.decks = new ArrayList<Deck>();
  this.dealer = new Dealer();
  }

  public int getNumberOfPlayers(){
    return this.players.size();
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public int getNumberOfDecks() {
    return this.decks.size();
  }

  public Dealer getDealer(){
    return this.dealer;
  }

  public ArrayList<Player> getPlayers(){
    return this.players;
  }

  public void giveDecksToDealer(int numberOfDecks) {
    Deck deck = new Deck();
    deck.populateDeck();

    for (int i = 0; i < numberOfDecks; ++i){
      this.decks.add(deck);
    }

    this.dealer.populateGameCards(this.decks);
  }

  public void startGame() {
    this.dealer.shuffleGameCards();

    //burn first card
    this.dealer.dealCard();

    for (int i = 0; i < 2; ++i) {
      for (Player player : this.players) {
        Card dealtCard = this.dealer.dealCard();
        player.receiveCard(dealtCard);
      }
      Card dealerCard = this.dealer.dealCard();
      this.dealer.receiveCard(dealerCard);
    }
  }

//  public Person getWinner(){
//    for (Player player : this.players) {
//      if(player.getTotalValueOfHand() > 21)
//    }
//  }

}
