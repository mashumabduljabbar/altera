public class BilanganPrima {
	public static void main(String[] args) {
		int inputNumber = 10;
		boolean label = false;
		for (int i = 2; i <= inputNumber / 2; ++i) {
			// Kondisi untuk bukan Bilangan Prima
			if (inputNumber % i == 0) {
				label = true;
				break;
			}
		}

		if (!label) {
			System.out.println("Bilangan Prima");
		}else{
			System.out.println("Bukan Bilangan Prima");
		}
	}
}