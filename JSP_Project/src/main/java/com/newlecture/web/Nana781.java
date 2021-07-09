

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi01")
public class Nana781 extends HttpServlet{
 
	@Override
	// HttpServlet Ŭ������ ���� service �޼ҵ�� java�� main �޼ҵ�� ���� ������ �Ѵ�. 
	protected void service(HttpServletRequest request, HttpServletResponse response)
	// request ��ü�� response ��ü�� �Ű������� �޴� service �޼ҵ�!
	throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		// Ŭ���̾�Ʈ���� ������ ������ ���� ���ڵ� ��� ����
		response.setContentType("text/html; charset=UTF-8");
		// ����� ��� Ŭ���̾�Ʈ���� ������ ����
		
		PrintWriter out = response.getWriter();
		out.println("Hello~~~ this is first Servlet <br/><br/>");
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
//		request.getParameter()�� ������Ʈ������ ���� ��û���� key���� �Ű������� �־ 
//		value ���� ���ڿ��� ��ȯ�ϴ� �޼����̴�. ���ڿ��� ��ȯ�ϱ� ������ ������ ����ϱ� ���ؼ���
//		Integer Ŭ������ parseInt �޼���� �Ľ��Ѵ�. 
		
		for (int i = 0; i < cnt; i++) 
			out.println("�ȳ� Servlet <br/>");	
	
		// �������� ������ ������ �˷����� ���� ��� ���� ������ ������� �ؼ��Ѵ�. 
		// ���� ��� crome�� text�� �ؼ��ϰ� explorer�� html�� �ؼ��Ѵ�. 
			
	} // service()
	
} // class Nana