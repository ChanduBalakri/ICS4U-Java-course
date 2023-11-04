/*
 * Race uses the implementations of the abstractAuto class to perform a race with various 
 * automobile types.
 Author: Mike King, 2013
 */
package abstractDayAtTheRaces;

public class Race {

	//hardcoded number of vehicles in the race. Edit this number to match the number of vehicles racing.
	static int numCars = 5;
	
	//method to display the race results
	static void displayResults(abstractAuto[] autos){
		for (int i = 0; i < numCars; i++){
			System.out.println(autos[i].getType() + i + " finished in position: " + autos[i].getPosition());
		}
	}
	
	//method to run the race, takes the array of vehicles as an input parameters
	static void runRace(abstractAuto[] autos){
		int finish = 1;
		int i = 0;
		boolean finished = false;
		
		while (!finished){

			if (!autos[i].finishedRace()){
				
				//if the auto has not yet reached maxSpeed, accelerate!
				if (autos[i].speed < autos[i].maxSpeed){
					autos[i].accelerate();
				}
				
				//drive ahead
				autos[i].drive();
				
				//if the car has finished the race then mark the position and increment the finish number
				if (autos[i].finishedRace()){

					autos[i].position = finish;
					finish++;
				}
			}
			
			//if all autos have finished
			if (finish == numCars + 1){
				
				finished = true;
			}
			
			i++;
			
			if (i == numCars){
				i = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		
		
		abstractAuto[] raceCars = new abstractAuto[10];
		
		raceCars[0] = new Car();
		raceCars[1] = new Car(15);
		
		//Fill in the following with your own implementations of the abstractAuto class
		raceCars[2] = new Truck();
		raceCars[3] = new Motorcycle();
		raceCars[4] = new Unicycle();
		//raceCars[5] = 
		//raceCars[6] = 
		//raceCars[7] = 
		//raceCars[8] = 
		//raceCars[9] = 
		
		//the race loop, continues until a auto finishes the race
		runRace(raceCars);
		
		//display the race results
		displayResults(raceCars);
		
	}

}
