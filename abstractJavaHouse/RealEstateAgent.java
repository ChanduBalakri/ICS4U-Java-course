/* Date: 21/08/2023
 Dev: Chandresh Balakrishnan
*/

/*
 Pseudo Code
 get values from abstractHouse class
 generate number of jobs
 using random numbers with Math.random generate how many rooms/floors
 calculate the money via the Trailer/Mansion classes
 print out the final message alerting the user of how much money they made from all of the sales 
 */

package abstractJavaHouse;

import java.util.LinkedList;
import java.util.Queue;

public class RealEstateAgent {

	
	Queue<abstractHouse> workQueue;	
	double wallet;					
	int jobCounter;					

	RealEstateAgent(){
		
		workQueue = new LinkedList<abstractHouse>();	
		wallet = 0;										
		jobCounter = 0;									
		
	}
	

	String summarizeWork(){
		
		return "I completed " + jobCounter + " jobs and earned " + wallet + " dollars!";
		
	}
	

	boolean randomBool(){
		
		switch((int)(Math.random() * 100) % 2){
		
			case 0:	return false;
			default:return true;
			
		}
		
	}
	

	boolean advertiseProperty(){
		
		if (workQueue.size() < 3 && (int)Math.floor((Math.random() * 100) % 7) == 0){
		
			return true;
		
		}
		return false;
	}

	void newJob(){

		int tempVal = (int) ((Math.random() * 5) % 2) ;
		int tempWheels;
		int tempRooms;
		int tempFloors;
		
		switch(tempVal){
			
			//new Trailer
			case 0:	tempWheels = (int)(Math.floor((Math.random() * 5)) + 1);
				tempRooms = (int)(Math.floor((Math.random() * 10) % 3) + 1);
				workQueue.add(new Trailer(tempWheels, tempRooms));
				jobCounter++;
				System.out.println("\nGot a new Job selling a " + tempWheels + " wheeled, " + tempRooms + " room Trailer!");
				break;
			
			//new Mansion
			case 1: tempFloors = (int)(Math.floor((Math.random() * 100) % 20) + 1);
				workQueue.add(new Mansion(tempFloors, randomBool(), randomBool()));
				jobCounter++;
				System.out.println("\nGot a new Job selling a " + tempFloors + " floored Mansion!");
				break;
				
			default:System.out.println("Error in switch statement");
		
		}
		
	}
	

	boolean workLeft(){
		
		return !workQueue.isEmpty();
		
	}
	

	void doJob(){
		if (workQueue.peek().doWork()){
			
			wallet += workQueue.peek().value;
			workQueue.remove();
		}
		
	}
	
	
	
	public static void main(String args[]){
		
		RealEstateAgent myRealEstateAgent = new RealEstateAgent();
		
		myRealEstateAgent.newJob();	
		
		while (myRealEstateAgent.workLeft()){
			
			myRealEstateAgent.doJob();
			
			if (myRealEstateAgent.advertiseProperty()){
				
				myRealEstateAgent.newJob();	
			}
			
		}
		
		System.out.println(myRealEstateAgent.summarizeWork());
		
		
	}
	
	
}
