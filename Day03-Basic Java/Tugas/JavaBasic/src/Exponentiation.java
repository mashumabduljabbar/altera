class Exponentiation {
	public static void main(String[] args) {
		int x = 2, n = 3;
		long result = 1;
		while (n != 0) {
			result *= x;
			--n;
		}
		System.out.println(result);
	}
}