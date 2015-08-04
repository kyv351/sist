package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

public interface NoticeFileDao {
	
	/*public List<Notice> getNotices(int page, String field, String query);
	public List<Notice> getNotices(int page);
	public List<Notice> getNotices();
	public Notice getNotice(String code);
*/	
	public int addNoticeFile(NoticeFile nf);
	public List<NoticeFile> getNoticeFilesofNotice(String code);
	public NoticeFile getNoticeFile(String code);
	
	/*public NoticeFile getNoticeFile(String code);
	
	public List<NoticeFile> getNoticeFiles();*/
	
	

}
