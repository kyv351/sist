package com.newlecture.web.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;

public class Notice {
	
	private String code;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int hit;
	//-----------
	private int cmtCount;
	private String writerName;
	
	private List<NoticeFile> files;
	
	
	public List<NoticeFile> getFiles() {
		return files;
	}
	public void setFiles(List<NoticeFile> files) {
		this.files = files;
	}
	
	/*public List<NoticeFile> getFiles(){
		NoticeFileDao fileDao = new MyBatisNoticeFileDao();
		
		return fileDao.getNoticeFilesofNotice(this.code);
		
	}*/
	
	
	public int getcmtCount() {
		return cmtCount;
	}
	public void setcmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	

}
