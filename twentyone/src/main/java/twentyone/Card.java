package twentyone;

public class Card {
    public enum Value {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    public enum Suit {HEART, SPADE, DIAMOND, CLUB}

    private Suit suit;
    private Value value;

    Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    Value getValue() {
        return this.value;
    }


}
