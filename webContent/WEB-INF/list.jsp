<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import = "java.util.List" %>
<%@page import = "com.javaex.vo.*" %>
    
<% //request 안에 데이터 사용 --> pList
	List<PhoneVo> personList = (List<PhoneVo>)request.getAttribute("pList");
	System.out.println("==========JSP=========");
	System.out.println(personList);
	
	
	/* 자료형 파악
	int age = (int)request.getAttribute("age");
	String name = (String)request.getAttribute("name");
	
	System.out.println(age + name);
	*/
	
	
%>    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
	
	
	<% for(int i=0; i<personList.size(); i++) {
		
		%>
		
		<table border="1">
		
		<tr>
			<td>이름</td>
		 	<td><%=personList.get(i).getName() %></td>
		</tr>
		<tr>
			<td>핸드폰</td>
		 	<td><%=personList.get(i).getHp() %></td>
		</tr>
		<tr>
			<td>회사</td>
		 	<td><%=personList.get(i).getCompany() %></td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=delete&personId=<%=personList.get(i).getPersonId()%>">[삭제]</a></td>
			<td><a href="/phonebook2/pbc?action=uform&personId=<%=personList.get(i).getPersonId()%>">[수정]</a></td>
		</tr>
	
	</table>
		
	<br>
	
	<%
	}
	%>
		
		<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>
	
	
</body>
</html>