package pro.buildmysoftware.efficientjava.newio.server;

import java.io.IOException;

public class EchoExample {
	public static void main(String[] args) throws IOException,
		InterruptedException {

		new Thread(() -> EchoServer.start()).start();

		EchoClient client = EchoClient.start();
		Thread.sleep(500);

		new Thread(() -> client.sendMessage("hello")).start();
		new Thread(() -> client.sendMessage("hello2")).start();
		new Thread(() -> client.sendMessage("hello3")).start();

		Thread.sleep(200);
		EchoClient.stop();
		EchoServer.stop();
	}
}
