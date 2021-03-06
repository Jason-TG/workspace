

package com.newlecture.web.jsp0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();

		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String op = request.getParameter("operator");

		int x = 0;
		int y = 0;
		int result = 0;

		if (x_.equals("") || x_== null) 
			writer.println("숫자를 입력해주세요 <br/>");
		if (y_.equals("") || y_== null) 
			writer.println("숫자를 입력해주세요 <br/>");
		
		x = Integer.parseInt(x_);
		y = Integer.parseInt(y_);

		if (op.equals("덧셈"))
			result = x + y;
		else
			result = x - y;
	
		writer.printf("result is %d \n", result);
		
	} // service()
	
} // class Add
