package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	������
 * 		pageContext:��ǰҳ������Ч��
 * 		request:������������Ч�������һ������Ĳ�ͬServlet�����ݹ������⡣
 * 		session�����λỰ����Ч�������һ���û��Ĳ�ͬ��������ݹ������⡣
 * 		application:һ����Ŀֻ��һ��������λ�û�ȡ�Ķ���ͬһ����������ǲ�ͬ�û������ݹ������⡣
 * */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//������������ʽ
			req.setCharacterEncoding("utf-8");
		//������Ӧ�����ʽ
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//��ȡ������Ϣ
			//��ȡ��������Ϣ
			//��ȡ�û���������
			String name=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			System.out.println(name+":"+pwd);
		//����������Ϣ
			//ҵ���߼�����
			if("����".equals(name) && "123".equals(pwd)){
				//ʵ���������½
					//����Cookie��Ϣ
					Cookie c=new Cookie("num", "20170926");
					c.setMaxAge(3600*3*24);//����cookie��Ч��
					c.setPath("/servlet/cookie");
					//��ӦCookie��Ϣ
					resp.addCookie(c);
				//��Ӧ������
				//����ת��(�����ݴ洢����������)
					//����������Ϣ�洢����������
					req.setAttribute("name",name);
					req.getRequestDispatcher("main.jsp").forward(req, resp);
			}else{//�û����������벻��
				//����������ʾ��
				req.setAttribute("str", "�û��������������");
				//����ת����¼ҳ��
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}
			
	}
	
}
