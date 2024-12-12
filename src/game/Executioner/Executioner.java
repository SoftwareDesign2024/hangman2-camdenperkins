package game.Executioner;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {
    protected String mySecretWord;

    public Executioner(HangmanDictionary dictionary, int wordLength) {
        mySecretWord = makeSecretWord(dictionary, wordLength);
    }

    public DisplayWord getDisplayWord() {
        return new DisplayWord(mySecretWord);
    }

    public void printEnding() {
        System.out.println("The secret word was " + mySecretWord);
    }

    private String makeSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }

    public boolean checkGuessInSecret(char guess, DisplayWord displayWord) {
        if (mySecretWord.indexOf(guess) >= 0) {
            displayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    public boolean isGameWon(DisplayWord displayWord) {
        return displayWord.equals(mySecretWord);
    }

    public String getSecretWord() {
        return mySecretWord;
    }
}
