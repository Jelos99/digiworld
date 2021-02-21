package digiworld.testStore;

import static org.junit.Assert.assertEquals;

import digiworld.store.Product;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProductTest extends TestCase{
	
	private Product p;
	
	public void setUp() {
		p = new Product(0, null, 0, null, 0, 0, null, false, null);
	}
	
	public void testSetCategory() {
		p.setCategory("music");
		assertEquals("music",p.getCategory());
	}

	public void testSetDescription() {
		p.setDescription("Dj set pool party MAW in Miami");
		assertEquals("Dj set pool party MAW in Miami",p.getDescription());
	}
	
	public void testSetDiscount() {
		p.setDiscount(10);
		assertEquals(10,p.getDiscount());
	}
	
	public void testSetDLC() {
		p.setDLC(true);
		assertEquals(true,p.IsDLC());
	}
	
	public void testSetName() {
		p.setName("Miami now");
		assertEquals("Miami now", p.getName());
	}
	
	
	public void testSetPrice() {
		p.setPrice(19);
		assertEquals(19, p.getPrice());
	}
	
	public void testSetRegion() {
		p.setRegion("Italy");
		assertEquals("Italy", p.getRegion());
	}

	public void testSetService() {
		p.setService(9);
		assertEquals(9, p.getService());
	}
	public static Test suite() {
		return new TestSuite(ProductTest.class);
	}
}