import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem4ArrayUnique {
	public static void main(final String[] args) {
		final ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		final ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 16));
		final HashSet<Integer> set1 = new HashSet<>(list1);
		final HashSet<Integer> set2 = new HashSet<>(list2);

		set1.retainAll(set2);
		list1.removeAll(set1);
		list2.removeAll(set2);
		list1.addAll(list2);

		System.out.println(new HashSet<>(list1));
	}
}