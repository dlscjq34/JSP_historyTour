<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/include/head.jsp" />
    <link rel="stylesheet" href="css/board.css">
</head>
<body>
    <!-- <header> -->
    <jsp:include page="/WEB-INF/views/include/header.jsp" />


    <!-- <aside> <article> -->
    <div class="center">
        <jsp:include page="/WEB-INF/views/include/aside.jsp" />
    
        <article>
            <h1>게시판 (총 ${ count }건)</h1>            
            <div class="board">
                <table border="1">
                    <thead>
                        <tr>
                            <th>REF</th><%-- test --%>
                            <th>LEVEL</th><%-- test --%>
                            <th>SEQ</th><%-- test --%>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="i">
                        <tr>
                            <td>${ i.replyRef }</td><%-- test --%>
                            <td>${ i.replyLevel }</td><%-- test --%>
                            <td>${ i.replySeq }</td><%-- test --%>
                            <td>${ i.num }</td>
                            <td align="left">
                            	<c:if test="${i.replyLevel gt 0}">
                            		<span style="display: inline-block; width:${ i.replyLevel * 10 }px;"></span>
	                            	<img src="images/re.gif">
                            	</c:if>
                            	
                            	<a href="boardDetail.do?num=${ i.num }&nowIndex=${ nowIndex }&method=${ method }&field=${ field }&word=${ word }">${ i.title }</a>
                           	</td>
                            <td>${ i.writer }</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ i.wrtDate }" /></td>
                            <td>${ i.hit }</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <form action="board.do?">
                    <select name="field" id="field">
                        <option value="title">제목</option>
                        <option value="writer">이름</option>
                    </select>
                    <input type="text" name='word'>
                    <input type="submit" value="검색">
                    

                    <input type="hidden" name="method" value="someList">
                </form>
            </div>
            
        	 <c:if test="${ startIndex gt 1 }">
				<a href="board.do?nowIndex=${ startIndex - 1 }">[이전]</a>
			</c:if>
			
            <c:forEach begin="${ startIndex }" end="${ endIndex }" var="i">
            
       			<a href="board.do?nowIndex=${ i }&method=${ method }&field=${ field }&word=${ word }">
       				<c:choose>
       					<c:when test="${ i eq nowIndex }">
       						<span style="font-weight: bold; color: red;">${ i }</span>	
       					</c:when>
       					<c:otherwise>
       						${ i }
       					</c:otherwise>
       				</c:choose>	
       			</a>
            			
		    </c:forEach>
			
			<c:if test="${ endIndex lt totalIndex }">
				<a href="board.do?nowIndex=${ endIndex + 1 }">[다음]</a>
			</c:if>
			<input type="button" name='write' value="글쓰기" onclick="location.href='write.do'">
        </article>
    </div>
    
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>