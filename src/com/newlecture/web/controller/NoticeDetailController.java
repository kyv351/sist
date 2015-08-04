package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

/*@WebServlet("/customer/noticeDetail")*/
public class NoticeDetailController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		if(session.getAttribute("uid")==null)
			response.sendRedirect("notice?error=1");
		
		
		
		NoticeDao noticeDao = new MyBatisNoticeDao();
		String code = request.getParameter("c");
		Notice n = noticeDao.getNotice(code);
		
		request.setAttribute("n",n);
		//
		/*NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
		String noticeCode=request.getParameter("f");
		NoticeFile nf = noticeFileDao.getNoticeFile(noticeCode); 	
	 	request.setAttribute("f", nf);*/

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeDetail.jsp");
	 	dispatcher.forward(request, response);
		
	}

}
