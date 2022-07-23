package Materi1;
public class Problem1BilanganPrima {

	public static void main(String[] args) {
		System.out.println(primeNumber(1000000007));
		System.out.println(primeNumber(13));
		System.out.println(primeNumber(17));
		System.out.println(primeNumber(20));
		System.out.println(primeNumber(35));
	}

	static boolean primeNumber(Integer number) {
		for (int i = 2; i*i <= number; i++) {
	        if (number % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
}