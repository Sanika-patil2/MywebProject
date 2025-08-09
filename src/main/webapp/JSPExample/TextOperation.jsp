<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="obj" scope="page" class="mybeans.TextBean">
    <jsp:setProperty name="obj" property="txt" />
    <jsp:setProperty name="obj" property="option" />
    Enter Text=<jsp:getProperty name="obj" property="txt" /><br>
    Selected operation=<jsp:getProperty name="obj" property="option" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String Etext=request.getParameter("txt");
String opt=request.getParameter("option");
  out.println("Entered text= "+Etext);
  out.println("Selected operation ="+opt);
  if(opt.equalsIgnoreCase("upper"))
  {
	  out.println(obj.upper());
  }
  else if(opt.equalsIgnoreCase("lower"))
  {
	  out.println(obj.lower());
  }
  else if(opt.equalsIgnoreCase("reverse"))
  {
	  out.println(obj.reverse());
  }
 out.println("<html>");
 out.println("<body>");
 out.println("<form action=\"http://localhost:8888/MywebProject/JSPExample/TextDemo.html\">");
  out.println("<button type=\"submit\">Back</button>");
  out.println("</form>");
  out.println("</body>");
  out.println("</html>");
  
%>
</body>
</html>
</jsp:useBean>