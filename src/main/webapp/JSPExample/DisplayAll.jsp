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
ResultSetMetaData rsmd;
%>
<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","swara");
	System.out.println("Database connected");
	pst=con.prepareStatement("Select * from studentdetails");
	rs =pst.executeQuery();
	rsmd =rs.getMetaData();
	int cols =rsmd.getColumnCount();
	out.println("<html><body><table style=\"background-color:lightblue; border-style:solid; border-color:black\"><tr>");
	int i;
	for(i=1;i<=cols;i++)
	{
		out.println("<td>"+rsmd.getColumnName(i)+"</td>");
		
	}
	out.println("</tr>");
	
	while(rs.next())
	{
		out.println("<tr>");
		for(i=1;i<=cols;i++)
		{
			out.println("<td>"+rs.getString(i)+"</td>");	
			
		}
		out.println("</tr>");
	}
	out.println("</table><a href=\"http://localhost:8888/MywebProject/HomePage.html\">Go back home</a></body></html>");
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