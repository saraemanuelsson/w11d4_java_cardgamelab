import java.util.ArrayList;

public class Game {

  private ArrayList<Player> players;
  private Deck deck;

  public Game(){
  this.players = new ArrayList<Player>();
  this.deck = new Deck();
  }

  public int getNumberOfPlayers(){
    return this.players.size();
  }

  public void addPlayer(Player player){
    this.players.add(player);
  }

}
