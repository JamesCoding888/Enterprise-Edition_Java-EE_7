package javaWebEE.hr2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = {"/hr2"})
//@WebServlet(urlPatterns = "/hr2")
public class UpdateEmployeeServlet extends HttpServlet {

    @EJB
    private HRService hrService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String badgeId = request.getParameter("badge");
        String name = request.getParameter("name");        
        out.print("badgeId: " + badgeId + "<br>");
        out.print("name: " + name + "<br>");
        Employee emp = hrService.findEmployee(badgeId);
        emp.setName(name);
        hrService.updateEmployee(emp);
    }
}