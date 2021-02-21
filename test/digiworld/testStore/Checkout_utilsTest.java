package digiworld.testStore;

import java.util.ArrayList;
import digiworld.database.connectionManager;
import digiworld.store.CartItem;
import digiworld.store.Checkout_utils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Checkout_utilsTest extends TestCase{
	
	private ArrayList<CartItem> cart = new ArrayList<CartItem>();
	private String SessionKey;
	
	public void setUp() {
		cart.add(new CartItem(1,1,6));
	}
	
	public void testProcessCart() {
		connectionManager.createConnection();
		boolean db = Checkout_utils.processCart(cart, SessionKey);
		assertEquals(false, db);
	}
	public static Test suite() {
		return new TestSuite(Checkout_utilsTest.class);
	}
}