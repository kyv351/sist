package com.newlecture.web.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

@Controller
@RequestMapping("/customer/*")//homeDirectory
public class CustomerController {
	
	private NoticeDao noticeDao;
	private NoticeFileDao noticeFileDao;

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@RequestMapping("notice") //url이름.url mapping
	public String notice(Model model){
		
		//NoticeDao noticeDao = new MyBatisNoticeDao();
	 	List<Notice> list = noticeDao.getNotices();
	 	
	 	model.addAttribute("list", list);	 	
	 		 	
	 	//ModelAndView mv = new ModelAndView();
	 	//mv.setViewName("/WEB-INF/view/customer/notice.jsp");
	 	//mv.addObject("list", list);
	 	
	 	return "customer.notice";
		//return "/WEB-INF/view/customer/notice.jsp";
		
	}
	
	//GET과 POST를 구분하지 않은 것이다
	//c가 request.getParameter("c")를 나타낸다. 전달할 파라미터 그대로 인자로 전해준다
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model){
		//값을 넘겨줄 변수. c=? -> String c
		//NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice n = noticeDao.getNotice(c);
		
		model.addAttribute("n", n);
		
			
		model.addAttribute("nf", noticeFileDao.getNoticeFile(c));
		
		return "customer.noticeDetail";
		
	}
	
	//GET요청
	@RequestMapping(value="noticeReg",method=RequestMethod.GET)
	public String noticeReg(){
		
		return "customer.noticeReg"; //forward
		
	}
	
	//POST요청
	@RequestMapping(value="noticeReg",method=RequestMethod.POST)
	public String noticeReg(Notice n,MultipartFile file,Principal principal, HttpServletRequest request, SecurityContext securityContext) throws IOException{
		
		//Part part = request.getPart("file");
		
		if(request.isUserInRole("ROLE_ADMIN")){
			
			
		}
	/*	securityContext.getAuthentication().getAuthorities();
		securityContext.getAuthentication().isAuthenticated();*/
		
		n.setWriter(principal.getName());
		noticeDao.addNotice(n);
 		String lastcode = noticeDao.getLastCode();
		
		if(!file.isEmpty()){
			ServletContext application = request.getServletContext();
 
			String url = "/resource/customer/upload";
			String path = application.getRealPath(url);
			String temp =  file.getOriginalFilename();
			String fname=temp.substring(temp.lastIndexOf("\\")+1);
			String fpath = path +"\\" +fname;	 
 		
			InputStream ins = file.getInputStream(); // part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath);
 		
 		
			byte[] buffer = new byte[1024];
 		
			int len = 0;
 		
			while((len = ins.read(buffer,0,1024))>=0)
				outs.write(buffer, 0, len);
 		
			outs.flush();
			outs.close();
			ins.close();
 		
			NoticeFile noticeFile = new NoticeFile();
				noticeFile.setName(fname);
				noticeFile.setNoticeCode(lastcode);
				noticeFileDao.addNoticeFile(noticeFile);
		}
 		
 
 		

 	/*	String title = request.getParameter("title");
 		//String file = request.getParameter("file");
 		String content = request.getParameter("content");

 		Notice notice = new Notice();
 		
 		notice.setTitle(title);
 		notice.setWriter("newlec");
 		notice.setContent(content);
 		
 		//NoticeDao noticeDao = new MyBatisNoticeDao();
 		noticeDao.addNotice(notice);
 		
 		NoticeFile noticeFile = new NoticeFile();
 		noticeFile.setName(fname);
 		noticeFile.setNoticeCode(noticeDao.getLastCode());
 		 
 		// NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
 		 noticeFileDao.addNoticeFile(noticeFile);*/
		
		//return "redirect:notice";
		return "customer.notice";//redirect
		
	}
	
	
	
	

}
