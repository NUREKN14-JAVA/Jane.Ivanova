/*
 * Copyright (c) 2016, KNURE and/or its affiliates. All rights reserved.
 * Use is subject to license terms.
 *
 *
 *
 *
 */
package kn_14_5.Ivanova.database;

import java.util.Collection;

import kn_14_5.Ivanova.User;
/*
 * An interface that has the basic methods of work with the database.
 */
public interface UserDao {
	
	User create(User user) throws DatabaseException;
	
	void update(User user) throws DatabaseException;
	
	void delete(User user) throws DatabaseException;
	
	User find(Long id) throws DatabaseException;

	Collection findAll() throws DatabaseException;
	
	Collection find(String firstName, String lastName) throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);
	
}
