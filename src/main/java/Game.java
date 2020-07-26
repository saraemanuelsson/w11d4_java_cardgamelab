import java.util.ArrayList;

public class Game {

  private ArrayList<Player> players;
  private Dealer dealer;
  private ArrayList<Person> winners;
  private int numberOfDecks;

  public Game(int numberOfDecks) {
  this.players = new ArrayList<Player>();
  this.dealer = new Dealer();
  this.winners = new ArrayList<Person>();
  this.numberOfDecks = numberOfDecks;
  }

  public int getNumberOfPlayers(){
    return this.players.size();
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public Dealer getDealer() {
    return this.dealer;
  }

  public ArrayList<Player> getPlayers() {
    return this.players;
  }

  public ArrayList<Person> getWinners() {
    return this.winners;
  }

  public void giveDecksToDealer() {
    Deck deck = new Deck();
    deck.populateDeck();

    ArrayList<Deck> decksForDealer = new ArrayList<Deck>();

    for (int i = 0; i < this.numberOfDecks; ++i){
      decksForDealer.add(deck);
    }

    this.dealer.populateGameCards(decksForDealer);
  }

  public void startGame() {
    giveDecksToDealer();
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

  public void getResult(){
    for (Player player : this.players) {
      if (player.getTotalValueOfHand() > this.dealer.getTotalValueOfHand() && !player.getBust()) {
        winners.add(player);
      } else {
        winners.add(this.dealer);
      }
    }
  }

  public Boolean blackJack(Person person) {
    if (person.getTotalValueOfHand() == 21 && person.getNumberOfCards() == 2) {
      return true;
    }
    return false;
  }

  public void handleBlackJack() {

    if (blackJack(this.dealer)) {
      this.winners.add(this.dealer);
    } else {
      for (Player player : this.players) {
        if (blackJack(player)) {
          this.winners.add(player);
          player.changeStand();
        }
      }
    }
  }

  public void handleDealersTurn() {
    while (this.dealer.getTotalValueOfHand() <= 16) {
      Card dealerCard = this.dealer.dealCard();
      this.dealer.receiveCard(dealerCard);
    }
  }

  public void handleDealerBust() {
    if (this.dealer.getBust()) {
      for (Player player : this.players) {
        if (!player.getBust()) {
          this.winners.add(player);
        }
      }
    }
  }

  public void dealMoreCardsToPlayer() {
    for (Player player : this.players) {
      while (!player.getStand() && !player.getBust()) {
        Card dealtCard = this.dealer.dealCard();
        player.receiveCard(dealtCard);
        //handle ace
        //check if player wants more cards
      }
    }
  }

  public ArrayList<Person> playGame() {
    handleBlackJack();
//    handle ace
//    check if players want more cards
    dealMoreCardsToPlayer();
    handleDealersTurn();
    handleDealerBust();
    if (this.winners.size() == 0) {
      getResult();
    }
    return this.winners;
  }

}
