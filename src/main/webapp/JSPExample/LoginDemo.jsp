<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
Connection con;
PreparedStatement pst;
ResultSet rs;
%>
<%
String username=request.getParameter("username");
String pass=request.getParameter("password");
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","swara");
	System.out.println("Database connected");
	pst=con.prepareStatement("Select * from userdetails where username=? and password=?");
	pst.setString(1, username);
	pst.setString(2, pass);
	rs=pst.executeQuery();
	if(rs.next())
	{
		response.sendRedirect("http://localhost:8888/MywebProject/JSPExample/HomePage.html");
	}
	else
	{
		response.sendRedirect("http://localhost:8888/MywebProject/JSPExample/Error.html");
	}
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</body>
</html>