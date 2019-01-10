package pro.buildmysoftware.efficientjava.newio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedFileReadExample {
	public static void main(String[] args) throws IOException {
		try (FileChannel channel = FileChannel.open(Paths
			.get("files", "input.txt"), StandardOpenOption.READ)) {
			MappedByteBuffer mappedByteBuffer = channel
				.map(FileChannel.MapMode.READ_ONLY, 0, channel
					.size());
			while (mappedByteBuffer.hasRemaining()) {
				System.out.print((char) mappedByteBuffer.get());
			}
		}
	}
}
