/**
 * 
 */
package kn_14_5.Ivanova.database;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Jane
 *
 */
public class DaoFactoryTest {

	/**
	 * Test method for {@link kn_14_5.Ivanova.database.DaoFactory#getUserDao()}.
	 */
	@Test
	public void testGetUserDao() {
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null", daoFactory);
			UserDao userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
