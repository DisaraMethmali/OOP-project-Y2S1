package com.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteInquiry")
public class deleteInquiry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inquiryNo = request.getParameter("no");
            boolean isTrue;

            isTrue = InquiryDBUtil.deleteInquiry(inquiryNo);

            if (isTrue) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
                dispatcher.forward(request, response);
            } else {
                List<Inquiry> inquiryDetails = InquiryDBUtil.getInquiryDetails(inquiryNo);
                request.setAttribute("inquiryDetails", inquiryDetails);

                RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
                dis.forward(request, response);
            }

        } catch (NumberFormatException e) {
           // Log the exception for debugging

            // Handle the exception by forwarding to a confirmation page or taking other actions
          RequestDispatcher dispatcher = request.getRequestDispatcher("confirmation.jsp");
            dispatcher.forward(request, response);
        }
    }
}
