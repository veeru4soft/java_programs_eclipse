package com.vb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UplServlet
 */
@WebServlet("/UplServlet")
public class UplServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UplServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter pw = null;
//		MultipartFormData = null;
		UploadBean bean = null;
		Hashtable ht = null;
		Enumeration e = null;
		pw = response.getWriter();
		response.setContentType("text/html");
		try {
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(request);
			UploadBean upb = new UploadBean();
			upb.setFolderstore("c:/store");
			upb.setOverwrite(false);
			upb.store(nreq);
			pw.println("<h1> The uploaded files are </h1>");
			ht = nreq.getFiles();
			e = ht.elements();
			while(e.hasMoreElements()) {
				UploadFile file = (UploadFile)e.nextElement();
				pw.println("<br>" + file.getFileName()+" " +file.getFileSize());
			}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
}
