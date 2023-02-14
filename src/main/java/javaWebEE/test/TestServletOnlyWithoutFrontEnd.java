package javaWebEE.test;
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns ="/timestamp4numberrecord")
public class TestServletOnlyWithoutFrontEnd extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String number = req.getParameter("num");
		out.print("[" + new Date() + "] Get the number from front-end: " + number);
	}
}
