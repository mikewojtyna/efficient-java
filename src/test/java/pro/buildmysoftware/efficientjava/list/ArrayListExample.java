package pro.buildmysoftware.efficientjava.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayListExample {

	@DisplayName("show how to use sublist views")
	@Test
	void test0() throws Exception {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		List<Integer> subList = numbers.subList(1, 3);
		assertThat(subList).containsExactly(2, 3);

		subList.remove(0);
		assertThat(numbers).containsExactly(1, 3);
	}

	@DisplayName("show array lists usage")
	@Test
	void test1() throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
		}
	}
}
