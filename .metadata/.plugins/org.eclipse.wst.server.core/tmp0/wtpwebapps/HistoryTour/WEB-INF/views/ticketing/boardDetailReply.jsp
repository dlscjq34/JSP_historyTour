<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/include/head.jsp" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" ></script>
</head>
 	<!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
<body>
	<h1>댓글 쓰기</h1>
	
	<form action="boardDetailReplyPro.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="nowIndex" value="${ nowIndex }">
		<input type="hidden" name="method" value="${ method }">
		<input type="hidden" name="field" value="${ field }">
		<input type="hidden" name="word" value="${ word }">
		<input type="hidden" name="replyRef" value="${ replyRef }">
		<input type="hidden" name="replyLevel" value="${ replyLevel }">
		<input type="hidden" name="replySeq" value="${ replySeq }">
       	<table border="1">
            <tr>
               <th>제목 : </th>
               	<td><input type="text" name="title" id="title" value=""/></td>
            </tr>
            <tr>
          		<th>내용 : </th>
          		<td><textarea name="content" id="content" rows="10" cols="30"></textarea> </td>
      	 	</tr>
            <tr>
            	<th>첨부파일 : </th>
                <td><input type="file" name="fileName" id="fileName"/> </td>
            </tr> 	                    
  		</table>
  		<input type="submit" value="등록">
  		<input type="reset" value="입력 초기화">
	</form> 
	
    <input type="button" value="목록" onclick="location.href='board.do?nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }'">
     
     
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>


</html>

