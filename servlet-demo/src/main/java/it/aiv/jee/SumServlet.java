package it.aiv.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SumServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		int value1 = Integer.parseInt(req.getParameter("value1"));
		int value2 = Integer.parseInt(req.getParameter("value2"));
		
		writer.write("Sum: " + (value1 + value2));
		writer.flush();
		writer.close();
	}
	
}
