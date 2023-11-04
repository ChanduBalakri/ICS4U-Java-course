/*
 Chandresh Balakrishnan
 01/09/2023
 */

import java.io.IOException;
import java.io.BufferedReader;  // import BufferedReader library to access readLine() method
import java.io.FileReader; // reading the file when loading contact book
import java.io.FileWriter; // used to write to the file when saving contact book
import java.io.IOException; // used to throw IOException in methods
import java.io.InputStreamReader; // used to get inputs from the user
import java.io.PrintWriter; // also used to write to the file
import java.util.Scanner; // used to read file

public class Fibonacci {


	public static void main(String[] args) throws IOException {
		System.out.println("Pick a n number to commence the Fibonacci Sequence: ");
		int n = readInt();
		for (int i = 0; i < n; i++) {
			int result = recursionSequence(i);
			System.out.println(result + "");
		}
		//nonrecursionSequence(n);
	
	}
	public static int recursionSequence(int n) {
		if (n == 0) {
			return 0;
		}
		else if(n==1 || n==2) {
			return 1;
		}
		return recursionSequence(n-1) + recursionSequence(n-2);
	}
	
	public static void nonrecursionSequence(int n) {
		 int previousNumber = 0;
		 int nextNumber = 1;
	        for (int i = 1; i <= n; ++i)
	        {
	            System.out.print(previousNumber+" ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
	}
	
	private static int readInt(){ // reading user inputs for choice
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

}