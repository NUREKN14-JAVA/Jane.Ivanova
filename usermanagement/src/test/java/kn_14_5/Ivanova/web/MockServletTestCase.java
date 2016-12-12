/**
 * 
 */
package kn_14_5.Ivanova.web;

import java.util.Properties;

import kn_14_5.Ivanova.database.DaoFactory;
import kn_14_5.Ivanova.database.MockDaoFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;

/**
 * @author Jane
 *
 */
public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {
	
	private Mock mockUserDao;

	/**
	 * @return the mockUserDao
	 */
	public Mock getMockUserDao() {
		return mockUserDao;
	}

	/**
	 * @param mockUserDao the mockUserDao to set
	 */
	public void setMockUserDao(Mock mockUserDao) {
		this.mockUserDao = mockUserDao;
	}

	/* (non-Javadoc)
	 * @see com.mockrunner.servlet.BasicServletTestCaseAdapter#setUp()
	 */
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();
		properties.setProperty("dao.factory", MockDaoFactory.class.getName());
		DaoFactory.init(properties);
		setMockUserDao(((MockDaoFactory)DaoFactory.getInstance()).getMockUserDao());
	}

	/* (non-Javadoc)
	 * @see com.mockrunner.servlet.BasicServletTestCaseAdapter#tearDown()
	 */
	@After
	protected void tearDown() throws Exception {
		getMockUserDao().verify();
		super.tearDown();
	}

}
