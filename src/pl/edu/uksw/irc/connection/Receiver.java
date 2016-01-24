package pl.edu.uksw.irc.connection;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Receiver implements Runnable {
	Selector selector;
	SelectionKey key;

	public Receiver(Selector selector) {
		this.selector=selector;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("tst");
			try {

				int howManyChannelsReady = selector.selectNow();
				System.out.println("how many: " + howManyChannelsReady);
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
						}
						String[] ss = s.split("\r\n|[\r\n]");
						for (String sss : ss) {
							System.out.print(sss);
							System.out.println('*');
							System.out.println("splitu");

							// TODO:
							// TUTAJ WRZUCAMY NA KOLEJKE TO CO PRZYSZLO!!!
						}

						keyIter.remove();
					}
				} else {
					Thread.sleep(1000);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("tstEND");
		}
	}

}
