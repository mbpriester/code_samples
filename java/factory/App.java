package factory;

public class App {
	public static void main(String[] args){
		VehicleFactory factory = new VehicleFactory();
		
		System.out.println(factory.getVehicle(VehicleType.CAR).startEngine());
		
	}
}
