<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
<style type="text/css">
body {
	font-family: 'Arial', sans-serif;
	background-color: #f5e1c3; /* Light brown background color */
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.container {
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	border-radius: 10px;
	max-width: 600px;
	padding: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: left;
	font-weight: bold;
}

th {
	background-color: #f5c092; /* Light orange header background color */
	font-weight: bold;
}

a {
	text-decoration: none;
}

.button-container {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.button {
	background-color: #e36913; /* Darker orange button color */
	color: #fff;
	border: none;
	padding: 10px 20px;
	margin: 10px;
	border-radius: 5px;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
}

.button:hover {
	background-color: #ff7d33; /* Lighter orange on hover */
}

.rounded-profile {
	border-radius: 50%;
	display: block;
            margin: 0 auto;
}
input[type="text"],
        input[type="email"] ,input[type="password"] {
        
        
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

</style>
</head>
<body>
<h1>Update My Account</h1>
<div class="container">

	<img src="image/imge8.jpg" class="rounded-profile" width="110">
	
	
	<br>
	<%
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
	%>
	
	
	<form action="UpdateCustomerServlet" method="post">
	<table>
		<tr>
			<td>Customer ID</td>
			<td><input type="text" name="cusid" value="<%= id %>" readonly></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" value="<%= name %>"></td>
		</tr>
		<tr>
		<td>Email</td>
		<td><input type="text" name="email" value="<%= email %>"></td>
	</tr>
	<tr>
		<td>Phone number</td>
		<td><input type="text" name="phone" value="<%= phone %>"></td>
	</tr>
	<tr>
		<td>User name</td>
		<td><input type="text" name="uname" value="<%= userName %>"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="pass" value="<%= password %>"></td>
	</tr>		
	</table>
	<br>
	<center>
	<input type="submit" name="submit" value="Update My Data">
	</center>
	</form>
</div>
</body>
</html>