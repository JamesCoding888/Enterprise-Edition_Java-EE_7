package javaWebEE.hr;

import java.io.IOException; 

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HR", urlPatterns = "/hr")
public class HRServlet extends HttpServlet {
	
	@EJB
	private HRService HrService;
	

}
