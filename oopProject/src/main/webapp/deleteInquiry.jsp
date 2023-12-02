<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <style>
        body {
            background-color: #EFD5C3; /* Light Yellow Background */
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 400px;
            text-align: center;
        }

        .container h2 {
            color: #6c513d; /* Brown Text Color */
        }

        .input-group {
            margin: 20px 0;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"] {
            width: 90%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #6c513d; /* Brown Button Color */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
        }

        input[type="submit"]:hover {
            background-color: #543c2b; /* Darker Brown Button Color on Hover */
        }
    </style>
</head>
<body>
 <div class="container">

	  <%
            String inquiryNo = request.getParameter("inquiryNo");
            String inname = request.getParameter("inname");
            String inemail = request.getParameter("inemail");
            String intype = request.getParameter("intype");
            String inmessage = request.getParameter("inmessage");
        %>

	<h1>Inquiry Delete</h1>

	<form action="deleteInquiry" method="post">
		  <div class="input-group">
                <label for="inquiryNo">Inquiry Number</label>
                <input type="text" name="inquiryNo" value="<%= inquiryNo %>" readonly>
            </div>
            <div class="input-group">
                <label for="inname">Name</label>
                <input type="text" name="inname" value="<%= inname %>">
            </div>
            <div class="input-group">
                <label for="inemail">Email</label>
                <input type="email" name="inemail" value="<%= inemail %>">
            </div>
            <div class="input-group">
                <label for="intype">Type</label>
                <input type="text" name="intype" value="<%= intype %>">
            </div>
            <div class="input-group">
                <label for="inmessage">Message</label>
                  <input type="text" name="inmessage" value="<%= inmessage %>">
           

            </div>
            <br> <input type="submit" name="submit" value="Delete Inquiry">
	</form>
</div>
</body>
</html>