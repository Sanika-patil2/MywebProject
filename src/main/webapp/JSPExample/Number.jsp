<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int num1=Integer.parseInt(request.getParameter("num"));
String Eoption=request.getParameter("option");
out.println("<html>");
out.println("<body>");
out.println("<form>");
out.println("<table>");
out.println("<tr>");
out.println("<td>Enter Text:</td><td><input type=\"number\" name=\"num\" value="+num1+"></td>");
out.println("</tr>");
out.println("<br>");
out.println("<tr>");
out.println("<td>Select Operation:</td> <td><input type=\"text\" name=\"Text\" value="+Eoption+"></td>");
out.println("</td>");
out.println("</tr>");
out.println("</table>");
out.println("</form>");
out.println("</body>");
out.println("</html>");
%>
</body>
</html>