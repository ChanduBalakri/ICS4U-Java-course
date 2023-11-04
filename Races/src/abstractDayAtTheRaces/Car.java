/*
 * Car is an implementation of abstractAuto used in Race.java
 * the default constructor initializes the variables declared in 
 * abstractAuto, the second constructor takes the car's acceleration as input
 * 
 * Car overrides the abstract methods accelerate and getType quite simply:
 * accelerate increases the car's speed by 80% of the acceleration, getType
 *  returns "Car"
 Author: Mike King, 2013
 */

package abstractDayAtTheRaces;

public class Car extends abstractAuto {

	public Car() {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = 100;
		acceleration = 10;
		position = 0;
		raceProgress = 0;
	}
	
	public Car(float accelerationIn) {
		numberOfWheels = 4;
		speed = 0;
		maxSpeed = 100;
		acceleration = accelerationIn;
		position = 0;
		raceProgress = 0;
	}

	@Override
	void accelerate() {
		speed += acceleration * 0.80;
	}

	@Override
	String getType() {
		return "Car ";
		
	}

}
