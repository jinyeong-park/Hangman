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

import hangman.EvilHangman;

//import com.sun.tools.javac.util.List;

import hangman.Hangman;
import hangman.TraditionalHangman;

public class HangmanGame {
	
	// decided game type randomly by computer
//	public static void openFile(File file) {
//		FileReader fileReader = null;
//		BufferedReader bufferedReader = null;
		
//
//		try {
//			fileReader = new FileReader(file);
//			bufferedReader = new BufferedReader(fileReader);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		// for traditioanl game => get random number
//		List<String> allLines = Files.readAllLines(file.getPath());
		
//		try {
//			// random 
//			String s = bufferedReader.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// traditional case - get one random word
		
		// evil game case- more than more word
		// create a group and update a group
		
//	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// open the file
		// somehow randomly select the word from file
		// changed file name to our cleaned file later
//		System.out.println("hello");
		String pathToFie = "words_clean.txt";
		
		//1. First, create a File object
		File myFile = new File(pathToFie);

		// 2. Then create a FileReader with the given File object
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(myFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. Finally, create a BufferedReader which takes a FileReader as an argument - 
		//  A buffered reader provides buffering of data stored in memory for fast and efficient reading. You can use a buffered reader to read entire lines of data.
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String randomWord = "";
		// randomNumber 
		int min = 0;
		int max = 57;
		Random rand = new Random();
		int randomLineNum = (int)Math.floor(Math.random() * (max-min+1)+min);
		System.out.println("randomLineNum" + randomLineNum);
		
		try (Stream<String> lines = Files.lines(Paths.get(pathToFie))) {
			randomWord = lines.skip(randomLineNum).findFirst().get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileReader.close();
		bufferedReader.close();
		

		
//		// To read a whole line with the BufferedReader, use the readLine method
//		String s = "";
//		try {
//			s = bufferedReader.readLine();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(s);
		System.out.println(randomWord);

		
		
		// pass that word to the Hanman(either traditioal hangman or evil)
		
		// randomly select game - traditional or evil
		boolean hangmanVersion = rand.nextInt(2) == 0 ? true : false;
		System.out.println(hangmanVersion);
		Hangman hangman;
		Scanner scanner = new Scanner(System.in);
		if(hangmanVersion) {
			hangman = new TraditionalHangman(randomWord);
		}else {
			File file = new File(pathToFie);

			FileReader reader = null;
			try {
				reader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BufferedReader bfr = new BufferedReader(reader);
			ArrayList<String> listWords = new ArrayList<String>();
			String s = bfr.readLine();
			while(s != null) {
				
				s = s.strip();
				if(s.length() == randomWord.length()) {
					System.out.println(s);
					listWords.add(s);
				}
				s = bfr.readLine();
			}
			hangman = new EvilHangman(randomWord, listWords);
			
		}
		fileReader.close();
		bufferedReader.close();
		
		boolean playing = true;
		System.out.println("Welcome to Hangman");
		while(playing) {
			System.out.println("Guess a letter");
			// nextLine() :take string, nextInt(): takes int, next(): 
			//char letter = scanner.next().charAt(0);
			
			System.out.println(hangman.getUserWord());
			System.out.println("Total Guess " + hangman.getTotalGuess());
			System.out.println("Incorrect Guesses " + hangman.getIncorrectGuess());
			char letter = scanner.next().charAt(0);
			hangman.checkLetterInTheWord(letter);
			if(hangman.isGameOver()) {
				playing = false;
				System.out.println("Over");
			}
			
			
		}
		scanner.close();
	}

}