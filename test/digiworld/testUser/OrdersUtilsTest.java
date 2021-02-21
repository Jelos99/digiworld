package digiworld.testUser;

import java.sql.SQLException;
import java.util.ArrayList;

import digiworld.database.connectionManager;
import digiworld.user.Order;
import digiworld.user.OrdersUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;




public class OrdersUtilsTest extends TestCase {
	
	private static OrdersUtils order = new OrdersUtils();
	private Order order1 = new Order(1, 1, 1, 1, 1);

	@Override
	protected void setUp() throws SQLException {


	}
	
	
	public void testfetchUserOrders() throws SQLException {
	connectionManager.createConnection();
	
	ArrayList<Order> order2 = OrdersUtils.fetchUserOrders(1);
	for (Order i : order2) {
	assertEquals(1, i);}
	}
	
	public static Test suite() {
		return new TestSuite(OrdersUtilsTest.class);
	}


}