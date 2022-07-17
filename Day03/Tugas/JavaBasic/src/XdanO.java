public class XdanO {
	static int hitungJumlahChar(String inputXO, int n, char x)
	{
		int res = 0;
		char name[]=inputXO.toCharArray();
		for (int i=0; i<n; i++)
			if (x == name[i])
				res++;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputXO = "xoxoxo";
		int n = inputXO.length();
		char x = 'x';
		char o = 'o';
		int jumlahX = hitungJumlahChar(inputXO, n, x);
		int jumlahO = hitungJumlahChar(inputXO, n, o);
		if(jumlahX==jumlahO) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

}
