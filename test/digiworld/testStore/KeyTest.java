package digiworld.testStore;

import digiworld.store.Key;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class KeyTest extends TestCase {
	private Key key;
	
	protected void setUp() {
	key = new Key(1,1,"codice",false);
		
	}
	
	public void testSetKeyID() {
		key.setKeyID(1);
		assertEquals(1, key.getKeyID());	
	}
	
	public void testSetProductID() {
		key.setProductID(1);
		assertEquals(1, key.getProductID());	
	}
	
	public void testSetKey() {
		key.setKey("codice");
		assertEquals("codice", key.getKey());	
	}
	
	
	public void testSetSold() {
		key.setSold(true);
		assertEquals(true, key.IsSold());	
	}
	
	
	public static Test suite() {
		return new TestSuite(KeyTest.class);
	}
}