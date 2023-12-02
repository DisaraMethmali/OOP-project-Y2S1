package com.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateInquiry")
public class UpdateInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inquiryNo = request.getParameter("inquiryNo");
		String inname = request.getParameter("inname");
		String inemail = request.getParameter("inemail");
		String intype = request.getParameter("intype");
		String inmessage = request.getParameter("inmessage");
		
		
		boolean isTrue;
		
		isTrue = InquiryDBUtil.updateinquiry(inquiryNo, inname, inemail, intype, inmessage);
		
		if(isTrue == true) {
			
			List<Inquiry> inquiryDetails = InquiryDBUtil.getInquiryDetails(inquiryNo);
			request.setAttribute("inquiryDetails", inquiryDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("confirmation.jsp");
			dis.forward(request, response);
		}
		else {
			List<Inquiry> inquiryDetails = InquiryDBUtil.getInquiryDetails(inquiryNo);
			request.setAttribute("inquiryDetails", inquiryDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
	}

}
