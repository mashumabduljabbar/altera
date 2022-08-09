// Java program for the above approach

import java.util.*;
import java.lang.Math;
public class Soal3
{
	public static void main(String args[])
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(6);
		arr.add(3);
		arr.add(1);
		arr.add(0);
		
		ArrayList<Integer> rearrange_arr = new ArrayList<Integer>();
		for(int i = 0; i<arr.size(); i++) {
	         if(arr.get(i) >= 1 && arr.get(i) <= Math.pow(10, 5)) {
	        	 rearrange_arr.add(arr.get(i));
	         }
	    }
		
		int min = Collections.min(rearrange_arr);
		int minCount = Collections.frequency(arr, min);
		int total = arr.size()-minCount;
		System.out.println(total);
	}
}
