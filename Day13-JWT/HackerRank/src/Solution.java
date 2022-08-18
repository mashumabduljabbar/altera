import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args)  {
    	findLongestSubsequence();
    }

	private static void findLongestSubsequence() {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<>() ;
    	arr.add(7);
    	arr.add(5);
    	arr.add(6);
    	arr.add(2);
    	arr.add(3);
    	arr.add(2);
    	arr.add(4);
    	
    	int n = arr.size();
    	
    	Collections.sort(arr);
       // Selisih
       int selisih = 0;
       for(int x = 0; x < arr.size(); x++){
           if(x != arr.size()-1){
            selisih += (arr.get(x+1) - arr.get(x));
           }
           System.out.println(arr.get(x));
       }
       
       System.out.println("Total : "+selisih);
	}
}
