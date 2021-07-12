
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
//		���ø����̼� ����� ��ü ����
//		���ø����̼� ����Ҵ� ��� Sevlet ���Ͽ� ���� �������� ����� ������ �Ѵ�.  

		HttpSession session = request.getSession();
//		���� ��ü ����
//		������ ���� ������ ����ڿ��Ը� �Ҵ�Ǵ� ������̴�. 

		PrintWriter writer = response.getWriter();

		String v_ = request.getParameter("numVal");
		String op_ = request.getParameter("operator");

		int v = 0; // v_�� null�� ������ ���� ����� v �� �ʱ�ȭ.
		if (v_.equals("") || v_ == null)
			writer.println("���ڸ� �Է����ּ��� <br/>");
		else
			v = Integer.parseInt(v_); // ����� ���� �Ľ�

//		���
		if (op_.equals("=")) {

//			int x = (Integer)application.getAttribute("firstVal");
//			  => ���ø����̼� ����ҿ� "firstVal"�̶�� Ű������ ������ ������� Integer Ÿ������ ��ȯ�Ͽ�
//					int Ÿ�� ���� x�� ����

			int x = (Integer)session.getAttribute("firstVal");
//			  => ���� ����ҿ� "firstVal"�̶�� Ű������ ������ ������� Integer Ÿ������ ��ȯ�Ͽ�
//					int Ÿ�� ���� x�� ����

			int y = v;

//			String operator = (String) application.getAttribute("firstOp");
//			  => ���ø����̼� ����ҿ� "firstOp"��� Ű������ ������ ������� String Ÿ������ ��ȯ�Ͽ�
//					String Ÿ�� ���� operator�� ����. (String) : setAttribute�� ���� �� ��� ���� Object Ÿ������ 
//					��ȯ�ϱ� ������ �ٽ� ���ϴ� Ÿ������ ����ȯ�� �ʿ��ϴ�. 
			
			String operator = (String) session.getAttribute("firstOp");
			int result = 0;

			if (operator.equals("+"))
				result = x + y;
			else if (operator.equals("-"))
				result = x - y;
			else
				writer.print("���� �߻�");

			writer.printf("result is %d \n", result);
			
		} // if (op_.equals("="))

//		����� ����
		else {
//			application.setAttribute("firstVal", v);
//			application.setAttribute("firstOp", op_);
			session.setAttribute("firstVal", v);
			session.setAttribute("firstOp", op_);

		} // else

	} // service()

} // class Add