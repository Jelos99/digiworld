package digiworld.testUser;

import java.sql.SQLException;

import digiworld.database.connectionManager;
import digiworld.testStore.ProductUtilsTest;
import digiworld.user.User;
import digiworld.user.UserUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UserUtilsTest extends TestCase{
	
	User u = new User(4, "sabatino", "avellino", "sabatino@gmail.com", "sabatino", "inijnbi", 0, false);
	User b = new User(5, "vincenzo", "porcospino", "vincenzo@gmail.com", "vincenzo", "inijnbi", 0, false);
	User a = new User(1, "jacopo_sole", "porcodio", "solejacopo5@gmail.com", "jacopo", "inijnbi", 0, true);
	
	UserUtils user = new UserUtils();
	protected void setUp() {
		
	}

	
	public void testCreateUser() throws SQLException, ClassNotFoundException{
		connectionManager.createConnection();
		
		boolean db= UserUtils.createUser("vincenzo", "porcospino", "porcospino", "vincenzo@gmail.com");
		assertEquals(true, db);
		
	}

	public void testDoLogin() throws SQLException{
		connectionManager.createConnection();
		String db = UserUtils.doLogin("jacopo_sole", "porcodio");
		assertEquals("jacopo_sole", a.getUsername());
		
	}
	
	
	public void testChangePassword() throws SQLException{
		connectionManager.createConnection();
		boolean db = UserUtils.changePassword("sabatino", "avellino", "avellino1912");
		assertEquals(true, db);
		
	}
	
	public void testSetBillingAddress() throws SQLException{
		connectionManager.createConnection();
		boolean db = UserUtils.setBillingAddress("xuKIPaBcQxEGWZXtAsNtiDlzdkGztXzjacopo_sole", "inijnbi");
		assertEquals(true, db);
	}
	
	
	public void testIsAdmin() {
		connectionManager.createConnection();
		boolean db = UserUtils.isAdmin("xuKIPaBcQxEGWZXtAsNtiDlzdkGztXzjacopo_sole");
		assertEquals(true, db);
	}
	
	public static Test suite() {
		return new TestSuite(UserUtilsTest.class);
	}
}
