package javaWebEE.ejb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet4EJB", urlPatterns = {"/HelloServlet4EJB"})
public class HelloServlet4EJB extends HttpServlet {

//	@EJB
	private MyEJB myEJB = new MyEJB();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
        if (name != null && !name.isEmpty()) {
        	System.out.println(name);
            String message = myEJB.sayHello(name);
            req.setAttribute("message", message);
        }
        req.getRequestDispatcher("/WEB-INF/view/EJBView.jsp").forward(req, resp);
	}
}
