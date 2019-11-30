package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowCookiesServlet
 */
@WebServlet("/ShowCookiesServlet")
public class ShowCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCookiesServlet() {
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
		String title = "Active Cookies";
		out.println("<html> <head> <title>" + title);
		out.println("</title> </head> <body>");
		out.println("<table border=1 align='center'>");
		out.println("<tr> <td> Cookie Name </td>");
		out.println("<td> Cookie Value</td>");
		Cookie[] cks = request.getCookies();
		if(cks!=null) {
			for(Cookie ck:cks ) {
				out.println("<tr> <td>"+ ck.getName()+"</td> <td>"+ck.getValue()+"</td></tr>");
			}
			out.println("</table></body></html>");
		}
		else {
			System.out.println("No Cookies present.....");
			out.println("<b> <b> No cookies present.... </b></b>");
		}
		
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
