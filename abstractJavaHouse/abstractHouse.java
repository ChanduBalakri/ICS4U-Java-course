package abstractJavaHouse;

public abstract class abstractHouse {
	
	int numOfRooms;
	double value;
	int workRequired;
	int workCounter;
	
	abstract void calculateValue(boolean x, boolean y);
	
	boolean doWork() {
		
		
		return false;
	}

}
