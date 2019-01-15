package pro.buildmysoftware.efficientjava.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;

public class JsonSerializeExample {
	public static void main(String[] args) throws JsonProcessingException {
		Order order = new Order(Arrays
			.asList(new Product("product0", 10.00), new Product(
				"product1", 5.00), new Product("product2",
				20.00)));

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);


		String json = mapper.writeValueAsString(order);
		System.out.println(json);
	}
}
