package com.inquiry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

// Your import statements for necessary classes

@WebServlet("/displayAllInquiries")
public class DisplayAllInquiriesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Fetch the list of inquiries (you may need to replace this with your own code)
            List<Inquiry> inquiries = InquiryDBUtil.getAllInquiries();
            
           

            // Set the inquiries list as a request attribute
            request.setAttribute("inquiries", inquiries);

            // Forward the request to the JSP page for displaying inquiries
            RequestDispatcher dispatcher = request.getRequestDispatcher("CRMpage.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
