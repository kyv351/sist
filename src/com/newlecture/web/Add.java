package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Nana
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
       // super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int x = 0;
		int y = 0;
		
		int result = 0;
		
		String _result = request.getParameter("result");
		
		if(_result !=null)
			result = Integer.parseInt(_result);
		
		if(request.getMethod().equals("POST")){
			
			
			String _btn = request.getParameter("btn");
			
			
			if(_btn.equals("Application")){
				ServletContext application = request.getServletContext();
				application.setAttribute("a", result);
				out.write("<p>application에 저장 완료</p>");
				
			}else if(_btn.equals("Session")){
				HttpSession session = request.getSession();
				session.setAttribute("s", result);
				out.write("<p>Session에 저장 완료</p>");
				
			}else if(_btn.equals("Cookie")){ // 쿠키 저장
				Cookie cookie = new Cookie("c", String.valueOf(result));
				//cookie.setMaxAge(24*60*60); // 24시간
				cookie.setMaxAge(24*60*60); // 24시간
				response.addCookie(cookie); // response에 쿠키를 요청한다??
				
				out.write("<p>Cookie에 저장 완료</p>");
				
			} else{
			
			String _x = request.getParameter("x");
			String _y = request.getParameter("y");
		
		
			if(_x!= null && !_x.isEmpty())
				x = Integer.parseInt(_x);
			
			if(_y!= null && !_y.isEmpty())
				y = Integer.parseInt(_y);
			
			
			result = x + y;
			}
		}
		
		
		
		
		
		out.write("<form action=\"add\" method=\"post\">");
		out.write("<li><label for =\"x\"> X: </label><input name=\"x\"/></li>");
		out.write("<li><label for =\"y\"> Y: </label><input name=\"y\"/></li>");
		out.write("</ul>");
		out.printf("<input type=\"hidden\" name=\"result\" value=\"%d\"/>", result);
		out.write("<p><input type=\"submit\" name=\"btn\" value=\"덧셈\"/> &nbsp&nbsp");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Application\"/>&nbsp&nbsp");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Session\"/>&nbsp&nbsp");
		out.write("<input type=\"submit\" name=\"btn\" value=\"Cookie\"/></p>");
		out.write("</form>");
		
			
		
		out.println("덧셈 결과는" + result + "<br />");
		out.println("<a href=\"MyPage\"> 마이페이지 </a>");
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		service(request,response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		service(request,response);
		
		
		
	}

}
