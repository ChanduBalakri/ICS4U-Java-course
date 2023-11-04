/* Date: 09/09/2023
 Dev: Chandresh Balakrishnan
 VS: Java 20
*/

/*
 Battleship is a player vs. player or player vs. computer game that consists of placing boats on an open playing field
 After both players have assigned their boats to locations, each player takes turns blind guessing to destroy their opponents boats.
 This game consists of skill/strategy and also a bit a luck!
 */



import java.util.ArrayList;
import java.util.Scanner; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class Restaurant extends JFrame implements ActionListener{ // declares the class
	static int choice = 0; 
	static JPanel myJPanel;
	static JTextField myTextField;
	static JLabel  L1, L2;
	static JButton addButton;
	static JTable table;
	static Container contentPane;
	static String [] columnNames1 = {"Console Message"}; 
	static int introduction = 0;
	static int workersOrder = 0;
	static int workers = 10;
	static int wallet = 500;
	static int productOrder = 0;
	static int steak = 10;
	static int chicken = 10;
	static int house_salad = 10;
	static int coffee = 10;
	static int steakSold = 0;
	static int chickenSold = 0;
	static int house_saladSold = 0;
	static int coffeeSold = 0;
	static int type = 0;
	static int day = 1;
	static int daily = 0;
	static int spent = 0;
	static int multi = 0;
	static int times = 0;
	static int key = 0;
	static boolean found = false;
	static int [] prices = {20, 10, 5, 3};
	static ArrayList <Integer> scores = new ArrayList <Integer>();
	
	public static void main(String[] args) throws NullPointerException, NumberFormatException, IOException{ // main method
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
	
	
	public Restaurant() { // common constructor to establish menuheader and menuitems
		JMenuBar menuBar;
	    JMenu menu;
	    JMenuItem menuItem;
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    menu = new JMenu("Welcome");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Introduction");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Workers");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Hire Workers");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Fire Workers");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Product");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Add Products");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Remove Products");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Bank");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Balance");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Recent Day Profit/Deficit");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);


	    menu = new JMenu("Progress");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Simulate Day");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("External");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Record High Score");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
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
	
	private static void displayMenu () { // general window GUI initialization
		Restaurant window = new Restaurant();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Your Restaurant Manager");
	    window.setSize(800,600);
	    window.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){ // shows how each button corresponds to an action, this way certain actions occur
		// calls methods for certain choices
		String event = e.getActionCommand();
		if (event.equals("Introduction")) { // introduces the game and provides necessary details to the user
			if (introduction == 0) {
				String [][] myArray = {{"Restaurant Manager Game:"}, {"You have a starting balance of $500 and 10 starting workers"},{"Adding workers costs $50 each while removing workers gives you the $50 back"},
						{"You start with 10 steaks, 10 chickens, 10 house salads, and 10 coffees"},{"Steak - Produce: $20 Sell: $30"},{"Chicken - Produce: $10 Sell: $15"},{"House Salad - Produce: $5 Sell: $12"},
						{"Coffee - Produce: $3 Sell: $8"},{"Be careful, at the end of each day your food can spoil!"}, {"Also, your customers may like certain foods, pay attention!"}, {"Your goal is to create the perfect ratio with products and workers"}, {"Try to maximize profits, you have 7 days! GOOD LUCK!"}};
				console(myArray);
				introduction = 1;
			}
			else {
				String [][] myArray = {{"Already finished introduction"}};
				console(myArray);
			}
			System.out.println("Introduction");
		}
		
		else if (event.equals("Hire Workers")) { // hires workers
			if (day != 8) {
				if (introduction == 1) {
					workers();
					workersOrder = 0;
				}
				else {
					String [][] myArray = {{"View Introduction First!"}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Hire Workers");
		}
		
		else if (event.equals("Fire Workers")) { // fires workers
			if (day != 8) {
				if (introduction == 1) {
					workers();
					workersOrder = 1;
				}
				else {
					String [][] myArray = {{"View Introduction First!"}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Fire Workers");
		}
		
		else if (event.equals("Add/Remove Workers")) { 
			if (workersOrder == 0) { // adds workers 
				workers = workers + Integer.parseInt(myTextField.getText());
				wallet = wallet - (Integer.parseInt(myTextField.getText()) * (50));
				spent = spent + (Integer.parseInt(myTextField.getText()) * (50));
				String [][] myArray = {{"Your worker count is now " + workers}};
				console(myArray);
			}
				
			if (workersOrder == 1) { // removes workers
				if (workers - Integer.parseInt(myTextField.getText()) > 0) {
					workers = workers - Integer.parseInt(myTextField.getText());
					wallet = wallet + (Integer.parseInt(myTextField.getText()) * (50));
					spent = spent - (Integer.parseInt(myTextField.getText()) * (50));
					String [][] myArray = {{"Your worker count is now " + workers}};
					console(myArray);
				}
				else {
					String [][] myArray = {{"Your worker count has to be greater than 0"}};
					console(myArray);
				}
			}
			System.out.println("Add/Remove Workers");
		}
		
		else if (event.equals("Add Products")) { // adds product
			if (day != 8) {
				if (introduction == 1) {
					products();
					productOrder = 0;
				}
				else {
					String [][] myArray = {{"View Introduction First!"}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Add Products");
		}
		
		else if (event.equals("Remove Products")) { // removes product
			if (day != 8) {
				if (introduction == 1) {
					products();
					productOrder = 1;
				}
				else {
					String [][] myArray = {{"View Introduction First!"}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Remove Products");
		}
		
		else if (event.equals("Choose Product")) { 
			if (myTextField.getText().compareTo("steak") == 0) { // if user chooses steak
				L1 = new JLabel("Enter many steaks would you like to add/remove: ");
			    addButton = new JButton("Add/Remove Product");
				message(L1, addButton);
				type = 0;
			}
			else if (myTextField.getText().compareTo("chicken") == 0) { // if user chooses chicken
				L1 = new JLabel("Enter many chickens would you like to add/remove: ");
			    addButton = new JButton("Add/Remove Product");
				message(L1, addButton);	
				type = 1;
			}
			else if (myTextField.getText().compareTo("house salad") == 0) { // if user chooses house_salad
				L1 = new JLabel("Enter many house salads would you like to add/remove: ");
			    addButton = new JButton("Add/Remove Product");
				message(L1, addButton);	
				type = 2;
			}
			else if (myTextField.getText().compareTo("coffee") == 0) { // if user chooses coffee
				L1 = new JLabel("Enter many coffees would you like to add/remove: ");
			    addButton = new JButton("Add/Remove Product");
				message(L1, addButton);	
				type = 3;
			}
			else {
				String [][] myArray = {{"Invalid Input!"}};
				console(myArray);
			}	
			System.out.println("Choose Product");
		}
		
		else if (event.equals("Add/Remove Product")) { 
			if (productOrder == 0) { // adds product
				if (type == 0) { // steak
					steak = steak + Integer.parseInt(myTextField.getText());
				}
				else if (type == 1) { // chicken
					chicken = chicken + Integer.parseInt(myTextField.getText());			
				}
				else if (type == 2) { // house salad
					house_salad = house_salad + Integer.parseInt(myTextField.getText());	
				}
				else if (type == 3) { // coffee
					coffee = coffee + Integer.parseInt(myTextField.getText());
				}
				wallet = wallet - (Integer.parseInt(myTextField.getText()) * prices[type]);
				spent = spent + (Integer.parseInt(myTextField.getText()) * prices[type]);
				String [][] myArray = {{"Your product count is now: "}, {"steak " + steak},{"chicken " + chicken},
				{"house salad " + house_salad},{"coffee " + coffee}};
				console(myArray);
			}
			else if (productOrder == 1) { // removes product
				if (type == 0) {
					if (steak-Integer.parseInt(myTextField.getText()) >= 0) { // steak
						steak = steak - Integer.parseInt(myTextField.getText());
					}
					else {
						String [][] myArray = {{"Cannot have negative product"}};
						console(myArray);
					}
				}
				else if (type == 1) { // chicken
					if (chicken-Integer.parseInt(myTextField.getText()) >= 0) {
						chicken = chicken - Integer.parseInt(myTextField.getText());
					}
					else {
						String [][] myArray = {{"Cannot have negative product"}};
						console(myArray);
					}
				}
				else if (type == 2) { // house salad
					if (house_salad-Integer.parseInt(myTextField.getText()) >= 0) {
						house_salad = house_salad - Integer.parseInt(myTextField.getText());
					}
					else {
						String [][] myArray = {{"Cannot have negative product"}};
						console(myArray);
					}
				}
				else if (type == 3) { // coffee
					if (coffee-Integer.parseInt(myTextField.getText()) >= 0) {
						coffee = coffee - Integer.parseInt(myTextField.getText());
					}
					else {
						String [][] myArray = {{"Cannot have negative product"}};
						console(myArray);
					}
				}
				wallet = wallet + (Integer.parseInt(myTextField.getText()) * prices[type]);
				spent = spent - (Integer.parseInt(myTextField.getText()) * prices[type]);
				String [][] myArray = {{"Your product count is now: "}, {"steak " + steak},{"chicken " + chicken},
				{"house salad " + house_salad},{"coffee " + coffee}};
				console(myArray);
			}
			System.out.println("Add/Remove Product");
		}
		
		else if (event.equals("Balance")) { // displays balance to user
			if (day != 8) {
				if (introduction == 1) {
					String [][] myArray = {{Integer.toString(wallet)}};
					console(myArray);
				}
				else {
					String [][] myArray = {{"View Introduction First!"}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Balance");
		}
		
		else if (event.equals("Recent Day Profit/Deficit")) { // shows the previous day profit or deficit
			if (day != 8) {
				if (introduction == 1 && day != 1) {
					String [][] myArray = {{Integer.toString(daily)}};
					console(myArray);
				}
				else {
					if (introduction == 0 && day == 1) {
						String [][] myArray = {{"View Introduction First!"}};
						console(myArray);
					}
					else if (day == 1) {
						String [][] myArray = {{"Simulate at least one day first, you are on day 1"}};
						console(myArray);
					}
				}
			}
			else {
				String [][] myArray = {{"Game Complete"}};
				console(myArray);
			}
			System.out.println("Recent Day Profit/Deficit");
		}
		
		else if (event.equals("Simulate Day")) { // simulates a day
			if (introduction == 1) {
				simulate();
			}
			else {
				String [][] myArray = {{"View Introduction First!"}};
				console(myArray);
			}
			System.out.println("Simulate Day");
		}
		
		else if (event.equals("Record High Score")) { // records the score of the user and determines if it is a high score using sequential sort of an ArrayList
			if (introduction == 1 && day == 8) {
				found = false;
				try {
					loadScore();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					saveScore();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < scores.size(); i++) {
					if (scores.get(i) > wallet) {
						found = true;
						key = i;
					}
				}
				if (found == true) {
					String [][] myArray = {{"Your High Score is " + scores.get(key) + " that was not this game!"}};
					console(myArray);
				}
				else {
					String [][] myArray = {{"Your High Score is this game! " + wallet}};
					console(myArray);
				}
			}
			else {
				String [][] myArray = {{"View Introduction First or Complete Full Week"}};
				console(myArray);
			}
			System.out.println("Record High Score");
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
	
	private void workers() { // asks the user how many workers to add or remove
		L1 = new JLabel("Enter how many workers you would like to add/remove: ");
	    addButton = new JButton("Add/Remove Workers");
		message(L1, addButton);
	}
	
	private void products() { // asks the user which product they would like to alter the supply of
		L1 = new JLabel("Enter what product you would like to change (steak, chicken, house salad, coffee): ");
	    addButton = new JButton("Choose Product");
		message(L1, addButton);
	}
	
	private void simulate() { /* simulates a day, makes sure the day is not day 7 already so the game can still progress. This method is used to progress the game but it also determines how much of each product
								is being consumed by the customers. Therefore, the program will detremine the profits and the wallet updates after all of these integer values are set. The day variable is increased by one
								and the game progresses as usual*/
		if (day != 8) {			
			daily = 0;
			if (workers > 10) {
				multi = workers - 10;
			}
			steakSold = (int)(Math.random() * steak);
			chickenSold = (int)(Math.random() * chicken);
			house_saladSold = (int)(Math.random() * house_salad);
			coffeeSold = (int)(Math.random() * coffee);
			steak = steak-steakSold;
			chicken = chicken-chickenSold;
			house_salad = house_salad-house_saladSold;
			coffee = coffee-coffeeSold;
			daily = daily + (steakSold * (30+multi)) + (chickenSold * (15+multi)) + (house_saladSold * (12+multi)) + (coffeeSold * (8+multi));
			daily = daily - spent;
			day = day + 1;
			wallet = wallet + (steakSold * (30+multi)) + (chickenSold * (15+multi)) + (house_saladSold * (12+multi)) + (coffeeSold * (8+multi));
			String [][] myArray = {{"Report: "}, {"Steaks Sold: "+ steakSold}, {"Chickens Sold: " + chickenSold}, {"House Salads Sold: " + house_saladSold},
			{"Coffees Sold: " + coffeeSold},{"Your profit/deficit was " + daily},{"Your wallet is now " + wallet},{"You are on day " + day}};
			console(myArray);
			checkEnd();
			spent = 0;
		}
	}
	
	private void checkEnd() { // checks if the game has ended by checking if the day variable is equal to 8
		if (day == 8) {
			String [][] myArray = {{"Day 7 finished!"},{"Your final balance was: " + wallet}};
			console(myArray);
		}
	}
	
	private void loadScore() throws IOException, NumberFormatException{ /* loads the scores of the user from an external document. This allows the local ArrayList to be filled with all of the user's scores, which is later used for
	 							sequential search to determine if they hit their all time high score*/
		BufferedReader in1;         
	    in1 = new BufferedReader(new FileReader("scores.txt"));
	    BufferedReader in;         
	    in = new BufferedReader(new FileReader("scores.txt"));
	    if (in.readLine() != null) {
		    times = Integer.valueOf(in1.readLine());
		    for (int i = 0; i < times; i++) {
		    	scores.add(Integer.valueOf(in1.readLine()));
		    }
		    scores.add(wallet);
		    times = times + 1;
	    }
	    else {
	    	scores.add(wallet);
	    	times = times + 1;
	    }
	    in1.close();
	    in.close();
	    
	    
	}
	
	private void saveScore() throws IOException { // saves the score in order to update the external file and use for later high score searches
		PrintWriter output1;
	    output1 = new PrintWriter(new FileWriter("scores.txt"));
	    output1.println(times);
	    for (int i = 0; i < times; i++) {
	    	output1.println(scores.get(i));
		}
	    output1.close();
	}
	
	private void saveBook() throws IOException { // saves all the data necessary for the user to leave the system and rejoin at the exact same position
		PrintWriter output1;
	    output1 = new PrintWriter(new FileWriter("storage1.txt"));
	    output1.println(introduction);
	    output1.println(wallet);
	    output1.println(day);
	    output1.println(daily);
	    output1.println(workers);
	    output1.println(steak);
	    output1.println(chicken);
	    output1.println(house_salad);
	    output1.println(coffee);
	    output1.close();
		}
	
	private void loadBook() throws IOException { // loads all the data which was once saved in order to allow the user to start exactly where they left off

		BufferedReader in1;         
	    in1 = new BufferedReader(new FileReader("storage1.txt"));
	    introduction = Integer.valueOf(in1.readLine());
	    wallet = Integer.valueOf(in1.readLine());
	    day = Integer.valueOf(in1.readLine());
	    daily = Integer.valueOf(in1.readLine());
	    workers = Integer.valueOf(in1.readLine());
	    steak = Integer.valueOf(in1.readLine());
	    chicken = Integer.valueOf(in1.readLine());
	    house_salad = Integer.valueOf(in1.readLine());
	    coffee = Integer.valueOf(in1.readLine());
	    in1.close();
	}
	
	private void console(String [][] myArray) { // standard console message to make program more modular and less redundant, this is called throughout the program when a message is needed to be shared to the user
		contentPane = getContentPane();
		contentPane.removeAll();
		myJPanel = new JPanel();
		L1 = new JLabel("Console", JLabel.LEFT);
		L1.setFont(new Font("Comic Sans", Font.BOLD, 18));
		myJPanel.add(L1, BorderLayout.NORTH);
		table = new JTable(myArray, columnNames1);
		JScrollPane scrollPane = new JScrollPane(table);
		myJPanel.add(scrollPane, BorderLayout.CENTER);
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private JTextField message(JLabel L1, JButton addButton) { /* a textfield method that improves the aspect of modular programming, but also is called abundantly throughout the program to make it interactive and allow
																the user to make personalized choices*/
		contentPane = getContentPane();
		contentPane.removeAll();
		contentPane = getContentPane();
		myJPanel = new JPanel();
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	    
	    return myTextField;
	}
}