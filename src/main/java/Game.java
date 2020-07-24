import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

  private ArrayList<Player> players;
  private ArrayList<Deck> decks;

  public Game() {
  this.players = new ArrayList<Player>();
  this.decks = new ArrayList<Deck>();
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

  public ArrayList<Deck> getDecks(int numberOfDecks) {
    Deck deck = new Deck();
    deck.populateDeck();

    for (int i = 0; i < numberOfDecks; ++i){
      this.decks.add(deck);
    }

    return this.decks;
  }

//  public void startGame() {
//
//    // give arraylist of decks to dealer which will populate cards
//    // deal 2 cards to each player and burn 2
//  }

}
