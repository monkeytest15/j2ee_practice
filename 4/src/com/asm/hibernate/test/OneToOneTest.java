package com.asm.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.IdCard;
import com.asm.hibernate.domain.User;
import com.asm.hibernate.utils.HibernateUtil;

public class OneToOneTest {
	public static void main(String[] args) {
		add();
		query(1);
		System.out.println(" qry 2 start....");
		query2(1);
	}

	static void add() {
		Session s = null;
		Transaction tr = null;
		try {
			s = HibernateUtil.getSession();
			tr = s.beginTransaction();

			User person = new User();
			person.setName("pName");
			IdCard idCard = new IdCard();
			idCard.setValidity(new Date());

			// �ֱ�ע�͵��������䣬������ִ�����
			person.setIdCard(idCard);
			idCard.setPerson(person);

			s.save(person);
			s.save(idCard);
			tr.commit();
		} finally {
			if (s != null)
				s.close();
		}
	}
	
	static User query(int id) {
		Session s = null;
		Transaction tr = null;
		try {
			s = HibernateUtil.getSession();
			tr = s.beginTransaction();
			User p = (User) s.get(User.class, id);
			System.out.println("���֤��Ч��:" + p.getIdCard().getValidity());
			tr.commit();
			return p;
		} finally {
			if (s != null)
				s.close();
		}
	}  

	
	static IdCard query2(int id) {
		Session s = null;
		Transaction tr = null;
		try {
			s = HibernateUtil.getSession();
			tr = s.beginTransaction();
			IdCard idCard = (IdCard) s.get(IdCard.class, id);
			System.out.println("�˵����֣�" + idCard.getPerson().getName());
			//ȥ����һ��ע�ͺ󣬷��ֻ��ѯ���Ρ�
			tr.commit();
			return idCard;
		} finally {
			if (s != null)
				s.close();
		}
	}

}
