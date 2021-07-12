

package com.newlecture.web.jsp0712;

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

@WebServlet("/calc5")
public class Calc5 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Cookie[] cookies = request.getCookies();
//		request ��ü�� ��Ű�� �迭�� �����´�. 

		PrintWriter writer = response.getWriter();

		String v_ = request.getParameter("numVal");
		String op_ = request.getParameter("opVal");
 
		int v = 0; // v_�� null�� ������ ���� ����� v �� �ʱ�ȭ.
		if (v_.equals("") || v_ == null)
			writer.println("���ڸ� �Է����ּ��� <br/>");
		else
			v = Integer.parseInt(v_); // ����� ���� �Ľ�

//		���
		if (op_.equals("=")) {

			int x = 0;
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("firstVal")) {
//				Cookie Ŭ������ getName() �޼���� �ش� Cookie ��ü�� ����� Ű ���� ��ȯ(���ڿ� ��).
//				Ű ��, �� ��Ű�� �̸��� Ȯ���Ͽ� ���ϴ� ��Ű�� ã�� �۾�.

				x = Integer.parseInt(cookie.getValue());
//			 	Cookie Ŭ������ getValue() �޼���� �̸� �״�� �ش� ��ü�� ����� ������� ��ȯ(���ڿ� ��).
//				��Ű ��ü���� ���ڿ��� ������ �� �ִ�. 
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
				writer.print("���� �߻�");

			writer.printf("result is %d \n", result);

		} // if (op_.equals("="))

//		����� ����
		else {
			Cookie valueCookie = new Cookie("firstVal", String.valueOf(v));
			Cookie opCookie = new Cookie("firstOp", op_);
//			valueCookie.setPath("/"); => ��� ������ ��û �ø��� valueCookie�� ���������� ��
//			valueCookie.setPath("/boy"); => boy �ּ� ��û �� valueCookie�� ���������� ��
//			valueCookie.setPath("/boy/"); =>  boy ���丮 ������ ��� �ּ� ��û �� valueCookie�� ���������� ��
			valueCookie.setPath("/");
			valueCookie.setMaxAge(60*60*24); // �� ���� ������ ���� �ð��� ���ϴ� ��. 
//			������ �������� ������ ��Ű���� �������.
			opCookie.setPath("/");

			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc5.jsp");

		} // else

	} // service()

} // class Add