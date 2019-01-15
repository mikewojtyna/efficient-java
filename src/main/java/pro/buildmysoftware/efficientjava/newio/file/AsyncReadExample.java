package pro.buildmysoftware.efficientjava.newio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncReadExample {
	public static void main(String[] args) throws IOException,
		ExecutionException, InterruptedException {
		ByteBuffer buffer = ByteBuffer.allocate(48);

		try (AsynchronousFileChannel fileChannel =
			     AsynchronousFileChannel
			.open(Paths.get("files", "input.txt"))) {

			System.out.println("Executing async read");
			Future<Integer> futureHoldingNumberOfReadBytes =
				fileChannel
				.read(buffer, 0);
			// do something else
			System.out.println("Now i'm doing something else");
			// ready to get the future
			System.out.println("Getting number of read bytes");
			Integer bytesRead = futureHoldingNumberOfReadBytes
				.get();
			System.out.printf("Bytes read: %d\n", bytesRead);
			System.out.println("Buffer contains:");
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char) buffer.get());
			}
		}
	}
}
