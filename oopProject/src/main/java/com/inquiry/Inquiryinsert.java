package com.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Inquiryinsert")
public class Inquiryinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inname = request.getParameter("inname");
		String inemail = request.getParameter("inemail");
		String intype = request.getParameter("intype");
		String inmessage = request.getParameter("inmessage");
		
		
		boolean isTrue;
		
		
		isTrue = InquiryDBUtil.insertInquiry(inname,inemail,intype,inmessage);
		
		if(isTrue == true) {
			List<Inquiry> inquiryDetails = InquiryDBUtil.getInquiryDetails(inemail);
			request.setAttribute("inquiryDetails", inquiryDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("displayInquirypage.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		

	}
}
