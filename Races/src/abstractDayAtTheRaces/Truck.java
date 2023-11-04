package abstractDayAtTheRaces;
/*
	Skeleton class for a Truck 
	Author: Mike King, 2013
*/

/* Psuedo Code
 define Trucks characteristics
 define acceleration
 choose acceleration metric multiplier 
 return String value
 */

public class Truck extends abstractAuto{

	public Truck() {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = 70;
		acceleration = 7;
		position = 0;
		raceProgress = 0;
	}
	
	public Truck(float accelerationIn) {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = 70;
		acceleration = accelerationIn;
		position = 0;
		raceProgress = 0;
	}

	@Override
	void accelerate() {
		speed += acceleration * 0.60;
		
	}

	@Override
	String getType() {
		return "Truck ";
	}

}
