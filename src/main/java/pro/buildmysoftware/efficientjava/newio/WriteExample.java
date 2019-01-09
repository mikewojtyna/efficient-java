package pro.buildmysoftware.efficientjava.newio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteExample {
	public static void main(String[] args) throws IOException {
		try (FileChannel channel = FileChannel.open(Paths
			.get("files", "output.txt"), StandardOpenOption.WRITE,
			StandardOpenOption.CREATE)) {

			ByteBuffer buffer = ByteBuffer.allocate(48);
			buffer.put("hello".getBytes());
			buffer.flip();

			while (buffer.hasRemaining()) {
				channel.write(buffer);
			}
		}
	}
}
