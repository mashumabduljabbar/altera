import java.util.LinkedHashSet;

public class Problem5RemoveDuplicates {
	public static void main(String[] args) {
		int a[] = {2, 3, 3, 3, 6, 9, 9};
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

		for (int i = 0; i < a.length; i++)
			set.add(a[i]);
		System.out.print(set.size());
	}

}