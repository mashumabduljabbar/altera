class Vehicle {
	String name;
	String with_engine;
	int wheel_count;
	
	public void name() {
		System.out.println("Hi I'm Parent of All Vehicles, My Name is Gerobak, My Engine is 'no engine'");
	}
}

class Bikes extends Vehicle {
	public void display() {
		System.out.println("Hi I'm Bike , My Name is "+name+", My Engine Status is '"+with_engine+"', I have "+wheel_count+" Wheel(s)");
	}
}

class Cars extends Vehicle {
	String engine_type;
	public void display() {
		System.out.println("Hi I'm Car , My Name is "+ name +", My Engine Status is '"+ with_engine +"', I have "+wheel_count+", My Engine Type = "+engine_type);
	}
}

class Buses extends Vehicle {
	String private_bus;
	public void display() {
		System.out.println("Hi I'm Bus ["+private_bus+"] , My Name is "+ name +", My Engine Status is '"+ with_engine +"', I have "+wheel_count+" Wheel(s)");
	}
}

class C3InheritPolymVehicles {
	public static void main(String[] args) {
		Bikes bike = new Bikes();
		bike.name();
		System.out.println();
		
		bike.name = "Pedal Bikes";
		bike.with_engine = "no engine";
		bike.wheel_count = 2;
		bike.display();
		bike.name = "Motor Bikes";
		bike.with_engine = "with engine";
		bike.wheel_count = 2;
		bike.display();
		System.out.println();
		
		Cars car = new Cars();
		car.name = "Sport Cars";
		car.with_engine = "with engine";
		car.wheel_count = 4;
		car.engine_type = "V8";
		car.display();
		car.name = "Pickup Cars";
		car.with_engine = "with engine";
		car.wheel_count = 4;
		car.engine_type = "Solar";
		car.display();
		System.out.println();
		
		Buses bus = new Buses();
		bus.private_bus = "Public Bus";
		bus.name = "Trans Jakarta";
		bus.with_engine = "with engine";
		bus.wheel_count = 4;
		bus.display();
		bus.private_bus = "Private engine";
		bus.name = "School Bus";
		bus.with_engine = "with engine";
		bus.wheel_count = 4;
		bus.display();
	}
}