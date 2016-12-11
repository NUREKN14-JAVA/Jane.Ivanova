package kn_14_5.Ivanova.database;
/* 
 * Test method for the create ().
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import junit.framework.TestCase;
import kn_14_5.Ivanova.User;

public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	/* 
	 * @see junit.framework.TestCase#setUp()
	 */
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);	
	}

	/* Test method for ''
	 * Create an instance of the User, 
	 * enter values for the name, surname, date of birth 
	 * and check that before adding the ID is not defined. 
	 * Next, using the DAO, this object is added to the database 
	 * and get set up with the user ID specified.
	 */
	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName("John");
			user.setLastName("Doe");
			user.setDateOfBirth(new Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	
	public void testUpdate(){
		 try {
			 
			 User user = new User();
			 user.setId(1L);
			 String newFirstName = "Jane";
			 String newLastName = "Ivanova";
			 @SuppressWarnings("deprecation")
			 Date newDate = new Date(1997,1,30);
			 user.setFirstName(newFirstName);
			 user.setLastName(newLastName);
			 user.setDateOfBirth(newDate);
			 dao.update(user);
			 user = dao.find(user.getId());
			 assertEquals("Firstname fail", newFirstName, user.getFirstName());
			 assertEquals("Lastname fail", newLastName, user.getLastName());
			 assertEquals("Date fail", newDate, user.getDateOfBirth());
	     } catch (DatabaseException e) {
	     	e.printStackTrace();
	     	fail(e.toString());
	     }
	 }

	 public void testDelete() {
		 try {
			 User user = new User();
			 long id = 1L;
			 user.setId(id);
			 dao.delete(user);
		 }catch(DatabaseException e){
			 e.printStackTrace();
		 	 fail(e.toString());
		 }
	}
	 
	public void testFind() {
		 try {
		 	User user = dao.find(2L);
		 	assertNotNull(user);
			assertEquals(new Long(2L), user.getId());
			assertEquals("George", user.getFirstName());
			assertEquals("Bush", user.getLastName());
		 } catch (DatabaseException e) {
		 		e.printStackTrace();
		 		fail(e.toString());
		 }
		 long id = 3L;
		 try {
		 		dao.find(id);   
		 } catch (DatabaseException e) {
		 		assertEquals(e.getMessage().toString(), "Could not find the user with id="+id);
		 }
	}
		 	
	public void testFindAll(){
		 try {
			 Collection collection = dao.findAll();
			 assertNotNull("Collection is null", collection);
			 assertEquals("Collection size.", 2, collection.size());
		 } catch (DatabaseException e) {
			 e.printStackTrace();
			 fail(e.toString());
		 }
	}
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl();
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader()
				.getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}
