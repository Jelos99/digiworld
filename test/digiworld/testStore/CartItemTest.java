package digiworld.testStore;

import java.sql.SQLException;
import digiworld.database.connectionManager;
import digiworld.store.CartItem;
import digiworld.store.Product;
import digiworld.store.ProductUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CartItemTest extends TestCase{
	
	private static CartItem cartItem;
	private static Product product;

	public void setUp() {
		cartItem = new CartItem(112,2,19);
		product = new Product (232312, "Saw", 103, "Colonna sonora Film horror", (float) 9.99, 0, "Italia", false, getName());		
	}
	
	public void testSetItemID() {
		cartItem.setItemID(300);
		assertEquals(300, cartItem.getItemID());
	}
	
	public void testSetUserID() {
		cartItem.setUserID(31);
		assertEquals(31, cartItem.getUserID());
	}
	
	public void testProductName() {
		// Il valore cercato è già impostato dal costruttore, quindi verifico subito con assertEquals
		// Accertarsi che il confronto tra stringhe sia gestito.....
		assertEquals("Saw", product.getName());
	}
	
	public void testProductNameException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getName();
			fail("Controllo non superato");
		} catch (SQLException e) {	}
	}
	
	public void testProductDescription() {
		assertEquals("Colonna sonora Film horror", product.getDescription());
	}
	
	public void testProductDescriptionException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getDescription();
			fail("Controllo non superato");
		} catch (SQLException e) {  }		
	}
	
	public void testProductPrice() {
		product.setPrice(9.99F);
		assertEquals(9.99F, product.getPrice());
	}
	
	public void testProductPriceException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getPrice();
			fail("Controllo non superato");
		} catch (SQLException e) {  }
	}

	public void testProductRegion() {
		assertEquals("Italia", product.getRegion());
	}
	
	public void testProductRegionException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getRegion();
			fail("Controllo non superato");
		} catch (SQLException e) {  }
	}

	public void testProductDiscountPrice() {
		product.setDiscount(2);
		assertEquals(2, product.getDiscount());
	}
	
	public void testProductDiscountPriceException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getDiscount();
			fail("Controllo non superato");
		} catch (SQLException e) {  }
	}

	public void testProductDiscountPercentage() {
		assertEquals(0, product.getDiscount());
	}
	
	public void testProductDiscountPercentageException() {
		try {
			connectionManager.createConnection();
			ProductUtils.productByID(1).getDiscountPrice();
			fail("Controllo non superato");
		} catch (SQLException e) {  }
	}
	public static Test suite() {
		return new TestSuite(ProductUtilsTest.class);
	}
}