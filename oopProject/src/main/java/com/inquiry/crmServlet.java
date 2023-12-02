package com.inquiry;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/crmServlet")
public class crmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    List<Inquiry> inquiries = new ArrayList<>();

	    try {
	        // Get a database connection
	        Connection connection = DBConnect.getConnection();

	        // Query to retrieve inquiries
	        String sql = "SELECT * FROM inquiry";
	        java.sql.PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet resultSet = statement.executeQuery();

	        // Process the results and create Inquiry objects
	        while (resultSet.next()) {
	            Inquiry inquiry = new Inquiry(
	                resultSet.getInt("inquiryNo"),
	                resultSet.getString("inname"),
	                resultSet.getString("inemail"),
	                resultSet.getString("intype"),
	                resultSet.getString("inmessage")
	            );
	            inquiries.add(inquiry);
	        }

	        // Close resources
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Set the inquiries as an attribute in the request
	    request.setAttribute("inquiry", inquiries);

	    
	    request.getRequestDispatcher("CRMpage.jsp").forward(request, response);
	}
}
