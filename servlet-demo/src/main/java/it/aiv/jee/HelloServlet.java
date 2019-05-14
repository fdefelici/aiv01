package it.aiv.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String aName = req.getParameter("name");
		if (aName == null) aName = "Nobody";
		
		writer.write("Hello " + aName);
		
		writer.flush();
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		String ageAsStr = req.getParameter("age");
		int age = Integer.parseInt(ageAsStr);
		
		writer.write("Age: " + age);
		writer.flush();
		writer.close();
	}
	
}
