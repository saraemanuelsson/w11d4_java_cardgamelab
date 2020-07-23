import org.junit.Before;
import org.junit.Test;

public class CardTest {

  private Card card;

  @Before
  public void before(){
    card = new Card(SuitType.HEARTS, RankType.TEN);
  }

//  @Test
//  public void getSuit(){
//    assertEquals(SuitType.HEARTS, card.getSuit());
//  }
//
//  @Test
//  public void getRank(){
//    assertEquals(RankType.TEN, card.getRank());
//  }

}
