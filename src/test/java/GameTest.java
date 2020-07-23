import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GameTest {

   private Player player1;
   private Player player2;
   private Game game;
   private Deck deck;

   @Before
    public void before() {
       player1 = new Player("Alice");
       player2 = new Player("Bob");
       game = new Game();
       game.addPlayer(player1);
       game.addPlayer(player2);
       deck = new Deck();
       deck.populateDeck();
       deck.shuffleDeck();
       player1.receiveCard();
       player2.receiveCard();
   }

   @Test
   public void willSetWinner(){
     game.winnerPlayer();
     assertFalse(!player1.isWinner());
   }

//   @Test
//   public void hasPlayers(){
//      assertEquals();
//   }


}
