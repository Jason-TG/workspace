

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String cnt_ = request.getParameter("cnt");

int cnt = 100;
//정확한 쿼리 스트링이 입력되지 않은 경우 100회 반복

if(cnt_ != null && !cnt_.equals("")) 	
	cnt = Integer.parseInt(cnt_);
//밸류값이 정확히 들어온 경우 밸류값을 파싱하여 요청받은 횟수만큼 반복
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for (int i=0; i < cnt; i++) { %>
		안녕, Sevlet!! <br/>
	<% } %>
	<br />
</body>
</html>