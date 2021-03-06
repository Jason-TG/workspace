

package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getMethod().equals("GET")) {
			// 전달방식은 대문자로 전달된다. 
			System.out.println("GET 요청이 왔습니다.");
		} else if (request.getMethod().equals("POST")) {
			System.out.println("POST 요청이 왔습니다.");			
		}
		
		super.service(request, response);
		
	} //  service()
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		String exp = "0";

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				} // if
			} // for
		} // if

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>");

		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("input{");
		out.write("width : 50px;");
		out.write("height : 50px;");
		out.write("}");
		out.write(".output {");
		out.write("height : 50px;");
		out.write("background : #e9e9e9;");
		out.write("font-size : 24px;");
		out.write("font-weight : bold;");
		out.write("text-align : right;");
		out.write("padding : 0px 5px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("");
		out.write("<body>");
		out.write("");
		out.write("<div>");
		out.write("<form method=\"post\">");
		out.write("<table>");
		out.write("<tr>");
		out.printf("	<td class=\"output\" colspan=\"4\">%s</td>", exp);
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("	<td><input type=\"submit\" name=\"operator\" value=\"CE\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"C\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"BS\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"/\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"7\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"8\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"9\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"*\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"4\" /></td>");
		out.write("	<td><input type=\"submit\" name=\"value\" value=\"5\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"6\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"-\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"1\" /></td>");
		out.write("	<td><input type=\"submit\" name=\"value\" value=\"2\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"value\" value=\"3\" /></td>");
		out.write("		<td><input type=\"submit\" name=\"operator\" value=\"+\" /></td>");
		out.write("	</tr>");
		out.write("	<tr>");
		out.write("	<td></td>");
		out.write("	<td><input type=\"submit\" name=\"value\" value=\"0\" /></td>");
		out.write("	<td><input type=\"submit\" name=\"dot\" value=\".\" /></td>");
		out.write("	<td><input type=\"submit\" name=\"operator\" value=\"=\" /></td>");
		out.write("		</tr>");
		out.write("	</table>");
		out.write("	</form>");
		out.write("</div>");
		out.write("	");
		out.write("</body>");
		out.write("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST 메소드가 호출되었습니다.");		
		
		Cookie[] cookies = request.getCookies();

		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		String exp = "";

		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				} // if
			} // for
		} // if
		
		if(operator != null && operator.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			} // t-c
		} else if(operator != null && operator.equals("C")) {					
			exp = "0";
		} else {
		exp += ((value == null)? "" : value);
		exp += ((operator == null)? "" : operator);
		exp += ((dot == null)? "" : dot);
		} // if-else
			
		String sum = "";
		
		Cookie expCookie = new Cookie("exp", exp);
		
		if(operator != null && operator.equals("C")) { 
				expCookie.setMaxAge(0);
		}
		
		expCookie.setPath("/calculator");
		// get 요청과 post 요청에 대해 메서드로 구분하고 한 페이지로 합치면 쿠키를 해당 페이지에만 전송하도록 설정하면 되므로 편리하다. 
		response.addCookie(expCookie);		

		response.sendRedirect("calculator");
		// get요청 => doGet함수 
		
	} // doPost()
 
} // Calculator {}
