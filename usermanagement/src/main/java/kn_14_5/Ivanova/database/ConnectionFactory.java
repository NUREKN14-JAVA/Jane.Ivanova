package kn_14_5.Ivanova.database;

import java.sql.Connection;

/*
 *  Interface for connecting to the database.
 */
public interface ConnectionFactory {
	Connection createConnection() throws DatabaseException;
}
