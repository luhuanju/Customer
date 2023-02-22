package com.cogent.setvlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class MyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head><title>My Page</title></head>");
		writer.println("<body>");
		writer.println("<h1>Hello, world!</h1>");
		writer.println("</body></html>");
		writer.close();
	}
}
