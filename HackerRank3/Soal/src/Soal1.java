import java.util.*;

public class Soal1 {
    public static void main(String[] args)
    {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.print(input);
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i=input.size()-1; i>=0; i--) {
        	output.add(input.get(i));
        }

    	System.out.println(output);
    }
}