package com.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    public Validator() {
        super();       
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	public void init (ServletConfig config){
		config.getInitParameter("time");
		System.out.println(" init ......"+config.getInitParameter("time"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setContentType()���������趨�ַ����룬���Ҫ��ʾ���ģ����Խ�charset�趨Ϊ
		// GB18030
		response.setContentType("text/html;charset= GB18030");
		PrintWriter out = response.getWriter();
		//ʹ��request. getParameter()������ȡ���е�ֵ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��֤ҳ��</TITLE></HEAD>");
		out.println("  <BODY>");
		//�ж��û��Ƿ���д�û���������
		if(username.length()<1||password.length()<1)
		{
			out.println("�����������û��������룬<a href='./login.jsp'>����˴�����</a>");
		//�ж��û����Ƿ���hacker������ǣ�����ʾ��ֹ����ҳ�����Ϣ
		}
		else if(username.equalsIgnoreCase("hacker"))
		{
			out.println("�ܱ�Ǹ������ֹ��¼��ҳ��<a href='./login.jsp'>����˴�����</a>");
		//ͨ����֤�����ʾ������¼��ҳ����ת��welcome.jspҳ��
		}
		else
		{
			request.setAttribute("username", "test");
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			//response.sendRedirect("./welcome.jsp?username="+username);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	
	@Override
	public void destroy() {
		
		super.destroy();
		System.out.println(" destory");
	}
}
