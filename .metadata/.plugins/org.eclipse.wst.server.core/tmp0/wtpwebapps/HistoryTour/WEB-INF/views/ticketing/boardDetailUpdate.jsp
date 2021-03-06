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
	<h1>게시글 수정 페이지</h1>
	
	<form action="boardDetailUpdatePro.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="nowIndex" value="${ nowIndex }">
		<input type="hidden" name="method" value="${ method }">
		<input type="hidden" name="field" value="${ field }">
		<input type="hidden" name="word" value="${ word }">
	 	<table border="1">
         <thead>
             <tr>
                 <th>글번호</th>
                 <td><input type="text" name="num" value="${ vo.num }" readonly></td>
             </tr>
             <tr>
                 <th>작성자</th>
                 <td><input type="text" name="writer" value="${ vo.writer }" readonly></td>
             </tr>
             <tr>
                 <th>제목</th>
                 <td><input type="text" name="title" value="${ vo.title }"></td>
             </tr>
             <tr>
                 <th>내용</th>
                 <td><input type="text" name="content" value="${ vo.content }"></td>
             </tr>
             <tr>
                 <th>첨부파일</th>
                 <td>
                 	<%-- 첨부파일이 있나 없나? ----------------------------------------%>
               		 <c:choose>		
               		 
               		 
               		 	<%-- 첨부파일 없을 시 ----------------------------------------%>
                 		<c:when test="${ empty vo.filename }">	
                 		
                 			<input type="file" name="newFile">	                 		
	                 		
                 		</c:when>
                 		
                 		
                 		<%-- 첨부파일 있을 시 ----------------------------------------%>
                 		<c:otherwise>							  
                 		               		
                 				<c:choose>	
									
									<%-- 첨부파일 있을 시 이미지이면 ----------------------%>	                 			
			                 		<c:when test="${ isImage }">	
			                 		
				                 		<div class="delBtn">
				                 			<a href="upload/${ vo.filename }">
				                 				<img src="upload/${ vo.filename }" width="200" height="100">	
				               				</a>
				               				<input type="button" value="파일삭제">
										</div>			               				
			               				<input type="hidden" name="oldFileName" value="${ vo.filename }">
			               				
			                 		</c:when>	
			                 		
			                 		<%-- 첨부파일 있을 시 일반 파일이면 -----------------%>	                 		
			                 		<c:otherwise>	
			                 			
			                 			<div class="delBtn">
			                 				<a href="upload/${ vo.filename }">${ vo.filename }</a>
			                 				<input type="button" value="파일삭제">
		                 				</div>
			                 			<input type="hidden" name="oldFileName" value="${ vo.filename }">
			                 			
			                 		</c:otherwise>	 			                 		
			                 		
	           		            </c:choose>
	           		            
                 		</c:otherwise>
                 		
                 	</c:choose>
                 </td>
             </tr>
     	</table>
			                 			
     	<input type="submit" value="수정완료">
     	<input type="reset" value="초기화">
	</form> 
	
    <input type="button" value="목록" onclick="location.href='board.do?nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }'">
     
     
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>

<script>	// 파일 삭제 클릭 시
	$('.delBtn').click(function() {
		/* alert($(this).next().attr('name'));	//test */
		/* $(this).next().css('color', 'red'); //test */
		
		$(this).next().prop('name', 'delFilename');	//클릭버튼 다음 태그의 이름을 변경(컨틀로러에서 사용)		
		$(this).closest('td').prepend('<input type="file" name="newFile">'); // 가장 가까운 태그에 파일입력폼 삽입
		$(this).closest('div').remove();	// 기존 파일 표시 해제(컨트롤러에서 삭제)
		
	});
</script>

</html>

