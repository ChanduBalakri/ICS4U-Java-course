/*
 * MyFirstMenu is a simple integer-driven menu that allows a user to enter their name, edit their name, display their name or exit the program appropriately
 */

/*
 Chandresh Balakrishnan
 27/08/2023
 */


/* Pseudo Code
 Create instance of class named window
 Define window size and title
 Call display method which displays menu headings and items
 initialize the actionlistener for all items
 create new override method to perform an action when item is clicked 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class Chandresh_menu extends JFrame implements ActionListener{
	
	static String myName;	//String variable used to store the entered name
	static int choice = 0;	//integer variable used to select the menu options
	
	
	public static void main(String[] args) {
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		menuBar.add(file);
		menuBar.add(edit); 
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		while (choice != 4){	//4 is the exit choice of the menu
			
			displayMenu();		//call display menu to output the menu options
			choice = readInt();	//get the menu choice from the user
			executeChoice(choice);//execute the menu option selected
			
		}
		
	}

	
	public Chandresh_menu() { // create the menu and initialize the actionListener for all items
		JMenuBar menuBar;
	    JMenu menu;
	    JMenuItem menuItem;
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    menu = new JMenu("File");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Open");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Close");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Quit");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	 
	    
	    menu = new JMenu("Edit");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Undo");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Cut");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Copy");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	
	    menuItem = new JMenuItem("Paste");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Find");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Insert");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Image");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Tools");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Spelling");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Word Count");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Options");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	 
	    
	    menu = new JMenu("Help");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("About");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Help");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    
	}
	
	/*
	 * displayMenu simply writes to standard output the name of the program and the menu options
	 */
	private static void displayMenu(){ // create the window, title, and size
		
		Chandresh_menu window = new Chandresh_menu();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Chandreshs first menu");
	    window.setSize(800,600);
	    window.setVisible(true);
		
	}
	
	
	
	/*
	 * readInt reads an integer from the standard input and returns the integer, used to set choice
	 */
	private static int readInt(){
		
		Scanner in = new Scanner(System.in);
		return in.nextInt();
		
	}
	
	
	
	/*
	 * executeChoice calls the appropriate method, depending on what the user chose
	 */
	private static void executeChoice(int x){
		
		//write the switch statement here
		//********************************************************************
		
		
	}
	
	
	
	/*
	 * enterName asks the user to enter their name and reads it from the standard input to the variable myName
	 */
	private static void enterName(){
		
		//declare and initialize the InputStreamReader and BufferedReader
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		System.out.println("Enter your name:");

		//enclose the readLine method in a try/catch block incase of an exception
		try {
			myName = reader.readLine();
		}
		catch (Exception e){
			System.out.println("You typed " + myName + "...there was a problem with that");
		}		
		
	}
	
	
	
	/*
	 * editName performs the same function as enterName, but displays the current name before asking for what the name should be
	 */
	private static void editName(){
		
		//declare and initialize the InputStreamReader and BufferedReader
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		//if no name has been entered
		if (myName == null){
			System.out.println("You haven't entered your name yet! What is it?");
		}
		else {
			System.out.println("Your name is " + myName + ", what should it be?");
		}
		
		//enclose the readLine method in a try/catch block in case of an exception being thrown
		try {
			myName = reader.readLine();
		}
		catch (Exception e){
			System.out.println("You typed " + myName + "...there was a problem with that");
		}
		
	}
	
	
	
	/*
	 * readName outputs the stored name to standard output
	 */
	private static void readName(){
		
		//if the name was never set, inform the user
		if (myName == null){
			
			System.out.println("Sorry, I don't know your name.");
			enterName();
			
		}
		else {
			
			System.out.println(myName);
			
		}
	}


	@Override
	 public void actionPerformed(ActionEvent e) // Prints to System what is being clicked
	  {
	    String event = e.getActionCommand();
	    // Menu Items
	    if(event.equals("Open"))
	    {
	    	System.out.println("Open");
	    }
	    else if(event.equals("Close"))
	    {
	    	System.out.println("Close");
	    }
	    else if(event.equals("Quit"))
	    {
	    	System.out.println("Quit");
	    }
	    else if(event.equals("Undo"))
	    {
	    	System.out.println("Undo");
	    }
	    else if(event.equals("Cut"))
	    {
	    	System.out.println("Cut");
	    }
	    else if(event.equals("Copy"))
	    {
	    	System.out.println("Copy");
	    }
	    else if(event.equals("Paste"))
	    {
	    	System.out.println("Paste");
	    }
	    else if(event.equals("Find"))
	    {
	    	System.out.println("Find");
	    }
	    else if(event.equals("Image"))
	    {
	    	System.out.println("Image");
	    }
	    else if(event.equals("Spelling"))
	    {
	    	System.out.println("Spelling");
	    }
	    else if(event.equals("Word Count"))
	    {
	    	System.out.println("Word Count");
	    }
	    else if(event.equals("Options"))
	    {
	    	System.out.println("Options");
	    }
	    else if(event.equals("About"))
	    {
	    	System.out.println("About");
	    }
	    else if(event.equals("Help"))
	    {
	    	System.out.println("Help");
	    }
	  }
	
}
