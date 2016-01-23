package pl.edu.uksw.irc.connection;

import java.nio.channels.Selector;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accepter accepter = new Accepter(9999);
		Thread accepterThread = new Thread(accepter);
		accepterThread.start();
		System.out.println("Accepter started");
		
		Selector selector = accepter.getSelector();
						
		Receiver receiver = new Receiver(selector);
		Thread receiverThread = new Thread(receiver);
		receiverThread.start();
		System.out.println("Receiver started");
		
	}

}
