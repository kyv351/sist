package com.newlecture.web.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/*@WebServlet("/customer/download")*/
public class DownloadController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		
		String fname = request.getParameter("f");
		response.setHeader("Content-Disposition", "attachment;filename="+fname);
		response.setContentType("application/octet-stream");
			
 		//실제 경로
 		ServletContext application = request.getServletContext();
 		String url = "/customer/upload";
 		String path = application.getRealPath(url);
 		String fpath = path +"\\" +fname;
 		//response.getWriter().println(fpath);	 
 		OutputStream outs = response.getOutputStream();
 		InputStream ins = new FileInputStream(fpath);
 				
 		
 		byte[] buffer = new byte[1024];
 		
 		int len = 0;
 		
 		while((len = ins.read(buffer,0,1024))>=0)
 			outs.write(buffer, 0, len);
 		
 		outs.flush();
 		outs.close();
 		ins.close();
		
		
		
	}

}
