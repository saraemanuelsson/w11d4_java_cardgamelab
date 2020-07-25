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
    public void willSetTotalOfHandTo0IfBust() {
        person.receiveCard(card);
        person.receiveCard(card);
        person.receiveCard(card);
        assertEquals(0, person.getTotalValueOfHand());
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

}
