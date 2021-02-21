package digiworld.testStore;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import digiworld.database.connectionManager;
import digiworld.store.CartItem;
import digiworld.store.CartUtils;
import digiworld.store.Product;
import digiworld.store.ProductUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CartUtilsTest extends TestCase{
	
	private CartUtils cart = new CartUtils();
	private CartItem c = new CartItem(0, 0, 0);

	public void setUp() throws SQLException {
		//p1 = new Product(3, "skyfall", 10, "Flight simulator", 22.9F, 10, "Europe", false, "Game");
		//p2 = pUtils.productByID(3);
		//pUtils.deleteProductById(400);
	}
	
	public void testAddToCart() throws SQLException {
		connectionManager.createConnection();
		boolean db = CartUtils.addToCart(1,"GHDEnvzQYNczGPHajEGddmtKWmkgSXGporcodio");
		assertEquals(true, db);
		
	}
	
	public void testDeleteFromCart() {
		connectionManager.createConnection();
		boolean db = CartUtils.deleteFromCart("GHDEnvzQYNczGPHajEGddmtKWmkgSXGporcodio", 6);
		assertEquals(true, db);
	}
	public static Test suite() {
		return new TestSuite(CartUtilsTest.class);
	}
}