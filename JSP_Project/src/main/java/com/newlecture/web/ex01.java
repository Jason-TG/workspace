package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01")
public class ex01 extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) 
		throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		for (int i = 0; i<100; i++) {
			out.println((i+1) + " �ȳ� Servlet!! ");
		}
			
		
	}

}
