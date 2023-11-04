package abstractDayAtTheRaces;

/* Psuedo Code
define Unicycles characteristics
define acceleration
choose acceleration metric multiplier 
return String value
*/

public class Unicycle extends abstractAuto{

	public Unicycle() {
		numberOfWheels = 1;
		speed = 0;
		maxSpeed = 40;
		acceleration = 4;
		position = 0;
		raceProgress = 0;
	}
	
	public Unicycle(float accelerationIn) {
		numberOfWheels = 1;
		speed = 0;
		maxSpeed = 40;
		acceleration = accelerationIn;
		position = 0;
		raceProgress = 0;
	}


	@Override
	void accelerate() {
		speed += acceleration * 0.40;
		
	}

	@Override
	String getType() {
		return "Unicycle ";
	}

}