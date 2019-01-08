package pro.buildmysoftware.efficientjava.newio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadExample {
	public static void main(String[] args) throws IOException {
		try (FileChannel channel = FileChannel.open(Paths
			.get("files", "input.txt"), StandardOpenOption.READ)) {
			ByteBuffer buffer = ByteBuffer.allocate(48);
			int bytesRead = channel.read(buffer);

			while (bytesRead != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}
				buffer.clear();
				bytesRead = channel.read(buffer);
			}
		}
	}
}
