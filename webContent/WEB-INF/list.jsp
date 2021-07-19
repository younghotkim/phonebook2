<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<c:forEach items="${pList}" var="phoneVo">
	
	<table border="1">

		<tr>
			<th>이름</th>
			<td>${phoneVo.name}</td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td>${phoneVo.hp}</td>
		</tr>
		<tr>
			<th>회사</th>
			<td>${phoneVo.company}</td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=delete&personId=${phoneVo.personId}">[삭제]</a></td>
			<td><a href="/phonebook2/pbc?action=uform&personId=${phoneVo.personId}">[수정]</a></td>
		</tr>

	</table>

	<br>

	</c:forEach>

	<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>


</body>
</html>