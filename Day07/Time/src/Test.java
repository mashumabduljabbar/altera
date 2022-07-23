
public class Test {


	private static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	static void numberofHalves(int n) {
		setCount(0);
		while(n > 1) {
			n/=2;
		}
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Test.count = count;
	}

}
