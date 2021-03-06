

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

//@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Cookie[] cookies = request.getCookies();
//		request 객체는 쿠키를 배열로 가져온다. 

		PrintWriter writer = response.getWriter();

		String v_ = request.getParameter("numVal");
		String op_ = request.getParameter("opVal");
 
		int v = 0; // v_에 null이 들어왔을 때를 대비한 v 값 초기화.
		if (v_.equals("") || v_ == null)
			writer.println("숫자를 입력해주세요 <br/>");
		else
			v = Integer.parseInt(v_); // 계산할 숫자 파싱

//		계산
		if (op_.equals("=")) {

			int x = 0;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("firstVal")) {
//				Cookie 클래스의 getName() 메서드는 해당 Cookie 객체에 저장된 키 값을 반환(문자열 값).
//				키 값, 즉 쿠키의 이름을 확인하여 원하는 쿠키를 찾는 작업.

				x = Integer.parseInt(cookie.getValue());
//			 	Cookie 클래스의 getValue() 메서드는 이름 그대로 해당 객체에 저장된 밸류값을 반환(문자열 값).
//				쿠키 객체에는 문자열만 저장할 수 있다. 
				}
				break;
			}
			


			String operator = "";
			for (Cookie c : cookies) {
				if (c.getName().equals("firstOp")) {

					operator = c.getValue();
				}
				break;
			}

			int y = v;

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
			Cookie valueCookie = new Cookie("firstVal", String.valueOf(v));
			Cookie opCookie = new Cookie("firstOp", op_);
//			valueCookie.setPath("/"); => 모든 페이지 요청 시마다 valueCookie를 가져오도록 함
//			valueCookie.setPath("/boy"); => boy 주소 요청 시 valueCookie를 가져오도록 함
//			valueCookie.setPath("/boy/"); =>  boy 디렉토리 하위의 모든 주소 요청 시 valueCookie를 가져오도록 함
			valueCookie.setPath("/calc3");
			valueCookie.setMaxAge(1000); // 초 단위 값으로 만료 시간을 정하는 것. 
//			원래는 브라우저가 닫히면 쿠키값이 사라진다.
			opCookie.setPath("/calc3");

			response.addCookie(valueCookie);
			response.addCookie(opCookie);

		} // else

	} // service()

} // class Add
