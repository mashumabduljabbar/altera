class Animal {
	String name;
	String jenismakanan;
	String gigibinatang;
	
	public void name() {
		System.out.println("Hi I'm Parent of All Animal, My Name is Binatang");
	}
}

class Herbivor extends Animal {
	public void display() {
		System.out.println("Hi I'm Herbivor , My Name is "+ name +", My Food is '"+ jenismakanan +"', I have "+gigibinatang);
	}
}

class Carnivor extends Animal {
	public void display() {
		System.out.println("Hi I'm Carnivor , My Name is "+ name +", My Food is '"+ jenismakanan +"', I have "+gigibinatang);
	}
}

class Omnivor extends Animal {
	public void display() {
		System.out.println("Hi I'm Omnivor , My Name is "+ name +", My Food is '"+ jenismakanan +"', I have "+gigibinatang);
	}
}

class C4InheritPolymAnimals {
	public static void main(String[] args) {
		Herbivor herbi = new Herbivor();
		herbi.name();
		System.out.println();
		
		herbi.name = "Kambing";
		herbi.jenismakanan = "tumbuhan";
		herbi.gigibinatang = "tumpul teeth";
		herbi.display();
		
		Carnivor carniv = new Carnivor();
		carniv.name = "Singa";
		carniv.jenismakanan = "daging";
		carniv.gigibinatang = "tajam teeth";
		carniv.display();
		
		System.out.println();
		
		Omnivor omniv = new Omnivor();
		omniv.name = "Ayam";
		omniv.jenismakanan = "semua";
		omniv.gigibinatang = "tumpul teeth";
		omniv.display();
		
	}
}