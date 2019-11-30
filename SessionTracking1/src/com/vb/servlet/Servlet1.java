package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("pname");
		String age = request.getParameter("page");
		String mstatus = request.getParameter("ms");
		
		if(mstatus == null) {
			mstatus = "single";
		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		if(mstatus.equals("married")) {
			pw.println("<form action='s2url' method='post'>");
			pw.println("<b> SpouseName: </b> <input type='text' name='st1'> <br>");
			pw.println("<b> No.of Children: </b> <input type='text' name='st2'> <br>");
			pw.println("<input type='submit' value='Submit'>");
			pw.println("</form>");
			
		}
		else {
			pw.println("<form action='s2url' method='post'>");
			pw.println("<b> When do you want marry: </b> <input type='text' name='st1'> <br>");
			pw.println("<b> why do you want marry: </b> <input type='text' name='st2'> <br>");
			pw.println("<input type='submit' value='Submit'>");
			pw.println("</form>");
			
		}
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
