package hangman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EvilHangman extends Hangman {
	
	//private static String word = "heel";
	private ArrayList<String> listWords = new ArrayList<String>();
	private String initialKey = "";
	
	public EvilHangman(String selectedWord, ArrayList<String> listWords){
		super(selectedWord);
		this.setListWords(listWords);
		for (int i = 0; i < this.getLengthOfWord(); i++) {
			this.initialKey += "_";
		}
	}
	@Override
	public void checkLetterInTheWord(char letter) {
		repeatProcess(letter);
	}
	public void repeatProcess(char letter) {
		//create string with _
		Random rand = new Random();
		int randInt = rand.nextInt(listWords.size());
		
		this.setSelectedWord(listWords.get(randInt));
		//System.out.println(this.getSelectedWord());
		
		String modifiedKey; 
		
		this.setTotalGuess();
		Map<String, ArrayList<String>> familyGroups = new HashMap<String,ArrayList<String>>();
		
		for (int i = 0; i < listWords.size(); i++) {
			int firstOccurenceIdx = listWords.get(i).indexOf(letter);
			//System.out.println(firstOccurenceIdx);
			if (firstOccurenceIdx != -1) {
				modifiedKey = this.initialKey;
				//modifiedKey = this.createKeys(modifiedKey,firstOccurenceIdx, letter);
				// for loop, and add index into the list and pass list
				for (int j = firstOccurenceIdx; j < this.getLengthOfWord(); j++) {
					
					if (listWords.get(i).charAt(j) == letter) {
						
						modifiedKey = this.createKeys(modifiedKey,j, letter);
						//System.out.println(modifiedKey);
						
					}
				}
				//if (!map.containsKeys(modi))
				if(!familyGroups.containsKey(modifiedKey)) {
					familyGroups.put(modifiedKey, new ArrayList<String>());
					familyGroups.get(modifiedKey).add(listWords.get(i));
				}else {
					familyGroups.get(modifiedKey).add(listWords.get(i));
				}
			}else {
				if(!familyGroups.containsKey(this.initialKey)) {
					familyGroups.put(this.initialKey, new ArrayList<String>());
					familyGroups.get(this.initialKey).add(listWords.get(i));
				}else {
				//familyGroups.put(initialKey, new ArrayList<String>());
					familyGroups.get(this.initialKey).add(listWords.get(i));
				}
				
			}

		}
		//System.out.println(this.listWords);
		String maxKey = keyWithMaxItem(familyGroups);
		for (String name : familyGroups.keySet()) {
			//System.out.println("Key: " + name);
			System.out.println(name + " list " + familyGroups.get(name));
            }
		
		//System.out.println(maxKey + " Max list" + familyGroups.get(maxKey));
		if(maxKey == this.initialKey) {
			this.addIncorrectGuesses(letter);
		}
		//else {
			this.listWords = familyGroups.get(maxKey);
			//System.out.println(this.listWords);
			this.setUserWord(maxKey);
			this.initialKey = maxKey;
		//}

	}
	//helper method
	public String keyWithMaxItem(Map<String, ArrayList<String>> familyGroups) {
		String maxKey= "";
		int maxItem = 0;
		for (String name : familyGroups.keySet())
            if(familyGroups.get(name).size() > maxItem) {
            	maxItem = familyGroups.get(name).size();
            	maxKey = name;
            }
		
		return maxKey;
	}
	
	public String createKeys(String key, int index, char letter) {
		
		if(index == this.getLengthOfWord()-1) {
			return key.substring(0,index) + letter;
		}else {
			return key.substring(0,index) + letter + key.substring(index + 1);
		}
		//return key;
	}
	public ArrayList<String> getListWords() {
		return listWords;
	}
	public void setListWords(ArrayList<String> listWords) {
		this.listWords = listWords;
	}
}