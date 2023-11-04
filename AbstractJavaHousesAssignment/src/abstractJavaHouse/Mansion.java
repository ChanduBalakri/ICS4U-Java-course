/* Date: 21/08/2023
 Dev: Chandresh Balakrishnan
*/

/*
 Pseudo Code
 define numOfWheels
 create calculateValue and doWork methods
 */

package abstractJavaHouse;

public class Mansion extends abstractHouse { // calling main class
	
	int numOfFloors;
	boolean driveway;
	boolean furnished;
	
	@Override
	void calculateValue(boolean driveway, boolean furnished) { // used to determine value of item
		
		value = numOfFloors * 3000;
		if (driveway == true) {
			value = value + 200;
			workRequired = workRequired + 20;
		}
		if (furnished == true) {
			value = value + 500;
			workRequired = workRequired + 100;
		}
	}
	
	boolean doWork() { // used to determine when the job is finished
		workCounter++;
		
		if (workCounter < workRequired){
			//System.out.println("...");
			return false;
		}
		else {
			System.out.println("Done workin' on my Mansion!");
			return true;
		}
		
	}
	
	Mansion(int floors, boolean driveway, boolean furnished){ // default constructor to call certain methods and define values
		 
		numOfFloors = floors;
		workCounter = 0;
		workRequired = 50;
		calculateValue(driveway, furnished);

	}
}
