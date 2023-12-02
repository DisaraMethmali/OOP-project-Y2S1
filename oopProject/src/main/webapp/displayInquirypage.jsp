<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
    body {
        font-family: 'Poppins';
        background-color: #e0f2e9; /* Light Green Background */
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #404040;
        padding: 20px;
    }

    table {
        border-collapse: collapse;
        margin: 20px auto;
        background-color: #ffffff; /* White Background */
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        border-radius: 10px;
        width: 80%;
        max-width: 800px;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #6c757d; /* Dark Gray Header Background */
        color: #ffffff; /* White Text Color */
    }

    tr:nth-child(even) {
        background-color: #f2f2f2; /* Light Gray Background for Even Rows */
    }

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    .button {
        display: inline-block;
        background-color: #2e7d32; /* Dark Green Button Color */
        color: #ffffff; /* White Text Color */
        padding: 10px 20px;
        text-decoration: none;
        margin: 10px;
        border-radius: 5px;
        font-size: 16px;
        transition: background-color 0.3s;
    }

    .button:hover {
        background-color: #1b5e20; /* Darker Green Button Color on Hover */
    }
</style>
<title>Insert title here</title>
</head>
<body>
<h1>Inquiry Details</h1>
	<table>
	
	<c:forEach var="inquiry" items="${inquiryDetails}">
	
	<c:set var="inquiryNo" value="${inquiry.inquiryNo}"/>
	<c:set var="inname" value="${inquiry.inname}"/>
	<c:set var="inemail" value="${inquiry.inemail}"/>
	<c:set var="intype" value="${inquiry.intype}"/>
	<c:set var="inmessage" value="${inquiry.inmessage}"/>

	
	
	 <tr>
            <td>Inquiry ID</td>
            <td>${inquiry.inquiryNo}</td>
        </tr>
        <tr>
            <td>Inquiry Name</td>
            <td>${inquiry.inname}</td>
        </tr>
        <tr>
            <td>Inquiry Email</td>
            <td>${inquiry.inemail}</td>
        </tr>
        <tr>
            <td>Inquiry Phone</td>
            <td>${inquiry.intype}</td>
        </tr>
        <tr>
            <td>Inquiry Message</td>
            <td>${inquiry.inmessage}</td>
        </tr>

	</c:forEach>
	</table>

	<c:url value="Inquiryupdatepage.jsp" var="updateinquiry">
		
		<c:param name="inquiryNo" value="${inquiryNo}" />
		<c:param name="inname" value="${inname}" />
		<c:param name="inemail" value="${inemail}" />
		<c:param name="intype" value="${intype}" />
		<c:param name="inmessage" value="${inmessage}" />
	</c:url>

	<div class="button-container">
        <a href="${updateinquiry}" class="button">Edit Inquiry</a>
   
	<br>
	<c:url value="deleteInquiry.jsp" var="deleteinquiry">
			<c:param name="inquiryNo" value="${inquiryNo}" />
		<c:param name="inname" value="${inname}" />
		<c:param name="inemail" value="${inemail}" />
		<c:param name="intype" value="${intype}" />
		<c:param name="inmessage" value="${inmessage}" />
	</c:url>
	
	
        <a href="${deleteinquiry}" class="button">Delete Inquiry</a>
    </div>
	
		
		
</body>
</body>
</html>