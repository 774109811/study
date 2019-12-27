package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestListNum {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(5);
		list2.add(2);
		list1.removeAll(list2);
		System.out.println(list1);
		System.out.println(list1.size());

	}
}
