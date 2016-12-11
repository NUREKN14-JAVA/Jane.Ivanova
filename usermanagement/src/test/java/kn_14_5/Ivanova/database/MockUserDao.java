package kn_14_5.Ivanova.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import kn_14_5.Ivanova.User;

public class MockUserDao implements UserDao {
	private long id = 0;
    private Map<Long, User> users = new HashMap<Long, User>();

	@Override
	public User create(User user) throws DatabaseException {
		Long currentId = new Long(++id);
        user.setId(currentId);
        users.put(currentId, user);
        return user;
	}

	@Override
	public void update(User user) throws DatabaseException {
		Long currentId = user.getId();
        users.remove(currentId);
        users.put(currentId, user);

	}

	@Override
	public void delete(User user) throws DatabaseException {
		Long currentId = user.getId();
        users.remove(currentId);

	}

	@Override
	public User find(Long id) throws DatabaseException {
		return (User) users.get(id);
	}

	@Override
	public Collection<?> findAll() throws DatabaseException {
		 return users.values();
	}

	@Override
	public Collection<?> find(String firstName, String lastName)
			throws DatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		// TODO Auto-generated method stub

	}

}
