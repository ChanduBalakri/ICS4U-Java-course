/*
 * abstractAuto is an abstract class to be used in ICS4U
 * 
 * The variables define some key aspects of an auto such as:
 * the number of wheels, the current speed, the maximum speed,
 * the rate of acceleration, the race position, and the progress in a race
 * 
 * The methods are getSpeed which returns the current speed,
 * drive which moves the auto along the course and decelerates due to friction,
 * boolean finishedRace when the auto's race progress exceeds the race length
 * 
 * And abstract methods: accelerate and getType,
 * accelerate increases the current speed of the auto,
 * getType returns the type of the auto as a String- useful for output.
 * 
 Author: Mike King, 2013
 */
package abstractDayAtTheRaces;

public abstract class abstractAuto {

		int numberOfWheels;	//number of wheels the auto has
		float speed;			//the  speed of the auto
		float maxSpeed;		//the max speed of the auto
		float acceleration;	//the acceleration of the auto
		int position;		//the position of the auto
		float raceProgress = 0;	//the autos current progress in the race
		float raceLength = 1000;	//the length of the race
		
		//return the speed of the auto
		float getSpeed(){
			
			return speed;
		}
		
		//increase raceProgress by speed
		void drive(){
			
			raceProgress += speed;
			speed = numberOfWheels;
		}
		
		//return the final position of the auto
		int getPosition(){
			return position;
		}
		
		//return if the auto has finished the race or not
		boolean finishedRace(){
			
			if (raceProgress < raceLength){
				return false;
			}
			else {
				return true;
			}
			
		}
		
		//abstract methods to implement
		abstract void accelerate();
		
		abstract String getType();


}
