import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DisplayAllServlet
 */
@WebServlet("/DisplayAllServlet")
public class DisplayAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	ResultSetMetaData rsmd;
	String colname;
	String rowsdata;
    public DisplayAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		//int roll=Integer.parseInt(request.getParameter("Rollno"));
		PrintWriter out=response.getWriter();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
