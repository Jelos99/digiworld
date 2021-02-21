package digiworld.testStore;

import java.sql.SQLException;
import java.util.ArrayList;

import digiworld.database.connectionManager;
import digiworld.store.Key;
import digiworld.store.Product;
import digiworld.store.ProductServlet;
import digiworld.store.ProductUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProductUtilsTest extends TestCase{

	private ProductUtils pu = new ProductUtils();
	Product p= new Product(1, "Gomorra", 1, "vieniti a prendere il perdono", 66 , 20, "Europe", true, "book");
	Product p1= new Product(9, "HarryPotter", 1, "si dice leviosa non leviosà", 66 , 20, "Europe", true, "book");
	Key key = new Key(1, 1, "qwerty", false);
	
	@Override
	protected void setUp() throws Exception {
	
	}
	
	public void testProductByID() throws SQLException {
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(1);
		assertEquals(p.getID(), db.getID());
	}
	
	public void testAddNewProduct() throws SQLException{
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(9);
		ProductUtils.addNewProduct(p1);
		assertEquals(p1.getID(), db.getID());	
	}
	
	public void testUpdateProduct() throws SQLException{
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(8);
		db.setName("HarryPotter");
		assertEquals("HarryPotter", db.getName());
	}
	
	public void testImportKey() throws SQLException{
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(1);
		assertEquals(db.getID(), key.getProductID());
		
	}
		
	public void testRetriveProducts() throws SQLException{
		connectionManager.createConnection();
		ArrayList<Product> products = new ArrayList<Product>();
		ProductUtils.retriveProducts(1, products.size());
		for(Product i: products) {
			assertEquals(products.size(), i.getID());
		}
	}
	public void testRetriveProductsByCategory() throws SQLException{
		connectionManager.createConnection();
		ArrayList<Product> products = ProductUtils.retriveProductsByCategory("Game");
		for(Product i: products) {
			assertEquals("Game", i.getCategory());
		}
	}
	
	public void testCountProducts() throws SQLException {
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(8);
		assertEquals(1, db.getService());
	}
	
	public void testCountKeysStock() throws SQLException {
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(8);
		assertEquals(p1.getStock(),db.getStock());		
		
	}
	/*public void testDeleteProductById() throws SQLException {	
		connectionManager.createConnection();
		Product db = ProductUtils.productByID(9);
		ProductUtils.deleteProductById(9);
		assertEquals(true, db.getID() );
		
	}*/
	
	public static Test suite() {
		return new TestSuite(ProductUtilsTest.class);
	}
}
