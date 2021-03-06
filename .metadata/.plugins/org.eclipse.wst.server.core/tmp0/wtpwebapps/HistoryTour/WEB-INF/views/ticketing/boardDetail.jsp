<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/views/include/head.jsp" />
</head>
 	<!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />
<body>
	<h1>게시글 상세 페이지</h1>
	
	
	  <table border="1">
         <thead>
             <tr>
                 <th>글번호</th>
                 <td>${ vo.num }</td>
             </tr>
             <tr>
                 <th>작성자</th>
                 <td>${ vo.writer }</td>
             </tr>
             <tr>
                 <th>제목</th>
                 <td>${ vo.title }</td>
             </tr>
             <tr>
                 <th>내용</th>
                 <td>${ vo.content }</td>
             </tr>
             <tr>
                 <th>작성일</th>
                 <td><fmt:formatDate pattern="yyyy-MM-dd kk:mm:ss" value="${ vo.wrtDate }" /></td>
             </tr>
             <tr>
                 <th>조회수</th>
                 <td>${ vo.hit }</td>
             </tr>
             <tr>
                 <th>첨부파일</th>
                 <td>
                 	 <%-- 첨부파일 있을 시 ----------------------------------------%>
	                 <c:if test="${ not empty vo.filename }">
	                 	<c:choose>
	                 		<%-- 첨부파일 있을 시 이미지이면 ----------------------%>
	                 		<c:when test="${ isImage }">
	                 			<a href="upload/${ vo.filename }">
	                 				<img src="upload/${ vo.filename }" width="200" height="100">
	               				</a>
	                 		</c:when>
	                 		<%-- 첨부파일 있을 시 일반 파일이면 -----------------%>
	                 		<c:otherwise>
	                 			<a href="upload/${ vo.filename }">${ vo.filename }</a>
	                 		</c:otherwise>
	                 	</c:choose>
	                 </c:if>
                 </td>
             </tr>
     </table>
     <input type="button" value="목록" onclick="location.href='board.do?nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }'">
     <input type="button" value="댓글" onclick="location.href='boardDetailReply.do?num=${ vo.num }&nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }&replyLevel=${ vo.replyLevel }&replyRef=${ vo.replyRef }&replySeq=${ vo.replySeq }'">
     <input type="button" value="수정" onclick="location.href='boardDetailUpdate.do?num=${ vo.num }&nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }'">
     															   
     <input type="button" name='delete' value="삭제" onclick="check()">
     
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
    
    <!-- 삭제 최종 체크 -->
    <script>
		function check() {
			let remove = confirm('정말 삭제하시겠습니까?');
			if(remove)
				location.href='boardDeleteProAction.do?num=${ vo.num }&filename=${ vo.filename }&nowIndex=${ nowIndex }';
		}    
    </script>
</body>
</html>