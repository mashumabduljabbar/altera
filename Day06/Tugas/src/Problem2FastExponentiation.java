public class Problem2FastExponentiation {
	public static void main(String[] args) {
		System.out.println(pow(2, 3));
		System.out.println(pow(5, 3));
		System.out.println(pow(10, 2));
		System.out.println(pow(2, 5));
		System.out.println(pow(7, 3));
	}

	static Integer pow(Integer x, Integer n) {
		return (int) Math.pow(x,n);
	}
}
