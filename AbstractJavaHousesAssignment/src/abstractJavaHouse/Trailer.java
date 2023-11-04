/* Date: 21/08/2023
 Dev: Chandresh Balakrishnan
*/

/*
 Pseudo Code
 define numOfWheels
 create calculateValue and doWork methods
 */


package abstractJavaHouse;

public class Trailer extends abstractHouse{

	int numOfWheels;
	
	/*
	 * calculateValue calculates the value of the trailer based on the number of rooms.
	 */
	@Override
	void calculateValue(boolean x, boolean y) { // used to determine value of item

		value = numOfWheels * numOfRooms * 2000;
		
	}

	/*
	 * doWork performs work on the Trailer and returns a boolean value if the work is finished
	 */
	@Override
	boolean doWork() { // used to determine when the job is finished
		workCounter++;
		
		if (workCounter < workRequired){
			//System.out.println("...");
			return false;
		}
		else {
			System.out.println("Done workin' on my Trailer!");
			return true;
		}
		
	}
	
	/*
	 * Default constructor, a trailer is pretty consistent work hence always a workRequired value of 10
	 */
	Trailer(int wheels, int rooms){ // default constructor to call certain methods and define values
		
		numOfRooms = rooms;
		numOfWheels = wheels;
		workCounter = 0;
		workRequired = 10;
		calculateValue(true, true);

	}

}
