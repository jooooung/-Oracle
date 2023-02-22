<%@page import="com.lec.dto.BoardDto"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%
  	String num = request.getParameter("num");
		//pageNum
		String pageNum = request.getParameter("pageNum");
		BoardDao bDao = BoardDao.getInstance();
		BoardDto dto = bDao.getBoardOneLine(num);
  %>
  <form action="updatePro.jsp" method="post">
  	<input type="hidden" name="num" value="<%=num%>">
  	<input type="hidden" name="pageNum" value="<%=pageNum%>">
  	<table>
  		<caption><%=num %>번 글 수정</caption>
  		<tr>
  			<th>작성자</th>
  			<td>
  				<%=dto.getWriter() %>
  			</td>
  		</tr>
  		<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" required="required" value="<%=dto.getSubject()%>">
				</td>
			</tr>
			<tr>
				<th>본문</th>
				<td>
					<textarea rows="5" name="content" required="required"><%=dto.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" value="<%=dto.getEmail()==null? "-" : dto.getEmail()%>">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" class="btn">
					<input type="reset" value="취소" class="btn" onclick="history.go(-1)">
					<input type="button" value="목록" class="btn" onclick="location.href='list.jsp?pageNum=<%=pageNum%>'">
				</td>
			</tr>
  	</table>
  </form>
</body>
</html>