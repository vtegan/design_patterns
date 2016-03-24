/**
 * 
 */
package org.vegan.factory.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author egan
 *
 */
public class UserFactoryTests {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Performs a test to the factory method using a mock user, so we don't need to rely on the database connection.
	 * 
	 * Test method for {@link org.vegan.factory.login.UserMockDAO#loadByUsernameAndPassword(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLoadByUsernameAndPassword() {
		UserDAO dao = UserDAOFactory.createUserDAO("MOCK");
		
		User user = dao.loadByUsernameAndPassword(LoginConstants.USER_ONE, LoginConstants.PASSWORD_ONE);
		
		String expectedResult = "Egan";
		String actualResult = user.getLastName();
		assertEquals(expectedResult, actualResult);
	}

}
