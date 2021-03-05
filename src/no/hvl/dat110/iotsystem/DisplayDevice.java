package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");

		// create a client object and use it to
		Client displayClient = new Client("displayClient", Common.BROKERHOST, Common.BROKERPORT);
		
		// - connect to the broker
		boolean connected = displayClient.connect();

		if (connected) {
			// - create the temperature topic on the broker
			displayClient.createTopic(Common.TEMPTOPIC);

			// - subscribe to the topic
			displayClient.subscribe(Common.TEMPTOPIC);

			// - receive messages on the topic
			for (int i = 0; i < COUNT; i++) {
				Message m = displayClient.receive();
				System.out.println(m.toString());
			}

			// - unsubscribe from the topic
			displayClient.unsubscribe(Common.TEMPTOPIC);

			// - disconnect from the broker
			displayClient.disconnect();
		}

		System.out.println("Display stopping ... ");

	}
}
