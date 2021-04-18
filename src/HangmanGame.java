import java.util.Scanner;

import hangman.Hangman;
import hangman.TraditionalHangman;

public class HangmanGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// open the file
		// somehow randomly select the word from file
		
		// pass that word to the Hanman(either traditioal hangman or evil)
		
		Scanner scanner = new Scanner(System.in);
		Hangman tradHang = new TraditionalHangman();
		boolean playing = true;
		System.out.println("Welcome to Hangman");
		while(playing) {
			System.out.println("Guess a letter");
			// nextLine() :take string, nextInt(): takes int, next(): 
			//char letter = scanner.next().charAt(0);
			
			System.out.println(tradHang.getUserWord());
			System.out.println("Total Guess " + tradHang.getTotalGuess());
			System.out.println("Incorrect Guesses " + tradHang.getIncorrectGuess());
			char letter = scanner.next().charAt(0);
			tradHang.checkLetterInTheWord(letter);
			if(tradHang.isGameOver()) {
				playing = false;
				System.out.println("Over");
			}
			
			
		}
		scanner.close();
	}

}
