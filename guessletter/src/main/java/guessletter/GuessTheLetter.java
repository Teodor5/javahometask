package guessletter;
//https://github.com/yegor256/hangman приклад ООП проекту

import javax.swing.*;
import java.security.SecureRandom;
import java.util.regex.Pattern;

//TODO переробити в ООП

public class GuessTheLetter {
    public static void main(String[] args) {

        char randomLetter = getRandomLowerCaseLatinLetter();
        boolean userCorrect = false;
        int attemptsCount = 1;

        String userInputString;
        char userGuessedLetter;
        while (!userCorrect) {
            attemptsCount++;
            String regex = "^[A-Za-z]$";
            do {
                userInputString = JOptionPane.showInputDialog("Введіть, будь ласка, букву: ");
                if(!Pattern.matches(regex, userInputString)){
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
        }
    }

    private static char getRandomLowerCaseLatinLetter() {
        SecureRandom r = new SecureRandom();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.charAt(r.nextInt(alphabet.length()));
    }
}