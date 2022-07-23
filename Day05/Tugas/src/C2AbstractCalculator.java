import java.util.Scanner;

abstract class Base
{
	abstract int add(int a, int b);
	abstract int sub(int a, int b);
	abstract int multiply(int a, int b);
	abstract int divide(int a, int b);
	int pilihan()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("++++++++++++++++ CALCULATOR ++++++++++++++++\r\n"
				+ "1: Open Calculator\r\n"
				+ "99: Exit\r\n"
				+ "Masukkan pilihan anda:");
		int num = scan.nextInt();
		return num;
	} 

	int value1()
	{
		Scanner scan1 = new Scanner(System.in);
		System.out.print("++++++++++++++++ CALCULATOR ++++++++++++++++\r\n"
				+ "Masukkan Value 1 : ");
		int val1 = scan1.nextInt();
		return val1;
	} 

	int value2()
	{
		Scanner scan2 = new Scanner(System.in);
		System.out.print("Masukkan Value 2 : ");
		int val2 = scan2.nextInt();
		return val2;
	} 

	int operator()
	{
		Scanner scan3 = new Scanner(System.in);
		System.out.print("++++++++++++++++ CALCULATOR ++++++++++++++++\r\n"
				+ "Please Enter Calculation Operator\r\n"
				+ "1. Add Value\r\n"
				+ "2. Sub Value\r\n"
				+ "3. Multiply Value\r\n"
				+ "4. Divide Value\r\n"
				+ "++++++++++++++++ CALCULATOR ++++++++++++++++\r\n"
				+ "Pilihan Anda : ");
		int op = scan3.nextInt();
		return op;
	}
}

class Calc extends Base
{
	int add(int a, int b)
	{
		return a+b;
	}

	int sub(int a, int b)
	{
		return a-b;
	}

	int multiply(int a, int b)
	{
		return a*b;
	}

	int divide(int a, int b)
	{
		return a/b;
	}
}

class C2AbstractCalculator
{
	public static void main(String...s)
	{
		Base b1=new Calc();
		switch(b1.pilihan()){  
		case 1: 
			int pil1 = b1.value1();
			int pil2 = b1.value2();
			int pil3 = b1.operator();
			switch(pil3){  
			case 1:
				System.out.println("Hasil : "+b1.add(pil1, pil2));		
				break;
			case 2:
				System.out.println("Hasil : "+b1.sub(pil1, pil2));		
				break;
			case 3:
				System.out.println("Hasil : "+b1.multiply(pil1, pil2));		
				break;
			case 4:
				System.out.println("Hasil : "+b1.divide(pil1, pil2));		
				break;
			}
			break; 
		case 99: 
			break;   
		}  
	}
}