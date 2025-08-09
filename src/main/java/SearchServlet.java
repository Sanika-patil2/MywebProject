import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		int roll=Integer.parseInt(request.getParameter("Rollno"));
		PrintWriter out=response.getWriter();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","swara");
			System.out.println("Database connected");
			pst=con.prepareStatement("Select * from studentdetails where roll=?");
			pst.setInt(1, roll);
			rs=pst.executeQuery();
			if(rs.next())
			{
				int roll1=rs.getInt(1);
				
				String name1=rs.getString(2);
				String addr1=rs.getString(3);
				out.println("<html>");
				out.println("<title>Search Page</title>");
				out.println("<body>");
				out.println("<form action='http://localhost:8888/MywebProject/UpdateServlet\' method='post'>");
				out.println("<center>");
				out.println("<table style=\"border-style:solid ;border-color:black\">");
				out.println("<tr>");
				out.println("<th>Student Details</th>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<tr>");
				out.println("<br><td>Rollno</td>");
				out.println("<td><input type=\"number\" name=\"Rollno\" value="+roll1+"></td>");
				out.println("</tr>");
				out.println("<br><td>Name</td>");
				out.println("<td><input type=\"text\" name=\"Name\" value="+name1+"></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<br><td>Address</td>");
				out.println("<td><input type=\"text\" name=\"Address\" value='"+addr1+"'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><button type=\"submit\">update</button></td>");
				out.println("</form>");
				out.println("<form action=\"http://localhost:8888/MywebProject/HomePage.html\" method=\"post\">");
				out.println("<td><button type=\"submit\">home</button></td>");
				out.println("</form>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
			}
			else
			{
				out.print("Record is not found");
			
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}


