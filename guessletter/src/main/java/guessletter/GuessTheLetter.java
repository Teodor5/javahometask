package guessletter;

import javax.swing.*;
import java.security.SecureRandom;
import java.util.regex.Pattern;


public class GuessTheLetter {
    private final char letter;

    GuessTheLetter() {
        letter = (char) (new SecureRandom().nextInt(26) + 'a');
    }

    char getLetter() {
        return letter;
    }

    public static void main(String[] args) {

        GuessTheLetter game = new GuessTheLetter();
        game.start();
    }

    private void start() {
        char randomLetter = this.getLetter();
        boolean userCorrect = false;
        int attemptsCount = 1;
        String userInputString;
        char userGuessedLetter;
        //Ігровий цикл
        while (!userCorrect) {
            String regex = "^[A-Za-z]$";
            do {
                userInputString = JOptionPane.showInputDialog("Введіть, будь ласка, букву: ");
                if (!Pattern.matches(regex, userInputString)) {
                    JOptionPane.showMessageDialog(null, "ПІДКАЗКА\nЗа правилами гри ви повинні ввести одну латинську літеру");
                }
            } while (!Pattern.matches(regex, userInputString));
            userGuessedLetter = userInputString.toLowerCase().charAt(0);
            if (userGuessedLetter > randomLetter) {
                JOptionPane.showMessageDialog(null, "Введіть букву ближчу до початку алфавіту, спробуйте ще раз");
            } else if (userGuessedLetter < randomLetter) {
                JOptionPane.showMessageDialog(null, "Введіть букву ближчу до кінця алфавіту, спробуйте ще раз");
            } else {
                JOptionPane.showMessageDialog(null, "Вірно, ви відгадали букву \"" + randomLetter + "\". Ви впоралися за стільки спроб: " + attemptsCount + "!");
                userCorrect = true;
            }
            attemptsCount++;
        }
    }

}