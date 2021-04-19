package hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EvilHangman extends Hangman {
	
	//private static String word = "heel";
	private ArrayList<String> listWords = new ArrayList<String>();
	
	public EvilHangman(String selectedWord, ArrayList<String> listWords){
		super(selectedWord);
		this.setListWords(listWords);
	}
	//helper method
	void createWordFamilyGroups(char letter, ArrayList<String> listWords){
		// 1st group : letter located in exact location and only one letter in the word // index: 2
		// 2nd group: if the letter exists but different location - 1
		// 3nd group: if the letter exists but different location - 3
		// 4nd group: if the letter exists but different location - 4
		// 5rd group: the letter doesn't exist in the word
		
		// key-: index separated by comma |  value-string: words
		Map<String, String> familyGroups = new HashMap<String, String>();
		
		for (int i = 0; i < listWord.length(); i++) {
			// {'1,2': 'HEEL'}
			
			// find the index
			listWord['1,2'] = listWord[i]
			
		}

	}
	public ArrayList<String> getListWords() {
		return listWords;
	}
	public void setListWords(ArrayList<String> listWords) {
		this.listWords = listWords;
	}
}
