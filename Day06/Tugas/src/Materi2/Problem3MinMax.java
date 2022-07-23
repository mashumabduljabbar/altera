package Materi2;

import java.util.ArrayList;

public class Problem3MinMax {

	public static void main(String[] args) {
		int[] arr = {5, 7, 4, -2, -1, 8};

		int min = getMin(arr);
		int indeksMin = getIndeks(arr, min);
		System.out.print("min: "+min+
				" index: "+indeksMin);
		
		int maks = getMaks(arr);
		int indeksMax = getIndeks(arr, maks);
		System.out.print(" max: "+maks+
				" index: "+indeksMax);
	}

	public static int getMaks(int[] num){
		int maksValue = num[0];
		for(int i=1;i < num.length;i++){
			if(num[i] > maksValue){
				maksValue = num[i];
			}
		}
		return maksValue;
	}
	public static int getMin(int[] num){
		int minValue = num[0];
		for(int i=1;i<num.length;i++){
			if(num[i] < minValue){
				minValue = num[i];
			}
		}
		return minValue;

	}
	public static int getIndeks(int arr[], int t)
	{
		ArrayList<Integer> clist = new ArrayList<>();
		for (int i : arr)
			clist.add(i);
		return clist.indexOf(t);
	}
}