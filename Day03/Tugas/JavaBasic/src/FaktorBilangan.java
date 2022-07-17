public class FaktorBilangan {
	public static void main(String[] args) {
		int angka = 20;
		for(int i = 1; i <= angka; i++)
		{
			if(angka % i == 0)
				System.out.println(i); 
		}
	}
}