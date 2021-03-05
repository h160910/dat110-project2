package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// create a client object and use it to
		Client tempClient = new Client("user1", Common.BROKERHOST, Common.BROKERPORT);

		// - connect to the broker
		boolean connected = tempClient.connect();

		// - publish the temperature(s)
		if(connected) {

			for (int i = 0; i < COUNT; i++) {

				String temp = String.valueOf(sn.read());
				tempClient.publish(Common.TEMPTOPIC, temp);

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// - disconnect from the broker
		tempClient.disconnect();

		System.out.println("Temperature device stopping ... ");
	}
}
