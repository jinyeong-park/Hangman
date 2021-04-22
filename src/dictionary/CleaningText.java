/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

//import File
package dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Represents reading, cleaning the given words.txt file
 */
public class CleaningText {
	// instance variables
	/**
	 * represent original file
	 */
	private String rawFile;
	
	/**
	 * represent the clean file
	 */
	private String cleanFile;
	
	private int numberOfLine;
	


	// constructor
	/** 
	 * set the instance variables with given arguments (rowFile and cleanFile)
	 * @param rawFile
	 * @param cleanFile
	 */
	public CleaningText(String rawFile, String cleanFile) {
		this.rawFile = rawFile;
		this.cleanFile = cleanFile;
		this.numberOfLine = 0;
	}
	
	// methods
	// getter & setters
	/**
	 * getter for RawFil
	 * @return RawFil
	 */
	public String getRawFile() {
		return rawFile;
	}

	/**
	 * setter for RawFil
	 * @param rawFile
	 */
	public void setRawFile(String rawFile) {
		this.rawFile = rawFile;
	}

	/**
	 * getter for cleanFile
	 * @return cleanFile
	 */
	public String getCleanFile() {
		return cleanFile;
	}

	/**
	 * setter for cleanFile
	 * @param cleanFile
	 */
	public void setCleanFile(String cleanFile) {
		this.cleanFile = cleanFile;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getNumberOfLine() {
		return numberOfLine;
	}

	/**
	 * 
	 * @param numberOfLine
	 */
	public void setNumberOfLine(int numberOfLine) {
		this.numberOfLine = numberOfLine;
	}
	
	// other methods
	/**
	* Read the file and cleaning the file
	*/
	public void cleaningFile() {
		//1. create a file object
		File file = new File(this.rawFile);
		
		// create FileReader object and BufferedReader object and set to null initially
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		
		// 2. Then create a FileReader with the given File object
		try {
			// create instance of FileReader with file object
			fileReader = new FileReader(file);
			// create bufferReader with fileReader object
			bufferedReader = new BufferedReader(fileReader);
			
			// create line variable
			String line;
			// create words ArrayList with String type
			ArrayList<String> words = new ArrayList<String>();
			// while the line exists
			while ((line = bufferedReader.readLine())!= null) {
				// start to clean
				// remove the leading and trailing whitespace
				String word = line.strip();
				// change word of string to array
				char[] charArray = word.toCharArray();
				// create a flag 
				boolean flag = true;
				// iterate over the char array
				for(int i = 0; i < charArray.length; i++) {
					char ch = charArray[i];
					// if the element of the charArray is all lower case of alphabets
					if(!(ch >= 'a' && ch <= 'z')) {
						// change flag to false and break
						flag = false;
						break;
					}
					
				}
				// if flag is false, continue to the next
				if(flag  == false) {
					continue;
				}
				// otherwise add the word  to words ArrayList
				words.add(word);
			}
			// write this words ArrayList to clean file
			this.writeToFile(words);
			
		// if there is no file or IOException, catch the error
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		// After that
		} finally {
			//regardless, close file objects
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}


	/**
	 * Represent write to the file
	 * @param words
	 */
	private void writeToFile(ArrayList<String> words) {
		//create file object
		File file = new File(this.cleanFile);
				
		//define file writer
		FileWriter fileWriter = null;
		
		//define print writer
		PrintWriter printWriter = null;
		
		try { 
			//create filewriter and printwriter object to write it to the file
			//FileWriter fw = new FileWriter(new File(pathToFile), append);
			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);
			
			// if there is no error 
			// iterate over words arraylist
			for(int i = 0; i < words.size(); i++) {
				// write each element to the clean file
				printWriter.println(words.get(i));
				this.numberOfLine++;
				
			}
		// if there is error, catch it.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//regardless of what happens, close file objects
			try {
				fileWriter.close();
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}