

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


import javax.servlet.ServletConfig;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ConPoolServlet
 */
@WebServlet("/ConPoolServlet")
public class ConPoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConPoolServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter pw = null;
		String tabName = null;
		ResultSetMetaData rsmd = null;
		int colCnt = 0;
		//General settings
		pw = res.getWriter();
		// Set response content type
		res.setContentType("text/html");
		
		tabName = req.getParameter("table")
		// write JDBC code for remaning work
		try{
		 // get con object from JDBC con pool
		 con = makeConnection();
		 // create Statement object
		 st = con.createStatement();
		 // send and execute SQL Query in DB software
		 rs = st.executeQuery("select * from " +tabName);
		 // get ResultsetMetaData
		 rsmd = rs.getMetaData();
		 // print col names
		 colCnt = rsmd.getColumnCount();
		 pw.println("<table border='1' bgcolor = 'red'");
		 pw.println("<tr bgcolor='cyan'>");
		 for(int i=1; i<=colCnt; ++i){
			pw.println("<th>"+rsmd.getColumnLabel(i)+"</th");
		 }
		 pw.println("</tr>");
		 //process the ResultSet
		 while(res.next()){

		 }	 
					
					
					
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
