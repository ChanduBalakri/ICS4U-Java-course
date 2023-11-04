import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Random;

/*
 Chandresh Balakrishnan
 02/09/2023
 */

/* 1st Answer
 The bubble sort method is more efficient. This is found out by looking at the time taken of the two methods
 Although we have learned that this time can vary, throughout multiple tests it seems that the bubble sort is 5 milliseconds faster on average
 Moreover, we can also view the Big O notation of the two, the worst case of the bubble sort is O(n^2) while the worst case of the selection sort is O(n^3) because of all the nested loops. 
 Also, with the nearly sorted List, the bubble sort is faster while the selection sort stays the same. This is because the bubble sort uses swapped a 
 way to stop the sorting, therefore not having to unecessarily iterate.
 */

/* 2nd Answer
 The sequential sort has nested for loops causing a O(n^2) notation. Therefore, compared to the binary search of a O(3) notation, it is less efficient.
 Therefore the worst case of sequential sort takes longer. However, when using the sorted array, the binary is even faster taking less milliseconds to compute
*/

/*
 Pseudo Code
 start
 Populate two arrays, nearly sorted and unsorted
 Create two methods for both sort types
 Sort each array unsorted and nearly sorted and see how that effects each sorting method
 Then create two methods for searching and iterating through the arrays
 Search through an unsorted array and a sorted array to see how that affects the run times
 Run multiple tests to get an average of results
 Make sure to use recursive aspects in binary sort
 end
 */


//Lets test how fast your computer can process your code!
public class speedTest
{
	static ArrayList<int[]> unsortedAr = new ArrayList<int[]>();
	static ArrayList<int[]> sortedAr = new ArrayList<int[]>();
	static int changeup = 0;
	static Random rand;
	static boolean found = false;
	
	static boolean swapped = true;
  //main method
  public static void main(String[] args) throws IOException
  {
	//Some variables to help us out!
	long time, time2, finalTime;
	int i;

	//Get the current time in milliseconds
	time = System.currentTimeMillis();

	//Output time to the screen
	System.out.println("The Current Time is: " + time);

	//Here is some code for the computer to run.
	//You may have to change 500 to a higher number
	//if your computer is really really fast
	for(i = 0; i < 500; i++)
	{
      System.out.print(".");
	}

	//Get the time at the end of the program
	


	//count variable used as a limit for the number of randomly generated int arrays
	int count = 100;
	
	//declare and intialize the arraylist and the random
	unsortedAr = new ArrayList<int[]>();
	sortedAr = new ArrayList<int[]>();
	rand = new Random();
	
	//add count variable unique int arrays to the arraylist
	/*changeup = 10;
	for (int i11 = 0; i11 < count; i11++){
		unsortedAr.add(getUniqueArray(changeup, unsortedAr));
	}*/
	changeup = 2;
	for (int i11 = 0; i11 < count; i11++){
		sortedAr.add(getUniqueArray(changeup, sortedAr));
	}
	
	//print the unsorted list
	printList();
	
	//TODO
	//IMPLEMENT THE SORTING METHOD!
	//bubbleSortList(unsortedAr);
	//selectionSortList(unsortedAr);
	//bubbleSortList(sortedAr);
	//selectionSortList(sortedAr);
	//sequentialSearch(unsortedAr);
	//binarySearch(unsortedAr);
	//sequentialSearch(sortedAr);
	binarySearch(sortedAr, 7);
	
	System.out.println("-----------------------------");
	//print the sorted list
	printList();
	
	time2 = System.currentTimeMillis();
	
	System.out.println("-----------------------------");

	//Output the end time and the difference in times!
	System.out.println("");
	System.out.println("The End Time is: "+time2);


	finalTime = time2 - time;
	System.out.println("It took " +finalTime+ " Milliseconds");
	
}

	/*
	 * randomInt returns an random integer between 0-9 (inclusive)
	 */
	private static int randomInt(int changeup){
		return rand.nextInt(changeup);
	}
	
	/*
	 * newArray randomly generates an integer array
	 */
	private static int[] newArray(int changeup){
		int[] temp = new int[5];
		
		for (int i = 0; i < 5; i++){
			temp[i] = randomInt(changeup);
			if (changeup < 10) {
				changeup = changeup + 2;
			}
		}
		
		return temp;
	}
	
	/*
	 * getUniqueArray returns an integer array that is not already in the arraylist
	 */
	private static int[] getUniqueArray(int changeup, ArrayList<int[]> myArray){
		int[] temp = new int[5];
		
		temp = newArray(changeup);
		
		while (hasArray(temp, myArray)){
			
			temp = newArray(changeup);
		}
		
		return temp;
	}
	
	/*
	 * hasArray checks the arraylist to see if it currently has the integer array input parameter
	 * returns false if not
	 */
	private static boolean hasArray(int[] in, ArrayList<int[]> myArray){
		
		for (int i = 0; i < myArray.size(); i++){
			if (compareArrays(in, myArray.get(i))){
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
	
	private static void printList(){
			
			for (int i = 0; i < sortedAr.size(); i++){
				
				//uncomment the following line to see the index position of each array
				//System.out.print(i + ": ");
				
				for (int x = 0; x < sortedAr.get(i).length; x++){
					System.out.print(sortedAr.get(i)[x] + " ");
				}
				
				System.out.print("\n");
			}
		}
	  
	private static void bubbleSortList(ArrayList<int[]> myArray) {
		int temp;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < 5; i++) {
				for (int j = 1; j < myArray.size(); j++) {
					if (myArray.get(j-1)[i] > myArray.get(j)[i]){
	                    temp = myArray.get(j - 1)[i];
	                    myArray.get(j - 1)[i] = myArray.get(j)[i];
	                    myArray.get(j)[i] = temp;
	                    swapped = true;  
	                }
				}
			}
		}
	}
	
	private static void selectionSortList(ArrayList<int[]> myArray) {
		int i, j;
		int small = 0;
		int temp;
		for (int k = 0; k < 5; k++) {
			for (i = 0; i < 100; i++) {
				for (j = 1; j < 100; j++) {
					small = i;
					if (myArray.get(j)[k] < (myArray.get(small)[k])) {
						small = j;	
					}
					temp = myArray.get(j)[k];
					myArray.get(j)[k] = myArray.get(small)[k];
					myArray.get(small)[k] = temp;
					}
				}
			}
		}
	
	private static void sequentialSearch(ArrayList<int[]> myArray) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < myArray.size(); j++) {
				if (myArray.get(j)[i] == 7) {
					found = true;
				}
			}
		}
		if (found == true) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	
	public static int binarySearch(ArrayList<int[]> sortedAr2, int x){
        // calls binarySearch with explicit low and high input parameters
        try {
			return binarySearch2(sortedAr2, x, 0, sortedAr2.size()-1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
    }
    // recursive call, provides extra low and high input parameters
    private static int binarySearch2(ArrayList<int[]> a, int x, int low, int high){
        if (low > high){
            return - 1;
        }
        int mid = (low + high) / 2;
        if (a.get(x)[mid] == x){
            // if mid is the search key
            return mid;
        } else if (a.get(x)[mid] < x){
            // if mid was less than the search key
            return binarySearch2(a, x, mid + 1, high);
        } else {
            // otherwise mid was greater than the search key
            return binarySearch2(a, x, low, mid - 1);
        }
    }

}



