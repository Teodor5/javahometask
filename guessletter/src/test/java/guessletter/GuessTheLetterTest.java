package guessletter;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;


public  class GuessTheLetterTest {
    @Test
    public void generateLetterTest(){
        GuessTheLetter game = new GuessTheLetter();
        String regex = "^[a-z]$";
        Assert.assertTrue("Перевірка входження згенерованї букви у діапазон [a-z]", Pattern.matches(regex, Character.toString(game.getLetter())));
    }
}