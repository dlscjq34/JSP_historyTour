<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<h1>아이디 중복 확인</h1>
	아이디 : ${ id }
	<hr>
	
	<c:choose>
		<c:when test="${ dupCheck eq true }">
			사용중인 아이디입니다.<br>다시 입력하십시오.<hr>
		</c:when>
		<c:otherwise>
			사용가능한 ID 입니다.
			<input type="button" value="등록" onclick="toJoinForm()">
			<hr>		
		</c:otherwise>
	</c:choose> 
	
	<form action="joinCheck.do" method="get" name="thisFrm">
		<input type="text" name="id" value="${ id }">
		<input type="submit" value="중복확인"> 
	</form>
	
	
</body>

<script>
	function exit() { window.close(); }

	function toJoinForm() {
		opener.document.frm.id.value = thisFrm.id.value;
		opener.document.frm.id.select();
		window.close();
	}
</script>

</html>