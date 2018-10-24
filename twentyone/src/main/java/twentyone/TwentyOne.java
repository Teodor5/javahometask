package twentyone;

import java.util.Scanner;

public class TwentyOne {

    public static void main(String[] args) {

        //колода круп'є
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        //карти у руках гравця
        Deck playerCards = new Deck();
        //гроші гравця
        double playerMoney = 500.0;
        //карти у руказ круп'є
        Deck dealerCards = new Deck();


        Scanner userInput = new Scanner(System.in);

        //Грати поки є гроші у гравця
        //Цикл
        while (playerMoney > 0) {
            //Take Bet
            System.out.println("У вас є $" + playerMoney + ", який хочете розмір ставки?");
            double playerBet = userInput.nextDouble();
            if (playerBet > playerMoney) {
                System.out.println("Ставка не може перевищувати кількість ваших грошей");
                break;
            }

            System.out.println("Роздача...");
            //Гравець отримує дві карти
            playerCards.draw(playingDeck);
            playerCards.draw(playingDeck);

            //Круп'є отримує дві карти
            dealerCards.draw(playingDeck);
            dealerCards.draw(playingDeck);

            //Поки цикл, то роздача нових карт
            boolean endRound = false;
            while (true) {
                //Показати карти гравця
                System.out.println("Ваші карти:" + playerCards.toString());

                //Очки гравця
                System.out.println("Кількість очок ваших карт: " + playerCards.cardsValue());

                //Показати карти круп'є
                System.out.println("Карти круп'є: " + dealerCards.getCard(0).toString() + " та [приховано]");

                //Їх вибір
                System.out.println("Ви хочете (1)Грати або (2)Пасувати");
                int response = userInput.nextInt();
                //Грають
                if (response == 1) {
                    playerCards.draw(playingDeck);
                    System.out.println("Ви берете:" + playerCards.getCard(playerCards.deckSize() - 1).toString());
                    //Перебір, якщо більше 21
                    if (playerCards.cardsValue() > 21) {
                        System.out.println("Перебір. Поточна кількість: " + playerCards.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }

                //Пасувати
                if (response == 2) {
                    break;
                }

            }

            //розкрити карти круп'є
            System.out.println("Карти круп'є:" + dealerCards.toString());
            //Перевірити чи у круп'є не більше очок
            if ((dealerCards.cardsValue() > playerCards.cardsValue()) && !endRound) {
                System.out.println("Круп'є переміг вас " + dealerCards.cardsValue() + " проти " + playerCards.cardsValue());
                playerMoney -= playerBet;
                endRound = true;
            }
            //Правила гри для круп'є такі: він зобов'язаний брати додаткові карти, якщо сума його очок менше за 17 і повинен зупинитися, якщо очок 17 і більше.
            while ((dealerCards.cardsValue() < 17) && !endRound) {
                dealerCards.draw(playingDeck);
                System.out.println("Круп'є бере: " + dealerCards.getCard(dealerCards.deckSize() - 1).toString());
            }
            //Кількість очок у круп'є
            System.out.println("У круп'є на руках: " + dealerCards.cardsValue());
            //Перевірити чи круп'є не програв
            if ((dealerCards.cardsValue() > 21) && !endRound) {
                System.out.println("У круп'є перебір. Ви виграли!");
                playerMoney += playerBet;
                endRound = true;
            }
            //Перевірка на "рівно"
            if ((dealerCards.cardsValue() == playerCards.cardsValue()) && !endRound) {
                System.out.println("Всі при своїх ставках, нікто не виграв");
                endRound = true;
            }
            //Перевірити чи гравець виграв
            if ((playerCards.cardsValue() > dealerCards.cardsValue()) && !endRound) {
                System.out.println("Ви виграли.");
                playerMoney += playerBet;
            } else if (!endRound) //круп'є виграв
            {
                System.out.println("Круп'є переміг.");
                playerMoney -= playerBet;
            }


            playerCards.moveAllToDeck(playingDeck);
            dealerCards.moveAllToDeck(playingDeck);
            System.out.println("Кінець роздачі");

        }
        //Game over
        System.out.println("Ви програли:(");
        userInput.close();

    }


}
