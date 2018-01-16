package factory;

public enum VehicleType {
	CAR,
	TRUCK;
	
	
	public Vehicle getVehicle(){
		switch(this){
		case CAR:
			return new Car();
		case TRUCK:
			return new Truck();
		default: 
			return null;
		}
	}
	
}
