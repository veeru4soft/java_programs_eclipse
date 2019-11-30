package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.*;
/**
 * Servlet implementation class FormServlet
 */
//@WebServlet("/FormServlet")
@WebServlet(name="f1", value="/formurl", 
initParams=@WebInitParam(name="dbuser",value="scott")
)
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FormServlet() {
        // TODO Auto-generated constructor stub
    	System.out.println("FormServlet: 0-param constructor");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String user = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		if(user.equals("raja") && pwd.equals("rani")) {
			pw.println("<h1 style='coor:green'> Valid Credentials </h1> ");
		}
		else {
			pw.println("<h1 style='coor:red'> InValid Credentials </h1> ");
		}
		pw.println("<a href='input.html'> Home </a>");
		ServletConfig cg = getServletConfig();
		pw.println("DB user init param value"+ cg.getInitParameter("dbuser"));
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
