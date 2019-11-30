package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String income = request.getParameter("income");
		String tax = request.getParameter("tax");
		Cookie[] ck = request.getCookies();
		String name = null, fname = null;
		if(ck!=null) {
			name = ck[0].getValue();
			fname = ck[1].getValue();
		}
		try {
			Class.forName("oracle.JDBC.driver.OracleDriver");
			Connection con = DriverManager.getConnection("JDBC:oracle:thin:@localhost:1521:xe","system","123456");
			PreparedStatement ps = con.prepareStatement("insert into tax_tab values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, fname);
			ps.setString(3, income);
			ps.setString(4, tax);
			int result = ps.executeUpdate();
			if(result == 1) {
				out.println("<br> Record inserted.....");
			}
			else {
				out.println("<br> Record not inserted....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		out.println("Form2 data"+income+"....."+tax+"</br>");
		out.println("Form1 data"+name+"......"+fname+"<br/>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
