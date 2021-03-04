package no.hvl.dat110.broker.processing.tests;

import no.hvl.dat110.client.Client;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test1ConnectDisconnect extends Test0Base {

	@Test
	public void test() {
		
		Client client = new Client("testuser",super.BROKER_TESTHOST, super.BROKER_TESTPORT);
		
		super.broker.setMaxAccept(1); // only 1 connect in this scenario
		
		client.connect();
		
		client.disconnect();
		
		assertTrue(true);
	}
}
