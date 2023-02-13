package javaWebEE.hr.controller;

import java.io.IOException; 
import java.io.PrintWriter;
import javaWebEE.hr.model.Employee;
import javaWebEE.hr.service.HRService;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HR", urlPatterns = "/hr")
public class HRServlet extends HttpServlet {
	
	@EJB
	private HRService hrService;
	
	// Notice here ! This method of doGet, is NOT Security because the information of badge and name will be presented on url-address
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		// Get the parameters from front-end
		String badgeId = req.getParameter("badge");
		String name = req.getParameter("name");		
		// Console on local server
		PrintWriter out = res.getWriter();
		System.out.println(badgeId);
		System.out.println(name);		
		// Create an object of emp to query the value of badgeId from Database
		Employee emp = hrService.findEmployee(badgeId);
		// Get the object of emp if badgeId existence, then set the name of badgeId that end-users expected to be
		emp.setName(name);
		// Proceed the transaction on HRService class
		hrService.updateEmployee(emp);
	}
}
