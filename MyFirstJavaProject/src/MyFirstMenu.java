/*
 * MyFirstMenu is a simple integer-driven menu that allows a user to enter their name, edit their name, display their name or exit the program appropriately
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MyFirstMenu {
	static String blue = "\u001B[34m";
	static String red = "\u001B[31m";
	static String myName;	//String variable used to store the entered name
	static int choice = 0;	//integer variable used to select the menu options
	
	
	public static void main(String[] args) {
		
		while (choice != 4){	//4 is the exit choice of the menu
			displayMenu();	//call display menu to output the menu options
			choice = readInt();	//get the menu choice from the user
			executeChoice(choice);//execute the menu option selected
			
		}
		System.out.println(blue + "Thanks for using my menu!");
	}	
	
	/*
	 * displayMenu simply writes to standard output the name of the program and the menu options
	 */
	private static void displayMenu(){
		
		System.out.println(red + "Username Menu:\n1. Enter your Name\n2. Edit your name\n3. Display your Name\n4. Exit");
		//write the standard output line here
		//*****************************************************************
	
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
		if (choice == 1) { //check if user wants to enter a name, then call method
			enterName();
		}
		else if (choice == 2) { //check if user wants to edit their name, then call method
			editName(); 
		}
		else if (choice == 3) { //check if user wants to display their name, then call method
			readName();
		}
		
	}
	
	
	
	/*
	 * enterName asks the user to enter their name and reads it from the standard input to the variable myName
	 */
	private static void enterName(){
		
		//declare and initialize the InputStreamReader and BufferedReader
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		System.out.println(blue + "Enter your name:");

		//enclose the readLine method in a try/catch block in case of an exception
		try {
			myName = reader.readLine();
		}
		catch (Exception e){
			System.out.println(blue + "You typed " + myName + "...there was a problem with that");
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
			System.out.println(blue + "You haven't entered your name yet! What is it?");
		}
		else {
			System.out.println(blue + "Your name is " + myName + ", what should it be?");
		}
		
		//enclose the readLine method in a try/catch block in case of an exception being thrown
		try {
			myName = reader.readLine();
		}
		catch (Exception e){
			System.out.println(blue + "You typed " + myName + "...there was a problem with that");
		}
		
	}
	
	
	
	/*
	 * readName outputs the stored name to standard output
	 */
	private static void readName(){
		
		//if the name was never set, inform the user
		if (myName == null){
			
			System.out.println(blue + "Sorry, I don't know your name.");
			enterName();
			
		}
		else {
			
			System.out.println(blue+myName);
			
		}
	}
	
	
}
