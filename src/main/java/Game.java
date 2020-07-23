import java.util.ArrayList;

public class Game {

  private ArrayList<Player> players;


    public Game(){
    this.players = new ArrayList<Player>();
  }

  public void addPlayer(Player player){
    this.players.add(player);
  }

  public void winnerPlayer(Player player1, Player player2) {
    Card player1card = player1.getDealtCards().get(0);
    Card player2card = player2.getDealtCards().get(0);
    if (player1card.getValueFromEnum() > player2card.getValueFromEnum()){
      player1.setWinner();
    } else {
      player2.setWinner();
    }


  }




  // Start game
  // Deal cards
  // Print player 1 & player 2
  // Announce winner

}
