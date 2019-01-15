package pro.buildmysoftware.efficientjava.newio.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncWriteExample {
	public static void main(String[] args) throws IOException,
		ExecutionException, InterruptedException {
		ByteBuffer buffer = ByteBuffer.allocate(48);
		buffer.put("hello".getBytes(Charset.forName("UTF-8")));
		buffer.flip();

		try (AsynchronousFileChannel fileChannel =
			     AsynchronousFileChannel
			.open(Paths
				.get("files", "output.txt"),
				StandardOpenOption.WRITE,
				StandardOpenOption.CREATE)) {

			while (buffer.hasRemaining()) {

				System.out.println("Executing async write");
				Future<Integer> futureHoldingNumberOfWrittenBytes = fileChannel
					.write(buffer, 0);
				// do something else
				System.out
					.println("Now i'm doing something " +
						"else");
				// ready to get the future
				System.out
					.println("Getting number of written " + "bytes");
				Integer writtenBytes =
					futureHoldingNumberOfWrittenBytes
					.get();
				System.out
					.printf("Bytes written: %d\n",
						writtenBytes);
			}
		}
	}
}
