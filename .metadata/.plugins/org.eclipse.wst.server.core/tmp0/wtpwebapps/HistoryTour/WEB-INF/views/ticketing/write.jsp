<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <h1>게시글 작성</h1>            
            <div class="board">
                <form action="writePro.do" method="post" enctype="multipart/form-data">
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
		                    <td><input type="file" name="fileName" id="fileName" value=""/> </td>
		                </tr> 	                    
               		</table>
               		<input type="submit" value="등록">
               		<input type="reset" value="입력 초기화">
               		<input type="button" value="목록" onclick="location.href='board.do'">
                </form>
            </div>           
        </article>
    </div>
    
    
    <!-- <footer> -->
    <jsp:include page="/WEB-INF/views/include/footer.jsp" />

    
</body>
</html>