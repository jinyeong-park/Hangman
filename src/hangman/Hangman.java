package hangman;

import java.util.ArrayList;

public abstract class Hangman {
	// instance variables
	private String selectedWord;
	private int lengthOfWord;
	private int totalGuess;
	
	private ArrayList<String> incorrectGuess = new ArrayList<String>();
	private String updatedWord[];
	
	// constructor
	public Hangman(String selectedWord) {
		this.selectedWord = selectedWord;
		this.lengthOfWord = selectedWord.length();
		this.totalGuess = 0;
		this.updatedWord = new String[this.lengthOfWord];

	}
	
	// methods
	// getters and setters
	public String getSelectedWord() {
		return selectedWord;
	}

	public void setSelectedWord(String selectedWord) {
		this.selectedWord = selectedWord;
	}

	public int getLengthOfWord() {
		return lengthOfWord;
	}

	public void setLengthOfWord(int lengthOfWord) {
		this.lengthOfWord = lengthOfWord;
	}

	public int getTotalGuess() {
		return totalGuess;
	}

	public void setTotalGuess(int totalGuess) {
		this.totalGuess = totalGuess;
	}

	public ArrayList<String> getIncorrectGuess() {
		return incorrectGuess;
	}

	public void setIncorrectGuess(ArrayList<String> incorrectGuess) {
		this.incorrectGuess = incorrectGuess;
	}

	public String[] getUpdatedWord() {
		return updatedWord;
	}

	public void setUpdatedWord(String[] updatedWord) {
		this.updatedWord = updatedWord;
	}
	
	// other methods
	public void checkLetterInTheWord(Character letter) {
		// if checkLengthInTheWord true, 
		if (selectedWord.indexOf(letter) != -1) {
			// get the index of the char(letter)
			int letterIdx = selectedWord.indexOf(letter);
			// call updateUserWord(int indexToUpdate)
			updateUserWord(letterIdx);
			
		} else {
			// otherwise, add it to incorrectGuesses (call addIncorrectGuesses())
			
		}
		 
	}
	
	/**
	 * 
	 * @param index
	 */
	public void updateUserWord(int index) {
		// access index of selectedWord 
		// update updatedWord[]
		
		
		
	}
	
	/**
	 * 
	 */
	void addIncorrectGuesses(letter) {
		// add letter to incorrectGuesses arrayList
		
	}

}
