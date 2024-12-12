import game.Executioner.CheatingExecutioner;
import game.Executioner.Executioner;
import game.Guesser.AutoGuesser;
import game.Guesser.Guesser;
import util.HangmanDictionary;
import game.HangmanGame;

/**
 * This class launches the Hangman game and plays once.
 * 
 * @version 1.0
 * @since 2024-12-12
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;

    public static void main(String[] args) {
        HangmanDictionary dictionary = new HangmanDictionary(DICTIONARY);
        Executioner executioner = new CheatingExecutioner(dictionary, NUM_LETTERS);
        Guesser guesser = new AutoGuesser();
        new HangmanGame(NUM_MISSES, executioner, guesser).play();
    }
}
