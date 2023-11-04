import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.io.FileReader; // reading the file when loading contact book
import java.io.FileWriter; // used to write to the file when saving contact book
import java.io.IOException; // used to throw IOException in methods
import java.io.InputStreamReader; // used to get inputs from the user
import java.io.PrintWriter; // also used to write to the file
import java.util.Scanner; // used to read file

/* Pseudo Code
  start
  download all the names from the text file
  create while loop to continue until user says stop
  display the menu
  read users choice
  bubble sort or selection sort if user selects
  reset all variables after sort to get a new start for next choice by user
  end
 */

public class Sorting { 
	static int counter = 0;
	static int choice = 0;
	static int order = 0;
	static String [] names = new String [100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in;         
	    in = new BufferedReader(new FileReader("unsortedNames.txt"));
		for (int i = 0; i < 100; i++) { // add all names to Array
			names[i] = in.readLine();
		}
		in.close();
		while (choice != 3) { // continue while loop until user says stop
			displayMenu();
			choice = readInt(); 
			makeChoice(choice); 
		}

	}
	
	private static void displayMenu () { // basic display screen
		System.out.println("Bubble vs. Selection:\n1. Bubble Method\n2. Selection Method\n3. Quit");
	}
	
	private static int readInt(){ // read user inputs
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	private static void makeChoice(int x) throws IOException { // determines which choice user selects

		if (x == 1) { 
			bubble();
		}
		else if (x == 2) { 
			selection(); 
		}
	}
	
	private static void bubble() throws IOException { // bubble sorts 
		boolean swapped = true;
        String temp;  
        System.out.println("What order would you like the list, A-Z (1) or Z-A (2)");
		order = readInt();
        while (swapped){
            swapped = false;
            for (int i = 1; i < 100; i++){
            	if (order == 1) { // A-Z
	                if (names[i - 1].compareTo(names[i]) > 0){
	                    temp = names[i - 1];
	                    names[i - 1] = names[i];
	                    names[i] = temp;
	                    swapped = true;  
	                    counter++; // increment counter to indicate 1 switch
	                }
            	}
            	if (order == 2) { // Z-A
            		if (names[i - 1].compareTo(names[i]) < 0){
	                    temp = names[i - 1];
	                    names[i - 1] = names[i];
	                    names[i] = temp;
	                    swapped = true;  
	                    counter++; // increment counter to indicate 1 switch
	                }
            	}
            }
        }
        for (int i = 0; i< 100; i++) { // print out all the sorted names
			System.out.println(names[i]);
		}
		System.out.println(counter); // print out number of switches made
		counter = 0; // reset counter to 0 to start new sort
		BufferedReader in1;
		in1 = new BufferedReader(new FileReader("unsortedNames.txt"));
		for (int i1 = 0; i1 < 100; i1++) { // add all names to Array
			names[i1] = in1.readLine();
		}
		in1.close();
	}
	
	private static void selection() throws IOException { // selection sorting
		int i, j;
		int small = 0;
		String temp;
		System.out.println("What order would you like the list, A-Z (1) or Z-A (2)");
		order = readInt();
		for (i = 0; i < 100; i++) {
			for (j = 1; j < 100; j++) {
				small = i;
				if (order == 1) { 
					if (names[j].compareTo(names[small]) > 0) {
						small = j;	
						counter++; // increment counter
					}
				}
				if (order == 2) {
					if (names[j].compareTo(names[small]) < 0) {
						small = j;	
						counter++; // increment counter
					}
				}
			
				temp = names[i];
				names[i] = names[small];
				names[small] = temp;
			}
		}
		temp = names[0];
		for (i = 0; i < 99; i++) {
			names[i] = names[i+1];
		}
		names[99] = temp;
		for (i = 0; i < 100; i++) {
			System.out.println(names[i]); // print all the sorted names
		}
		System.out.println(counter); // print number of switches made
		counter = 0; // reset counter to 0
		BufferedReader in1;         
	    in1 = new BufferedReader(new FileReader("unsortedNames.txt"));
		for (int i1 = 0; i1 < 100; i1++) { // add all names to Array
			names[i1] = in1.readLine();
		}
		in1.close();
	}
}

/* Questions
 The selection algorithm was more efficient from A-Z and Z-A. 
 If the array is already sorted, then the number of swaps is 0.
 */
