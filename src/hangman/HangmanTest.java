/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

package hangman;

import java.util.ArrayList;
/**
 * Tests for Hangman, Traditioanl Hangman and EvilHangman
 */
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HangmanTest {
	
	Hangman hangman;
	Hangman hangmanEvil;


	@Test
	// getters and setters
	void testGetSelectedWord() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		assertEquals("help", hangman.getSelectedWord());
		
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		assertEquals("help", hangmanEvil.getSelectedWord());
		
	}
	
	void testGetLengthOfWord() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		assertEquals(4, hangman.getLengthOfWord());
		
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
	
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		assertEquals(4, hangmanEvil.getLengthOfWord());
		
	}

	void testGetTotalGuess() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		assertEquals(0, hangman.getTotalGuess());
		// test checkLetterInTheWord
		hangman.checkLetterInTheWord('a');
		assertEquals(1, hangman.getTotalGuess());
		hangman.checkLetterInTheWord('h');
		assertEquals(2, hangman.getTotalGuess());
		
		// test checkLetterInTheWord --- Evil Hangman
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		hangmanEvil.checkLetterInTheWord('a');
		assertEquals(1, hangmanEvil.getTotalGuess());
		hangmanEvil.checkLetterInTheWord('h');
		assertEquals(2, hangmanEvil.getTotalGuess());
	}
	
	void testGetIncorrectGuess() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		//assertEquals(, hangman.getIncorrectGuess());
		ArrayList<Character> arr = new ArrayList<Character>();
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		hangman.checkLetterInTheWord('a');
		arr.add('a');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());

		hangman.checkLetterInTheWord('h');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		//assertEquals(, hangman.getIncorrectGuess());
		
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		ArrayList<Character> arr1 = new ArrayList<Character>();
		assertArrayEquals(arr1.toArray(), hangmanEvil.getIncorrectGuess().toArray());
		hangmanEvil.checkLetterInTheWord('a');
		arr.add('a');
		assertArrayEquals(arr1.toArray(), hangmanEvil.getIncorrectGuess().toArray());
		// both group of words "h___" and "____" have two words in it, 
		// the first one "h___" is being chosen by computer
		hangmanEvil.checkLetterInTheWord('h');
		assertArrayEquals(arr1.toArray(), hangmanEvil.getIncorrectGuess().toArray());
		
		
		
	}

	void tesGetUserWord() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		assertEquals("____", hangman.getUserWord());
		hangman.checkLetterInTheWord('a');
		assertEquals("____", hangman.getUserWord());
		hangman.checkLetterInTheWord('h');
		assertEquals("h___", hangman.getUserWord());
		
		// Evil Hnangman
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		assertEquals("____", hangmanEvil.getUserWord());
		hangmanEvil.checkLetterInTheWord('a');
		assertEquals("____", hangmanEvil.getUserWord());
		hangmanEvil.checkLetterInTheWord('h');
		assertEquals("h___", hangmanEvil.getUserWord());
		
	}


	void testCheckLetterInTheWord() {
		// test traditional 
		String selectedWord = "help";

		//words.add("hair");
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		// test checkLetterInTheWord
		hangman.checkLetterInTheWord('a');
		assertEquals("____", hangman.getUserWord());
		
		hangman.checkLetterInTheWord('p');
		assertEquals("___p", hangman.getUserWord());
		
		hangman.checkLetterInTheWord('e');
		assertEquals("_e_p", hangman.getUserWord());
		
		// Evil Hangman
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		//words.add("hair");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);

		hangmanEvil.checkLetterInTheWord('a');
		assertEquals("____", hangmanEvil.getUserWord());
		
		hangmanEvil.checkLetterInTheWord('p');
		assertEquals("___p", hangmanEvil.getUserWord());
		
		hangmanEvil.checkLetterInTheWord('e');
		assertEquals("_e_p", hangmanEvil.getUserWord());

	
	}
	
	void testUpdateUserWord() {
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		// test checkLetterInTheWord
		
		hangman.updateUserWord(3, 'p');
	
		assertEquals("___p", hangman.getUserWord());
		
		hangman.updateUserWord(1, 'e');
		assertEquals("_e_p", hangman.getUserWord());

		hangman.updateUserWord(0, 'h');
		assertEquals("he_p", hangman.getUserWord());
//		
	
	}
	


	void testAddIncorrectGuesses() {
		// add letter to incorrectGuesses arrayList
		// test traditional 
		String selectedWord = "help";
		TraditionalHangman hangman = new TraditionalHangman(selectedWord);
		
		ArrayList<Character> arr = new ArrayList<Character>();
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		hangman.addIncorrectGuesses('a');
		arr.add('a');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		hangman.addIncorrectGuesses('l');
		arr.add('l');
		assertArrayEquals(arr.toArray(), hangman.getIncorrectGuess().toArray());
		
		//evil
		// test evil 
		ArrayList<String> words = new ArrayList<String>();
		words.add("feel");
		words.add("heel");
		words.add("help");
		words.add("belt");
		//words.add("hair");
		EvilHangman hangmanEvil = new EvilHangman(selectedWord, words);
		arr = new ArrayList<Character>();
		assertArrayEquals(arr.toArray(), hangmanEvil.getIncorrectGuess().toArray());
		
		hangmanEvil.addIncorrectGuesses('a');
		arr.add('a');
		assertArrayEquals(arr.toArray(), hangmanEvil.getIncorrectGuess().toArray());
		
		hangmanEvil.addIncorrectGuesses('l');
		arr.add('l');
		assertArrayEquals(arr.toArray(), hangmanEvil.getIncorrectGuess().toArray());

		

		
		
	}
	
	

}
