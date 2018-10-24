package twentyone;

import org.junit.Assert;
import org.junit.Test;

public class TwentyOneTest {

    @Test
    public void createFullDeckTest() throws InterruptedException {
        Deck deck = new Deck();
        deck.createFullDeck();
        Thread.sleep(5000);
        System.out.println("1");
        Assert.assertSame(52, deck.deckSize());
    }

    @Test
    public void getCardTest() throws InterruptedException {
        Deck deck = new Deck();
        deck.createFullDeck();
        deck.removeCard(1);
        Thread.sleep(5000);
        System.out.println("2");
        Assert.assertSame(Card.class, deck.getCard(2).getClass());
    }

    @Test
    public void removeCardTest() throws InterruptedException {
        Deck deck = new Deck();
        deck.createFullDeck();
        deck.removeCard(1);
        Thread.sleep(5000);
        System.out.println("3");
        Assert.assertSame(51, deck.deckSize());
    }
}
