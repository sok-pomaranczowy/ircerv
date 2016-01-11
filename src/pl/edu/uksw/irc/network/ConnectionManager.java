package pl.edu.uksw.irc.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author jaroslaw.waledziak
 *
 *         Class used for Managing Connections from clients creates
 *         ServerSocketChannel and SocketChannels it parses incoming messages
 *         and runs appripriate methods of UserManager
 */
public class ConnectionManager implements Runnable {

	Selector selector;
	SelectionKey key;

	public void execute() {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel
					.open();
			selector = Selector.open();

			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			serverSocketChannel.configureBlocking(false);
			long time = System.currentTimeMillis();

			Thread thread = new Thread(this);
			thread.start();

			while (true) {

				SocketChannel socketChannel = serverSocketChannel.accept();

				// do something with socketChannel...
				if (socketChannel != null) {
					System.out.println("Connection Established!");

					socketChannel.configureBlocking(false);

					SelectionKey key = socketChannel.register(selector,
							SelectionKey.OP_READ);

				} else {
					long time2 = System.currentTimeMillis();
					if (Math.abs(time - time2) > 1000) {
						time = time2;
						System.out.println("...");
					}
				}

			}

			// serverSocketChannel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * This method is launched when message is received from Client. It should
	 * parse the received message and execute appropriate command from
	 * UserManager interface
	 */

	public void parseMessageAndExecuteCommand(String message,
			SelectionKey connectionKey) {

		return;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("tst");
			try {

				int howManyChannelsReady = selector.selectNow();
				System.out.println("how many: "+howManyChannelsReady);
				if (howManyChannelsReady > 0) {

					Iterator<SelectionKey> keyIter = selector.selectedKeys()
							.iterator();
					System.out.println("tst2");

					while (keyIter.hasNext()) {
						
						

						System.out.println("Receiving stuff!");
						SelectionKey keyReady = keyIter.next();
						SocketChannel readChan = (SocketChannel) keyReady
								.channel();
						
						ByteBuffer readBuf = ByteBuffer.allocate(2048);
						readChan.read(readBuf);
						readBuf.flip();
						String s = "";
						while (readBuf.hasRemaining()) {
							s += (char) readBuf.get(); // read 1 byte at a time
							System.out.println("read");
						}
						String[] ss = s.split("\r\n|[\r\n]");
						for (String sss : ss) {
							System.out.print(sss);
							System.out.println('*');
							System.out.println("splitu");
						}
						
						String reply=":naszIrc 001 aaZZ :Witaj na naszym serwerze!\r\n";
						ByteBuffer buf = ByteBuffer.allocate(reply.getBytes().length);
						buf.clear();
						buf.put(reply.getBytes());

						buf.flip();
						while(buf.hasRemaining()) {
							readChan.write(buf);
						}

						
						

						keyIter.remove();
					}
				}else{
					Thread.sleep(1000);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("DRP");
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("tstEND");
		}
	}
}
