package twentyone;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    Deck() {
        this.cards = new ArrayList<Card>();
    }

    void createFullDeck() {
        for (Card.Suit cardSuit : Card.Suit.values()) {
            for (Card.Value cardValue : Card.Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }


    //Тасування
    void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt(this.cards.size() - 1 + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }


    void removeCard(int i) {
        this.cards.remove(i);
    }

    Card getCard(int i) {
        return this.cards.get(i);
    }

    private void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    void draw(Deck comingFrom) {

        this.cards.add(comingFrom.getCard(0));

        comingFrom.removeCard(0);
    }

    public String toString() {
        StringBuilder cardListOutput = new StringBuilder();
        for (Card aCard : this.cards) {
            cardListOutput.append("\n").append(aCard.toString());
        }
        return cardListOutput.toString();
    }

    void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.cards.size();
        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }

    int deckSize() {
        return this.cards.size();
    }

    int cardsValue() {
        int totalValue = 0;
        int aces = 0;
        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;
            }
        }


        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }
        return totalValue;

    }


}
