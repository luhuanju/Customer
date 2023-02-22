package com.cogent.setvlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dbInfo")
public class NWServlet extends HttpServlet {

	ServletConfig config = null;

	private static final String DB_URL = "jdbc:mysql://localhost/batch65";
	private static final String USER = "root";
	private static final String PASS = "password";

	private static Connection conn;

	// init method
	public void init(ServletConfig sc) {
		config = sc;

		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet rs = conn.getMetaData().getTables(null, null, "Customer", null);
			if (!rs.next()) {
				// create the table if it does not exist
				String sql = "CREATE TABLE Customer (CustomerID int, CustomerName VARCHAR(50), AccountType VARCHAR(50), Address VARCHAR(50) )";
				stmt.executeUpdate(sql);
				System.out.println("Table created successfully.");
			} else {
				System.out.println("Table already exists.");
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter writer = res.getWriter();
		writer.println("<html>");
		writer.println("<head><title>DB Resule</title></head>");
		writer.println("<body>");


		String sql = "SELECT * FROM Employee";
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

			System.out.println("Data in DB:");
			// process the result set
			while (rs.next()) {
				int id = rs.getInt("employeeId");
				String name = rs.getString("employeeName");
				String recordString = "employeeId: " + id + ", employeeName: " + name;
				writer.println("<h1>" + recordString + "</h1>");
			}

			writer.println("</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String accountType = request.getParameter("accountType");
		String address = request.getParameter("address");

		String sql = "INSERT INTO Customer (CustomerID, CustomerName, AccountType, Address) VALUES (?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.valueOf(id));
			stmt.setString(2, name);
			stmt.setString(3, accountType);
			stmt.setString(4, address);
			boolean rs = stmt.execute();
			System.out.println("inserted successfully.");

			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("accountlist.jsp");
		dispatcher.forward(request, response);

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("Success!");

	}



	// destroy method
	public void destroy() {
		System.out.println("in destroy");
	}

	public String getServletInfo() {
		return "LifeCycleServlet";
	}

	public ServletConfig getServletConfig() {
		return config; // getServletConfig
	}
}
