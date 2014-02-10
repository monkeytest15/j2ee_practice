package com.asm.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import com.asm.hibernate.domain.Department;
import com.asm.hibernate.domain.Employee;
import com.asm.hibernate.utils.HibernateUtil;

public class ManyToOneTest {   
    public static void main(String[] args) {   
        add();   
       Employee emp =  query(1);
       // Employee emp = query2(1);
        System.out.println(emp.getDepart().getName());

    }   
    static void add() {   
        Session s = null;   
        Transaction tx = null;   
        try {   
            Department depart = new Department();   
            depart.setName("departName");   
            Employee emp = new Employee();   
            emp.setName("empName");   
            emp.setDepart(depart);   
  
            s = HibernateUtil.getSession();   
            tx = s.beginTransaction();   
          
            s.save(depart);   
            s.save(emp);   
       
        // �������������λ�ã���Hibernateִ�е�sql��䡣��������һ�����²�����   
            tx.commit();   
        } finally {   
            if (s != null)   
                s.close();   
        }   
    }   
    
    static Employee query(int empId) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Employee emp = (Employee) s.get(Employee.class, empId);
			System.out.println("Department Name:" + emp.getDepart().getName());
			return emp;
		} finally {
			if (s != null)
				s.close();
		}
	}

    static Employee query2(int empId) {
		Session s = null;
		try {
			s = HibernateUtil.getSession();
			Employee emp = (Employee) s.get(Employee.class, empId);
			Hibernate.initialize(emp.getDepart()); 
			//��һ�����ú������˵�������������˽�
			return emp;
		} finally {
			if (s != null)
				s.close();
		}
	}

}  