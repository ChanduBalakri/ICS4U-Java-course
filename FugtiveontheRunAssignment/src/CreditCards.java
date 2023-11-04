/* Date: 21/07/2023
 Dev: Chandresh Balakrishnan
*/

import java.io.BufferedReader; // import BufferedReader library to access readLine() method
import java.io.FileReader; // used to readLine() along with BufferedReader
import java.util.ArrayList; // used for creating String Arrays of text files
import java.io.FileNotFoundException; // used to catch FileNotFoundExeption
import java.io.IOException; // used to throw IOException in methods

/* Pseudo Code
start
initialize and declare boolean variable match to false
read the first file using BufferedReader
nest a while loop in a for loop with increments of i++ where i starts at 1 and reaches number of card numbers in first file
conditions for while loop are, match equals false and reader doesn't reach to the end of the file (value does not equal null)
in while loop read the first file line by line and store it to a variable
check if this variable's value is in the second file by calling a method that uses .contains ArrayList
if match is true, then check if it is also true in the third file using another method which mirrors the second method
if the card is also in the third file, then print that card number and set match to false to restart the while loop
once for loop is done, close the first file, the other files will close in their respective methods
end
*/

public class CreditCards { 
	
	static boolean match = false; // create bool match variable to identify specific card number
	
	public static void main(String[] args) throws IOException, Exception { // main method
		
		// Colors
		String green = "\u001B[32m"; 
		
		BufferedReader in1 = readFile("creditCards1.txt");
		String cards1 = "";
		for (int i = 0; i < sizeOfCards(); i++) { // repeat for number of identities in file
			while (match != true && cards1 != null) { // repeat until match is found or reached end of text file
				cards1 = in1.readLine(); // read each line
				store2(cards1); // check if card is in store 2
				if (match == true) {
					store3(cards1); // check if card is in store 3
				}
			}
			if (cards1 != null) { // only print if value is not null (in order to eliminate considering null as a match)
				System.out.println(green + cards1); // print the card number
				match = false; // reset match to false to restart while loop
			}
		}
		in1.close(); 
	}
	
	private static BufferedReader readFile(String filename) throws FileNotFoundException{ // create method to call whenever accessing a file is needed
		BufferedReader in = new BufferedReader(new FileReader(filename));
		return in;
	}
	
	private static void store2(String text) { // create store2 method to check card in store 2
		String cards2 = "";
		ArrayList<String> CardList2 = new ArrayList <String>(); // make ArrayList which contains all contents of the second text file
		BufferedReader in2;
		try {
			in2 = readFile("creditCards2.txt");
			while (cards2 != null) { // add all contents to this CardList2
				cards2 = in2.readLine();
				CardList2.add(cards2);
			}
			in2.close();
		} catch (FileNotFoundException e) { // catch for FileNotFoundException
			e.printStackTrace();
		} catch (IOException e) { // catch for IOException
			e.printStackTrace();
		}	
		
		if (CardList2.contains(text) == true) { // checks if card is in CardList2, if so then set match to true
			match = true;
		}
	}
	
	private static void store3(String text) throws IOException { // create method for store 3 to check if card is prevalent in store 3
		String cards3 = "";
		ArrayList<String> CardList3 = new ArrayList <String>(); // create ArrayList for store 3 cards
		BufferedReader in3 = readFile("creditCards3.txt");	
		while (cards3 != null) { // Put all contents of the third text file into CardList3
			cards3 = in3.readLine();
			CardList3.add(cards3);
		}
		in3.close();
		if (CardList3.contains(text) == true) { // check if the card is in store 3, if so confirm match = true
			match = true;
		}
		else { // checks if card is only in store 1 and 2, if not in 3, change match to false and do not record that card number
			match = false;
		}
	}
	
	private static int sizeOfCards() throws IOException { // create sizeOfCards method to make code reusable for any text files
		String cards = "";
		ArrayList <String> sizeList = new ArrayList <String>(); // create ArrayList to add all cards from primary text file
		BufferedReader in4 = readFile("creditCards1.txt");	
		while (cards != null) { // added all cards to sizeList
			cards = in4.readLine();
			sizeList.add(cards);
		}
		in4.close();
		int size = sizeList.size(); // create an int value for the number of values in sizeList
		return size; // return value to use in for loop
	}
}