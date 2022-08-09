import java.util.ArrayList;

public class Soal2 {

	public static void main(String[] args) {
		
		int number = 23;
		int[] binary = new int[32];
        int id = 0;
 
        while (number > 0) {
            binary[id++] = number % 2;
            number = number / 2;
        }
        
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = id - 1; i >= 0; i--) {
            output.add(binary[i]);
        }
        
        int fourth = output.get(output.size()-4);
        
        System.out.println(fourth);

	}

}
