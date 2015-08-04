package com.newlecture.web.aop;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;

public class Program {
	
	static{		
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		/*NoticeDao noticeDao = new MyBatisNoticeDao(); //ÁøÂ¥ ¿ÕÀÚ´Ô
		NoticeDao proxy = (NoticeDao)Proxy.newProxyInstance(
				noticeDao.getClass().getClassLoader(),
				noticeDao.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] arg2)
							throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("»çÀü");
						List<Notice> list = (List<Notice>) method.invoke(noticeDao, args);
						System.out.println("»çÈÄ");
						
						return list;
					}
				});
		
		List<Notice> list = proxy.getNotices();
		
		//List<Notice> list = noticeDao.getNotices();
		
		for(Notice n: list)
			System.out.printf("title: %s\n", n.getTitle());*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/aop/spring-context.xml");
		
		NoticeDao noticeDao = (NoticeDao) context.getBean("noticeDao");
		
		List<Notice> list = noticeDao.getNotices();
		Notice notice = noticeDao.getNotice("3");
		
		for(Notice n: list)
			System.out.printf("title: %s\n", n.getTitle());
	}

}
