package ru.specialist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getServletContext().getInitParameter(arg0)
		
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		if (userName == null || userName.trim().isEmpty())
			response.sendRedirect("index.html");
		else {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.printf("<h1>Привет, %s!</h1>", userName);
		}
			
		
		
	}

}
