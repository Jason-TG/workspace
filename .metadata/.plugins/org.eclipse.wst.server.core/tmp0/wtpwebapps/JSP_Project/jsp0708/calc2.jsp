

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div>
		<form action="calc2" method="post">
			<div>
				<label>hello!</label>
			</div>
			<div>
				<label>입력 : </label> <input type="text" name="numVal" />
			</div>

			<div>
				<input type="submit" name="operator" value="+" />
				<input type="submit" name="operator" value="-" />
				<input type="submit" name="operator" value="=" />
				<!-- input 태그는 name값(키값)이 있으면 데이터가 전달된다.  -->
				<!-- type 속성의 값이 submit인 경우 value 속성의 값이 밸류로 전달된다. -->
			</div>
		</form>
	</div>

</body>
</html>









