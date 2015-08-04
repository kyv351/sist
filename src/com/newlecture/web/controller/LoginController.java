package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mybatis.MyBatisMemberDao;

/*@WebServlet("/joinus/login")*/
public class LoginController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		if(request.getMethod().equals("POST")){
			
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			MemberDao memberDao = new MyBatisMemberDao();
			
			if(memberDao.getMember(uid)==null){
				request.setAttribute("error", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
				
				//response.getWriter().print("<script>alert('���� ���̵��Դϴ�.');history.go(-1);</script>");
			} 			
			else if(!pwd.equals(memberDao.getMember(uid).getPwd())){
				request.setAttribute("error", "���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
				dispatcher.forward(request, response);
			
				//response.getWriter().print("<script>alert('��й�ȣ�� �ٽ� Ȯ�����ּ���.');history.go(-1);</script>"); 
			}
			else{
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);
				response.sendRedirect("../customer/notice");
			}
		}
		
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/joinus/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
