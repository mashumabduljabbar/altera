package Materi2;

import java.util.Scanner;
public class Problem1PrimakeX {
	public static void main(String[] args) 
	{
		int n;
		int arr[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
		Scanner s = new Scanner(System.in);
		System.out.print("Input: ");
		n = s.nextInt();
		System.out.print("Output: "+arr[n-1]);
	}
}