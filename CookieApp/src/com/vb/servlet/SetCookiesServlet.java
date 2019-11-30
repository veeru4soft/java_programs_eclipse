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
 * Servlet implementation class SetCookiesServlet
 */
@WebServlet("/SetCookiesServlet")
public class SetCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Cookie cookie1, cookie2, cookie3, cookie4;
		cookie1 = new Cookie("ap", "amaravathi");
		cookie2 = new Cookie("ts", "hyderabad");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		cookie3 = new Cookie("kr", "Bangalore");
		cookie4 = new Cookie("mh", "Mumbai");
		cookie3.setMaxAge(3600);
		cookie4.setMaxAge(3600);
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("Successful in setting cookies");
		System.out.println("Successful in setting in cookies.....");
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
