package com.newlecture.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class MyBatisMemberDao implements MemberDao {
	
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	
	@Autowired
	SqlSession session;

	@Override
	public Member getMember(String uid) {
		// TODO Auto-generated method stub
		//SqlSession session = factory.openSession(); 

		Member m = session.selectOne("com.newlecture.web.dao.MemberDao.getMember", uid);
					
		//session.close();
		return m;
	}
	
	

}
