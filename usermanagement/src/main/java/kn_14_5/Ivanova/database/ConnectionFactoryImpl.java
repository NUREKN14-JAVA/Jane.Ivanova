package kn_14_5.Ivanova.database;
/*
 * Realization of the created interface ConnectionFactory.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryImpl implements ConnectionFactory {
	
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public ConnectionFactoryImpl() {
		this.driver="org.hsqldb.jdbcDriver";
		this.url="jdbc:hsqldb:file:db/usermanagement";
		this.user="sa";
		this.password="";
	}

	
	public ConnectionFactoryImpl(String url, String user, String password, String driver) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public ConnectionFactoryImpl(Properties properties) {
		user = properties.getProperty("connection.user");
		driver = properties.getProperty("connection.driver");
		url = properties.getProperty("connection.url");
		password = properties.getProperty("connection.password");
	}
	
	public Connection createConnection() throws DatabaseException {
		String url = "jdbc:hsqldb:file:db/usermanagement";
		String user = "sa";
		String password = "";
		String driver = "org.hsqldb.jdbcDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		
	}

}
