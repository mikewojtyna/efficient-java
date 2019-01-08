package pro.buildmysoftware.efficientjava.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	@DisplayName("show array lists usage")
	@Test
	void test() throws Exception {
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
