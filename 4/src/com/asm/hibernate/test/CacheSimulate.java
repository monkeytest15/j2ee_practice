package com.asm.hibernate.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;

public class CacheSimulate {
	static Map cache = new HashMap();

	public static void main(String[] args) {
		addUser();
		// ��һ�β�ѯ����ȥ�������ݿ��ѯ
		User u1 = getUser(1);
		// �ڶ��β�ѯ��ֱ�Ӵ�Map cache��ȡ
		User u2 = getUser(1);
		// �����β�ѯ��ͬ����cache��ֱ��ȡ
		User u3 = getUser(1);
	}

	static User getUser(int id) {
		String key = User.class.getName() + id;
		User user = (User) cache.get(key);
		if (user != null)
			return user;
		user = getUserFromDB(id);
		cache.put(key, user);
		return user;
	}

	static void addUser() {
		Session s = null;
		Transaction ts = null;
		try {
			User user = new User();
			user.setName("jack");
			user.setDate(new Date());
			s = HibernateUtil.getSession();
			ts = s.beginTransaction();
			s.save(user);
			user.setName("jack_new");
			s.save(user);
			ts.commit();
		} catch (HibernateException e) {
			if (ts != null)
				ts.rollback();
			throw e;
		} finally {
			if (s != null)
				s.close();
		}
	}
	
	static User getUserFromDB(int id) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			User user =	(User) s.get(User.class, id);
	

			System.out.println("load--User:" + user.getClass());
			 user =	(User) s.get(User.class, id);
			 System.out.println("load--User:" + user.getClass());
			return user;
		} finally {
			if (s != null)
			s.close();
		}
	}
}
