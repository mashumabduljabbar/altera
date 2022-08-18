class Vehicle{
	private String brand;
	private String name;
	
	public Vehicle(String brand, String name) {
		this.brand = brand;
		this.name = name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getName() {
		return this.name;
	}
}

public class Showroom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = new Vehicle(null, null);
		vehicle.setBrand("Toyota");
		vehicle.setName("Innova");
		
		System.out.println("Brand : "+ vehicle.getBrand());
		System.out.println("Name : "+ vehicle.getName());
	}
}
