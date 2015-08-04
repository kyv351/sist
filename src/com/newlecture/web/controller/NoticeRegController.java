package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

/*@WebServlet("/customer/noticeReg")*/
@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5, //5메가
		maxRequestSize=1024*1024*5*5)//5메가 5개까지
public class NoticeRegController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	 	if(request.getMethod().equals("POST")){ //포스트 요청이라면
	 		
	 		Part part = request.getPart("file"); // 바이너리데이터 //저장할 디렉토리를 생각한다
	 		
	 		
	 		//실제 경로
	 		ServletContext application = request.getServletContext();
	 		String url = "/customer/upload";
	 		String path2 = application.getRealPath(url);
	 		String temp =  part.getSubmittedFileName();
	 		String fname=temp.substring(temp.lastIndexOf("\\")+1);
	 		String fpath = path2 +"\\" +fname;
	 		response.getWriter().println(fpath);	 
	 		InputStream ins = part.getInputStream();
	 		OutputStream outs = new FileOutputStream(fpath);
	 		
	 		
	 		/*String path = "D:\\IMAGES\\";
	 		String temp = part.getSubmittedFileName();
	 		String fname=temp.substring(temp.lastIndexOf("\\")+1);
	 		String fpath = path + fname;
	 		//response.getWriter().println(fpath);	 		
	 		InputStream ins = part.getInputStream();
	 		OutputStream outs = new FileOutputStream(fpath);*/
	 		
	 		byte[] buffer = new byte[1024];
	 		
	 		int len = 0;
	 		
	 		while((len = ins.read(buffer,0,1024))>=0)
	 			outs.write(buffer, 0, len);
	 		
	 		outs.flush();
	 		outs.close();
	 		ins.close();
	 		
	 		String title = request.getParameter("title");
	 		//String file = request.getParameter("file");
	 		String content = request.getParameter("content");

	 		Notice notice = new Notice();
	 		
	 		notice.setTitle(title);
	 		notice.setWriter("newlec");
	 		notice.setContent(content);
	 		
	 		NoticeDao noticeDao = new MyBatisNoticeDao();
	 		noticeDao.addNotice(notice);
	 		
	 		NoticeFile noticeFile = new NoticeFile();
	 		noticeFile.setName(fname);
	 		noticeFile.setNoticeCode(noticeDao.getLastCode());
	 		 
	 		 NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
	 		 noticeFileDao.addNoticeFile(noticeFile);
	 		
	 		response.sendRedirect("notice");//redirect는 controller를 요청하는 것이다
	 	}
	 	
	 	//notice?c=에서 notice는 서블릿명이다
	 	//forward는 notice.jsp
	 	else{
	 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
	 		dispatcher.forward(request, response);
	 	}
	}

}
