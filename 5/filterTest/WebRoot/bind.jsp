<%@ page language="java" import="com.pusoft.train.Student" pageEncoding="GBK"%>
<% 
		Student student = new Student();
		out.println("ѧ�����䣺" + student.getAge() + "<br>");
		session.setAttribute("st", student);
		out.println("����session�󣬸�ѧ�����䣺" + student.getAge() + "<br>");
		session.removeAttribute("st");
		out.println("��sessionɾ������ѧ�����䣺" + student.getAge() + "<br>");
%>
