/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

package hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EvilHangman extends Hangman {
	// instance variables
	/**
	 * listWords represents the list of available words for the computer to choose from
	 * this list is updated every time the user guesses a correct letter
	 * with the words in the highest family of groups
	 */
	private ArrayList<String> listWords = new ArrayList<String>();
	/**
	 * initialKey represents a string of same length as word
	 * consisting of only "_" underscores
	 * Used to create other the keys for the family of words
	 */
	private String initialKey = "";
	

	// constructor
	public EvilHangman(String selectedWord, ArrayList<String> listWords){
		super(selectedWord);
		this.setListWords(listWords);
		// populate the empty string with underscores
		for (int i = 0; i < this.getLengthOfWord(); i++) {
			this.initialKey += "_";
		}
	}
	/**
	 * Checks if the user guess is in the highest family group of word list
	 * @param letter is the user guess
	 */
	@Override
	public void checkLetterInTheWord(char letter) {

		//selecting a random word from the list of words
		Random rand = new Random();
		int randInt = rand.nextInt(listWords.size());
		// setting the word as the currently selected word
		this.setSelectedWord(listWords.get(randInt));

		// key for each family of word modified from the initial key of underscores
		String modifiedKey;
		// increment the total guess
		this.setTotalGuess();
		// create a map of key, value pair to store the family of words
		Map<String, ArrayList<String>> familyGroups = new HashMap<String,ArrayList<String>>();

		// iterate through each word in the list
		for (int i = 0; i < listWords.size(); i++) {

			int firstOccurenceIdx = listWords.get(i).indexOf(letter);
			// if the letter is not present in the word, indexOf() method returns -1
			if (firstOccurenceIdx != -1) {
				// initializing the modifiedKey
				modifiedKey = this.initialKey;

				// catches every occurrence of the letter in a certain word
				// creates the modifiedKey replacing the underscores with the letter
				for (int j = firstOccurenceIdx; j < this.getLengthOfWord(); j++) {

					if (listWords.get(i).charAt(j) == letter) {
						// create the key for the group of words
						modifiedKey = this.createKeys(modifiedKey,j, letter);


					}
				}
				// create key if it's not in the map yet
				// else add to the existing list of that key
				if(!familyGroups.containsKey(modifiedKey)) {
					familyGroups.put(modifiedKey, new ArrayList<String>());
					familyGroups.get(modifiedKey).add(listWords.get(i));
				} else {
					familyGroups.get(modifiedKey).add(listWords.get(i));
				}
			} else {
				// create key if it's not in the map yet
				// when the user guess is not found in any of the words, this is created
				// else add to the existing list of that key
				if(!familyGroups.containsKey(this.initialKey)) {
					familyGroups.put(this.initialKey, new ArrayList<String>());
					familyGroups.get(this.initialKey).add(listWords.get(i));
				}else {

					familyGroups.get(this.initialKey).add(listWords.get(i));
				}

			}

		}
		// maxKey is the key with highest number of words in the list
		String maxKey = keyWithMaxItem(familyGroups);
		// maximum number of words are in the list of the initialKey
		// the program will keep this list and deem the user guess as incorrect
		if(maxKey == this.initialKey) {
			this.addIncorrectGuesses(letter);
		}
		// assign the list of the maxKey to the listWords for next guess
		this.listWords = familyGroups.get(maxKey);
		// now userWord is the maxKey
		this.setUserWord(maxKey);
		// update initialKey
		this.initialKey = maxKey;


	}
	//helper method
	/**
	 * Finds the key in the map with maximum number of words in it
	 * @param familyGroups key,value pairs of family of words
	 * @return the key with maximum num of words in the list
	 */
	public String keyWithMaxItem(Map<String, ArrayList<String>> familyGroups) {
		//initialize
		String maxKey= "";
		// number of words in the maxKey
		int maxItem = 0;
		// iterate through each key in the map
		for (String name : familyGroups.keySet())
			if(familyGroups.get(name).size() > maxItem) {
				// update maxItem and maxKey
				maxItem = familyGroups.get(name).size();
				maxKey = name;
			}

		return maxKey;
	}
	/**
	 * crates keys replacing the underscores from the given key at given index with given letter
	 * @param key the given key that needs to be modified
	 * @param index the position of the letter to be placed
	 * @param letter is the correct guess of the user
	 * @return the created key
	 */
	public String createKeys(String key, int index, char letter) {

		if(index == this.getLengthOfWord()-1) {
			return key.substring(0,index) + letter;
		}else {
			return key.substring(0,index) + letter + key.substring(index + 1);
		}

	}
	/**
	 * getter method for the list of words
	 * @return listWords
	 */
	public ArrayList<String> getListWords() {
		return listWords;
	}
	/**
	 * setter method for the list of words
	 * @param listWords new list of words
	 */
	public void setListWords(ArrayList<String> listWords) {
		this.listWords = listWords;
	}
}

