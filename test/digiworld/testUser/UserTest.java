package digiworld.testUser;

import digiworld.user.User;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UserTest extends TestCase {
	private User user;
	
	protected void setUp() {
	user = new User(1,"username","password","email","nome","indirizzo",1,true);
		
	}
	
	public void TestID() {
		user.setID(1);
		assertEquals(1, user.getID());	
	}
	
	public void testSetUsername() {
		user.setUsername("username");
		assertEquals("username", user.getUsername());	
	}
	
	public void testHashedPassword() {
		user.setHashedPassword("password");
		assertEquals("password", user.getHashedPassword());	
	}
	
	public void testMailAddress() {
		user.setMailAddress("email");
		assertEquals("email", user.getMailAddress());	
	}
	
	public void testRealName() {
		user.setRealName("nome");
		assertEquals("nome", user.getRealName());	
	}
	
	public void testBillingAddress() {
		user.setBillingAddress("indirizzo");
		assertEquals("indirizzo", user.getBillingAddress());	
	}
	
	public void testPoints() {
		user.setPoints(1);
		assertEquals(1, user.getPoints());	
	}
	
	public void testAdmin() {
		user.setAdmin (true);
		assertEquals(true, user.IsAdmin());
	}
	
	public static Test suite() {
		return new TestSuite(UserTest.class);
	}
}