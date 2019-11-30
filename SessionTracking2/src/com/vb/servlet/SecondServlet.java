package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("hname");
		String fname = request.getParameter("hfname");
		String ms = request.getParameter("hms");
		String f2val1 = request.getParameter("f2t1");
		String f2val2 = request.getParameter("f2t2");
		try {
			Class.forName("oracle.JDBC.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123456");
			PreparedStatement ps = con.prepareStatement("insert into person_tab values(?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, fname);
			ps.setString(3, ms);
			ps.setString(4, f2val1);
			ps.setString(5, f2val2);
			int result = ps.executeUpdate();
			if(result ==1) {
				pw.println("<br> Record Inserted.... ");
			}
			else {
				pw.println("<br> Record not Inserted....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		pw.println("<br> form1 data is"+ name +"..." + fname +"..." + ms);
		pw.println("<br> form2 data is:" + f2val1 +"...." + f2val2);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
