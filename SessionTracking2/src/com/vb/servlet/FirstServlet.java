package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String pname = request.getParameter("tname");
		String pfname = request.getParameter("tfname");
		String pms = request.getParameter("ms");
		if(pms.equals("single")) {
			pw.println("<form action='surl' method='post'>");
			pw.println("<b> When do you want marry: </b> <input type='text' name='f2t1'> <br>");
			pw.println("<b> why do you want marry: </b> <input type='text' name='f2t2'> <br>");
			pw.println("<input type='hidden' name='hname'value="+pname+">");
			pw.println("<input type='hidden' name='hfname'value="+pfname+">");
			pw.println("<input type='hidden' name='hms'value="+pms+">");
			pw.println("<input type='submit' value='Submit'>");
			pw.println("</form>");
		}
		else {
			pw.println("<form action='surl' method='post'>");
			pw.println("<b> SpouseName: </b> <input type='text' name='f2t1'> <br>");
			pw.println("<b> No.of Children: </b> <input type='text' name='f2t2'> <br>");
			pw.println("<input type='hidden' name='hname'value="+pname+">");
			pw.println("<input type='hidden' name='hfname'value="+pfname+">");
			pw.println("<input type='hidden' name='hms'value="+pms+">");
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
