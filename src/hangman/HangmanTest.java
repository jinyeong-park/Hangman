package hangman;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanTest {
	
	Hangman hangman;
	Hangman hangmanEvil;

	@BeforeEach
	void setUp() throws Exception {
		// test traditional 
		String selectedWord = "help";
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		//words.add("hair");
		hangman = new TraditionalHangman(selectedWord);
		hangmanEvil = new EvilHangman(selectedWord, words);
		
	}

	@Test
	// getters and setters
	void testGetSelectedWord() {
		assertEquals("help", hangman.getSelectedWord());
		assertEquals("help", hangmanEvil.getSelectedWord());
		
	}
	
	void testGetLengthOfWord() {
		assertEquals(4, hangman.getLengthOfWord());
		assertEquals(4, hangmanEvil.getLengthOfWord());
		
	}

	void testGetTotalGuess() {
		assertEquals(0, hangman.getTotalGuess());
		// test checkLetterInTheWord
		hangman.checkLetterInTheWord('a');
		assertEquals(1, hangman.getTotalGuess());
		hangman.checkLetterInTheWord('h');
		assertEquals(2, hangman.getTotalGuess());
		
		// test checkLetterInTheWord --- Evil Hangman
		hangmanEvil.checkLetterInTheWord('a');
		assertEquals(1, hangmanEvil.getTotalGuess());
		hangmanEvil.checkLetterInTheWord('h');
		assertEquals(2, hangmanEvil.getTotalGuess());
	}
	
	void testGetIncorrectGuess() {
		//assertEquals(, hangman.getIncorrectGuess());
		ArrayList<Character> arr = new ArrayList<Character>();
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		hangman.checkLetterInTheWord('a');
		arr.add('a');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());

		hangman.checkLetterInTheWord('h');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		//assertEquals(, hangman.getIncorrectGuess());
		ArrayList<Character> arr1 = new ArrayList<Character>();
		assertArrayEquals(arr1.toArray(), hangman.getIncorrectGuess().toArray());
		hangman.checkLetterInTheWord('a');
		arr.add('a');
		assertArrayEquals(arr1.toArray(), hangman.getIncorrectGuess().toArray());

		hangman.checkLetterInTheWord('h');
		assertArrayEquals(arr1.toArray(), hangman.getIncorrectGuess().toArray());
		
		
		
	}

	void tesGetUserWord() {
		assertEquals("____", hangman.getUserWord());
		hangman.checkLetterInTheWord('a');
		assertEquals("____", hangman.getUserWord());
		hangman.checkLetterInTheWord('h');
		assertEquals("h___", hangman.getUserWord());
	}


	void testCheckLetterInTheWord() {
		// test checkLetterInTheWord
		hangman.checkLetterInTheWord('a');
		assertEquals("____", hangman.getUserWord());
		
		hangman.checkLetterInTheWord('p');
		assertEquals("___p", hangman.getUserWord());
		
		hangman.checkLetterInTheWord('e');
		assertEquals("_e_p", hangman.getUserWord());

	
	}
	
	void testUpdateUserWord() {
		// test checkLetterInTheWord
		
		hangman.updateUserWord(3, 'p');
	
		assertEquals("___p", hangman.getUserWord());
		
		hangman.updateUserWord(1, 'e');
		assertEquals("_e_p", hangman.getUserWord());

		hangman.updateUserWord(0, 'h');
		assertEquals("he_p", hangman.getUserWord());
	
	}
	


	void testAddIncorrectGuesses() {
		// add letter to incorrectGuesses arrayList

		
		ArrayList<Character> arr = new ArrayList<Character>();
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		hangman.addIncorrectGuesses('a');
		arr.add('a');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		hangman.addIncorrectGuesses('l');
		arr.add('l');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());

		
		
	}
	
	

}
