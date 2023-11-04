import java.io.BufferedReader; // import BufferedReader from java.io library to read user inputs
import java.io.InputStreamReader; // import InputStreamReader from java.io library to read user inputs
import java.io.IOException; // import IOException from java.io library handle readLine exception
public class Magic { // State class
	/* Pseudo Code **
	  main method
	  create two string variables for the user inputs
	  use InputStreamReader from library
	  ask user for two strings
	  readline, readline
	  check for equivalence, print yes or no
	  use string.length and print the length of each user input
	  print out the cases >, <, or = to using these integer lengths
	  index the 6th character of each input
	  print out these characters   
	 */
	
	public static void main(String[] args) throws IOException { // Main method declaration
		// Define colors for visually appealing output
		String red = "\u001B[31m";
		String blue = "\u001B[34m";
		String purple = "\u001B[35m";
		String green = "\u001B[32m";
		String yellow = "\u001B[33m";
		String black = "\u001B[39m";
		
		String firstinput; // Declare first user input variable
		String secondinput; // Declare second user input variable
		
		int firstlength; // Declare firstlength for 2nd trick
		int secondlength; // Declare secondlength for 2nd trick
		
		char firstchar; // Declare firstchar to determine the 6th character of first input for 3rd trick
		char secondchar; // Declare secondchar to determine the 6th character of second input for 3rd trick
		
		BufferedReader firstin = new BufferedReader(new InputStreamReader(System.in)); // create firstin variable to access readline method for first string
		BufferedReader secondin = new BufferedReader (new InputStreamReader(System.in)); // create secondin variable to access readline method for second string
		System.out.println(purple + "Enter two strings to see some magic!!!"); // Create a welcome message to tell user what to do
		
		System.out.println(red + "First String:"); // Request user's first string
		firstinput = firstin.readLine();
		
		System.out.println(blue + "Second String:"); // Request user's second string
		secondinput = secondin.readLine();
		
		// Check if string are equivalent: 1st trick
		if (firstinput.equals(secondinput) == true) {
			System.out.println(green + "Your Strings: " + firstinput + " and " + secondinput + ", are equivalent! :)");
			
		}
		else {
			System.out.println(red + "Your Strings: " + firstinput + " and " + secondinput + ", are not equivalent. :(");
		}
		
		// Output the length of each string: 2nd trick
		firstlength = firstinput.length();
		secondlength = secondinput.length();
		
		// Check which case the lengths follow
		if (firstlength > secondlength) {
			System.out.println(yellow + firstinput + "'s length is " + firstlength + " which is greater than " + secondinput + "'s length which is " + secondlength+".");
			
		}
		else if (firstlength < secondlength) {
			System.out.println(yellow + secondinput + "'s length is " + secondlength + " which is greater than " + firstinput + "'s length which is " + firstlength+".");
			
		}
		else {
			System.out.println(yellow + "Both of your string are equal at " + firstlength + " characters.");
			
		}

		// Check all cases to avoid errors only index when necessary
		if (firstinput.length() < 6 && secondinput.length() < 6) {
			System.out.print(black + "Both of your strings do not have a 6th character.");
		}
		else if (firstinput.length() < 6 && secondinput.length() >= 6) {
			secondchar = secondinput.charAt(5);
			System.out.println(black + "There is no 6th character for your first input and the 6th character of your second input is " + secondchar + ".");
		}
		else if (secondinput.length() < 6 && firstinput.length() >= 6) {
			firstchar = firstinput.charAt(5);
			System.out.println(black + "The 6th character of your first input is " + firstchar + " and there is no 6th character for your second input.");
		}
		else {
			firstchar = firstinput.charAt(5);
			secondchar = secondinput.charAt(5);
			System.out.println(black + "The 6th character of your first input is " + firstchar + " and the 6th character of your second input is " + secondchar + ".");
		}
	}
}
