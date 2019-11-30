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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
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
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String age = request.getParameter("age");
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("address", address);
		session.setAttribute("age", age);
		pw.println("<body bgcolor='cyan'>");
		pw.println("<center><h1><font color='red'> Provide your Exp & Skill </font></h1></center>");
		pw.println("<form action='surl' method='post'>");
		pw.println("<table align='center'>");
		pw.println("<tr><td> <h2> <font color='blue'> Enter Number of years Exp: </font> </h2>");
		pw.println("<input type='text' name='exp' size='6'> </td> </tr>");
		pw.println("<tr><td> <h2> <font color='blue'><b> select skills </b> </font> </h2>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<select name='skill'>");
		pw.println("<option value='java'> Java</option>");
		pw.println("<option value='net'> .Net</option>");
		pw.println("<option value='ruby'> Ruby</option>");
		pw.println("<option value='oracle'> Oracle</option>");
		pw.println("<option value='xml'> XML</option>");
		pw.println("</select>");
		pw.println("</td></tr>");
		
		pw.println("<tr><td><input type='submit' value='Continue'>");
		pw.println("</td></tr>");
		pw.println("</table> </body>");
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
