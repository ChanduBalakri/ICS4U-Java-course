/*
 Chandresh Balakrishnan 
 23/08/2023
 */

/*
 Pseudo Code (AI)
 start
 create AI to generate a random number between 0 to 2 for both column and row
 check if this spot is taken
 if it is taken then regenerate both numbers
 do so in a while loop until empty spot is found
 end
 */

/*
 Changes Made
 Instead of just column inputs it is changed to both column and row and gravity is not a factor
 Board was shrunk in order to be 3 by 3 now
 AI was created using Math.random
 */

import java.util.Scanner;


public class TicTacToe {

	static char[][] board = new char[3][3];	//playable board area
	static boolean gameOver = false;		// gameOver indicates if a player won a game
	static boolean exit = false;			// exit indicates if there are no other games to play and to exit the program
	static char player1 = 'a';				// player 1's token is a
	static char player2 = 'b';				// player 2's token is b
	static char turn = player1;				// turn specifies which player's turn it is
	
	public static void main(String[] args) {
		while (!exit){	//while exit has not been set to true
			System.out.println("Tic-Tac-Toe! Player " + turn + "\'s turn!");
			printBoard();	//print the boards state
			while (!gameOver){	//while the game is not over, execute turns
				move(turn);
			}
		}
		
	}
	
	
	/*
	 * Move places a piece in a column/row, if there's room for it.
	 */
	private static boolean move(char p){
		Scanner s = new Scanner(System.in);
		String str;
		int c = 0;
		int r = 0;
		boolean playable = false;
		
		//Get the column choice from the user
		while (playable == false) {
			
			System.out.println("It's player " + turn + "\'s turn! Which column do you want to lay a piece in? 0, 1, 2");
			if (turn == 'a') {
				str = s.nextLine();
				c = Character.getNumericValue(str.charAt(0));
				System.out.println("Choose row? 0, 1, 2");
				str = s.nextLine();
				r = Character.getNumericValue(str.charAt(0));
			}
			else { //AI
				c = (int)(Math.random() * 3);
				r = (int)(Math.random() * 3);
				while (board[c][r] == player1 || board[c][r] == player2) {
					c = (int)(Math.random() * 3);
					r = (int)(Math.random() * 3);
				}
			}
			//If the column choice is invalid, get a valid one
			if (c != 0 && c != 1 && c != 2 && c != 3 && c != 4 && c != 5 && c != 6 && c != 7 && c != 8 && c != 9){
				System.out.println("Sorry that wasn't a valid option. You entered \"" + c + "\" Please enter either 0, 1, 2 or 3");
				playable = false;
			}
			else {
				playable = checkCol(c, r);
				
				//if the column is full, then select another one
				if (playable == false){
					System.out.println("Sorry! Place " + c + ", " + r + " is taken!");
				}
			}
			
		}
		
		//If the column has a spot for your token, play it
		if (playable) {
			int free;
			char choice;
			
			board[c][r] = p;	//place piece in free slot
			System.out.println("\n\n\n\n\n\n\n");
			
			printBoard();
			
			//check if the player has won the game
			if (checkCharForWin(p)){
				
				System.out.println("Player " + p + " WINS!\nReset Game? y or n");
				gameOver = true;
				
				str = s.nextLine();
				choice = str.charAt(0);
				
				//check the user's input if they wish to continue playing
				if (choice != 'y' && choice !='n' ){
					System.out.println("Sorry, invalid input. Please enter \'y\' or \'n\'");
					str = s.nextLine();
					choice = str.charAt(0);
				}
				
				//if the user wishes to continue playing, reset the game
				if (choice == 'y'){
					clearGame();
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
					printBoard();
				}
				else {	//else quit the program
					System.out.println("Goodbye!");
					exit = true;
				}
				
			}	
			else if (checkDraw()){
				System.out.println("Draw! Reset game? y or n");
				gameOver = true;
				
				str = s.nextLine();
				choice = str.charAt(0);
				
				//check the user's input if they wish to continue playing
				if (choice != 'y' && choice !='n' ){
					System.out.println("Sorry, invalid input. Please enter \'y\' or \'n\'");
					str = s.nextLine();
					choice = str.charAt(0);
				}
				
				//if the user wishes to continue playing, reset the game
				if (choice == 'y'){
					clearGame();
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
					printBoard();
				}
				else {	//else quit the program
					System.out.println("Goodbye!");
					exit = true;
				}
			}
			
			//change player's turn, only if they successfully moved
			if (turn == player1){
				turn = player2;
			}
			else {
				turn = player1;
			}
			
		}

		return playable;
	}
	
	
	/*
	 * checkCharForWin checks the board to see if the passed character has a winning position
	 */
	private static boolean checkCharForWin(char x){
		boolean win = false;
		
		for (int i = 0; i < 3; i ++){
			//horizontal win
			if (board[i][0] == x && board[i][1] == x && board[i][2] == x){
				win = true;
			}
			//vertical win
			if (board[0][i] == x && board[1][i] == x && board[2][i] == x){
				win = true;
			}
		}
		//diagonal wins
		if (board[0][0] == x && board[1][1] == x && board[2][2] == x){
			win = true;
		}
		if (board[0][2] == x && board[1][1] == x && board[2][0] == x){
			win = true;
		}

		return win;
	}
	
	
	/*
	 * checkCol takes an integer between 0 and 2 and checks the column if there are moves available in that column
	 */
	private static boolean checkCol(int x, int y){
		
		boolean playable = false;
		
		if (board[x][y] != player1 && board[x][y] != player2){
			playable = true;
		}
		
		return playable;
	}
	
	
	/*
	 * checkDraw makes sure the board is not full, if the board is full and no one has one the game is a draw
	 */
	private static boolean checkDraw(){
		boolean draw = true;
		
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j++){
				if (board[i][j] != player1 && board[i][j] != player2){
					draw = false;
				}
			}
		}
		
		return draw;
	}
	
	
	/*
	 * printBoard displays the current connect 4 board
	 */
	private static void printBoard(){
		System.out.println("0\t1\t2");
		for (int i = 0; i < 3; i++){
			System.out.println(print(board[0][i]) + "\t" + print(board[1][i]) + "\t" + print(board[2][i]) + "\t" + i);
		}
		
	}
	
	
	/*
	 * print returns the player token if the character is a player token, otherwise it returns _
	 */
	private static char print(char x){
		if (x == player1 || x == player2){
			return x;
		}
		else {
			return '_';
		}
	}
	
	
	/*
	 * clearGame resets the board to blank, returns the users their pieces
	 */
	private static void clearGame(){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = 'x';
			}
		}
		gameOver = false;
	}
}
