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

public class MyBatisNoticeFileDao implements NoticeFileDao {
	
	private SqlSession session;	
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public int addNoticeFile(NoticeFile nf) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession();//true면 auto commit
		
		int result = 0;
		
		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
		result = dao.addNoticeFile(nf);
		
		/*try{
			NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
			result = dao.addNoticeFile(nf);
			session.commit();
		}
		finally{
			
			session.close();
		}*/
		return result;
	}
	
	@Override
	public List<NoticeFile> getNoticeFilesofNotice(String code) {
		// TODO Auto-generated method stub
		/*List<NoticeFile> list = new ArrayList<NoticeFile>();
		NoticeFile file = new NoticeFile();
		file.setName(code + "파일1");
		list.add(file);
		
		file = new NoticeFile();
		file.setName(code+"파일2");
		list.add(file);*/
		
		NoticeFileDao dao = (NoticeFileDao)session.getMapper(NoticeFileDao.class);
		List<NoticeFile> list = dao.getNoticeFilesofNotice(code);
		//session.close();
		
		return list;
	}
	
	@Override
	public NoticeFile getNoticeFile(String code) {
		// TODO Auto-generated method stub
		NoticeFileDao noticeFileDao = session.getMapper(NoticeFileDao.class);

		NoticeFile nf = session.selectOne("com.newlecture.web.dao.NoticeFileDao.getNoticeFile", code);					
		//session.close();		
		return nf;
		
		//return noticeFileDao.getNoticeFile(code);
	}

	/*@Override
	public NoticeFile getNoticeFile(String code) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession(); 

		NoticeFile nf = session.selectOne("com.newlecture.web.dao.NoticeFileDao.getNoticeFile", code);
					
		session.close();
		return nf;
	}

	@Override
	public List<NoticeFile> getNoticeFiles() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
		
		return dao.getNoticeFiles();
	}*/

	
	


}
