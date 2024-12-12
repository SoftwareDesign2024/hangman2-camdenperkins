package game.Guesser;

import game.HangmanGame;
import util.ConsoleReader;

public class Guesser {
    private StringBuilder myLettersLeftToGuess;

    public Guesser() {
        this.myLettersLeftToGuess = new StringBuilder(HangmanGame.ALPHABET);
    }

    public String makeGuess() {
        return ConsoleReader.promptString("Make a guess: ");
    }

    public void recordGuess(int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }

    public StringBuilder getMyLettersLeftToGuess() {
        return myLettersLeftToGuess;
    }
}
