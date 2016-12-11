package kn_14_5.Ivanova.database;

import com.mockobjects.dynamic.Mock;

public class MockDaoFactory extends DaoFactory {

	private Mock mockUserDao;

	public MockDaoFactory() {
		mockUserDao = new Mock(UserDao.class);
	}

	public Mock getMockUserDao() {
		return mockUserDao;
	}

	@Override
	public UserDao getUserDao() {
		return (UserDao) mockUserDao.proxy();
	}

}