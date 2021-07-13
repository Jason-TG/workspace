

package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spag")
public class Spag extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num = 0;
		String num_ = request.getParameter("n");
		if (num_ != null && !num_.equals("")) {
			num = Integer.parseInt(num_);
		}
		
		String result=null;
		
		if (num%2 != 0) {
			result = "홀수";
		} else {
			result = "짝수";
		} // if-else
		
		request.setAttribute("result", result);
			
		String[] names = {"chris", "jason", "teddy"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "편리한 EL식");
		request.setAttribute("notice", notice);
			
//		redirect는 새로고침처럼 서버 밖으로 나가서 새로 페이지에 대한 get 요청을 하는 것이고,	
//		forward는 리퀘스트 객체가 가진 정보를 그대로 갖고 페이지 이동을 한다. 
//		dispatcher가 포워드 메서드를 가진다..	
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("/spag.jsp");
		dispatcher.forward(request, response);

	} // doGet()
	
} // spag{}












