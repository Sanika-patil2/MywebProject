<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
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
int roll= Integer.parseInt(request.getParameter("Rollno"));
String name=request.getParameter("Name");
String addr=request.getParameter("Address");

try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","swara");
	System.out.println("Database connected");
	pst=con.prepareStatement("update studentdetails set Name=?,Address=? where Roll=?");
	pst.setString(1,name);
	pst.setString(2, addr);
	pst.setInt(3, roll);
	int res=pst.executeUpdate();
	if(res>=1)
	{
		out.print("Record updated successfully");
	}
	else
	{
		out.print("Record is not updated");
	}
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</body>
</html>