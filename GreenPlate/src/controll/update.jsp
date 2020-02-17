<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="sang.do?command=update" method="post">
<p>아이디</p>
<input type="text" name="id">
<p>닉네임</p>
<input type="text" name="nick">
<p>바꿀 아이디</p>
<input type="text" name="uid">
<p>바꿀 닉네임</p>
<input type="text" name="unick">
<input type="submit" value="입력">
</form>
</body>
</html>