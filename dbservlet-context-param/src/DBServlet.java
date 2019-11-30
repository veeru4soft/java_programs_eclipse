import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
import java.sql.*;
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement ps;
	
	public void init() {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

    /**
     * Default constructor. 
     */
    public DBServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig cg = getServletConfig();
		// read init parm values from web.xml
		String s1 = cg.getInitParameter("driver");
		String s2 = cg.getInitParameter("dburl");
		String s3 = cg.getInitParameter("dbuser");
		String s4 = cg.getInitParameter("dbpwd");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int  no = Integer.parseInt(request.getParameter("teno"));
		System.out.print(no);
		try {
			Class.forName(s1);
			con = DriverManager.getConnection(s2, s3, s4);
			ps = con.prepareStatement("select empno, ename, job, sal from emp where empno = ?");
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pw.println("<br> Employee Number:"+rs.getInt(1));
				pw.println("<br> Employee Name:"+rs.getString(2));
				pw.println("<br> Employee Desg:"+rs.getString(3));
				pw.println("<br> Employee Salary:"+rs.getFloat(4));
			}
			else {
				pw.println(" Employee Not Found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() {
		try {
			if(ps!=null) {
				ps.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
