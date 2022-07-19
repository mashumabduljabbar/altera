import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Problem3PairwithTargetSum {
	private static int[] targetSum(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				return new int[] { numMap.get(complement), i };
			} else {
				numMap.put(nums[i], i);
			}
		}
		return new int[] {};
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{2,5,9,11};
		int[] indeks = targetSum(nums, 11);
		ArrayList<Integer> hasil = new ArrayList<Integer>();
		hasil.add(indeks[0]);
		hasil.add(indeks[1]);
		System.out.println(hasil);
	}
}