package builder;

public class Vehicle {
	private double price;
	private String type;
	private String make;
	private int horsePower;
	private String model;
	private String color;
	private int doors;
	
	public Vehicle(Builder builder){
		this.horsePower = builder.horsePower;
		this.color = builder.color;
		this.doors = builder.doors;
		this.make = builder.make;
		this.price = builder.price;
		this.model = builder.model;
		this.type = builder.type;
	}
	
	@Override
	public String toString(){
		return "This vehicle is a "+type+" of make: "+make+" and model: "+model+". It has "+doors+" doors and has "+horsePower+
				" horsepower. It is " +color+" and costs $"+price+".";
	}
	
	public static class Builder{
		private double price;
		private String type;
		private String make;
		private int horsePower;
		private String model;
		private String color;
		private int doors;
		
		public Builder(String make, String model){
			this.make = make;
			this.model = model;
		}	
		
		public Builder price(double price){
			this.price = price;
			return this;
		}
		
		public Builder type(String type){
			this.type = type;
			return this;
		}
		
		public Builder horsePower(int value){
			this.horsePower = value;
			return this;
		}
		
		public Builder color(String value){
			this.color = value;
			return this;
		}
		
		public Builder doors(int doors){
			this.doors = doors;
			return this;
		}
		
		public Vehicle build(){
			return new Vehicle(this);
		}
	}
}
