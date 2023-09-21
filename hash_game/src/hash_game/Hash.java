package hash_game;

import java.util.Scanner;

public class Hash {
	private String[][] reference_matrix = {
			{"_", "_", "_"},
			{"_", "_", "_"},
			{"_", "_", "_"}};
	
	private String player1;
	private String player2;
	
	private boolean its_jover = false;
	
	public Hash(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	private void mark(int line, int column, String player) {
		for (int i = 0; i < this.reference_matrix.length; i++) {
			for (int k = 0; k < this.reference_matrix[i].length; k++) {
				if (i == line && k == column) {
					this.reference_matrix[i][k] = player;
				}
			}
		}
		
	}
	
	private void check_winner(String player) {
		if ((this.reference_matrix[0][0].equals(player) 
				&& this.reference_matrix[0][1].equals(player) 
				&& this.reference_matrix[0][2].equals(player)) 
				|| 
				(this.reference_matrix[1][0].equals(player) 
				&& this.reference_matrix[1][1].equals(player) 
				&& this.reference_matrix[1][2].equals(player)) 
				|| 
				(this.reference_matrix[2][0].equals(player) 
				&& this.reference_matrix[2][1].equals(player) 
				&& this.reference_matrix[2][2].equals(player)) 
				|| 
				(this.reference_matrix[0][0].equals(player) 
				&& this.reference_matrix[1][1].equals(player) 
				&& this.reference_matrix[2][2].equals(player)) 
				|| 
				(this.reference_matrix[0][2].equals(player) 
				&& this.reference_matrix[1][1].equals(player) 
				&& this.reference_matrix[2][0].equals(player))) {
			
			System.out.println("Player " + player + " wins.");
			this.its_jover = true;
		}
	}
	
	private void show_game() {
		for (int i = 0; i < this.reference_matrix.length; i++) {
			for (int k = 0; k < this.reference_matrix[i].length; k++) {
				String value = this.reference_matrix[i][k].equals("_")? " ": this.reference_matrix[i][k];
				
				System.out.print(" " + value + " ");
				if(k != this.reference_matrix[i].length - 1) {
					System.out.print("|");
				}
			}
			
			System.out.println();
			
			if(i != this.reference_matrix[i].length - 1) {
				System.out.println("---|---|---");
			}
		}
	}
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		Hash hash = new Hash("x", "y");
		
		System.out.println("Welcome to Hash game!!");
		
		System.out.print("   |   |   \n");
		System.out.print("---|---|---\n");
		System.out.print("   |   |   \n");
		System.out.print("---|---|---\n");
		System.out.print("   |   |   \n");	
		
		int turn = 0;
		do {	
			String player = turn % 2 == 0? hash.player1: hash.player2;
			
			System.out.println("Player " + player + " turn");
			System.out.print("Type the position that you wanna play: ");
			
			String[] pos =  sc.nextLine().split(" ");
			
			int i = Integer.parseInt(pos[0]);
			int k = Integer.parseInt(pos[1]);
			
			hash.mark(i, k, player);
			hash.check_winner(player);
			
			hash.show_game();
			
			turn++;
							
		}while(!hash.its_jover);
		
		sc.close();	
	}
	
}
