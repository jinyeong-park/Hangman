/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

package hangman;

/**
 * Represents subclass of hangman, TraditionalHangman game
 */
public class TraditionalHangman extends Hangman {

	// constructor
	public TraditionalHangman(String selecedWord){
		// call parent class constructor with given selecedWord
		super(selecedWord);
	}

	
	// subclass methods (traditional)
	/**
	 * check the character that a user guesses is in the selectedWord.
	 */
	public void checkLetterInTheWord(char letter) {
		// increase total guess
		this.setTotalGuess();
		// find the index of given letter from user guess in the selectedWord
		int firstOccurenceIdx = this.getSelectedWord().indexOf(letter);
		// if user guess is correct guess in the selectedWord
		if (firstOccurenceIdx != -1) {
			// iterate as the length of selectedWord and check
			for (int i = firstOccurenceIdx; i < this.getLengthOfWord(); i++) {
				// if the letter is in the selected word
				if (this.getSelectedWord().charAt(i) == letter) {
					// update userword with given letter in the correct location 
					this.updateUserWord(i, letter);
				}
			}
		} else {
			// otherwise, add it to incorrectGuesses (call addIncorrectGuesses())
			this.addIncorrectGuesses(letter);
		} 
	}
	
	/**
	 * update user word with given letter in the index of userWord of string
	 * @param index
	 */
	public void updateUserWord(int index, char letter) {
		// divide three parts in the given string of userWord string
		// first part (from beginning to before given index)
		// second part - letter (given letter with index)
		// last part - the remaining part
		// connect those three parts.
		this.setUserWord(this.getUserWord().substring(0,index) + letter + this.getUserWord().substring(index + 1));

		
		
	}
}
