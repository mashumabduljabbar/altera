public class Asterisk
{
	public static void main(String args[])
	{
		int inputNumber = 5;
		// outer loop untuk jumlah baris
		for (int i=0; i<inputNumber; i++)
		{
			// inner loop untuk jarak
			for (int j=inputNumber-i; j>1; j--)
			{
				System.out.print(" ");
			}

			//  inner loop untuk jumlah kolom
			for (int j=0; j<=i; j++ )
			{
				System.out.print("* ");
			}

			System.out.println();
		}
	}
}