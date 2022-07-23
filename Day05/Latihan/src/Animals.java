class Animals{  
	void eat(){
		System.out.println("eating...");
	}  
}  

class Dog extends Animals{  
	void bark(){
		System.out.println("barking...");
	}  
}  

class TestInheritance{  
	public static void main(String args[]){  
		Dog d=new Dog();  
		d.bark();  
		d.eat();  
	}
}  