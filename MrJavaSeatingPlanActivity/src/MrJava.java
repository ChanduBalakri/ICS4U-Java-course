import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
	Skeleton code for Mr.Java's program
	The task is to sort the 2D array
	
	Author: Mike King, 2013
*/

/* Finished Code
 Chandresh Balakrishnan 
 22/08/2023
 */

/*Psuedo Code
  
 
 */

public class MrJava {

	public static void main(String[] args) throws IOException {

		//declare the 2D String array
		String[][] seats = new String[10][10];
		
		//populate the 2D array from the file myNames.txt
		populateArray(seats);
		
		//print the unsorted contents of the 2D array
		printArray(seats);
		
		//TO DO: Implement a sorting algorithm here
		sortArray(seats);
		
		//print the sorted array
		
		System.out.println("------------------------------------------------------------------------------------------------------------");
		printArray(seats);
	
	}
	
	/*
	 * populateArray reads the list of names from the file myNames.txt
	 */
	static void populateArray(String[][] array){
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader("myNames.txt"));	
		
			for (int i = 0; i < 10; i++){
				for (int y = 0; y < 10; y++){
					array[i][y] = reader.readLine();
				}
			}
			
			//close the reader
			reader.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
	
	/*
	 * sortArray sorts the list of names per user request	
	*/
 
	static void sortArray(String [][] seats) {
		int counter = 10;
		boolean swapped = true;
		String temp;	
		while (swapped) {
			swapped = false;
			for (int i = 0; i < counter-1; i++){
			    for (int j=0; j < counter - 1; j++){
			        if (seats[j][i].compareTo(seats[j + 1][i]) > 0 && seats[j][i].compareTo(seats[i][j+1]) > 0){
			            if (seats[j+1][i].compareTo(seats[i][j+1]) > 0) {
			            	temp = seats[j][i];
				            seats[j][i] = seats[i][j+1];
				            seats[i][j+1] = temp;
				            swapped = true;
			            }
				        else {
				        	temp = seats[j][i];
				            seats[j][i] = seats[j + 1][i];
				            seats[j + 1][i] = temp;
				            swapped = true;
				        }
			        }
			        else if (seats[j][i].compareTo(seats[j][i+1]) > 0){
			            temp = seats[j][i];
			            seats[j][i] = seats[j][i+1];
			            seats[j][i+1] = temp;
			            swapped = true;
			        }
			        
			        else if (seats[j][i].compareTo(seats[j + 1][i]) > 0){
			            temp = seats[j][i];
			            seats[j][i] = seats[j+1][i];
			            seats[j+1][i] = temp;
			            swapped = true;
			        }
			    }
			}
		}
	}
	
	 /*
	 * printArray prints the contents of the 2D array input
	 */
	static void printArray(String[][] in){
		
		for (int i = 0; i < 10; i++){
			for (int y = 0; y < 10; y++){
				if (in[i][y] == null){
					
					if (y == 9){
						System.out.println(in[i][y] + "\n");
					}
					else {
						System.out.println("_\t");
					}
					
				}
				if (y == 9){
					System.out.print(in[i][y] + "\n");
				}
				else {
					System.out.print(in[i][y] + "\t");
				}
			}
		}
	}
}
