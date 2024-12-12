package game;

import game.Executioner.Executioner;
import game.Guesser.Guesser;
import util.DisplayWord;

public class HangmanGame {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private Executioner myExecutioner;
    private Guesser myGuesser;
    private DisplayWord myDisplayWord;
    private int myNumGuessesLeft;

    /**
     * This class represents the traditional word-guessing game Hangman
     * that plays interactively with the user.
     *
     * @author Robert C. Duvall
     * @author Shannon Duvall
     */
    
    public HangmanGame(int numGuesses, Executioner executioner, Guesser guesser) {
        myExecutioner = executioner;
        myGuesser = guesser;
        myDisplayWord = executioner.getDisplayWord();
        myNumGuessesLeft = numGuesses;
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            String guessStr = myGuesser.makeGuess();
            if (guessStr.length() == 1 && Character.isAlphabetic(guessStr.charAt(0))) {
                char guess = guessStr.toLowerCase().charAt(0);

                int index = myGuesser.getMyLettersLeftToGuess().indexOf("" + guess);
                if (index >= 0) {
                    myGuesser.recordGuess(index);
                    if (!myExecutioner.checkGuessInSecret(guess, myDisplayWord)) {
                        myNumGuessesLeft -= 1;
                    }

                    if (isGameLost()) {
                        System.out.println("YOU ARE HUNG!!!");
                        gameOver = true;
                    } else if (isGameWon()) {
                        System.out.println("YOU WIN!!!");
                        gameOver = true;
                    }
                } else {
                    System.out.println("You've already guessed that letter!");
                }
            } else {
                System.out.println("Please enter a single letter...");
            }
        }
        myExecutioner.printEnding();
    }

    private boolean isGameWon() {
        return myExecutioner.isGameWon(myDisplayWord);
    }

    private boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }

    private void printStatus() {
        System.out.println(myDisplayWord);
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("*** " + myExecutioner.getSecretWord());
        System.out.println();
    }
}
