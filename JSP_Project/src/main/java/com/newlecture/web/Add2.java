

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();

		String[] num_ = request.getParameterValues("num");

		int result = 0;

		for (int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result += num;
//			반복문 안에서 변수를 선언하면 지역변수로 처음 한 번만 선언된다. 
		}
		
		writer.printf("result is %d \n", result);
		
	} // service()
	
} // class Add





