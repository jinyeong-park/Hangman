/**
 * @authors: Jinyeong Park(Penn ID: 61203275), Tasnia Nowrin(Penn ID: 16999671)
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import dictionary.CleaningText;
import hangman.EvilHangman;
import hangman.Hangman;
import hangman.TraditionalHangman;

public class HangmanGame {
	/**
	 * Puts game in debug mode.
	 * Prints the version of the game the user is play. (traditional or evil)
	 * For traditional hangman, print the actual word to be guessed.
	 * For evil hangman, print the possible words to be guessed
	 */
	private static boolean debugMode = true;
	

	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// creating cleanigText passing given two files (words.txt and clean file name)
		CleaningText ct = new CleaningText("words.txt", "our_dictionary.txt");
		// call the cleaningFile method of CleaningText class
		ct.cleaningFile();
	
		// create the pathToFile variable and assign the result of getCleanFile
		String pathToFile = ct.getCleanFile();
		
		// First, create a File object
		File myFile = new File(pathToFile);

		// create fileReader object and set it to null
		FileReader fileReader = null;
		try {
			// create instance of FileReader with given myFile path
			fileReader = new FileReader(myFile);
		// if there is an error, catch it
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Finally, create a BufferedReader which takes a FileReader as an argument
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		// create randomWord variable and set to empty string
		String randomWord = "";
		
		// get randomNumber from random between min and max range
		int min = 0;
		int max = ct.getNumberOfLine();
		Random rand = new Random();
		int randomLineNum = (int)Math.floor(Math.random() * (max - min + 1) + min);
		

		try (Stream<String> lines = Files.lines(Paths.get(pathToFile))) {
			//
			randomWord = lines.skip(randomLineNum).findFirst().get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// close file objects
		fileReader.close();
		bufferedReader.close();
		
		
		
		// randomly select game - traditional or evil
		boolean hangmanVersion = rand.nextInt(2) == 0 ? true : false;
		
//		// debugging purpose
//		System.out.println(hangmanVersion);
		
		// declare hangman
		Hangman hangman;
		
		// create instance of scanner object with system.in
		Scanner scanner = new Scanner(System.in);
		
		// if hangmanVersion is true, create traditionalHanman with randomWord
		if (hangmanVersion) {
			hangman = new TraditionalHangman(randomWord);
		// otherwise, create Evil hangman
		} else {
			// prepare to create random lists of words with the same length
			
			// create the file objects (File, FileReader, FileReader)
			File file = new File(pathToFile);
			FileReader reader = null;
			
			try {
				reader = new FileReader(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			// create bufferReader object with given fileReader
			BufferedReader bfr = new BufferedReader(reader);
			// create listWords ArrayList
			ArrayList<String> listWords = new ArrayList<String>();
			// create variable s to hold each line from the bufferedReader
			String s = bfr.readLine();
			// if each line exists,
			while(s != null) {
				// clean the line
				s = s.strip();
				// if each line and randomword's length are the same
				if(s.length() == randomWord.length()) {
					// add s to listWords
					listWords.add(s);
				}
				s = bfr.readLine();
			}
			// create the EvilHangman instance
			hangman = new EvilHangman(randomWord, listWords);
			
		}
		// close file objects
		fileReader.close();
		bufferedReader.close();
		
		
		// set the flag of playing as true
		boolean playing = true;
		
		// Greeting to the user
		System.out.println("Welcome to Hangman");
		
		// As long as playing is true, keep playing the game
		while(playing) {
			
			
			// ask the user to guess a letter
			System.out.println("Guess a letter");
			
			// debugging purpose
			System.out.println(hangman.getUserWord());
			// show  the number of the total guess
			System.out.println("Total Guess " + hangman.getTotalGuess());
			// show the incorrect guesses
			System.out.println("Incorrect Guesses " + hangman.getIncorrectGuess());
			char letter = scanner.next().charAt(0);
			hangman.checkLetterInTheWord(letter);
			// if game is over, change the playing flag to false
			if (hangman.isGameOver()) {
				playing = false;
				System.out.println("Over");
			}

		}
		// close the scanner
		scanner.close();
	}

}