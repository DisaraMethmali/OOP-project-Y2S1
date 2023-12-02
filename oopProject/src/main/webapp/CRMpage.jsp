<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Inquiries</title>
</head>
<body>
    <h1>All Inquiries</h1>
    <form action="displayAllInquiries" method="get" style="display:inline;">
            <input type="hidden" name="adminId">
            <input type="submit" value="show">
        </form>
   <!--    <a href="displayAllInquiries">Display All Inquiries</a>-->

    <table>
        <tr>
            <th>Inquiry ID</th>
            <th>Inquiry Name</th>
            <th>Inquiry Email</th>
            <th>Inquiry Type</th>
            <th>Inquiry Message</th>
            <th>Actions</th>
        </tr>
        
        <c:forEach var="inquiry" items="${inquiries}">
            <tr>
                <td>${inquiry.inquiryNo}</td>
                <td>${inquiry.inname}</td>
                <td>${inquiry.inemail}</td>
                <td>${inquiry.intype}</td>
                <td>${inquiry.inmessage}</td>
                <td>
              
                </td>
            </tr>
        </c:forEach>
    </table>
     
</body>
</html>
