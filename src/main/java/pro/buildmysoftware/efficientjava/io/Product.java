package pro.buildmysoftware.efficientjava.io;

import lombok.Value;

import java.util.UUID;

@Value
public class Product {

	private String name;
	private UUID id;
}
