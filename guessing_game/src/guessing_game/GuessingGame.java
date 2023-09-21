package guessing_game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	
	private int guess_num;
	private int guessed_num;
	private Scanner sc = new Scanner(System.in);
	
	public GuessingGame() {
		generate_num();
	}
	
	private void generate_num() {
		Random rand = new Random();
		this.guess_num = rand.nextInt(101);
	}
	
	private void guess_a_num() {
		System.out.print("   Guess a number: ");
		
		this.guessed_num = sc.nextInt();
	}
	
	private void welcome() {
		String welcome_msg = " Welcome to Guessing Game!! "; 
		String plus_sign = "+".repeat((60 - welcome_msg.length())/2);
		
		System.out.println("+=+".repeat(20));
		System.out.println(plus_sign + welcome_msg + plus_sign);
		System.out.println("+=+".repeat(20)+"\n");
	}
	
	public void run_game() {
		welcome();
		do {
			guess_a_num();				
			
			if (this.guess_num == this.guessed_num) {
				System.out.println("\n	Congrats you win, motherfucker!!\n");
			}else if (this.guess_num < this.guessed_num ) {
				System.out.println("\n	Try Lower\n");
			}else {
				System.out.println("\n 	Trye Upper\n");
			}
		}while (this.guess_num != this.guessed_num);
	}
	
	public int getGuessNum() {
		return this.guess_num;
	}
	
	public void setGuesNum() {
		generate_num();
	}
	
}
