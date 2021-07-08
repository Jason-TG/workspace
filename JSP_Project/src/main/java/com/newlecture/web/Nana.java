

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet{
 
	@Override
	// HttpServlet 클래스가 가진 service 메소드는 java의 main 메소드와 같은 역할을 한다. 
	protected void service(HttpServletRequest request, HttpServletResponse response)
	// request 객체와 response 객체를 매개변수로 받는 service 메소드!
	throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		// 클라이언트에게 보내는 정보에 대한 인코딩 방식 설정
		response.setContentType("text/html; charset=UTF-8");
		// 헤더에 담아 클라이언트에게 보내는 정보
		
		PrintWriter out = response.getWriter();
		out.println("Hello~~~ this is first Servlet <br/><br/>");
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
//		request.getParameter()는 쿼리스트링으로 받은 요청에서 key값을 매개변수에 넣어서 
//		value 값을 문자열로 반환하는 메서드이다. 문자열로 반환하기 때문에 정수로 사용하기 위해서는
//		Integer 클래스의 parseInt 메서드로 파싱한다. 
		
		for (int i = 0; i < cnt; i++) 
			out.println("안녕 Servlet <br/>");
		
		// 브라우저에 컨텐츠 형식을 알려주지 않은 경우 각자 설정된 방법으로 해석한다. 
		// 예를 들어 crome은 text로 해석하고 explorer는 html로 해석한다. 
			
	} // service()
	
} // class Nana
