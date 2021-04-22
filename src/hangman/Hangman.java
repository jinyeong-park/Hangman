/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

package hangman;

import java.util.ArrayList;


/**
 * abstract class represents a hangman game with some functionalities.
 */
public abstract class Hangman {
	// instance variables
	/**
	 * The selectedWord represent randomly selected word initially
	 * A user need to guess the selectedWord
	 */
	private String selectedWord;
	
	/**
	 * length of selectedWord
	 */
	private int lengthOfWord;
	
	/**
	 * The total number of a user guesses
	 */
	private int totalGuess;
	
	/**
	 * The incorrect guesses from the a user
	 */
	private ArrayList<Character> incorrectGuess = new ArrayList<Character>();
	
	/**
	 * userWord represents a string that reflects the correct guess from user 
	 */
	private String userWord = "";
	

	// constructor
	public Hangman(String selectedWord) {
		// The constructor sets the selectedWord, lengthOfWord, totalGuess, userWord with given selectedWord
		this.selectedWord = selectedWord;
		this.lengthOfWord = selectedWord.length();
		this.totalGuess = 0;
		// iterate over total length of selected word, and create the userWord with "_"
		for (int i = 0; i < this.lengthOfWord; i++) {
			this.userWord += "_";
		}
	}
	
	// methods
	// getters and setters
	/**
	 * getter for selectedWord
	 * @return selectedWord
	 */
	public String getSelectedWord() {
		return selectedWord;
	}
	
	/**
	 * setter for selectedWord
	 * @param selectedWord
	 */
	public void setSelectedWord(String selectedWord) {
		this.selectedWord = selectedWord;
	}

	/**
	 * getter for LengthOfWord
	 * @return LengthOfWord
	 */
	public int getLengthOfWord() {
		return lengthOfWord;
	}

	/**
	 * setter for LengthOfWord
	 * @param lengthOfWord
	 */
	public void setLengthOfWord(int lengthOfWord) {
		this.lengthOfWord = lengthOfWord;
	}

	/**
	 * getter for TotalGuess
	 * @return TotalGuess
	 */
	public int getTotalGuess() {
		return totalGuess;
	}

	/**
	 * setter for TotalGuess
	 */
	public void setTotalGuess() {
		this.totalGuess++;
	}

	/**
	 * getter for IncorrectGuess
	 * @return IncorrectGuess(
	 */
	public ArrayList<Character> getIncorrectGuess() {
		return incorrectGuess;
	}

	/**
	 * setter for incorrectGuess
	 * @param incorrectGuess
	 */
	public void setIncorrectGuess(ArrayList<Character> incorrectGuess) {
		this.incorrectGuess = incorrectGuess;
	}

	/**
	 * getter for UserWord
	 * @return UserWord
	 */
	public String getUserWord() {
		return userWord;
	}

	/**
	 * setter for UserWord
	 * @param userWord
	 */
	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}
	
	// abstract method
	/**
	 * check the character that a user guesses is in the selectedWord.
	 * Every specific type of the hangman (e.g. TraditionalHangman and EvilHangman) has to override 
	 * and implement this method
	 * @param letter
	 */
	public abstract void checkLetterInTheWord(char letter);
	

	// other methods
	/**
	 * Add incorrect guess of the character from the user to incorreactGuess ArrayList
	 * @param letter
	 */
	public void addIncorrectGuesses(char letter) {
		// add letter to incorrectGuesses arrayList
		this.incorrectGuess.add(letter);
		
	}
	
	
	/**
	 * Returns true if the user guess the correct word.
	 * @return boolean
	 */
	public boolean isGameOver() {
		// check the userWord string is same as selectedWord string, return true
		if(this.userWord.equals(this.selectedWord)) {
			return true;
		}
		// otherwise return false
		return false;
	}

}