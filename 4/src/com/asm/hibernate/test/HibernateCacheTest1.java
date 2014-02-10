package com.asm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.stat.Statistics;

import com.asm.hibernate.domain.Name;
import com.asm.hibernate.domain.People;
import com.asm.hibernate.utils.HibernateUtil;

public class HibernateCacheTest1 {
	public static void main(String[] args) {
		addUser();
		getUser(1);
		Statistics st = HibernateUtil.getSessionFactory().getStatistics();
		System.out.println(st);
		System.out.println("put:" + st.getSecondLevelCachePutCount());
		System.out.println("hit:" + st.getSecondLevelCacheHitCount());
		System.out.println("miss:" + st.getSecondLevelCacheMissCount());

	}

	
	static People getUser(int id) {
		Session s = null;
		People user = null;
		try {
			s = HibernateUtil.getSession();
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());

			// session���棬��sessionδ�ر�ʱ���ٲ�ѯֱ�Ӵӻ����л�����ݡ�
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());

			// �������������棬�ٲ�ѯʱ�����������⡣
			s.evict(user);// ���ָ��������
			// s.clear();//�����ǰsession�����е���������
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());
			
		} finally {
			if (s != null)
				s.close();
		}

		// �������session�رպ�������ٻ�ȡǰ���ѯ�����ݣ��������²�⡣
		try {
			s = HibernateUtil.getSession();
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());
		} finally {
			if (s != null)
				s.close();
		}
		return user;
	}

	
	
	static void addUser() {
		People user = new People();
		Name name= new Name();
		name.setFirstName("ryan");
		name.setSecondName("Zhang");
		user.setName(name);
		HibernateUtil.save(user);
	}
}
