/* Date: 26/07/2023
 Dev: Chandresh Balakrishnan
*/

import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.io.IOException; // used to throw IOException in methods
import java.io.InputStreamReader; // used to get inputs from the user
import java.util.Scanner; // used to read file

/* Pseudo Code
start
declare static variables for array, adding name, flag search, and choice variable
start the main method and create a while loop that continues until user selects quit
call the displaymenu method which displays a base menu
read user's input to determine what page to go to
switch the menu accordingly using 3 different functions for the 3 different pages
for the add friend page, add the friends using a counter variable to retain proper index
make sure to cut off the command after 5 names have been added, as stated in the declaration of the array
for the view FriendList method simply print out all the names using a for loop, and indexing the array with the for-loop variable "i"
for the searchFriendList we set a flag variable to be equal the user input.
then using a for loop index through the array to see if there is a match
display the result accordingly
end
*/


public class FriendsList {
	static int choice = 0; // to switch pages
	static int counter = 0; // to index adding friends without a for loop
	static String flag = ""; // used when searching through array
	static String [] friends = new String[5]; // create an array with static size, 5 friends in this case
	static String friendName = ""; // blank String variable to be used when adding names
	
	public static void main(String[] args) throws IOException{
		while (choice != 4) { // common while loop to only stop when user selects quit option
			displayMenu(); // go through base display method, regular print statement
			choice = readInt(); // read the choice by the user
			makeChoice(choice); // use this choice to determine what page to go through in makeChoice method
			
		}

	}
	
	private static void displayMenu () { // standard print home page
		System.out.println("Friend Menu:\n1. Add New Entry\n2. View All Entries\n3. Search For An Entry\n4. Quit");
	}
	
	private static int readInt(){ // reading user inputs for choice
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private static void makeChoice(int x) throws IOException { // calls methods for certain choices

		if (x == 1) { 
			addEntry();
		}
		else if (x == 2) { 
			viewEntry(); 
		}
		else if (x == 3) { 
			searchEntry();
		}
		
	}
	
	private static void addEntry() throws IOException { // adding an entry
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		if (friends[4] == null) { // as long as array is not full
			System.out.println("Enter your friend's name:");
			friendName = reader.readLine();
			friends[counter] = friendName; 
			counter++; 
		}
		else { // to avoid outOfBounds Exception 
			System.out.println("Your FriendList is full!");
		}
	}
	
	private static void viewEntry() { // display entire array 
		System.out.println("Your friends are:");
		for (int i = 0; i < 5; i++) { // used to index through the array
		
			if (friends[i] == null) { // used to not display null values, and rather display nothing
			}
			else {
				System.out.println(friends[i]);
			}
		}
	}

	private static void searchEntry() throws IOException{ // searching through the array
		boolean found = false; // found boolean variable to determine yes or no in list 
		System.out.println("Enter the name you would like to search: ");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		flag = reader.readLine(); // set flag to the user's requested name to search
		for (int i = 0; i < 5; i++) {
			if (flag.compareTo(friends[i]) == 0) { // if the user input is identical to a name in the array
				found = true;
			}
		}
		if (found == true) { // print accordingly if the name is or is not seen
			System.out.println(flag + " is in your FriendList!");
		}
		else {
			System.out.println(flag + " is not in your FriendList :(");
		}
}

}
