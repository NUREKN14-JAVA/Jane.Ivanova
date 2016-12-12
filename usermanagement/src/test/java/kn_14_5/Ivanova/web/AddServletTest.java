package kn_14_5.Ivanova.web;

import java.text.DateFormat;
import java.util.Date;

import kn_14_5.Ivanova.User;

import org.junit.Before;
import org.junit.Test;

public class AddServletTest extends MockServletTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		createServlet(AddServlet.class);
	}
	
	public void testAdd() {
        Date date = new Date();
        User newUser = new User("Jane", "Ivanova", date);
        User user = new User(new Long(1000), "Jane", "Ivanova", date);
        getMockUserDao().expectAndReturn("create", newUser, user);
        
        addRequestParameter("firstName", "Jane");
        addRequestParameter("lastName", "Ivanova");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
    }
	
	public void testAddEmptyFirstName() {
        Date date = new Date();
        addRequestParameter("firstName", "Jane");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }
	
	public void testAddEmptyLastName() {
        Date date = new Date();
        addRequestParameter("lastName", "Ivanova");
        addRequestParameter("date", DateFormat.getDateInstance().format(date));
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDate() {
        Date date = new Date();
        addRequestParameter("firstName", "Jane");
        addRequestParameter("lastName", "Ivanova");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

    public void testAddEmptyDateIncorrect() {
        Date date = new Date();
        addRequestParameter("firstName", "Jane");
        addRequestParameter("lastName", "Ivanova");
        addRequestParameter("date", "oooooo");
        addRequestParameter("okButton", "Ok");
        doPost();
        String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
        assertNotNull("Could not find error message in session scope", errorMessage);
    }

}
