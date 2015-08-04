package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;


/*@WebServlet("/customer/notice")*/
public class NoticeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDao noticeDao = new MyBatisNoticeDao();
	 	List<Notice> list = noticeDao.getNotices();
	 	
	 	request.setAttribute("list", list);
	 	
	 	//
	 	/*NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
	 	List<NoticeFile> nflist = noticeFileDao.getNoticeFiles();
	 	
	 	request.setAttribute("nflist", nflist);*/
	 	
	 	
	 	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
	 	dispatcher.forward(request, response);
	}
	
	

}
