
package com.newlecture.web.jsp0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

//		ServletContext application = request.getServletContext();
//		어플리케이션 저장소 객체 생성
//		어플리케이션 저장소는 모든 Sevlet 파일에 대한 전역적인 저장소 역할을 한다.  

		HttpSession session = request.getSession();
//		세션 객체 생성
//		세션은 현재 접속한 사용자에게만 할당되는 저장소이다. 

		PrintWriter writer = response.getWriter();

		String v_ = request.getParameter("numVal");
		String op_ = request.getParameter("operator");

		int v = 0; // v_에 null이 들어왔을 때를 대비한 v 값 초기화.
		if (v_.equals("") || v_ == null)
			writer.println("숫자를 입력해주세요 <br/>");
		else
			v = Integer.parseInt(v_); // 계산할 숫자 파싱

//		계산
		if (op_.equals("=")) {

//			int x = (Integer)application.getAttribute("firstVal");
//			  => 어플리케이션 저장소에 "firstVal"이라는 키값으로 저장한 밸류값을 Integer 타입으로 변환하여
//					int 타입 변수 x에 저장

			int x = (Integer)session.getAttribute("firstVal");
//			  => 세션 저장소에 "firstVal"이라는 키값으로 저장한 밸류값을 Integer 타입으로 변환하여
//					int 타입 변수 x에 저장

			int y = v;

//			String operator = (String) application.getAttribute("firstOp");
//			  => 어플리케이션 저장소에 "firstOp"라는 키값으로 저장한 밸류값을 String 타입으로 변환하여
//					String 타입 변수 operator에 저장. (String) : setAttribute로 저장 시 모든 값을 Object 타입으로 
//					변환하기 때문에 다시 원하는 타입으로 형변환이 필요하다. 
			
			String operator = (String) session.getAttribute("firstOp");
			int result = 0;

			if (operator.equals("+"))
				result = x + y;
			else if (operator.equals("-"))
				result = x - y;
			else
				writer.print("오류 발생");

			writer.printf("result is %d \n", result);
			
		} // if (op_.equals("="))

//		밸류값 저장
		else {
//			application.setAttribute("firstVal", v);
//			application.setAttribute("firstOp", op_);
			session.setAttribute("firstVal", v);
			session.setAttribute("firstOp", op_);

		} // else

	} // service()

} // class Add
