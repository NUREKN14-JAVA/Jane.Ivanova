/**
 * 
 */
package kn_14_5.Ivanova.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kn_14_5.Ivanova.User;
import kn_14_5.Ivanova.database.DaoFactory;
import kn_14_5.Ivanova.database.DatabaseException;

/**
 * @author Jane
 *
 */
public class AddServlet extends EditServlet {
	
	protected void processUser(User user) throws DatabaseException {
        DaoFactory.getInstance().getUserDao().create(user);
    }
	
	protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

}
