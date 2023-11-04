/*
 * ICS4U ArraysList Formative Assignment
 * Randomly generates an arraylist of unique 5 element integer arrays
 * Your task: Sort the arraylist, then output the results
 */

/*
 Chandresh Balakrishnan
 30/08/2023
 */

/*Psuedo Code
 Implement bubble sort method for each column from smallest to largest
 */

package Dynamic;

import java.util.ArrayList;
import java.util.Random;

public class ArraysList {

	static ArrayList<int[]> ar;
	
	static Random rand;
	
	static boolean swapped = true;
	
	public static void main(String[] args) {

		//count variable used as a limit for the number of randomly generated int arrays
		int count = 100;
		
		//declare and intialize the arraylist and the random
		ar = new ArrayList<int[]>();
		rand = new Random();
		
		//add count variable unique int arrays to the arraylist
		for (int i = 0; i < count; i++){
			ar.add(getUniqueArray());
		}
		
		//print the unsorted list
		printList();
		
		//TODO
		//IMPLEMENT THE SORTING METHOD!
		
		sortList();
		System.out.println("-----------------------------");
		//print the sorted list
		printList();
		
	}

	/*
	 * randomInt returns an random integer between 0-9 (inclusive)
	 */
	private static int randomInt(){
		return rand.nextInt(10);
	}
	
	/*
	 * newArray randomly generates an integer array
	 */
	private static int[] newArray(){
		int[] temp = new int[5];
		
		for (int i = 0; i < 5; i++){
			temp[i] = randomInt();
		}
		
		return temp;
	}
	
	/*
	 * getUniqueArray returns an integer array that is not already in the arraylist
	 */
	private static int[] getUniqueArray(){
		int[] temp = new int[5];
		
		temp = newArray();
		
		while (hasArray(temp)){
			
			temp = newArray();
		}
		
		return temp;
	}
	
	/*
	 * hasArray checks the arraylist to see if it currently has the integer array input parameter
	 * returns false if not
	 */
	private static boolean hasArray(int[] in){
		
		for (int i = 0; i < ar.size(); i++){
			if (compareArrays(in, ar.get(i))){
				return true;
			}
		}
		
		return false;
		
	}
	
	/*
	 * comapreArrays compares the contents of two arrays, if they differ 
	 * by 1 element, then it returns false. If they are the same, returns true.
	 */
	private static boolean compareArrays(int[] in1, int[] in2){
		
		boolean same = true;
		
		//for the entirety of both arrays, mark of they are the same.
		for (int i = 0; i < in1.length; i++){
			if (in1[i] != in2[i]){
				same = false;
			}
		}
		
		return same;
	}
	
	/*
	 * printList prints all of the arraylist arrays
	 */
	private static void printList(){
		
		for (int i = 0; i < ar.size(); i++){
			
			//uncomment the following line to see the index position of each array
			//System.out.print(i + ": ");
			
			for (int x = 0; x < ar.get(i).length; x++){
				System.out.print(ar.get(i)[x] + " ");
			}
			
			System.out.print("\n");
		}
	}
	
	private static void sortList() {
		int temp;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < 5; i++) {
				for (int j = 1; j < ar.size(); j++) {
					if (ar.get(j-1)[i] > ar.get(j)[i]){
	                    temp = ar.get(j - 1)[i];
	                    ar.get(j - 1)[i] = ar.get(j)[i];
	                    ar.get(j)[i] = temp;
	                    swapped = true;  
	                }
				}
			}
		}
	}
	
}
