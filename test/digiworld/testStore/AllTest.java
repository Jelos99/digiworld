package digiworld.testStore;

import digiworld.testUser.OrdersUtilsTest;
import digiworld.testUser.UserTest;
import digiworld.testUser.UserUtilsTest;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTest {

	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(CartItemTest.suite());
		test.addTest(CartUtilsTest.suite());
		test.addTest(Checkout_utilsTest.suite());
		test.addTest(KeyTest.suite());
		test.addTest(ProductTest.suite());
		test.addTest(ProductUtilsTest.suite());
		
		test.addTest(OrdersUtilsTest.suite());
		test.addTest(UserTest.suite());
		test.addTest(UserUtilsTest.suite());
		
		
		return test;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}


}
