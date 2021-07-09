

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana791 extends HttpServlet{
 
	@Override

	protected void service(HttpServletRequest request, HttpServletResponse response)

	throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String cnt_ = request.getParameter("cnt");

		int cnt = 100;
//		정확한 쿼리 스트링이 입력되지 않은 경우 100회 반복

		if(cnt_ != null && !cnt_.equals("")) 	
			cnt = Integer.parseInt(cnt_);
//		밸류값이 정확히 들어온 경우 밸류값을 파싱하여 요청받은 횟수만큼 반복
			
		for (int i=0; i < cnt; i++) 
			out.println( (i+1) + " : 안녕, Sevlet! <br/>" );
			
	} // service()
	
} // class Nana
