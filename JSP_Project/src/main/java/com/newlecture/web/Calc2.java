

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext application = request.getServletContext();
//		어플리케이션 저장소 객체 생성
//		어플리케이션 저장소는 모든 Sevlet 파일에 대한 전역적인 저장소 역할을 한다.  
		
		HttpSession session = request.getSession();
//		세션 객체 생성
//		세션은 현재 접속한 사용자에게만 할당되는 저장소이다. 
		
		
		PrintWriter writer = response.getWriter();

		String v_ = request.getParameter("numVal");
		String op_ = request.getParameter("operator");

		int v = 0; // v_에 null이 들어왔을 때를 대비한 v 값 초기화.
		if (v_.equals("") || v_== null) 	writer.println("숫자를 입력해주세요 <br/>");
		else v = Integer.parseInt(v_); // 계산할 숫자 파싱
		
//		계산
		if (op_.equals("=")) {
			
//			int x = (Integer)application.getAttribute("firstVal");
			int x = (Integer)session.getAttribute("firstVal");
			int y = v;
//			String operator = (String) application.getAttribute("firstOp");
			String operator = (String) session.getAttribute("firstOp");
			int result = 0;
			
			if (operator.equals("+"))
				result = x + y;
			else if (operator.equals("-"))
				result = x - y;
			else 
				writer.print("오류 발생");
			
			writer.printf("result is %d \n", result);
		}
			
//		밸류값 저장
		else {	
//			application.setAttribute("firstVal", v);
//			application.setAttribute("firstOp", op_);
			session.setAttribute("firstVal", v);
			session.setAttribute("firstOp", op_);
		}
		
	} // service()
	
} // class Add














