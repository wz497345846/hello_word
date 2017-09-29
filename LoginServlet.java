package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	作用域：
 * 		pageContext:当前页面内有效。
 * 		request:当次请求内有效，解决了一次请求的不同Servlet的数据共享问题。
 * 		session：当次会话内有效。解决的一个用户的不同请求的数据共享问题。
 * 		application:一个项目只有一个，任意位置获取的都是同一个。解决的是不同用户的数据共享问题。
 * */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
			req.setCharacterEncoding("utf-8");
		//设置相应编码格式
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
			//获取请求行信息
			//获取用户请求数据
			String name=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			System.out.println(name+":"+pwd);
		//处理请求信息
			//业务逻辑处理
			if("张三".equals(name) && "123".equals(pwd)){
				//实现三天免登陆
					//创建Cookie信息
					Cookie c=new Cookie("num", "20170926");
					c.setMaxAge(3600*3*24);//设置cookie有效期
					c.setPath("/servlet/cookie");
					//响应Cookie信息
					resp.addCookie(c);
				//响应处理结果
				//请求转发(将数据存储到作用域中)
					//将张三的信息存储到作用域中
					req.setAttribute("name",name);
					req.getRequestDispatcher("main.jsp").forward(req, resp);
			}else{//用户名或者密码不对
				//创建错误提示语
				req.setAttribute("str", "用户名或者密码错误");
				//请求转发登录页面
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				
			}
			
	}
	
}
