package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServet
 */
@WebServlet("/SecondServet")
public class SecondServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServet() {
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
		PrintWriter pw = response.getWriter();
		String exp = request.getParameter("exp");
		String skils = request.getParameter("skill");
		HttpSession session = request.getSession(true);
		session.setAttribute("exp", exp);
		session.setAttribute("skill", skill);
		
		pw.println("<body bgcolor='cyan'>")
		pw.println("<center><h1><font color='red'> Provide City & Salary </font></h1></center>");
		pw.println("<form action='turl' method='post'>");
		pw.println("<table align='center'>");
		pw.println("<tr><td> <h2> <font color='blue'> Enter Preference City:</font> </h2>");
		pw.println("")
		pw.println("</table>");
		pw.println("</form>");
		pw.println("</body>");
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
