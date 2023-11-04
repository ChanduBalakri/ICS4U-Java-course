/* Date: 30/08/2023
 Dev: Chandresh Balakrishnan
*/

import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.util.ArrayList;
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
/* Pseudo Code
 start 
 ** Array Lists**
 Dedicate each field to a seperate array list
 now that there is no maximum, no need to check for full arrays
 Also, when showing the contact book on the screen, make sure you create a new static 2D array every time
 , this way, the array will always be the exact size as the parameters will be corresponding to the size of the ArrayLists.
 Now the table will not be scrollable until enough elements are filled to go off the screen (empty cells won't be displayed).
 declare Arrays for all 5 fields and book array
 define int choice to switch menu screens
 define flag and key variables to search through arrays
 define found variable to indicate a match in the contact book and user input
 define int counter to keep track of place in contact book
 initiate main loop
 always displaymenu and wait for reader choice until user chooses the quit menu item
 create a constructor to create the JPanel menu
 include menuitems and menu headers
 implement actionlistener to switch screen when necessary
 create an override actionlistener class to read when certain buttons are being clicked
 create a method for (messages) in order to display a message after each screen is finished its usage
  if user View display their book by printing the book array (call method)
 if user Add ask them for the details to add a new person in their contact book (call method)
 if user Modify ask them for the name of the person they would like to modify, then update the details (call method)
 if user Delete ask them for the name of the person they would like to delete, then delete and update book formatting (call method)
 if user Save, save their current contact book and all values in the storage file (call method)
 if user Load load their saved storage and override their existing storage, make sure all arrays are updated to the latest save file (call method)
 if user Sort ask them for what field they would like to sort, then sort accordingly from high-low or low-high per request
 if user Search ask then for what field they would like to search, go through this field's array and check if value is found, if not then print accordingly
 end
 */

/* IPO Charts
 Input: choose View
 Output: allow user to view the book 
 ^ applies to all choices in this code
 -----------------------------------------------
 Input: choose Add
 Output: what is the  name of your contact?
 Input: *any name*
 Process: adds name to name array
 Output: what is the number of your contact
 Input: *any number*
 Process: adds number to number array
 Output: what is the last name of your contact
 Input: *any last name*
 Process: adds last name to last name array
 Output: what is the address of your contact
 Input: *any address*
 Process: adds address to address array
 Output: what is the email of your contact
 Input: *any email*
 Process: adds email to email array
 Output: 
 ^ technically there is no direct output after this process if we assume the process is adding to the array (although displaying the menu occurs right after)
 ---------------------------------------------------------------------------------------------------------------------------------------------------------------
 Input: choose Modify
 Output: what is the name of the contact you would like to modify?
 Input: *any name*
 Process: check if name is in the contact book (assume it is)
 Output: ask all questions to modify all values if necessary
 ----------------------------------------------------------------------
 Input choose Delete
 Output: what is the name of the contact you would like to delete?
 Input: *any name*
 Process: check if name is in the contact book (assume it is)
 Output: delete contact from the contact book and all individual arrays
 Then print "*name* was deleted from your Contact Book"
 -----------------------------------------------------------------------
 Input: choose Save
 Output: print counter, book array, name array, number array, last name array, address array, and email array to the storage file
 Then print "Saved Book!" to console
 ------------------------------------------------------------------------------------------------------------------------------
 Input: choose Load
 Output: read the counter value, book array, and all value arrays from the storage and copy them to now represent the current contacts
 Then print "Loaded Contact Latest Storage!" to console
 ------------------------------------------------------------------------------------------------------------------------------------------
 Input: choose Sort (A-Z with any options present)
 Output: read what value to user set to sort by, then call sorting method to sort from high-low or low-high accordingly
 ------------------------------------------------------------------------------------------------------------------------------------------
 Input: choose Search (any options present)
 Output: search for specific value within appropriate array
 Then print "No Contact Found" or the contact if it is present
  ------------------------------------------------------------------------------------------------------------------------------------------
 */

public class NewContact3 extends JFrame implements ActionListener{
	static ArrayList<String> firstName = new ArrayList<String>();
	static ArrayList<String> number = new ArrayList<String>();
	static ArrayList<String> lastName = new ArrayList<String>();
	static ArrayList<String> address = new ArrayList<String>();
	static ArrayList<String> email = new ArrayList<String>();
	/*static String [] firstName = new String [100]; 
	static String [] number = new String [100]; 
	static String [] lastName = new String [100];
	static String [] address = new String [100]; 
	static String [] email = new String [100]; // define main arrays for all details*/
	
	static ArrayList<String> book = new ArrayList<String>(); // define book array to be printed and shown to the user
	
	static boolean swapped = true;
	static int choice = 0; // used to switch between screens
	static int order = 0; // A-Z or Z-A
	static int character = 0; // which field to organize
	static int field = 0;
	static String contactDetails = ""; // placeholder variable to read user inputs, this variable is used for all adding and modifying inputs
	static String flag = ""; // flag variable when using linear searches
	static int counter = 0; // makes sure contact are being added in the right place, fixed formatting of book
	static int key = 0; // key when using linear searches 
	static boolean found = false; // in order to indicate a match
	static JPanel myJPanel;
	static JTextField myTextField;
	static JLabel  L1, L2;
	static JButton addButton;
	static JTable table;
	static int vary = 0;
	static int versus = 0;
	static Container contentPane;
	static String[] columnNames = {"First Name", "Number", "Last Name", "Address", "Email"};
	static String [] columnNames1 = {"Console Message"}; 
	static ArrayList<String> property;
	static int login = 0;
	
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
			choice = readInt();	//get the menu choice from the user
		}
		while (choice != 4);  
			
		// common while loop to only stop when user selects quit option
			// go through base display method, regular print statement	
		

	}
	
	public NewContact3() { // constructor to add all values to the menu including the menu items, add actionlistener to change screens when desired
		JMenuBar menuBar;
	    JMenu menu;
	    JMenuItem menuItem;
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    menu = new JMenu("View");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("View");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Search");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("For First Name");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("For Last Name");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("For Number");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("For Address");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("For Email");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);

	    
	    menu = new JMenu("Update");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Add");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Delete");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Edit");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	
	    
	    menu = new JMenu("A-Z Sort");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("By First Name (A-Z)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Last Name (A-Z)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Number (A-Z)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Address (A-Z)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Email (A-Z)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	
	    
	    menu = new JMenu("Z-A Sort");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("By First Name (Z-A)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Last Name (Z-A)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Number (Z-A)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	
	    menuItem = new JMenuItem("By Address (Z-A)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("By Email (Z-A)");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);	
	    
	    
	    
	    menu = new JMenu("External");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Save");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    menuItem = new JMenuItem("Load");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	    
	    menu = new JMenu("Quit");
	    menuBar.add(menu);
	    
	    menuItem = new JMenuItem("Quit");
	    menuItem.addActionListener(this);
	    menu.add(menuItem);
	}
	
	private static void displayMenu () { // standard window screen
		NewContact3 window = new NewContact3();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setTitle("Your Contact Book");
	    window.setSize(800,600);
	    window.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// calls methods for certain choices
		String event = e.getActionCommand();
		if (event.equals("View")) { // show all contacts
			viewEntry();
			System.out.println("View");
		}
		else if (event.equals("Add")) { // add a contact
			try {
				addEntry();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			System.out.println("Add");
		}
		else if (event.equals("Edit")) { // modify a contact
			try {
				modifyEntry();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Edit");
		}
		else if (event.equals("Delete")) { // delete a contact
			try {
				deleteEntry();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Delete");
		}
		else if (event.equals("Save")) { // save entire book
			try {
				saveBook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Save");
		}
		else if (event.equals("Quit")) { // save entire book
			System.out.println("Quit");
			System.exit(0);
		}
		else if (event.equals("Load")) { // load entire stored book
			try {
				loadBook();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Load");
		}
		else if (event.equals("By First Name (A-Z)") || event.equals("By Last Name (A-Z)") || event.equals("By Number (A-Z)") ||
				event.equals("By Address (A-Z)") || event.equals("By Email (A-Z)")) { // sort entire stored book
			if (event.equals("By First Name (A-Z)")) { 
				String temp = "";
				order = 1;
				organize(firstName, temp);
				swapped = true;
				System.out.println("By First Name (A-Z)");
			}
			if (event.equals("By Last Name (A-Z)")) {
				String temp = "";
				order = 1;
				organize(lastName, temp);
				swapped = true;
				System.out.println("By Last Name (A-Z)");
			}
			if (event.equals("By Number (A-Z)")) {
				String temp = "";
				order = 1;
				numbOrganize(number, temp);
				swapped = true;
				System.out.println("By Number (A-Z)");
			}
			if (event.equals("By Address (A-Z)")) {
				String temp = "";
				order = 1;
				organize(address, temp);
				swapped = true;
				System.out.println("By Address (A-Z)");
			}
			if (event.equals("By Email (A-Z)")) {
				String temp = "";
				order = 1;
				organize(email, temp);
				swapped = true;
				System.out.println("By Email (A-Z)");
			}
			String[][] myArray = {{"Sorted A-Z"}};
			message(myArray);
		}
		else if (event.equals("By First Name (Z-A)") || event.equals("By Last Name (Z-A)") || event.equals("By Number (Z-A)") ||
				event.equals("By Address (Z-A)") || event.equals("By Email (Z-A)")) { // sort entire stored book
			if (event.equals("By First Name (Z-A)")) {
				String temp = "";
				order = 2;
				organize(firstName, temp);
				swapped = true;
				System.out.println("By First Name (Z-A)");
			}
			if (event.equals("By Last Name (Z-A)")) {
				String temp = "";
				order = 2;
				organize(lastName, temp);
				swapped = true;
				System.out.println("By Last Name (Z-A)");
			}
			if (event.equals("By Number (Z-A)")) {
				String temp = "";
				order = 2;
				numbOrganize(number, temp);
				swapped = true;
				System.out.println("By Number (Z-A)");
			}
			if (event.equals("By Address (Z-A)")) {
				String temp = "";
				order = 2;
				organize(address, temp);
				swapped = true;
				System.out.println("By Address (Z-A)");
			}
			if (event.equals("By Email (Z-A)")) {
				String temp = "";
				order = 2;
				organize(email, temp);
				swapped = true;
				System.out.println("By Email (Z-A)");
			}
			String[][] myArray = {{"Sorted Z-A"}};
			message(myArray);
		}
		else if (event.equals("For First Name") || event.equals("For Last Name") || event.equals("For Number") ||
				event.equals("For Address") || event.equals("For Email")) { // search through entire stored book
				if (event.equals("For First Name")) { // for searching
					try {
						searchBook();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					property = firstName;
					System.out.println("For First Name");
				}
				if (event.equals("For Last Name")) {
					try {
						searchBook();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					property = lastName;
					System.out.println("For Last Name");
				}
				if (event.equals("For Number")) {
					try {
						searchBook();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					property = number;
					System.out.println("For Number");
				}
				if (event.equals("For Address")) {
					try {
						searchBook();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					property = address;
					System.out.println("For Address");
				}
				if (event.equals("For Email")) {
					try {
						searchBook();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					property = email;
					System.out.println("For Email");
				}
		}
		else if (event.equals("Search This Entry")) { // if button is clicked
			for (int i = 0; i < counter; i++) {
				if (myTextField.getText().compareTo(property.get(i)) == 0) { 
					found = true;
					key = i;
				}
			}
			if (found == true) { 
				String[][] myArray = {{"Value Found"},{book.get(key)}};
				message(myArray);
				found = false;
			}
			else {
				String[][] myArray = {{"Value Not Found"}};
				message(myArray);
			}
		}
		else if(event.equals("Add To Book")) { // if adding button is clicked
			if (versus == 0) {
				addAndClear();
				if (vary == 0) {
					counter++;
				}
			}
			else if (versus == 1) {
				addAndClear();
			}
		}
		else if(event.equals("Search For Entry")) { // if modifying button is clicked
			for (int i = 0; i < firstName.size(); i++) {
				if (firstName.get(i) != null) {
					if (myTextField.getText().compareTo(firstName.get(i)) == 0) { // if the contact is actually found in the book
						found = true;
						key = i;
					}
				}
			}
				if (found == true) { // call questions again and use variable "key" to replace appropriate values
					try {
						questions();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					found = false;
				}
				
				else { // if not found 	contentPane = getContentPane();
					String[][] myArray = {{"Value Not Found"}};
					message(myArray);
			}
		}
		else if(event.equals("Delete This Entry")) { // if deleting button is clicked
			for (int i = 0; i < counter; i++) { 
				if (myTextField.getText().compareTo(firstName.get(i)) == 0) { // check if the contact is actually in the book
					found = true;
					key = i;
				}
			}
			if (found == true) { // replace each contact with the one ahead of it, starting from key. This way there will be no empty space in the array and it sorts the array automatically
				firstName.remove(key);
				number.remove(key);
				lastName.remove(key);
				address.remove(key);
				email.remove(key);
				book.remove(key);
				found = false;
				counter = counter - 1; // reduce counter to fix the index positions as now there is 1 less contact and 1 more free space
				String[][] myArray = {{"Deleted Entry"}};
				message(myArray);
			}
			else { // if not found
				String[][] myArray = {{"Value Not Found"}};
				message(myArray);
			}
		}
		
	}
	
	private static int readInt(){ // reading user inputs for choice
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private void questions() throws IOException { // runs the questions being asked to the users, this is used when modifying or adding contacts
		contentPane = getContentPane();
		contentPane.removeAll();
		contentPane = getContentPane();
		myJPanel = new JPanel();
		L1 = new JLabel("Enter a String: ");
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    // add "addButton" to the JPanel
	    addButton = new JButton("Add To Book");
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    // clear the contentpane, add the new JPanel and validate
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private int addAndClear() { // adds all values to the array indexed accordingly
		if (versus == 0) {
			if (vary == 0) {
				firstName.add(counter, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 1) {
				number.add(counter, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 2) {
				lastName.add(counter, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 3) {
				address.add(counter, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 4) {
				email.add(counter, myTextField.getText());
				vary = 0;
				myTextField.setText("");
				book.add(counter, firstName.get(counter) + "\t" + number.get(counter) + "\t" + lastName.get(counter) + "\t" + address.get(counter) + "\t" + email.get(counter)); 
				String[][] myArray = {{"Finished Adding All Values"},{"1. first name"},{"2. number"},{"3. last name"},{"4. address"},{"5. email"}};
				message(myArray);
			}
		}
		else if (versus == 1) {
			if (vary == 0) {
				firstName.remove(key);
				firstName.add(key, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 1) {
				number.remove(key);
				number.add(key, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 2) {
				lastName.remove(key);
				lastName.add(key, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 3) {
				address.remove(key);
				address.add(key, myTextField.getText());
				vary++;
				myTextField.setText("");
			}
			else if (vary == 4) {
				email.remove(key);
				email.add(key, myTextField.getText());
				vary = 0;
				myTextField.setText("");
				book.remove(key);
				book.add(key, firstName.get(key) + "\t" + number.get(key) + "\t" + lastName.get(key) + "\t" + address.get(key) + "\t" + email.get(key)); 
				String[][] myArray = {{"Finished Adding All Values"},{"1. first name"},{"2. number"},{"3. last name"},{"4. address"},{"5. email"}};
				message(myArray);
			}
		}
		return counter;
	}
	
	private void viewEntry() { // displays book
		String [][] convertedArray = new String [counter][5];
		 for (int i = 0; i < 5; i++) {
			 for (int j = 0; j < counter; j++) {
				 if (i == 0) {
				 	convertedArray[j][i] = firstName.get(j);
				 }
				 else if (i == 1) {
					convertedArray[j][i] = number.get(j);
				 }
				 else if (i == 2) {
					convertedArray[j][i]= lastName.get(j);
				 }
				 else if (i == 3) {
					convertedArray[j][i] = address.get(j);
				 }
				 else if (i == 4) {
					convertedArray[j][i] = email.get(j);
				 }
			 }
		 }
		 contentPane = getContentPane();
		 contentPane.removeAll();
		 myJPanel = new JPanel();
		 L1 = new JLabel("Contact Book", JLabel.LEFT);
		 L1.setFont(new Font("Comic Sans", Font.BOLD, 18));
		 myJPanel.add(L1, BorderLayout.NORTH);
		 table = new JTable(convertedArray, columnNames);
		 JScrollPane scrollPane = new JScrollPane(table);
		 myJPanel.add(scrollPane, BorderLayout.CENTER);
	     // add the myJPanel to the content pane
	     contentPane.add(myJPanel);
	     validate();
	}
	
	private void addEntry() throws IOException { // adds a contact
		versus = 0; 
		questions(); // ask the user the questions
			// move to the next index as the current one is now taken
	}

	private void modifyEntry() throws IOException{ // modify a contact
		versus = 1;
		contentPane = getContentPane();
		myJPanel = new JPanel();
		L1 = new JLabel("Enter the name of the contact to modify: ");
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    // add "addButton" to the JPanel
	    addButton = new JButton("Search For Entry");
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    // clear the contentpane, add the new JPanel and validate
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private void deleteEntry() throws IOException { // delete a contact
		contentPane = getContentPane();
		myJPanel = new JPanel();
		L1 = new JLabel("Enter the name of the contact to delete: ");
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    // add "addButton" to the JPanel
	    addButton = new JButton("Delete This Entry");
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    // clear the contentpane, add the new JPanel and validate
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private void saveBook() throws IOException, NullPointerException { // save the entire contact book to the storage file
	    login = 1;
		PrintWriter output;
	    output = new PrintWriter(new FileWriter("storage1.txt"));
	    output.println(counter); // send counter number as it will be used when loading this book and keeping track of correct index
	    for(int i = 0; i < counter; i++){
	    	output.println(book.get(i)); // send book array to the file
	    }
	    for (int i = 0; i < counter; i++) {
    		output.println(firstName.get(i));
    		output.println(number.get(i));
	    	output.println(lastName.get(i));
	    	output.println(address.get(i));
	    	output.println(email.get(i));  	
	    }
	    String[][] myArray = {{"Book Saved"}};
		message(myArray);
	    output.close(); // close the file
	}
	
	private void loadBook() throws IOException, NullPointerException {
		int multi = 0;
		int pos = 0;
		String [] junk = new String [101];
	    BufferedReader in;         
	    in = new BufferedReader(new FileReader("storage1.txt"));
	    counter = Integer.valueOf(in.readLine()); // take appropriate counter number for this save
	    for (int i = 1; i < counter+1; i++){
	    	book.add(i-1, in.readLine()); // read the user   
	    }
	    BufferedReader in2;         
	    in2 = new BufferedReader(new FileReader("storage1.txt"));
	    for (int i = 0; i < (counter*6)+1; i++) { // for length of storage
	    	if (i == (counter+1+multi)) { // formula coordinates the location of all the names
	    		if (login == 1) {
	    			firstName.remove(i-(counter+1+multi)+pos);
	    		}
	    		firstName.add(i-(counter+1+multi)+pos, in2.readLine());
	    	}
	    	else if (i == (counter+2+multi)) { // formula coordinates the location of all the numbers
	    		if (login == 1) {
	    			number.remove(i-(counter+2+multi)+pos);
	    		}
	    		number.add(i-(counter+2+multi)+pos, in2.readLine());
	    	}
	    	else if (i == (counter+3+multi)) { // formula coordinates the location of all the last names
	    		if (login == 1) {
	    			lastName.remove(i-(counter+3+multi)+pos);
	    		}
	    		lastName.add(i-(counter+3+multi)+pos, in2.readLine());
	    	}
	    	else if (i == (counter+4+multi)) { // formula coordinates the location of all the addresses
	    		if (login == 1) {
	    			address.remove(i-(counter+4+multi)+pos);
	    		}
	    		address.add(i-(counter+4+multi)+pos, in2.readLine());
	    	}
	    	else if (i == (counter+5+multi)) { // formula coordinates the location of all the emails
	    		if (login == 1) {
	    			email.remove(i-(counter+5+multi)+pos);
	    		}
	    		email.add(i-(counter+5+multi)+pos, in2.readLine());
	    		multi = multi + 5; // increase multi to move forward in the storage
	    		pos = pos + 1; // increase pose to move forward in the index of the arrays
	    	}
	    	else {
	    		junk[0] = in2.readLine(); // in order to keep the readLine going down in the file
	    	}
	    }
	    String[][] myArray = {{"Book Loaded"}};
		message(myArray);
	    in.close(); // close the file
	    in2.close(); // close the file
	}
	
	private static void organize(ArrayList<String> firstName2, String temp) { // bubble sorting method
		while (swapped){
			swapped = false;
			for (int i = 1; i < counter; i++){
	        	if (order == 1) { // A-Z
	                if (firstName2.get(i - 1).compareTo(firstName2.get(i)) > 0){
	                	temp = firstName.get(i - 1);
	                    firstName.add(i-1, firstName.get(i));
	                    firstName.remove(i);
	                    firstName.remove(i);
	                    firstName.add(i, temp);
	                    
	                    temp = book.get(i - 1);
	                    book.add(i-1, book.get(i));
	                    book.remove(i);
	                    book.remove(i);
	                    book.add(i, temp);
	                    
	                    temp = number.get(i - 1);
	                    number.add(i-1, number.get(i));
	                    number.remove(i);
	                    number.remove(i);
	                    number.add(i, temp);
	                    
	                    temp = lastName.get(i - 1);
	                    lastName.add(i-1, lastName.get(i));
	                    lastName.remove(i);
	                    lastName.remove(i);
	                    lastName.add(i, temp);
	                    
	                    temp = address.get(i - 1);
	                    address.add(i-1, address.get(i));
	                    address.remove(i);
	                    address.remove(i);
	                    address.add(i, temp);
	                    
	                    temp = email.get(i - 1);
	                    email.add(i-1, email.get(i));
	                    email.remove(i);
	                    email.remove(i);
	                    email.add(i, temp);
	                    swapped = true;  
	                }
	        	}
	        	if (order == 2) { // Z-A
	        		if (firstName2.get(i - 1).compareTo(firstName2.get(i)) < 0){
	        			temp = firstName.get(i - 1);
	                    firstName.add(i-1, firstName.get(i));
	                    firstName.remove(i);
	                    firstName.remove(i);
	                    firstName.add(i, temp);
	                    
	                    temp = book.get(i - 1);
	                    book.add(i-1, book.get(i));
	                    book.remove(i);
	                    book.remove(i);
	                    book.add(i, temp);
	                    
	                    temp = number.get(i - 1);
	                    number.add(i-1, number.get(i));
	                    number.remove(i);
	                    number.remove(i);
	                    number.add(i, temp);
	                    
	                    temp = lastName.get(i - 1);
	                    lastName.add(i-1, lastName.get(i));
	                    lastName.remove(i);
	                    lastName.remove(i);
	                    lastName.add(i, temp);
	                    
	                    temp = address.get(i - 1);
	                    address.add(i-1, address.get(i));
	                    address.remove(i);
	                    address.remove(i);
	                    address.add(i, temp);
	                    
	                    temp = email.get(i - 1);
	                    email.add(i-1, email.get(i));
	                    email.remove(i);
	                    email.remove(i);
	                    email.add(i, temp);
	                    swapped = true;  
	                }
	        	}
	        }
		}
	}
	
	private static void numbOrganize(ArrayList<String> number2, String temp) { // bubble sorting for integers specifically
		while (swapped){
			swapped = false;
			for (int i = 1; i < counter; i++){
	        	if (order == 1) { // A-Z
	                if (Long.parseLong(number2.get(i - 1)) > Long.parseLong(number2.get(i))){
	                	temp = firstName.get(i - 1);
	                    firstName.add(i-1, firstName.get(i));
	                    firstName.remove(i);
	                    firstName.remove(i);
	                    firstName.add(i, temp);
	                    
	                    temp = book.get(i - 1);
	                    book.add(i-1, book.get(i));
	                    book.remove(i);
	                    book.remove(i);
	                    book.add(i, temp);
	                    
	                    temp = number.get(i - 1);
	                    number.add(i-1, number.get(i));
	                    number.remove(i);
	                    number.remove(i);
	                    number.add(i, temp);
	                    
	                    temp = lastName.get(i - 1);
	                    lastName.add(i-1, lastName.get(i));
	                    lastName.remove(i);
	                    lastName.remove(i);
	                    lastName.add(i, temp);
	                    
	                    temp = address.get(i - 1);
	                    address.add(i-1, address.get(i));
	                    address.remove(i);
	                    address.remove(i);
	                    address.add(i, temp);
	                    
	                    temp = email.get(i - 1);
	                    email.add(i-1, email.get(i));
	                    email.remove(i);
	                    email.remove(i);
	                    email.add(i, temp);
	                    swapped = true;    
	                }
	        	}
	        	if (order == 2) { // Z-A
	        		if (Long.parseLong(number2.get(i-1)) < Long.parseLong(number2.get(i))){
	        			temp = firstName.get(i - 1);
	                    firstName.add(i-1, firstName.get(i));
	                    firstName.remove(i);
	                    firstName.remove(i);
	                    firstName.add(i, temp);
	                    
	                    temp = book.get(i - 1);
	                    book.add(i-1, book.get(i));
	                    book.remove(i);
	                    book.remove(i);
	                    book.add(i, temp);
	                    
	                    temp = number.get(i - 1);
	                    number.add(i-1, number.get(i));
	                    number.remove(i);
	                    number.remove(i);
	                    number.add(i, temp);
	                    
	                    temp = lastName.get(i - 1);
	                    lastName.add(i-1, lastName.get(i));
	                    lastName.remove(i);
	                    lastName.remove(i);
	                    lastName.add(i, temp);
	                    
	                    temp = address.get(i - 1);
	                    address.add(i-1, address.get(i));
	                    address.remove(i);
	                    address.remove(i);
	                    address.add(i, temp);
	                    
	                    temp = email.get(i - 1);
	                    email.add(i-1, email.get(i));
	                    email.remove(i);
	                    email.remove(i);
	                    email.add(i, temp);
	                    swapped = true;  
	                }
	        	}
	        }
		}
	}
	
	private void searchBook() throws IOException { // search through book
		contentPane = getContentPane();
		myJPanel = new JPanel();
		L1 = new JLabel("Enter the String to Search: ");
	    myJPanel.add(L1);
	    myTextField = new JTextField(20);
	    myJPanel.add(myTextField);
	    // add "addButton" to the JPanel
	    addButton = new JButton("Search This Entry");
	    addButton.addActionListener(this);
	    myJPanel.add(addButton);
	    // clear the contentpane, add the new JPanel and validate
	    contentPane.removeAll();
	    contentPane.add(myJPanel);
	    validate();
	}
	
	private void message(String [][] myArray) {
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
}