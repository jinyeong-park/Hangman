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


public class CleaningText {
	// instance variables
	// define fileName
	private String rawFile;
	private String cleanFile;
	
	
	// constructor
	public CleaningText(String rawFile, String cleanFile) {
		this.rawFile = rawFile;
		this.cleanFile = cleanFile;
	}
	

	public void cleaningFile() {
		// create a file object
		File file = new File(this.rawFile);
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		
		// 2. Then create a FileReader with the given File object
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			String line;
			ArrayList<String> words = new ArrayList<String>();
			while ((line = bufferedReader.readLine())!= null) {
				// cleaning
				// only take if it is alphabet without space
				String word = line.strip();
				char[] charArray = word.toCharArray();
				boolean flag = true;
				for(int i = 0; i < charArray.length; i++) {
					char ch = charArray[i];
					if(!(ch >= 'a' && ch <= 'z')) {
						flag = false;
						break;
					}
					
				}
				if(flag  == false) {
					continue;
				}
				words.add(word);
			}
			this.writeToFile(words);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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


	private void writeToFile(ArrayList<String> words) {
		// TODO Auto-generated method stub
		//create file object
		File file = new File(this.cleanFile);
				
		//define file writer
		FileWriter fileWriter = null;
		
		//define print writer
		PrintWriter printWriter = null;
		
		try { 
			//FileWriter fw = new FileWriter(new File(pathToFile), append);
			fileWriter = new FileWriter(file, true);
			printWriter = new PrintWriter(fileWriter);
			
			for(int i = 0; i < words.size(); i++) {
				
				printWriter.println(words.get(i));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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


	public String getRawFile() {
		return rawFile;
	}


	public void setRawFile(String rawFile) {
		this.rawFile = rawFile;
	}


	public String getCleanFile() {
		return cleanFile;
	}


	public void setCleanFile(String cleanFile) {
		this.cleanFile = cleanFile;
	}
}