package com.vb.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DownloadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext sc = null;
		File file = null;
		String path = null;
		long length = 0;
		String mimeType = null;
		InputStream is = null;
		ServletOutputStream sos = null;
		byte[] buffer = new byte[4096];
		int bytesRead = 0;
		sc = getServletContext();
		path = sc.getRealPath("/james.png");
		file = new File(path);
		length = file.length();
		response.setContentLengthLong(length);
		mimeType = sc.getMimeType("/james.png");
		response.setContentType(mimeType);
		response.setHeader("content-disposition", "attachment;fileName=james.png");
		is = sc.getResourceAsStream("/james.png");
		sos = response.getOutputStream();
		while((bytesRead=is.read(buffer)) !=-1) {
			sos.write(buffer, 0, bytesRead);
		}
		is.close();
		sos.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
