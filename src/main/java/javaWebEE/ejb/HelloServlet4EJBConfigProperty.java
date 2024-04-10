package javaWebEE.ejb;
/*
		If you don't want to reveal the location of the JSP file in your code, one way to refactor the code is to store the JSP file location in a configuration file or environment variable, and then read the value from the file or variable at runtime.

			1) Create a configuration file (e.g., config.properties) in the src/main/resources directory of your Eclipse project

			2) Add a property to the configuration file that specifies the location of the JSP file
			
			3) Load the configuration file in your servlet or JSP using a Properties object
			
			4) Retrieve the JSP file location from the Properties object
			
			5) Use the retrieved JSP file location in your code
			
	
*/
import java.io.IOException; 
import java.io.InputStream;
import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet4EJBConfigProperty", urlPatterns = {"/HelloServlet4EJBConfigProperty"})
public class HelloServlet4EJBConfigProperty extends HttpServlet {


	private MyEJB myEJB = new MyEJB();
	/*
		@EJB	
		private MyEJB myEJB;
	*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println(name);
        if (name != null && !name.isEmpty()) {
        	System.out.println(name);
            String message = myEJB.sayHello(name);
            req.setAttribute("message", message);
        }
        /*
        	Load the configuration file in your servlet or JSP using a Properties object 
        */
        Properties props = new Properties();
        /*
         	Create a config.properties file in the src/main/resources directory 
         	and add the following line 'ejbview.location=/WEB-INF/view/EJBView.jsp' to 'config.properties'
        */
        InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
        props.load(is);
        // Retrieve the JSP file location from the Properties object
        String ejbViewLocation = props.getProperty("ejbview.location");
        // Use the retrieved JSP file location in your code
        req.getRequestDispatcher(ejbViewLocation).forward(req, resp);
	}
}
