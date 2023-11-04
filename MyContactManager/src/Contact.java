import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.io.FileReader; // reading the file when loading contact book
import java.io.FileWriter; // used to write to the file when saving contact book
import java.io.IOException; // used to throw IOException in methods
import java.io.InputStreamReader; // used to get inputs from the user
import java.io.PrintWriter; // also used to write to the file
import java.util.Scanner; // used to read file

/* Pseudo Code
 start 
 declare Arrays for all 5 fields and book array
 define int choice to switch menu screens
 define flag and key variables to search through arrays
 define found variable to indicate a match in the contact book and user input
 define int counter to keep track of place in contact book
 initiate main loop
 always displaymenu and wait for reader choice until user choice is equal to 7 (quit)
 if user chooses 1 display their book by printing the book array (call method)
 if user chooses 2 ask them for the details to add a new person in their contact book (call method)
 if user chooses 3 ask them for the name of the person they would like to modify, then update the details (call method)
 if user chooses 4 ask them for the name of the person they would like to delete, then delete and update book formatting (call method)
 if user chooses 5, save their current contact book and all values in the storage file (call method)
 if user chooses 6 load their saved storage and override their existing storage, make sure all arrays are updated to the latest save file (call method)
 end
 */

/* IPO Charts
 Input: choose option 1
 Process: check what option 1 is (View) 
 Output: allow user to view the book 
 ^ applies to all choices in this code
 -----------------------------------------------
 Input: choose option 2
 Process: check what option 2 is (Add)
 Output: what is the name of your contact?
 Input: *any name*
 Process: adds name to name array
 Output: what is the number of your contact
 Input: *any number*
 Process: adds number to number array
 Output: what is the dob of your contact
 Input: *any dob*
 Process: adds dob to dob array
 Output: what is the address of your contact
 Input: *any address*
 Process: adds address to address array
 Output: what is the email of your contact
 Input: *any email*
 Process: adds email to email array
 Output: 
 ^ technically there is no direct output after this process if we assume the process is adding to the array (although displaying the menu occurs right after)
 ---------------------------------------------------------------------------------------------------------------------------------------------------------------
 Input: choose option 3
 Process: check what option 3 is (Modify)
 Output: what is the name of the contact you would like to modify?
 Input: *any name*
 Process: check if name is in the contact book (assume it is)
 Output: ask all questions to modify all values if necessary
 ----------------------------------------------------------------------
 Input choose option 4
 Process: check what option 4 is (Delete)
 Output: what is the name of the contact you would like to delete?
 Input: *any name*
 Process: check if name is in the contact book (assume it is)
 Output: delete contact from the contact book and all individual arrays
 Then print "*name* was deleted from your Contact Book"
 -----------------------------------------------------------------------
 Input: choose option 5
 Process: check what option 5 is (Save)
 Output: print counter, book array, name array, number array, dob array, address array, and email array to the storage file
 Then print "Saved Book!" to console
 ------------------------------------------------------------------------------------------------------------------------------
 Input: choose option 6
 Process: check what option 6 is (Load)
 Output: read the counter value, book array, and all value arrays from the storage and copy them to now represent the current contacts
 Then print "Loaded Contact Latest Storage!" to console
 ------------------------------------------------------------------------------------------------------------------------------------------
 */

/* DFD Diagram 
https://app.diagrams.net/?src=about#G13IbNoJbDFGnKPGu5Ujhqz7PuSFYeyNq7
 */

public class Contact {
	static String [] name = new String [100]; static String [] number = new String [100]; static String [] dob = new String [100];
	static String [] address = new String [100]; static String [] email = new String [100]; // define main arrays for all details
	
	static String [] book = new String [100]; // define book array to be printed and shown to the user
	
	static int choice = 0; // used to switch between screens
	static String contactDetails = ""; // placeholder variable to read user inputs, this variable is used for all adding and modifying inputs
	static String flag = ""; // flag variable when using linear searches
	static int counter = 0; // makes sure contact are being added in the right place, fixed formatting of book
	static int key = 0; // key when using linear searches 
	static boolean found = false; // in order to indicate a match
	
	public static void main(String[] args) throws IOException {
		while (choice != 7) { // common while loop to only stop when user selects quit option
			displayMenu(); // go through base display method, regular print statement
			choice = readInt(); // read the choice by the user
			makeChoice(choice); // use this choice to determine what page to go through in makeChoice method
		}

	}
	
	private static void displayMenu () { // standard print home page
		System.out.println("Contact Menu:\n1. View All Entries\n2. Add New Entry\n3. Modify An Entry\n4. Delete An Entry\n5. Save Contact Book\n6. Load Contact Book\n7. Quit");
	}
	
	private static int readInt(){ // reading user inputs for choice
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private static void makeChoice(int x) throws IOException { // calls methods for certain choices

		if (x == 1) { // show all contacts
			viewEntry();
		}
		else if (x == 2) { // add a contact
			addEntry(); 
		}
		else if (x == 3) { // modify a contact
			modifyEntry();
		}
		else if (x == 4) { // delete a contact
			deleteEntry();
		}
		else if (x == 5) { // save entire book
			saveBook();
		}
		else if (x == 6) { // load entire stored book
			loadBook();
		}
		
	}
	
	private static void questions(int counter) throws IOException { // runs the questions being asked to the users, this is used when modifying or adding contacts
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		
		System.out.println("Enter your contact's name: "); // name question
		contactDetails = reader.readLine();
		name[counter] = contactDetails; /* stored (uses counter which essentially remembers the index which is the next to be filled; when modifying, the counter 
										is changed to the variable "key" which makes sure to replace the same position of the contact being modified) */
		
		System.out.println("Enter your contacts's number: "); // number question
		contactDetails = reader.readLine();
		number[counter] = contactDetails; // stored
			
		System.out.println("Enter your contacts's date of birth (DD/MM/YYYY): "); // date question
		contactDetails = reader.readLine();
		dob[counter] = contactDetails; // stored
			
		System.out.println("Enter your contacts's address: "); // address question
		contactDetails = reader.readLine();
		address[counter] = contactDetails; // stored
			
		System.out.println("Enter your contacts's email: "); // email question
		contactDetails = reader.readLine();
		email[counter] = contactDetails; // stored
		
		book[counter] = name[counter] + "\t" + number[counter] + "\t" + dob[counter] + "\t" + address[counter] + "\t" + email[counter]; // formats with tabs to ensure uniform contact book for all contacts
	}
	
	private static void viewEntry() { // displays book
		System.out.println("Your Contact Book is: ");
		for (int i = 0; i < 100; i++) { 
		
			if (book[i] == null) { // makes sure to exclude nulls
			}
			else {
				System.out.println(book[i]);
			}
		}
	}
	
	private static void addEntry() throws IOException { // adds a contact
		if (name[99] == null) { // as long as the array has space
			questions(counter); // ask the user the questions
			counter++; // move to the next index as the current one is now taken
		}
		else { // if no more space
			System.out.println("Your Contact Book is full!");
		}
	}

	private static void modifyEntry() throws IOException{ // modify a contact
		System.out.println("Enter the contact's name you would like to modify: ");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		flag = reader.readLine(); 
		for (int i = 0; i < 100; i++) {
			if (name[i] != null) {
				if (flag.compareTo(name[i]) == 0) { // if the contact is actually found in the book
					found = true;
					key = i;
				}
			}
		}
		if (found == true) { // call questions again and use variable "key" to replace appropriate values
			questions(key);
			found = false;
		}
		else { // if not found 
			System.out.println(flag + " is not in your Contact Book :(");
		}
	}
	
	private static void deleteEntry() throws IOException { // delete a contact
		System.out.println("Enter the contact's name you would like to delete: ");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		flag = reader.readLine(); 
		for (int i = 0; i < counter; i++) { 
			if (flag.compareTo(name[i]) == 0) { // check if the contact is actually in the book
				found = true;
				key = i;
			}
		}
		if (found == true) { // replace each contact with the one ahead of it, starting from key. This way there will be no empty space in the array and it sorts the array automatically
			while (key < 99) {
				name[key] = name[key+1]; number[key] = number[key+1]; dob[key] = dob[key+1];
				address[key] = address[key+1]; email[key] = email[key+1];
				book[key] = book[key+1];
				key++;
			}
			name[99] = null; number[99] = null; dob[99] = null; address[99] = null; email[99] = null; book[99] = null; // set last value to null as it will always be null when deleting an item
			found = false;
			System.out.println(flag +" was deleted from your Contact Book");
			counter = counter - 1; // reduce counter to fix the index positions as now there is 1 less contact and 1 more free space
		}
		else { // if not found
			System.out.println(flag + " is not in your Contact Book :(");
		}
	}
	
	private static void saveBook() throws IOException { // save the entire contact book to the storage file
	    PrintWriter output;
	    output = new PrintWriter(new FileWriter("storage.txt"));
	    output.println(counter); // send counter number as it will be used when loading this book and keeping track of correct index
	    for(int i = 0; i < counter; i++){
	    	if (book[i] == null) {
	    	}
	    	else {
	    		output.println(book[i]); // send book array to the file
	    	}
	    }
	    System.out.println("Saved Book!");
	    for (int i = 0; i < counter; i++) {
	    	if (name[i] == null) {
	    	}
	    	else { // send individual arrays to the file in order to load them back when user calls
	    		output.println(name[i]);
	    		output.println(number[i]);
		    	output.println(dob[i]);
		    	output.println(address[i]);
		    	output.println(email[i]);
	    	}    	
	    }
	    output.close(); // close the file
	}
	
	private static void loadBook() throws IOException {
		int multi = 0;
		int pos = 0;
		String [] junk = new String [101];
	    BufferedReader in;         
	    in = new BufferedReader(new FileReader("storage.txt"));
	    System.out.println("Loaded Contact Latest Storage!");
	    counter = Integer.valueOf(in.readLine()); // take appropriate counter number for this save
	    for (int i = 1; i < counter+1; i++){
	        book[i-1] = in.readLine(); // read the user   
	    }
	    BufferedReader in2;         
	    in2 = new BufferedReader(new FileReader("storage.txt"));
	    for (int i = 0; i < (counter*6)+1; i++) { // for length of storage
	    	if (i == (counter+1+multi)) { // formula coordinates the location of all the names
	    		name[i-(counter+1+multi) + pos] = in2.readLine();
	    	}
	    	else if (i == (counter+2+multi)) { // formula coordinates the location of all the numbers
	    		number[i-(counter+2+multi)+pos] = in2.readLine();
	    	}
	    	else if (i == (counter+3+multi)) { // formula coordinates the location of all the dobs
	    		dob[i-(counter+3+multi)+pos] = in2.readLine();
	    	}
	    	else if (i == (counter+4+multi)) { // formula coordinates the location of all the addresses
	    		address[i-(counter+4+multi)+pos] = in2.readLine();
	    	}
	    	else if (i == (counter+5+multi)) { // formula coordinates the location of all the emails
	    		email[i-(counter+5+multi)+pos] = in2.readLine();
	    		multi = multi + 5; // increase multi to move forward in the storage
	    		pos = pos + 1; // increase pose to move forward in the index of the arrays
	    	}
	    	else {
	    		junk[0] = in2.readLine(); // in order to keep the readLine going down in the file
	    	}
	    }
	    System.out.println(counter);
	    for (int i = 0; i < counter+1; i++) {
	    	System.out.println(book[i]);
	    	System.out.println(name[i]);
	    	System.out.println(number[i]);
	    	System.out.println(dob[i]);
	    	System.out.println(address[i]);
	    	System.out.println(email[i]);
	    }
	    book[counter] = null;
	    name[counter] = null;
	    number[counter] = null;
	    dob[counter] = null;
	    address[counter] = null;
	    email[counter] = null;
	    in.close(); // close the file
	    in2.close(); // close the file
	}
}


