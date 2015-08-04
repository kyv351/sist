package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/imkgy")
public class Nana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nana() {
       // super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String _cnt = request.getParameter("cnt");
		int cnt = 10;
		
		if(_cnt !=null && !_cnt.isEmpty())
			cnt = Integer.parseInt(_cnt);			
				
		PrintWriter out = response.getWriter();
		//for(int i=0; i<cnt; i++)
		//	out.println("³ª¾ß : Hello Servlet<br/>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		int result = 0;
		
		if(_x!= null && !_x.isEmpty())
			x = Integer.parseInt(_x);
			
		if(_y!= null && !_y.isEmpty())
			y = Integer.parseInt(_y);
		
		result = x + y;
		
		PrintWriter out = response.getWriter();
		
		
		out.write("<form action=\"imkgy\" method=\"post\">");
		out.write("<li><label for =\"x\"> X: </label><input name=\"x\"/></li>");
		out.write("<li><label for =\"y\"> Y: </label><input name=\"y\"/></li>");
		out.write("</ul>");
		out.write("<p><input type=\"submit\" value=\"µ¡¼À\"/>&nbsp&nbsp");
		out.write("<input type=\"submit\" value=\"Application\"/>&nbsp&nbsp");
		out.write("<input type=\"submit\" value=\"Session\"/>&nbsp&nbsp");
		out.write("<input type=\"submit\" value=\"Cookie\"/></p>");
		out.write("</form>");
			
		
		out.println("µ¡¼À °á°ú´Â  " + result + "</br>");
		out.println("<a href=\"add\"> µ¹¾Æ°¡±â </a>");
		
		
		
	}

}
