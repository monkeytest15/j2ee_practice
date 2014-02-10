package com.asm.hibernate.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.asm.hibernate.domain.Name;
import com.asm.hibernate.domain.People;
import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;
import com.asm.hibernate.utils.HibernateUtilSelf;

public class HibernateCacheTest2 {
	public static void main(String[] args) {
		addUser1();
		//getUser(1);
		Statistics st = HibernateUtilSelf.getSessionFactory().getStatistics();
		System.out.println(st);
		System.out.println("put:" + st.getSecondLevelCachePutCount());
		System.out.println("hit:" + st.getSecondLevelCacheHitCount());
		System.out.println("miss:" + st.getSecondLevelCacheMissCount());

	}

	static People getUser(int id) {
		Session s = null;
		People user = null;
		Transaction ts = null;
		try {
			s = HibernateUtilSelf.getThreadLocalSession();
			ts = s.beginTransaction();
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
			//if (s != null)
			//	s.close();
		}

		// �������session�رպ�������ٻ�ȡǰ���ѯ�����ݣ��������²�⡣
		try {
			s = HibernateUtilSelf.getThreadLocalSession();
			ts = s.beginTransaction();
			
			user = (People) s.get(People.class, id);
			System.out.println("userName:" + user.getName());
			ts.commit();
		} finally {
//			if (s != null)
//				s.close();
		}
		return user;
	}

	
	
	static void addUser1() {
		Session s = null;
		Transaction ts = null;
		try {
			s = HibernateUtilSelf.getThreadLocalSession();
			ts = s.beginTransaction();
			People user = new People();
			Name name= new Name();
			name.setFirstName("ryan");
			name.setSecondName("Zhang");
			user.setName(name);
			s.save(user);
			s.flush();
			s = HibernateUtilSelf.getThreadLocalSession();
			ts = s.beginTransaction();
			
			
			// session���棬��sessionδ�ر�ʱ���ٲ�ѯֱ�Ӵӻ����л�����ݡ�
			user = (People) s.get(People.class, 1);
			System.out.println("userName:" + user.getName().getFirstName());

			// �������������棬�ٲ�ѯʱ�����������⡣
			s.evict(user);// ���ָ��������
			// s.clear();//�����ǰsession�����е���������
			user = (People) s.get(People.class, 1);
			System.out.println("userName:" + user.getName().getFirstName());
			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			throw e;
		} finally {
			if (s != null)
				// s.close(); //ע�����ﲻ��ʹ��close,��ע������Ĵ�ӡ���
				System.out.println("s=" + s);
		}
	}
}
