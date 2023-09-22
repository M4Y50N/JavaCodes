package hash_game;

import java.util.Scanner;

public class Hash {
	private String[][] reference_matrix = {
			{"_", "_", "_"},
			{"_", "_", "_"},
			{"_", "_", "_"}};
	
	private String player1;
	private String player2;
	
	private String winner;
	
	// controls the state of the game
	private boolean its_jover = false;
	
	// verify if player's symbols is numeric
	private boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

	// +++++++++++++++++++++++++++++++++++
	// constructors
	private Hash(String player1, String player2) {
		this.player1 = ((player1.toLowerCase().equals(player2.toLowerCase())) || (isNumeric(player1)) || player1.length() > 1) ? "X" : player1.toUpperCase();
		this.player2 = ((player1.toLowerCase().equals(player2.toLowerCase())) || (isNumeric(player1)) || player2.length() > 1)? "O" : player2.toUpperCase();
	}
	
	private Hash(String player1) {
		this.player1 = ((player1.toLowerCase().equals(player2.toLowerCase())) || (isNumeric(player1)) || player1.length() > 1)? "X" : player1.toUpperCase();
		this.player2 =  "O";
	}
	
	private Hash() {
		this.player1 = "X";
		this.player2 = "O";
	}
	// end constructors
	// +++++++++++++++++++++++++++++++++++
	
	// mark a position in reference matrix
	private void mark(int line, int column, String player) {
		for (int i = 0; i < this.reference_matrix.length; i++) {
			for (int k = 0; k < this.reference_matrix[i].length; k++) {
				if (i == line && k == column) {									
					this.reference_matrix[i][k] = player;
				}
			}
		}
		
	}
	
	// check if player already marks the pos
	private int[] check_pos(Scanner sc) {
		String[] pos;
		
		int line;
		int column;
		
		do {
			System.out.print("Type the position that you wanna play: ");
			
			pos = sc.nextLine().split(" ");
			
			line = pos.length > 1 ? Integer.parseInt(pos[0]): 99;
			column = pos.length > 1 ? Integer.parseInt(pos[1]): 99;
			
			
			if ((line < 0 || line > 2) || (column < 0 || column > 2)){
				System.out.println("\n   *Invalid position, please type 2 numbers greater than 0 and less than 3!!*\n");
			}else if (!this.reference_matrix[line][column].equals("_")){
				System.out.println("\n   *Position already occupied!!*\n");
			}
			
		}while (((line < 0 || line > 2) || (column < 0 || column > 2)) || !this.reference_matrix[line][column].equals("_"));							
			
		
		final int[] PAIR = {line, column};
		
		return PAIR;
	}
	
	//verify if has a winner
	private void check_winner(String player, int turn) {
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
			
			this.winner = player;
			String player_msg = " Player " + winner + " wins! ";
			

			System.out.println("\n" + player.repeat(50));
			format_sysout(player, 50, player_msg);
			System.out.println(player.repeat(50));
			
			this.its_jover = true;
			
		}else if (turn == 8 && this.winner == null) {
			this.its_jover = true;
			String player_msg = " Ladys and gentlemen, it was a draw!! ";
			System.out.println("\n" + this.player1.repeat(50));
			format_sysout(this.player2, 50, player_msg);
			System.out.println(this.player1.repeat(50));
		}
	}
	
	
	// show matrix
	private void show_game() {
		String hash_fance = " ---|---|--- ";
		
		System.out.println();
		for (int i = 0; i < this.reference_matrix.length; i++) {
			System.out.print(" ".repeat((50 - hash_fance.length())/2) + " ");
			for (int k = 0; k < this.reference_matrix[i].length; k++) {
				String value = this.reference_matrix[i][k].equals("_")? " ": this.reference_matrix[i][k];
				System.out.print(" " + value + " ");
				if(k != this.reference_matrix[i].length - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if(i != this.reference_matrix[i].length - 1) {
				System.out.println(" ".repeat((50 - hash_fance.length())/2) + hash_fance);
			}
		}
	}
	
	
	// format sysout indentation
	public void format_sysout(String c, int times, String word) {
		System.out.println(c.repeat((Math.abs(times - word.length()))/2) + word + c.repeat((Math.abs(times - word.length()))/2));
	}
	
	public static void run() {
		Scanner sc = new Scanner(System.in);
		
		Hash hash = new Hash();
		
		String welcome = " Welcome to Hash game!! ";
		System.out.println("#".repeat(50));
		hash.format_sysout("#", 50, welcome);
		System.out.println("#".repeat(50));
		
		String hash_fance1 = " ---|---|--- ";
		String hash_fance2 = "    |   |    ";
		
		hash.format_sysout(" ", 50, hash_fance2);
		hash.format_sysout(" ", 50, hash_fance1);
		hash.format_sysout(" ", 50, hash_fance2);
		hash.format_sysout(" ", 50, hash_fance1);
		hash.format_sysout(" ", 50, hash_fance2);
		
		int turn = 0;
		do {	
			String player = turn % 2 == 0? hash.player1: hash.player2;
			
			String player_msg = "Player " + player + " turn";
			System.out.println();
			hash.format_sysout(" ", 20, player_msg);
			
			final int[] PAIR = hash.check_pos(sc);
			
			hash.mark(PAIR[0], PAIR[1], player);
			hash.check_winner(player, turn);
			
			hash.show_game();
			
			turn++;
							
		}while(!hash.its_jover);
		
		sc.close();	
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	
}
