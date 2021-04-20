package hangman;

import java.util.ArrayList;
//import java.util.Arrays;

public abstract class Hangman {
	// instance variables
	private String selectedWord;
	private int lengthOfWord;
	private int totalGuess;
	
	private ArrayList<Character> incorrectGuess = new ArrayList<Character>();
	//private CharSequence[] updatedWord;
	private String userWord = "";
	

	// constructor
	public Hangman(String selectedWord) {
		this.selectedWord = selectedWord;
		this.lengthOfWord = selectedWord.length();
		this.totalGuess = 0;
		//this.updatedWord = new CharSequence[this.lengthOfWord];  //[ _, , ,]
		//StringBuilder builder = new StringBuilder();
		for (int i = 0; i < this.lengthOfWord; i++) {
			this.userWord += "_";
		}
		// convert updateWord array to string  // "_______"
		//this.userWord = Arrays.toString(this.updatedWord);
	

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

	public void setTotalGuess() {
		this.totalGuess++;
	}

	public ArrayList<Character> getIncorrectGuess() {
		return incorrectGuess;
	}

	public void setIncorrectGuess(ArrayList<Character> incorrectGuess) {
		this.incorrectGuess = incorrectGuess;
	}

//	public char[] getUpdatedWord() {
//		return updatedWord;
//	}
//
//	public void setUpdatedWord(CharSequence[] updatedWord) {
//		this.updatedWord = updatedWord;
//	}
//	
	public String getUserWord() {
		return userWord;
	}

	public void setUserWord(String userWord) {
		this.userWord = userWord;
	}
	
	// other methods
	public void checkLetterInTheWord(char letter) {
		// if checkLengthInTheWord true, 
		this.totalGuess++;
		int firstOccurenceIdx = selectedWord.indexOf(letter);
		if (firstOccurenceIdx != -1) {
			// for loop, and add index into the list and pass list
			for (int i = firstOccurenceIdx; i < lengthOfWord; i++) {
				if (this.selectedWord.charAt(i) == letter) {
					this.updateUserWord(i, letter);
					
				}
			}
			
		} else {
			// otherwise, add it to incorrectGuesses (call addIncorrectGuesses())
			this.incorrectGuess.add(letter);
			
		}
		 
	}
	
	/**
	 * 
	 * @param index
	 */
	public void updateUserWord(int index, char letter) {
		// access index of selectedWord 
		// update updatedWord[]
		//this.updatedWord[index] = (CharSequence)letter;
		//this.userWord = String.join(",", this.updatedWord);
		this.userWord = this.userWord.substring(0,index) + letter + this.userWord.substring(index + 1);

		
		
	}
	
	/**
	 * 
	 */
	public void addIncorrectGuesses(char letter) {
		// add letter to incorrectGuesses arrayList
		this.incorrectGuess.add(letter);
		
	}
	
	public boolean isGameOver() {
		// check the userWord array is same as array ver of selectedWord
		// 1. either userword array  -> striing
		// 2. selectedString -> array
	
		if(this.userWord.equals(this.selectedWord)) {
			return true;
		}
		return false;
	}

}