import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;
    private Card card;

    @Before
    public void before(){
        person = new Person();
        card = new Card(SuitType.SPADES, RankType.JACK);
    }

    @Test
    public void testStartsWithEmptyHand() {
        assertEquals(0, person.getNumberOfCards());
    }

    @Test
    public void canReceiveCard() {
        person.receiveCard(card);
        assertEquals(1, person.getNumberOfCards());
    }

    @Test
    public void canGetHandOfCards() {
        person.receiveCard(card);
        assertEquals(card, person.getHandOfCards().get(0));
    }

    @Test
    public void canGetTotalValueOfHand() {
        person.receiveCard(card);
        person.receiveCard(card);
        assertEquals(20, person.getTotalValueOfHand());
    }

    @Test
    public void startsAtStandFalse() {
        assertFalse(person.getStand());
    }

    @Test
    public void canChangeStand() {
        person.changeStand();
        assertTrue(person.getStand());
    }

    @Test
    public void aceTurnsTo1IfBust() {
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        Card five = new Card(SuitType.CLUBS, RankType.FIVE);
        person.receiveCard(ace);
        person.receiveCard(five);
        person.receiveCard(card);
        assertEquals(16, person.getTotalValueOfHand());
    }

    @Test
    public void multipleAcesTurnsTo1IfBust() {
        Card ace = new Card(SuitType.CLUBS, RankType.ACE);
        Card five = new Card(SuitType.CLUBS, RankType.FIVE);
        person.receiveCard(ace);
        person.receiveCard(five);
        person.receiveCard(card);
        person.receiveCard(ace);
        assertEquals(17, person.getTotalValueOfHand());
    }

}
