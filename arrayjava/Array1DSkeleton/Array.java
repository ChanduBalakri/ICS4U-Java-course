import java.io.*;

/*
 * The Array Class used to demonstrate arrays to ICS4U, has a skeleton function to be used to: search, add, delete, modify, save and load the array.
	Author: Mike King, 2013
 */
public class Array {

	public static void main(String[] args) {

		String line;		//String variable line to hold the input
		BufferedReader in;	//Buffered reader ot read input
		String tokens[];	//delimited parts of the line
		String delims = " "; //The delimiter is a space " "
		String[] arr = new String[1000];
		int i = 0;
		
		//read names from names.txt, use to initialize array
		//enclose in a try...catch block incase of an exception
		try {
			//initialize the reader for names.txt
			in = new BufferedReader(new FileReader("names.txt"));
			
			line = in.readLine();
			
			//populate the array with all the first names
			while (i < 1000 && line != null){
				
				tokens = line.split(delims);
				arr[i] = tokens[0];
				line = in.readLine();
				i++;
			
			}
			//catch if the file is not found
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			//catch if there is an error in I/O
		} catch (IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		
		}

		//skeleton method call
		myFunc(arr);
		
		//display the array contents
		display(arr);
		
	}
	
	/*
	 * Skeleton Method, fill in myFunc
	 */
	public static void myFunc(String[] array){

		
	}
	
	/*
	 * Display lists the entire arr array to standard output
	 */
	public static void display(String[] array){
		for (int i = 0; i < 1000; i ++){
			System.out.println(array[i]);
		}
		
	}
}
