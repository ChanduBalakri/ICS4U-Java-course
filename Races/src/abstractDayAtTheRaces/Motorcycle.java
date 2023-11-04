package abstractDayAtTheRaces;

/* Psuedo Code
define Motorcycles characteristics
define acceleration
choose acceleration metric multiplier 
return String value
*/

public class Motorcycle extends abstractAuto{

	public Motorcycle() {
		numberOfWheels = 2;
		speed = 0;
		maxSpeed = 150;
		acceleration = 20;
		position = 0;
		raceProgress = 0;
	}

	public Motorcycle(float accelerationIn) {
		numberOfWheels = 2;
		speed = 0;
		maxSpeed = 150;
		acceleration = accelerationIn;
		position = 0;
		raceProgress = 0;
	}

	
	@Override
	void accelerate() {
		speed += acceleration * 0.90;
		
	}

	@Override
	String getType() {
		return "Motorcycle ";
	}

}