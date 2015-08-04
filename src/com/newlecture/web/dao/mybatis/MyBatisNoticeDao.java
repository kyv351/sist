package com.newlecture.web.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;


public class MyBatisNoticeDao implements NoticeDao {
	
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	
	private SqlSession session;
	
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		
		List <Notice> list = dao.getNotices(page, field, query);
		
		for(Notice n : list)
			n.setFiles(fileDao.getNoticeFilesofNotice(n.getCode()));
		
		return list;
	}

	@Override
	public Notice getNotice(String code) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession(); 

		/*Notice n = session.selectOne("com.newlecture.web.dao.NoticeDao.getNotice", code);
					
		session.close();
		return n;*/
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.getNotice(code);
		
	}

	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return getNotices(page, "TITLE", "");
	}

	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return getNotices(1, "TITLE", "");
	}

	@Override
	public int addNotice(Notice n) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();//true¸é auto commit
		
		int result = 0;
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		result = dao.addNotice(n);
		
		/*try{
			NoticeDao dao = session.getMapper(NoticeDao.class);
			result = dao.addNotice(n);
			session.commit();
		}
		finally{
			
			session.close();
		}*/
		return result;
	}

	@Override
	public String getLastCode() {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.getLastCode();
	}


}
