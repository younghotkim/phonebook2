<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.*" %>
<%@ page import="com.javaex.vo.*" %>
 
<%

	PhoneDao phoneDao = new PhoneDao();
	//파라미터(personId) 꺼내기
	int personId = Integer.parseInt(request.getParameter("personId"));
	System.out.println(personId);
	//dao에서 한 사람의 id 가져오기 --> phoneDao.getPerson()
	PhoneVo phoneVo = phoneDao.getPerson(personId);
	System.out.println(phoneVo.toString());



%>   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<h1>전화번호 수정</h1>
	<p>수정화면 입니다. 아래 항목을 수정하고 "수정" 버튼을 클릭하세요</p>
	
	<form action="/phonebook2/pbc" method="get">

		이름: <input type="text" name="name" value="<%=phoneVo.getName()%>"> <br>
		핸드폰: <input type="text" name="hp" value="<%=phoneVo.getHp()%>"> <br>
		회사: <input type="text" name="company" value="<%=phoneVo.getCompany()%>"> <br>
		<input type="hidden" name="personId" value="<%=phoneVo.getPersonId()%>">
		<input type="text" name="action" value="update"> <br>
	<button type="submit">수정</button>
	</form>


</body>
</html>