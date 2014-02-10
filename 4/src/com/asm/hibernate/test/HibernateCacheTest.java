package com.asm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import com.asm.hibernate.domain.People;
import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;

public class HibernateCacheTest {
	public static void main(String[] args) {
		addUser();
		getUser(1);
		
		Statistics st = HibernateUtil.getSessionFactory().getStatistics();
		System.out.println(st);
		System.out.println("put:" + st.getSecondLevelCachePutCount());
		System.out.println("hit:" + st.getSecondLevelCacheHitCount());
		System.out.println("miss:" + st.getSecondLevelCacheMissCount());
	}

	static User getUser(int id) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			// session���棬��sessionδ�ر�ʱ���ٲ�ѯֱ�Ӵӻ����л�����ݡ�
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
			
			
			// �������������棬�ٲ�ѯʱ�����������⡣
			s.evict(user);// ���ָ��������
			// s.clear();//�����ǰsession�����е���������
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}

		// �������session�رպ�������ٻ�ȡǰ���ѯ�����ݣ��������²�⡣
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}

	static User deleteUser(int id) {
		Session s = null;
		User user = null;
		try {
			s = HibernateUtil.getSession();
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			// session���棬��sessionδ�ر�ʱ���ٲ�ѯֱ�Ӵӻ����л�����ݡ�
			user = (User) s.get(User.class, id);
			System.out.println("userName:" + user.getName());

			s.delete(user);
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}
	static void addUser() {
		User user = new User();
		user.setName("genName");
		HibernateUtil.save(user);
	}
}
