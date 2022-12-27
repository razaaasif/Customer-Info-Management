package com.spring.hibernate.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3306/spring_learning?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			PrintWriter sysout = response.getWriter();
			sysout.print("Connecting to url : " + url);
			Connection myCon = DriverManager.getConnection(url, user, password);
			myCon.createStatement().addBatch("select * From student");
		} catch (Exception e) {
			// SQL EXCEPTION: handle exception
			e.printStackTrace();
		}
	}

}
