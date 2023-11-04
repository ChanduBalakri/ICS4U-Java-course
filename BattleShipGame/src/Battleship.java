/* Date: 31/08/2023
 Dev: Chandresh Balakrishnan
 VS: Java 20
*/

/*
 Battleship is a player vs. player or player vs. computer game that consists of placing boats on an open playing field
 After both players have assigned their boats to locations, each player takes turns blind guessing to destroy their opponents boats.
 This game consists of skill/strategy and also a bit a luck!
 */



import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.io.FileReader; // reading the file when loading contact book
import java.io.FileWriter; // used to write to the file when saving contact book
import java.io.IOException; // used to throw IOException in methods
import java.io.InputStreamReader; // used to get inputs from the user
import java.io.PrintWriter; // also used to write to the file
import java.util.Scanner; // used to read file
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class Battleship extends JFrame implements ActionListener{
	static int choice = 0; // used to switch between screens
	static JPanel myJPanel;
	static JTextField myTextField;
	static JLabel  L1, L2;
	static JButton addButton;
	static JTable table;
	static Container contentPane;
	static String[] columnNames = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	static String [] columnNames1 = {"Console Message"}; 
	static String twoBoat = "X";
	static String threeBoat = "Y";
	static String fourBoat = "Z";
	static String AItwoBoat = "A";
	static String AIthreeBoat = "B";
	static String AIfourBoat = "C";
	static int twoSetup = 0;
	static int threeSetup = 0;
	static int fourSetup = 0;
	static int column = 0;
	static int row = 0;
	static int shotcolumn = 0;
	static int shotrow = 0;
	static int counter = 0;
	static int hit = 0;
	static int [] memory1 = new int[100];
	static int [] memory2 = new int[100];
	static String [] boats = {twoBoat, threeBoat, fourBoat};
	static String [] AIboats = {AItwoBoat, AIthreeBoat, AIfourBoat};
	static int [] setups = {twoSetup, threeSetup, fourSetup};
	static String [] placements = {"First", "Second", "Third", "Fourth"};
	static int loops = 0;
	static int connection = 0;
	static int bot = 0;
	static boolean found = false;
	static boolean found1 = false;
	static String [][] duringArray = {{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""},{"=====", "=====", "=====", "=====" ,"=====" , "=====", "=====", "=====", "=====", "=====", "====="},{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""}
			 };
	static String [][] printArray = {{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""},{"=====", "=====", "=====", "=====" ,"=====" , "=====", "=====", "=====", "=====", "=====", "====="},{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""}
			 };
	static String [][] backendArray = {{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""},{"=====", "=====", "=====", "=====" ,"=====" , "=====", "=====", "=====", "=====", "=====", "====="},{"1", "", "", "" ,"" , "", "", "", "", "", ""},{"2", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"3", "", "", "" ,"" , "", "", "", "", "", ""},{"4", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"5", "", "", "" ,"" , "", "", "", "", "", ""},{"6", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"7", "", "", "" ,"" , "", "", "", "", "", ""},{"8", "", "", "" ,"" , "", "", "", "", "", ""},
			 {"9", "", "", "" ,"" , "", "", "", "", "", ""},{"10", "", "", "" ,"" , "", "", "", "", "", ""}
			 };
	
	public static void main(String[] args) throws NullPointerException{
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		menuBar.add(file);
		menuBar.add(edit); 
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		do {
			displayMenu(); 
			choice = readInt();	
		}
		while (choice != 4);  
	}
	
	
	public Battleship() { // constructor to add all values to the menu including the menu items, add actionlistener to change screens when desired
		JMenuBar menuBar;
	    JMenu menu;
	    JMenuItem menuItem;
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    menu = new JMenu("View");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("View Board");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Setup");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Place Boats");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Attack");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Place Shot");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Remove Shot");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Send Shot");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);

	    menu = new JMenu("External");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Save Game");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Load Game");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Quit");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Quit");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	}
	
	private static void displayMenu () { // standard window screen
		Battleship window = new Battleship();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Your Contact Book");
	    window.setSize(800,600);
	    window.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// calls methods for certain choices
		String event = e.getActionCommand();
		if (event.equals("View Board")) { 
			viewBoard();
			System.out.println("View Board");
		}
		
		else if (event.equals("Place Shot")) { // checks if the setup has already been completed, if so then allow shot to be made
			if (twoSetup == 1 && threeSetup == 1 && fourSetup == 1) {
				placeShot();
				System.out.println("Place Shot");
			}
			else {
				String [][] myArray = {{"Setup First"}};
				console(myArray);
			}
		}
		
		else if (event.equals("Remove Shot")) { // simple message that shot data has been deleted
			removeShot();
			System.out.println("Remove Shot");
		}
		
		else if (event.equals("Send Shot")) { 
			sendShot();
			System.out.println("Send Shot");
		}
		
		else if (event.equals("Place Boats")) { // Initiates the AI setups as well as own setups for the boats
			if (bot == 0) {
				AISetup();
				bot = 1;
			}
			if (twoSetup == 1 && threeSetup == 1 && fourSetup == 1) { // checks if setups have already been completed
				String [][] myArray = {{"Already Finished Full Setup"}};
				console(myArray);
			}
			else {
				placeBoats();
				System.out.println("Place Boats");
			}
		}
		
		else if (event.equals("Place Column")) { // when placing the column, the user is asked for an integer value in order to index the printArray easier
			column = Integer.parseInt(myTextField.getText());
			L1 = new JLabel("Enter Row of " + placements[counter] + " Spot For Boat (int): ");
			addButton = new JButton("Place Row");
			message(L1, addButton);
		}
		
		else if (event.equals("Place Row")) {// after the column is given, the user enters a row integer number the same way
			row = Integer.parseInt(myTextField.getText());
			duringArray[row-1][column] = boats[loops-2]; // this array is in order to settle own boat overlapping issues 
			if (twoBoat.compareTo(printArray[row-1][column]) != 0 && threeBoat.compareTo(printArray[row-1][column]) != 0 && fourBoat.compareTo(printArray[row-1][column]) != 0) { // makes sure that the place chosen is not already taken
				if (counter > 0) { // if its not the first spot of the boat being placed, therefore checking if the boat is touching the other spots (since a boat must be in one piece)
					if (row-1 == 0 && column == 1) { // checks all the scenarios to avoid index out of bounds error caused from indexing a negative number from printArray. Therefore, having to test all the border of column and row is necessary
						if (duringArray[row-1][column+1] == boats[loops-2] || duringArray[row][column] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1; // connection is used later to determine if the boat is being connected or not
						}
					}
					
					else if (row-1 == 0 && column == 10) {
						if (duringArray[row-1][column-1] == boats[loops-2] || duringArray[row][column] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (row-1 == 9 && column == 1) {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column+1] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (row-1 == 9 && column == 10) {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column-1] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (row-1 == 0) {
						if (duringArray[row-1][column-1] == boats[loops-2] || duringArray[row-1][column+1] == boats[loops-2] ||
								duringArray[row][column] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (row-1 == 9) {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column-1] == boats[loops-2] || duringArray[row-1][column+1] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (column == 1) {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column+1] == boats[loops-2] ||
								duringArray[row][column] == boats[loops-2]) {
							System.out.println("hello");
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
					else if (column == 10) {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column-1] == boats[loops-2] ||
								duringArray[row][column] == boats[loops-2]) {
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					else {
						if (duringArray[row-2][column] == boats[loops-2] || duringArray[row-1][column-1] == boats[loops-2] ||
								duringArray[row][column] == boats[loops-2] || duringArray[row-1][column+1] == boats[loops-2]) { /* this is if the boat is being placed in the middle of the board and not worrying about the edge limits,
								therefore, the biggest problem here is if the boats pieces are touching eachother or not*/
							memory1[counter] = row-1;
							memory2[counter] = column;
						}
						else {
							connection = 1;
						}
					}
					
				}
				else {
					memory1[counter] = row-1;
					memory2[counter] = column;
				}
				counter++;
					
				if (counter < loops || connection == 1) {
					if (connection == 0) {
						L1 = new JLabel("Enter Column of " + placements[counter] + " Spot For Boat (int): ");
						addButton = new JButton("Place Column");
						message(L1, addButton);
					}
					else if (connection == 1) { // if the boat seemed to be broken and not in one piece
						String [][] myArray = {{"Must Connect Boat Horizontally or Vertically"}};
						console(myArray);
						retry();
					}
				}
				else {
					for (int i = 0; i < counter; i++) { // place boat on board if no errors were met
						printArray[memory1[i]][memory2[i]] = boats[loops-2];
						memory1[i] = 0;
						memory2[i] = 0;
					}
					String [][] myArray = {{"Finished Boat"}}; // reset specific variables to get ready to start new boat
					console(myArray);
					counter = 0;
					connection = 0;
					
				}
			}
			else {
				String [][] myArray = {{"Already Filled Spot, Retry"}}; // if the spot chosen is already taken up
				console(myArray);
				retry();
			}
			
		}
		
		else if (event.equals("Start Setup")) { // Starts the setup of the game, calling for each individual boat to be identified and placed appropriately 
			if (myTextField.getText().compareTo("X") == 0) {
				if (twoSetup == 0) { // two spaced boat
					loops = 2;
					twoSetup = 1;
					L1 = new JLabel("Enter Column of " + placements[counter] + " Spot For Boat (int): ");
					addButton = new JButton("Place Column");
					message(L1, addButton);
				}
				else {
					String [][] myArray = {{"Already Done Two Boat"}};  // already finished boat
					console(myArray);
				}
			}
			else if (myTextField.getText().compareTo("Y") == 0) { // three spaced boat
				if (threeSetup == 0) {
					loops = 3;
					threeSetup = 1;
					L1 = new JLabel("Enter Column of " + placements[counter] + " Spot For Boat (int): ");
					addButton = new JButton("Place Column");
					message(L1, addButton);
				}
				else {
					String [][] myArray = {{"Already Done Three Boat"}};  // already finished boat
					console(myArray);
				}
			}
			else if (myTextField.getText().compareTo("Z") == 0) { // four spaced boat
				if (fourSetup == 0) {
					loops = 4;
					fourSetup = 1;
					L1 = new JLabel("Enter Column of " + placements[counter] + " Spot For Boat (int): ");
					addButton = new JButton("Place Column");
					message(L1, addButton);
				}
				else {
					String [][] myArray = {{"Already Done Four Boat"}}; // already finished boat
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Not a Valid Input"}}; // if the input is not recognized as X Y or Z
				console(myArray);
			}
		}
		
		else if(event.equals("Column of Shot")) { // asks for the column of the shot, integer value alike the setup
			shotcolumn = Integer.parseInt(myTextField.getText());
			L1 = new JLabel("Enter Row where you want to place a shot: ");
		    addButton = new JButton("Row of Shot");
			message(L1, addButton);
		}
		
		else if(event.equals("Row of Shot")) { // asks for row of the shot, again an integer value
			shotrow = Integer.parseInt(myTextField.getText());
			if (backendArray[(shotrow-1)+11][shotcolumn] == AItwoBoat || backendArray[(shotrow-1)+11][shotcolumn] == AIthreeBoat || backendArray[(shotrow-1)+11][shotcolumn] == AIfourBoat) { // checks if its a hit
				hit = 1;
			}
			else { // checks if its a miss
				hit = 0;
			}
			String [][] myArray = {{"Send Shot When Ready"}};
			console(myArray);
		}
		
		else if(event.equals("Send Shot!")) {
			if (hit == 1) { // if a hit
				printArray[(shotrow-1)+11][shotcolumn] = "*";
				backendArray[(shotrow-1)+11][shotcolumn] = "*";
			}
			else { // if a miss
				printArray[(shotrow-1)+11][shotcolumn] = "O";
				backendArray[(shotrow-1)+11][shotcolumn] = "O";
			}
			AIShot();
			String [][] myArray = {{"Shot Sent Check Board For Result"}, {"Opponent Also Sent A Shot, Look At Your Side Too"}};
			console(myArray);
			checkAIWin(); // check AI win
			checkWin(); // check user win
			if (found == false) {
				String [][] myArray1 = {{"You won! :)"}}; // If user won
				console(myArray1);
			}
			else if (found1 == false) {
				String [][] myArray1 = {{"You lost! :("}}; // If AI won
				console(myArray1);
			}
		}
		
		else if (event.equals("Load Game")) { // loads game
			try {
				loadBook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String [][] myArray = {{"Game Loaded"}};
			console(myArray);
			System.out.println("Load Game");
		}
		
		else if (event.equals("Save Game")) { // saves game
			try {
				saveBook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			String [][] myArray = {{"Game Saved"}};
			console(myArray);
			System.out.println("Save Game");
		}
		
		else if (event.equals("Quit")) { // quits game
			System.out.println("Quit");
			System.exit(0);
		}
	}
			
	
	private static int readInt(){ // reading user inputs for choice
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private void viewBoard() { /* displays board, this is needed to see the battleship board through the menuitem option. Almost acts as the motherboard of the 
		whole game as it holds all the components together (boats, hits, misses)*/
		 contentPane = getContentPane();
		 contentPane.removeAll();
		 myJPanel = new JPanel();
		 L1 = new JLabel("BattleShip Board", JLabel.LEFT);
		 L1.setFont(new Font("Comic Sans", Font.BOLD, 14));
		 myJPanel.add(L1, BorderLayout.NORTH);
		 table = new JTable(printArray, columnNames);
		 JScrollPane scrollPane = new JScrollPane(table);
		 myJPanel.add(scrollPane, BorderLayout.CENTER);
	     // add the myJPanel to the content pane
	     contentPane.add(myJPanel);
	     validate();
	}
	
	private void placeBoats() { // Initiates the setup of the boats to commence the game, without setting up your boats the game cannot run, and the program will not allow it to
		L1 = new JLabel("Enter X (two boat), Y (three boat), or Z (four boat) to decide which boat to set up first: ");
	    addButton = new JButton("Start Setup");
		message(L1, addButton);
	}
	
	private void placeShot() { // initiates the location of the shot 
		L1 = new JLabel("Enter Column where you want to place a shot (int): ");
	    addButton = new JButton("Column of Shot");
		message(L1, addButton);
	}
	
	private void removeShot() { // Simple message removing the shot and deleting the data
		if (shotcolumn != 0) {
			String [][] myArray = {{"Shot Removed"}};
			hit = 0;
			shotrow = 0;
			shotcolumn = 0;
			console(myArray);
		}
		else {
			String [][] myArray = {{"Place Shot First"}};
			console(myArray);
		}
	}
		
	
	private void sendShot() { /* This method is used for the menu item of actually sending the shot.
		This also sends the AIShot in the actionPerformed method, allows the game to progress*/
		if (shotcolumn != 0) {
			L1 = new JLabel("Are You Sure?: ");
		    addButton = new JButton("Send Shot!");
			message(L1, addButton);
		}
		else {
			String [][] myArray = {{"Place Shot First"}};
			console(myArray);
		}
	}
	
	private void AISetup() { /* This is the method where the AI sets up their boats. It is coded in a way that none of the boats can overlap 
	and the rules followed by battleship and the human player applies to this AI. Moreover, it scatters the three boats around the "water" 
	by using math.random to create unpredictability between times played.
	*/
		for (int i = 0; i < 3; i++) {
			column = (int)(Math.random() * 10);
			int multi = (int)(Math.random() * 2);
			if (column < 5) {
				backendArray[(row-1)+12+(2*i)][column+1] = AIboats[i];
				backendArray[(row-1)+12+(2*i)][column+2] = AIboats[i];
				if (i == 1 ) {
					backendArray[(row-1)+12+(2*i)][column+3] = AIboats[i];
				}
				if (i == 2 ) {
					backendArray[(row-1)+12+(2*i)][column+3] = AIboats[i];
					backendArray[(row-1)+12+(2*i)][column+4] = AIboats[i];
				}
			}
			else if (column > 5) {
				backendArray[(row-1)+12+(2*i)][column-1] = AIboats[i];
				backendArray[(row-1)+12+(2*i)][column-2] = AIboats[i];
				if (i == 1 ) {
					backendArray[(row-1)+12+(2*i)][column-3] = AIboats[i];
				}
				if (i == 2 ) {
					backendArray[(row-1)+12+(2*i)][column-3] = AIboats[i];
					backendArray[(row-1)+12+(2*i)][column-4] = AIboats[i];
				}
			}
			else if (column == 5) {
				backendArray[(row-1)+12+(2*i)][column-1] = AIboats[i];
				backendArray[(row-1)+12+(2*i)][column-2] = AIboats[i];
				if (i == 1 ) {
					backendArray[(row-1)+12+(2*i)][column-3] = AIboats[i];
				}
				if (i == 2 ) {
					backendArray[(row-1)+12+(2*i)][column-3] = AIboats[i];
					backendArray[(row-1)+12+(2*i)][column-4] = AIboats[i];
				}
			}
		}
	}
	
	private void AIShot() { /* This is where the AI actually shoots their shot, basically at random hoping for a hit.
	While this may seem like it gives the AI no chance, battleship can be a game of luck sometimes, and the AI has a strong
	chance using this method.
	*/
		int AIshotrow = (int)(Math.random() * 10) + 1;
		int AIshotcolumn = (int)(Math.random()*10) + 1;
		
		if (printArray[AIshotrow-1][AIshotcolumn] == twoBoat || printArray[AIshotrow-1][AIshotcolumn] == threeBoat ||printArray[AIshotrow-1][AIshotcolumn] == fourBoat) {
			printArray[AIshotrow-1][AIshotcolumn] = "*";
		}
		else {
			printArray[AIshotrow-1][AIshotcolumn] = "O";
		}
	}
	
	private void saveBook() throws IOException { /* Simply sends the printArray and the backendArray along with important
	integer variables in order to replay and recall the game when needed. This way there will be no more setup or an precautions
	needed and the player can go straight into the game.
	*/
		 PrintWriter output;
		    output = new PrintWriter(new FileWriter("storage1.txt"));
		    output.println(twoSetup);
		    output.println(threeSetup);
		    output.println(fourSetup);
		    for(int i = 0; i < 10; i++){
		    	for(int j = 0; j < 20; j++){
			    	output.println(printArray[j][i]); 
			    }
		    }
		    for(int i = 0; i < 10; i++){
		    	for(int j = 0; j < 20; j++){
			    	output.println(backendArray[j][i]); 
			    }
		    }
		    output.close(); // close the file
		}
	
	private void loadBook() throws IOException { /* Reads all the data from the external file that was just previously saved.
	By reading the variables of the setup, the user will no longer have to redo the setup as it should be. Loading the game should 
	put the user right where they left off, and this is exactly what this method does.
	*/
		BufferedReader in;         
	    in = new BufferedReader(new FileReader("storage1.txt"));
	    twoSetup = Integer.valueOf(in.readLine());
	    threeSetup = Integer.valueOf(in.readLine());
	    fourSetup = Integer.valueOf(in.readLine());
	    for(int i = 0; i < 10; i++){
	    	for(int j = 0; j < 20; j++){
		    	printArray[j][i] = in.readLine(); 
		    }
	    }
	    for(int i = 0; i < 10; i++){
	    	for(int j = 0; j < 20; j++){
		    	backendArray[j][i] = in.readLine();
		    }
	    }
	}
	
	private static void checkWin() { /* Checks if the human player won by doing a sequential search of the AI board, looking
		for anymore boats */
		found = false;
		for (int i = 11; i < 21; i++) {
			for (int j = 0; j < 10; j++) {
				if (backendArray[i][j].compareTo(AItwoBoat) == 0 || backendArray[i][j].compareTo(AIthreeBoat) == 0 ||
						backendArray[i][j].compareTo(AIfourBoat) == 0) {
					found = true;
				}
			}
		}
	}
	
	private static void checkAIWin() { /* Checks if the AI player won by doing a sequential search of the human board, looking
		for anymore boats.*/
		found = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (printArray[i][j].compareTo(twoBoat) == 0 || printArray[i][j].compareTo(threeBoat) == 0 ||
					printArray[i][j].compareTo(fourBoat) == 0) {
					found1 = true;
				}
			}
		}
	}
	
	private void console(String [][] myArray) { /* To avoid repititions in code and in search for modular programming,
	this method is called for any console message needed to be displayed to help the user progress in the game*/
		contentPane = getContentPane();
		contentPane.removeAll();
		myJPanel = new JPanel();
		L1 = new JLabel("Console", JLabel.LEFT);
		L1.setFont(new Font("Comic Sans", Font.BOLD, 18));
		myJPanel.add(L1, BorderLayout.NORTH);
		table = new JTable(myArray, columnNames1);
		JScrollPane scrollPane = new JScrollPane(table);
		myJPanel.add(scrollPane, BorderLayout.CENTER);
	    // add the myJPanel to the content pane
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private JTextField message(JLabel L1, JButton addButton) { /* Again to avoid repititions in code and in search for modular programming,
		this method is called for any textfield message needed to be displayed to get user inputs/prompt the user with certain fields to fill*/
		contentPane = getContentPane();
		contentPane.removeAll();
		contentPane = getContentPane();
		myJPanel = new JPanel();
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    // add "addButton" to the JPanel
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    // clear the contentpane, add the new JPanel and validate
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	    
	    return myTextField;
	}
	
	private static void retry() { /* method used when the user fails to meet the battleship ruling when setting up their boats.
		This could be because of not keeping the boats in one piece, diagonally placing boats, overlapping boats*/
		counter = 0;
		connection = 0;
		if (loops == 2) {
			twoSetup = 0;
		}
		if (loops == 3) {
			threeSetup = 0;
		}
		if (loops == 4) {
			fourSetup = 0;
		}
	}
}