package twentyone;

import org.junit.Assert;
import org.junit.Test;

public class TwentyOneTest {

    @Test
    public void createFullDeckTest() {
        Deck deck = new Deck();
        deck.createFullDeck();
        Assert.assertSame(52, deck.deckSize());
    }

    @Test
    public void getCardTest() {
        Deck deck = new Deck();
        deck.createFullDeck();
        deck.removeCard(1);
        Assert.assertSame(Card.class, deck.getCard(2).getClass());
    }

    @Test
    public void removeCardTest() {
        Deck deck = new Deck();
        deck.createFullDeck();
        deck.removeCard(1);
        Assert.assertSame(51, deck.deckSize());
    }
}
