<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 목록 페이지</title>
	<link rel="stylesheet" href="/blueberry/static/css/style.css" />
</head>
<body>
<header>
	<h1>게시글 목록 페이지</h1>
</header>
<hr/>
<nav>
	<%@ include file="../include/nav.jsp" %>
</nav>
<section>
	<table border = "1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>

		<c:forEach var="post" items="${posts}">
		<tr>
			<td>${post.id}</td>
			<td><a href="/blueberry/post?cmd=detail&id=${post.id}">${post.title}</a></td>
			<td>${post.createDate}</td>
		</tr>
		</c:forEach>

	</table>
	<a href="/blueberry/post?cmd=saveForm">글쓰기</a>
</section>
<footer>
	<p>Created By BlueBerry</p>
	<p>부산진구 중앙대로 708</p>
</footer>
</body>
</html>

