import java.util.ArrayList;
public class ArrayList_Alterra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		
		System.out.println(nums);
		
		nums.add(6);
		System.out.println(nums);
		
		for (int i = 0; i < nums.size(); i++){
			if (nums.get(i) > 5) {
				nums.remove(i);
	            i--;
	        }
		}
		System.out.println(nums);
	}
}